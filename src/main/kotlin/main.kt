
const val MINUTE_IN_SECONDS = 60
const val SECONDS_IN_HOURS = 3600
const val SECONDS_IN_DAY = 86400
const val HOURS_IN_DAYS = 24


fun main() {

    do {
        println("Введите количество секунд")
        val numberOfSeconds = readLine()?.toInt()
        if (numberOfSeconds != null && numberOfSeconds > 0) {
            toTimeAgo(numberOfSeconds)
        }
    } while (numberOfSeconds != -1)

}
fun toTimeAgo(n: Int): String {

    val fraseMap = mapOf("justNow" to " только что", "yesterday" to " вчера",
        " today" to " сегодня","ago" to " назад","long ago" to " давно","was" to "был(а)")
    val arrOfMinute = arrayOf("минуту", "минуты", "минут")
    val arrOfHours = arrayOf("час","часа","часов")

    val numberOfHours = n / SECONDS_IN_HOURS % HOURS_IN_DAYS
    val numberOfMinutes = n / MINUTE_IN_SECONDS % MINUTE_IN_SECONDS



    return when(n) {
       in 0..MINUTE_IN_SECONDS -> println(fraseMap["was"] + fraseMap["justNow"]).toString()
       in MINUTE_IN_SECONDS + 1..SECONDS_IN_HOURS -> println(endingUtil(numberOfMinutes, arrOfMinute) + fraseMap["ago"]).toString()
       in HOURS_IN_DAYS +1 ..SECONDS_IN_DAY -> println(endingUtil(numberOfHours, arrOfHours) + fraseMap["ago"]).toString()
       in (SECONDS_IN_DAY +1)..(SECONDS_IN_DAY*2) -> println(fraseMap["was"] + fraseMap["today"]).toString()
       in (SECONDS_IN_DAY*2)+1..SECONDS_IN_DAY*3-> println(fraseMap["was"] + fraseMap["yesterday"]).toString()
       else -> println(fraseMap["was"] + fraseMap["long ago"]).toString()
   }

}
fun endingUtil(T: Int, arrsome: Array<String>): String {
    return if (T % 10 == 1 && T % 100 != 11) T.toString() + " " + arrsome[0]
    else if (T % 10 == 2 && T % 100 != 12 || T % 10 == 3 && T % 100 != 13 || T % 10 == 4 && T % 100 != 14) T.toString() + " " + arrsome[1]
    else T.toString() + " " + arrsome[2]

}
