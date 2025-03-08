class MotivationModel {
  final int motivationId;
  final String motivationQuotes;
  final String motivationAuthor;

  MotivationModel({
    required this.motivationId,
    required this.motivationQuotes,
    required this.motivationAuthor,
  });

  /// Convert Map to Object (Deserialization)
  factory MotivationModel.fromMap(Map<String, dynamic> map) {
    return MotivationModel(
      motivationId: map['motivation_id'] as int,
      motivationQuotes: map['motivation_quotes'] as String,
      motivationAuthor: map['motivation_author'] as String,
    );
  }

  /// Convert Object to Map (Serialization)
  Map<String, dynamic> toMap() {
    return {
      'motivation_id': motivationId,
      'motivation_quotes': motivationQuotes,
      'motivation_author': motivationAuthor,
    };
  }
}
