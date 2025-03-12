import 'package:challangers/models/category_model.dart';
import 'package:challangers/models/challenge_model.dart';
import 'package:dio/dio.dart';
import 'api_client.dart';

class ApiService {
  final Dio _dio = ApiClient().dio;

  ///  CHALLENGE API ///
  Future<List<ChallengeModel>> fetchChallenges() async {
    try {
      Response response = await _dio.get('challengers');
      List data = response.data;
      return data.map((json) => ChallengeModel.fromMap(json)).toList();
    } catch (e) {
      throw Exception("Failed to load challenges: $e");
    }
  }

  // 🔹 GET Challenge by Category and ID (Menggunakan PathVariable)
  Future<List<ChallengeModel>> getChallengeByCategoryId(int categoryId) async {
    try {
      Response response = await _dio.get(
        'challenger/category/$categoryId',
        options: Options(headers: {'Cache-Control': 'no-cache'}),
      );

      print("data: ${response}");

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

  ///  CHALLENGE CATEGORY API ///
  /// GET CATEGORY
  Future<List<CategoryModel>> getCategory() async {
    try {
      Response response = await _dio.get(
        'categories',
        options: Options(headers: {'Cache-Control': 'no-cache'}),
      );

      print("data: ${response}");

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
}
