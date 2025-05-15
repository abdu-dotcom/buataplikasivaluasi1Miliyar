import 'package:challangers/models/leaderboard_model.dart';
import 'package:challangers/services/log_service.dart';
import '../core/api/api_service.dart';

class LeaderboardRepository {
  final ApiService _apiService = ApiService();

  /// 🔹 Mengambil data leaderboard lengkap
  Future<LeaderboardModel?> getLeaderboard(String userId) async {
    try {
      final response = await _apiService.getLeaderboard(userId);
      LogService.logger.d("➡️ response (repository): ${response}");

      final leaderboardModel = LeaderboardModel.fromJson(response);
      LogService.logger.d("✅ Parsed LeaderboardModel: $leaderboardModel");

      return LeaderboardModel.fromJson(response);
    } catch (e) {
      return null;
    }
  }
}
