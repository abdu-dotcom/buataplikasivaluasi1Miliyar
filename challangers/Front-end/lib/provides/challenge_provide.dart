import 'package:challangers/models/challenge_model.dart';
import 'package:challangers/repositories/challenge_repositories.dart';
import 'package:flutter/material.dart';

class ChallengeProvider with ChangeNotifier {
  final ChallengeRepository _repository = ChallengeRepository();
  List<ChallengeModel> _challenges = [];
  ChallengeModel? _challengeDetail; // ✅ Tambahkan ini
  bool _isLoading = true;

  List<ChallengeModel> get challenges => _challenges;
  ChallengeModel? get challengeDetail => _challengeDetail;
  bool get isLoading => _isLoading;

  Future<void> fetchChallenges() async {
    _isLoading = true;
    notifyListeners();

    try {
      _challenges = await _repository.getChallenges();
    } catch (e) {}

    _isLoading = false;
    notifyListeners();
  }

  // 🔹 Fetch Challenge by Category and ID
  Future<void> fetchChallengeByCategoryAndId(int categoryId) async {
    _isLoading = true;
    notifyListeners();

    try {
      _challenges = await _repository.getChallengesByCategoryId(categoryId);
    } catch (e) {
      _challenges = []; // Kosongkan jika error
    }

    _isLoading = false;
    notifyListeners();
  }

  // 🔹 Fetch Challenge by Category and ID
  Future<void> fetchChallengeByChallengeId(int challengeId) async {
    _isLoading = true;
    notifyListeners();

    try {
      final response =
          await _repository.getChallengesByChallengeId(challengeId);

      _challengeDetail = response;
    } catch (e) {
      _challengeDetail = null;
    }

    _isLoading = false;
    notifyListeners();
  }
}
