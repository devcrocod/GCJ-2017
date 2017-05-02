package problemA.pancake

import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val cases = input.nextInt()
    for (id in 1..cases) {
        var flips = 0
        val str: String = input.next()
        val k: Int = input.nextInt()
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
            println("Case #$id: $flips")
        else
            println("Case #$id: IMPOSSIBLE")
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

