class CategoryModel {
  final int categoryId;
  final String categoryName;
  final String categoryDesc;
  final String categoryImg;

  CategoryModel({
    required this.categoryId,
    required this.categoryName,
    required this.categoryDesc,
    required this.categoryImg,
  });

  /// Convert Map to Object (Deserialization)
  factory CategoryModel.fromMap(Map<String, dynamic> map) {
    return CategoryModel(
      categoryId: map['category_id'] as int,
      categoryName: map['category_name'] as String,
      categoryDesc: map['category_desc'] as String,
      categoryImg: map['category_img'],
    );
  }

  /// Convert Object to Map (Serialization)
  Map<String, dynamic> toMap() {
    return {
      'categoryId': categoryId,
      'categoryName': categoryName,
      'categoryDesc': categoryDesc,
      'categoryImg': categoryImg,
    };
  }
}
