package problemB.tidy

fun main(args: Array<String>) {
//    val input = Scanner(System.`in`)
//    val cases = input.nextInt()
    val cases = readLine()!!.toInt()
    for (id in 1..cases) {
//        var str: String = input.next()
        var str = readLine()!!
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
        println("Case #$id: $str")
    }
}
