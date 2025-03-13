import 'package:challangers/services/log_service.dart';
import 'package:dio/dio.dart';

class ApiClient {
  static const String baseUrl =
      "http://localhost:8089/api/v1/"; // Ubah jika backend sudah deploy
  final Dio _dio;

  ApiClient()
      : _dio = Dio(BaseOptions(
          baseUrl: baseUrl,
          connectTimeout: Duration(seconds: 10),
          receiveTimeout: Duration(seconds: 10),
          headers: {"Content-Type": "application/json"},
        )) {
    _dio.interceptors.add(InterceptorsWrapper(
      onRequest: (options, handler) {
        // LogService.logger.d(("➡️ Request: ${options.method} ${options.uri}"));
        return handler.next(options);
      },
      onResponse: (response, handler) {
        // LogService.logger
        //     .d(("✅ Response: ${response.statusCode} ${response.data}"));
        return handler.next(response);
      },
      onError: (DioException e, handler) {
        LogService.logger
            .d(("❌ Error: ${e.response?.statusCode} ${e.message}"));

        return handler.next(e);
      },
    ));
  }

  Dio get dio => _dio;
}
