import 'dart:convert';
import 'package:challangers/core/api/api_service.dart';
import 'package:challangers/models/user_challenge_model.dart';

class UserChallengeRepository {
  final ApiService _apiService = ApiService();

  Future<UserChallengeResponse> userChallenges(String userId) async {
    final response = await _apiService.userChallenges(userId);

    /// ✅ Konversi response dari `Map<String, dynamic>` ke model `UserChallengeResponse`
    return UserChallengeResponse.fromJson(response);
  }
}
