import 'package:challangers/core/api/api_service.dart';

class UserChallengeRepositories {
  final ApiService _apiService = ApiService();

  Future<Map<String, dynamic>> acceptChallenge(
      String userId, int challengeId) async {
    return await _apiService.acceptChallenge(userId, challengeId);
  }
}
