import 'package:logger/logger.dart';

class LogService {
  static final Logger logger = Logger(
    printer: PrettyPrinter(
      methodCount: 2, // Stack trace untuk error
      dateTimeFormat: DateTimeFormat.onlyTimeAndSinceStart, // Tambahkan waktu di log
    ),
  );
}
