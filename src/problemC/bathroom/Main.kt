package problemC.bathroom

import java.nio.file.Files
import java.nio.file.Paths

val rd = Files.newBufferedReader(Paths.get("src/problemC/C-large-practice.in"))!!
val writer = Files.newBufferedWriter(Paths.get("src/problemC/C-large-practice.out"))!!

fun main(args: Array<String>) {
    try {
        val case = rd.readLine().toInt()
        for (id in 1..case)
            stalls(id)
    } finally {
        rd.close()
        writer.close()
    }
}

fun max(n: Long) = (n + 1) / 2

fun min(n: Long) = n / 2

fun stalls(id: Int) {
    var (n, k) = rd.readLine().split(' ').map(String::toLong)
    while (k > 1) {
        val mx: Long = max(n - 1)
        val mn: Long = min(n - 1)
        k--
        if (k % 2 != 0L)
            n = mx
        else
            n = mn
        k = (k + 1) / 2
    }
    writer.write("Case #$id: ${max(n - 1)} ${min(n - 1)}\n")
}