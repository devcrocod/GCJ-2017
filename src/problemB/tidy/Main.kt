package problemB.tidy

import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    val rd = Files.newBufferedReader(Paths.get("src/problemB/B-large-practice.in"))
    val writer = Files.newBufferedWriter(Paths.get("src/problemB/B-large-practice.out"))
    try {
        val cases = rd.readLine().toInt()
        for (id in 1..cases) {
            var str = rd.readLine()
            if (str.length != 1) {
                var i = 0
                while (i < str.length - 1) {
                    if (str[i].toInt() > str[i + 1].toInt()) {
                        while (i - 1 >= 0 && str[i] == str[i - 1])
                            i--
                        var strChar: CharArray = str.toCharArray()
                        strChar[i] = (strChar[i].toInt() - 1).toChar()
                        for (j in i + 1..str.length - 1)
                            strChar[j] = '9'
                        if (strChar[0] == '0')
                            strChar = strChar.copyOfRange(1, strChar.size)
                        str = String(strChar)
                    }
                    i++
                }
            }
            writer.write("Case #$id: $str\n")
        }
    } finally {
        rd.close()
        writer.close()
    }
}
