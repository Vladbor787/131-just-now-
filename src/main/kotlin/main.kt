
const val MINUTE_IN_SECONDS = 60
const val SECONDS_IN_HOURS = 3600
const val SECONDS_IN_DAY = 86400
const val HOURS_IN_DAYS = 24

val fraseMap = mapOf("justNow" to " только что", "yesterday" to " вчера",
    " today" to " сегодня","ago" to " назад","long ago" to " давно",)
val arrOfMinute = arrayOf("минуту", "минуты", "минут")
val arrOfHours = arrayOf("час","часа","часов")

fun main() {

    do {
        println("Введите количество секунд")
        val numberOfSeconds = readLine()?.toInt()
        if (numberOfSeconds != null && numberOfSeconds > 0) {
            println("был(а) " + toTimeAgo(numberOfSeconds))
        }
    } while (numberOfSeconds != -1)

}

fun toTimeAgo(n: Int): String? {

    val numberOfHours = n / SECONDS_IN_HOURS % HOURS_IN_DAYS
    val numberOfMinutes = n / MINUTE_IN_SECONDS % MINUTE_IN_SECONDS

    return when(n) {
       in 0..MINUTE_IN_SECONDS -> (fraseMap["justNow"])
       in MINUTE_IN_SECONDS + 1..SECONDS_IN_HOURS ->(endingUtil(numberOfMinutes, arrOfMinute) + fraseMap["ago"])
       in HOURS_IN_DAYS +1 ..SECONDS_IN_DAY ->(endingUtil(numberOfHours, arrOfHours) + fraseMap["ago"])
       in (SECONDS_IN_DAY +1)..(SECONDS_IN_DAY*2) ->(fraseMap["today"])
       in (SECONDS_IN_DAY*2)+1..SECONDS_IN_DAY*3-> (fraseMap["yesterday"])
       else -> (fraseMap["long ago"])
   }

}
fun endingUtil(T: Int, arrOfMinutesAndHours: Array<String>): String {
    return when (T % 10) {
        1-> if (T % 100 == 11) { T.toString() + " " + arrOfMinutesAndHours[2]}else {T.toString() + " " + arrOfMinutesAndHours[0]}
        2-> if (T % 100 == 12) { T.toString() + " " + arrOfMinutesAndHours[2]}else {T.toString() + " " + arrOfMinutesAndHours[1]}
        3-> if (T % 100 == 13) { T.toString() + " " + arrOfMinutesAndHours[2]}else {T.toString() + " " + arrOfMinutesAndHours[1]}
        4-> if (T % 100 == 14) { T.toString() + " " + arrOfMinutesAndHours[2]}else {T.toString() + " " + arrOfMinutesAndHours[1]}
        else -> T.toString() + " " + arrOfMinutesAndHours[2]
    }
}
