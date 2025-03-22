import 'package:challangers/models/category_model.dart';
import 'package:challangers/models/challenge_model.dart';
import 'package:challangers/services/log_service.dart';
import 'package:dio/dio.dart';
import 'api_client.dart';

class ApiService {
  final Dio _dio = ApiClient().dio;

  // 🔹  GET all challenges
  Future<List<ChallengeModel>> fetchChallenges() async {
    try {
      Response response = await _dio.get('challengers');
      List data = response.data;
      return data.map((json) => ChallengeModel.fromMap(json)).toList();
    } catch (e) {
      throw Exception("Failed to load challenges: $e");
    }
  }

  // 🔹 GET Challenge by Category Id (Menggunakan PathVariable)
  Future<List<ChallengeModel>> getChallengeByCategoryId(int categoryId) async {
    try {
      Response response = await _dio.get(
        'challenger/category/$categoryId',
        options: Options(headers: {'Cache-Control': 'no-cache'}),
      );

      if (response.statusCode == 200) {
        List data = response.data;

        return data.map((json) => ChallengeModel.fromMap(json)).toList();
      } else {
        throw Exception("Failed to fetch challenge");
      }
    } on DioException catch (e) {
      throw Exception("Error fetching challenge: ${e.message}");
    }
  }

  // 🔹 GET Challenge by Challenge Id (Menggunakan PathVariable)
  Future<ChallengeModel> getChallengeByChallengeId(int challengeId) async {
    try {
      final response = await _dio.get(
        'challenger/$challengeId',
        options: Options(headers: {'Cache-Control': 'no-cache'}),
      );

      if (response.statusCode == 200) {
        return ChallengeModel.fromMap(response.data);
      } else {
        throw Exception("Failed to fetch challenge");
      }
    } on DioException catch (e) {
      throw Exception("Error fetching challenge: ${e.message}");
    }
  }

  // 🔹 GET Category
  Future<List<CategoryModel>> getCategory() async {
    try {
      Response response = await _dio.get(
        'categories',
        options: Options(headers: {'Cache-Control': 'no-cache'}),
      );

      if (response.statusCode == 200) {
        List data = response.data;

        return data.map((json) => CategoryModel.fromMap(json)).toList();
      } else {
        throw Exception("Failed to fetch categories");
      }
    } on DioException catch (e) {
      throw Exception("Error fetching categories: ${e.message}");
    }
  }

  // 🔹 POST User accept challenge
  Future<Map<String, dynamic>> acceptChallenge(
      String userId, int challengeId) async {
    try {
      Response response = await _dio.post(
        'user-challenge/accept-challenge',
        data: {"userId": userId, "challengeId": challengeId},
        options: Options(headers: {'Cache-Control': 'no-cache'}),
      );

      return response.data; // Jika sukses, langsung return response
    } on DioException catch (e) {
      // Tangani error berdasarkan status code
      String errorMessage;
      if (e.response?.statusCode == 400) {
        errorMessage = "Anda sudah mengikuti challenge ini sebelumnya!";
      } else if (e.response?.statusCode == 500) {
        errorMessage = "Server sedang bermasalah, coba lagi nanti.";
      } else {
        errorMessage = "Terjadi kesalahan jaringan: ${e.message}";
      }

      return {"success": false, "message": errorMessage};
    } catch (e) {
      return {"success": false, "message": "Terjadi kesalahan sistem: $e"};
    }
  }
}
