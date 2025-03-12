import 'package:challangers/models/category_model.dart';
import 'package:challangers/repositories/category_repositories.dart';
import 'package:flutter/material.dart';

class CategoryProvide with ChangeNotifier {
  final CategoryRepositories _repository = CategoryRepositories();
  List<CategoryModel> _categories = [];
  bool _isLoading = true;

  List<CategoryModel> get category => _categories;
  bool get isLoading => _isLoading;

  Future<void> getCategories() async {
    _isLoading = true;
    notifyListeners();

    try {
      _categories = await _repository.getCategories();
    } catch (e) {
      print("Error: $e");
    }

    _isLoading = false;
    notifyListeners();
  }
}
