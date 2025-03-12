import 'package:challangers/models/category_model.dart';
import '../core/api/api_service.dart';

class CategoryRepositories {
  final ApiService _apiService = ApiService();

  Future<List<CategoryModel>> getCategories() async {
    return await _apiService.getCategory();
  }
}
