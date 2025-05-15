import 'package:challangers/services/log_service.dart';
import 'package:flutter/material.dart';
import 'package:challangers/models/leaderboard_model.dart';
import 'package:challangers/repositories/leaderboard_repositories.dart';

class LeaderboardProvider with ChangeNotifier {
  final LeaderboardRepository _repository = LeaderboardRepository();
  LeaderboardModel? _leaderboard;
  bool _isLoading = false;
  String? _errorMessage;

  LeaderboardModel? get leaderboard => _leaderboard;
  bool get isLoading => _isLoading;
  String? get errorMessage => _errorMessage;

  Future<void> loadLeaderboard(String userId) async {
    _isLoading = true;
    _errorMessage = null;
    notifyListeners();

    try {
      final data = await _repository.getLeaderboard(userId);

      LogService.logger.d("➡️ response (provide): ${data?.toJson()} ");

      if (data == null) {
        _errorMessage = "Leaderboard tidak tersedia";
        LogService.logger.e("❌ Leaderboard null setelah fetch");
      } else {
        _leaderboard = data;
        LogService.logger
            .d("✅ Leaderboard disimpan: ${_leaderboard!.toJson()}");
      }
      _leaderboard = data;
    } catch (e) {
      _errorMessage = "Terjadi kesalahan: $e";
    }

    _isLoading = false;
    notifyListeners();
  }
}
