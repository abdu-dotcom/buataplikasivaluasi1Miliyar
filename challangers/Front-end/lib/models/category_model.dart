import 'package:flutter/material.dart';

class CategoryModel {
  final int categoryId;
  final String categoryName;
  final String categoryDesc;
  final IconData categoryImg;

  CategoryModel({
    required this.categoryId,
    required this.categoryName,
    required this.categoryDesc,
    required this.categoryImg,
  });

  /// Convert Map to Object (Deserialization)
  factory CategoryModel.fromMap(Map<String, dynamic> map) {
    return CategoryModel(
      categoryId: map['categoryId'] as int,
      categoryName: map['categoryName'] as String,
      categoryDesc: map['categoryDesc'] as String,
      categoryImg: map['categoryImg'] as IconData,
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
