import 'package:challangers/repositories/user_challenge_repositories.dart';
import 'package:flutter/material.dart';
import '../models/user_challenge_model.dart';

class UserChallengeProvider extends ChangeNotifier {
  final UserChallengeRepository _repository = UserChallengeRepository();

  UserChallengeResponse? _userChallengeResponse;
  bool _isLoading = false;
  String? _errorMessage;

  UserChallengeResponse? get userChallengeResponse => _userChallengeResponse;
  bool get isLoading => _isLoading;
  String? get errorMessage => _errorMessage;

  /// Fetch daftar tantangan pengguna berdasarkan `userId`
  Future<void> fetchUserChallenges(String userId) async {
    try {
      _isLoading = true;
      notifyListeners();

      /// ✅ Sekarang `userChallenges()` mengembalikan `UserChallengeResponse`
      _userChallengeResponse = await _repository.userChallenges(userId);
      _errorMessage = null;
    } catch (e) {
      _errorMessage = "Gagal mengambil tantangan: ${e.toString()}";
    } finally {
      _isLoading = false;
      notifyListeners();
    }
  }
}
