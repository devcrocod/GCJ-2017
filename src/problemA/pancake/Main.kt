package problemA.pancake

import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    val rd = Files.newBufferedReader(Paths.get("src/problemA/A-large-practice.in"))
    val writer = Files.newBufferedWriter(Paths.get("src/problemA/A-large-practice.out"))
    try {
        val cases = rd.readLine().toInt()
        for (id in 1..cases) {
            var flips = 0
            val line = rd.readLine().split(" ")
            val str: String = line[0]
            val k: Int = line[1].toInt()
            val happy: Array<Boolean?> = arrayOfNulls(str.length)
            for (i in 0..str.length - 1)
                happy[i] = str[i] == '+'
            for (i in 0..str.length - k) {
                if (!happy[i]!!) {
                    flip(happy, k, i)
                    flips++
                }
            }
            if (isHappy(happy))
                writer.write("Case #$id: $flips\n")
            else
                writer.write("Case #$id: IMPOSSIBLE\n")
        }
    } finally {
        rd.close()
        writer.close()
    }
}

private fun flip(happy: Array<Boolean?>, k: Int, i: Int): Array<Boolean?> {
    for (j in i..i + k - 1) {
        happy[j] = !happy[j]!!
    }
    return happy
}

private fun isHappy(happy: Array<Boolean?>): Boolean {
    return !happy.contains(false)
}

