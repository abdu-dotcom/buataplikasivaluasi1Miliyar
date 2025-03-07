class ChallengeModel {
  final String category;
  final String imageUrl;
  final String title;
  final double progress;
  final String userId;
  final String description;

  ChallengeModel({
    required this.category,
    required this.imageUrl,
    required this.title,
    required this.progress,
    required this.userId,
    required this.description,
  });

  // Convert object to Map<String, dynamic>
  Map<String, dynamic> toJson() {
    return {
      'category': category,
      'imageUrl': imageUrl,
      'title': title,
      'progress': progress,
      'userId': userId,
      'description': description,
    };
  }

  // Convert Map<String, dynamic> to object
  factory ChallengeModel.fromJson(Map<String, dynamic> json) {
    return ChallengeModel(
      category: json['category'],
      imageUrl: json['imageUrl'],
      title: json['title'],
      progress: (json['progress'] as num).toDouble(),
      userId: json['userId'],
      description: json['description'],
    );
  }
}
