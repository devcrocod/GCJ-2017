package problemC.bathroom

fun main(args: Array<String>) {
    val case = readLine()!!.toInt()
    for (id in 1..case)
        stalls(id)
}

fun max(n: Long) = (n+1) / 2

fun min(n: Long) = n / 2

fun stalls(id: Int) {
    var (n, k) = readLine()!!.split(' ').map(String::toLong)
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
    println("Case #$id: ${max(n - 1)} ${min(n - 1)}")
}