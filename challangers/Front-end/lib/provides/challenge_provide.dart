import 'package:challangers/models/challenge_model.dart';
import 'package:challangers/repositories/challenge_repositories.dart';
import 'package:flutter/material.dart';

class ChallengeProvider with ChangeNotifier {
  final ChallengeRepository _repository = ChallengeRepository();
  List<ChallengeModel> _challenges = [];
  bool _isLoading = true;

  List<ChallengeModel> get challenges => _challenges;
  bool get isLoading => _isLoading;

  Future<void> fetchChallenges() async {
    _isLoading = true;
    notifyListeners();

    try {
      _challenges = await _repository.getChallenges();
    } catch (e) {
      print("Error: $e");
    }

    _isLoading = false;
    notifyListeners();
  }

  // 🔹 Fetch Challenge by Category and ID
  Future<void> fetchChallengeByCategoryAndId(int categoryId) async {
    _isLoading = true;
    notifyListeners();

    try {
      print("🔎 Fetching challenge for category ID: $categoryId");
      _challenges = await _repository.getChallengesByCategoryId(categoryId);
      print("✅ Successfully fetched ${_challenges.length} challenges");
    } catch (e, stackTrace) {
      _challenges = []; // Kosongkan jika error
      print("Error fetching challenges by category: $e");
      print(stackTrace); // Menampilkan stack trace error
    }

    _isLoading = false;
    notifyListeners();
  }
}
