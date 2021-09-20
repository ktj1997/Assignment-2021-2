package yourssu.assignment.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DateUtils {

    fun getDateRange(date: LocalDate): Pair<LocalDateTime, LocalDateTime> {

        return Pair(date.atTime(0, 0, 0), date.atTime(23, 59, 59))
    }

    fun parseStringToDate(date: String): LocalDate {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    }
}