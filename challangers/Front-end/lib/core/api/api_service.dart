import 'package:challangers/models/category_model.dart';
import 'package:challangers/models/challenge_model.dart';
import 'package:dio/dio.dart';
import 'package:flutter/foundation.dart';
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
        'accept-challenge',
        data: {"userId": userId, "challengeId": challengeId},
        options: Options(headers: {'Cache-Control': 'no-cache'}),
      );

      return response.data; // Jika sukses, langsung return response
    } on DioException catch (e) {
      String errorMessage;
      if (e.response != null) {
        // 🛠 Debugging Log
        debugPrint("🔥 Error Response: ${e.response!.data}");

        errorMessage = e.response!.data['message'] ?? "Terjadi kesalahan!";
      } else {
        errorMessage = "Terjadi kesalahan jaringan: ${e.message}";
      }

      return {"success": false, "message": errorMessage};
    } catch (e) {
      debugPrint("🔥 Unexpected Error: $e");
      return {"success": false, "message": "Terjadi kesalahan sistem: $e"};
    }
  }

  // 🔹 GET User challenge List
  Future<Map<String, dynamic>> userChallenges(String userId) async {
    try {
      Response response = await _dio.get(
        'user-challenge/$userId',
        options: Options(headers: {'Cache-Control': 'no-cache'}),
      );

      return response.data; // Jika sukses, langsung return response
    } on DioException catch (e) {
      // Tangani error berdasarkan status code
      return {"success": false, "message": e.stackTrace};
    } catch (e) {
      return {"success": false, "message": "Terjadi kesalahan sistem: $e"};
    }
  }

  // 🔹 GET Leaderboard and User Rank
  Future<Map<String, dynamic>> getLeaderboard(String userId) async {
    try {
      Response response = await _dio.get(
        'leaderboard/$userId',
        options: Options(headers: {'Cache-Control': 'no-cache'}),
      );

      return response.data; // Jika sukses, langsung return response
    } on DioException catch (e) {
      // Tangani error berdasarkan status code
      return {"success": false, "message": e.stackTrace};
    } catch (e) {
      return {"success": false, "message": "Terjadi kesalahan sistem: $e"};
    }
  }
}
