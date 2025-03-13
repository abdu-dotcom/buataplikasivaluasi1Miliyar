import 'package:challangers/models/challenge_model.dart';
import '../core/api/api_service.dart';

class ChallengeRepository {
  final ApiService _apiService = ApiService();

  Future<List<ChallengeModel>> getChallenges() async {
    return await _apiService.fetchChallenges();
  }

  Future<List<ChallengeModel>> getChallengesByCategoryId(int categoryId) async {
    return await _apiService.getChallengeByCategoryId(categoryId);
  }

  Future<ChallengeModel?> getChallengesByChallengeId(int challengeId) async {
    return await _apiService.getChallengeByChallengeId(challengeId);
  }
}
