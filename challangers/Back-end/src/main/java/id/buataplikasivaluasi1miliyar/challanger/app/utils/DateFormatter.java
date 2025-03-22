package id.buataplikasivaluasi1miliyar.challanger.app.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Memformat LocalDateTime ke format "yyyy-MM-dd HH:mm:ss".
     *
     * @param dateTime LocalDateTime yang akan diformat.
     * @return String tanggal yang sudah diformat.
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }
    /**
     * Menambahkan jumlah hari tertentu ke timestamp.
     *
     * @param timestamp Waktu awal dalam milidetik.
     * @param daysToAdd Jumlah hari yang ingin ditambahkan.
     * @return Timestamp baru setelah penambahan hari.
     */
    public static long addDaysToTimestamp(long timestamp, int daysToAdd) {
        return timestamp + (daysToAdd * 24L * 60 * 60 * 1000);
    }
}
