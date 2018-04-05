package rubenpla.develop.privtmdbendlesslist.util

import android.util.Log
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import java.lang.Long.valueOf

class JodaTimeConverter {

    private val DATE_PATTERN = "yyyy-MM-dd"

    companion object {
        val jodaTimeInstance  = JodaTimeConverter()
    }

    fun getYearFromDate(date: String): Int {
        val dateInMillis = parseDateFromStringPatternToMillis(date)

        val localDate = LocalDate(valueOf(dateInMillis))

        return localDate.year
    }

    private fun parseDateFromStringPatternToMillis(date: String): String? {
        var dateInMillis: String? = null

        try {
            val formatter = DateTimeFormat.forPattern(DATE_PATTERN)
            var dt = formatter.parseDateTime(date)

            val month = dt.monthOfYear
            val day = dt.dayOfMonth
            val year = dt.year

            val localDate = LocalDate(year, month, day)
            dt = localDate.toDateTimeAtCurrentTime()
            dateInMillis = dt.millis.toString()
        } catch (illegalArgumentException: IllegalArgumentException) {
            dateInMillis = ""
            Log.e(JodaTimeConverter::class.simpleName, "IllegalArgumentException : "
                    + illegalArgumentException.localizedMessage)

        } finally {
            return dateInMillis
        }
    }


}