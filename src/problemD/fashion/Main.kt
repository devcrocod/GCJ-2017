package problemD.fashion

import java.nio.file.Files
import java.nio.file.Paths

val rd = Files.newBufferedReader(Paths.get("src/problemD/D-large-practice.in"))!!
val writer = Files.newBufferedWriter(Paths.get("src/problemD/D-large-practice.out"))!!

fun main(args: Array<String>) {
    try {
        val case = rd.readLine().toInt()
        for (id in 1..case)
            show(id)
    } finally {
        rd.close()
        writer.close()
    }
}

fun show(id: Int) {
    val (n, m) = rd.readLine().split(" ").map(String::toInt)
    val stage = mutableSetOf<Pair>()
    val row = mutableSetOf<Int>()
    val col = mutableSetOf<Int>()
    val diag = mutableSetOf<Int>()
    val anti = mutableSetOf<Int>()
    for (t in 0..m - 1) {
        val line = rd.readLine().split(" ")
        val style = line[0]
        val i = line[1].toInt()
        val j = line[2].toInt()
        stage.add(Pair(i, j))
        if (!style.equals("+")) {
            row.add(i)
            col.add(j)
        }
        if (!style.equals("x")) {
            diag.add(i - j)
            anti.add(i + j)
        }
    }

    val models = mutableListOf<List<String>>()
    val list = mutableListOf<Pair>()
    for (i in 1..n) {
        (i..n).mapTo(list) { Pair(i, it) }
        (i + 1..n).mapTo(list) { Pair(it, i) }
        for (p in list) {
            var addTimes = false
            var addPlus = false
            if ((p.first !in row) and (p.first + p.second !in col)) {
                addTimes = true
                row.add(p.first)
                col.add(p.second)
            }
            if ((p.first - p.second !in diag) and (p.first + p.second !in anti)) {
                addPlus = true
                diag.add(p.first - p.second)
                anti.add(p.first + p.second)
            }
            if ((addTimes and addPlus) or ((addTimes or addPlus) and (p in stage)))
                models.add(listOf("o", p.first.toString(), p.second.toString()))
            else {
                if (addTimes)
                    models.add(listOf("x", p.first.toString(), p.second.toString()))
                if (addPlus)
                    models.add(listOf("+", p.first.toString(), p.second.toString()))
            }
        }
    }
    writer.write("Case #$id: ${row.size + diag.size} ${models.size}\n")
    for (md in models)
        writer.write("${md[0]} ${md[1]} ${md[2]}\n")
}

data class Pair(val first: Int, val second: Int)