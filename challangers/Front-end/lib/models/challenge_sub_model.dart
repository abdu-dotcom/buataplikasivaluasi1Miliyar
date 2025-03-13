class ChallengeSubModel {
  final int challengeSubId;
  final String challengeSubName;
  final int challengeSubPoint;
  final String? challengeSubTypeDeadline;
  final int? challengeSubDeadlineTime;

  ChallengeSubModel({
    required this.challengeSubId,
    required this.challengeSubName,
    required this.challengeSubPoint,
    this.challengeSubTypeDeadline, // Bisa null
    this.challengeSubDeadlineTime, // Bisa null
  });

  /// Convert Map to Object (Deserialization)
  factory ChallengeSubModel.fromMap(Map<String, dynamic> map) {
    return ChallengeSubModel(
      challengeSubId: map['challengeSubId'] as int? ?? 0,
      challengeSubName: map['challengeSubName'] as String? ?? 'Unknown',
      challengeSubPoint: map['challengeSubPoint'] as int? ?? 0,
      challengeSubTypeDeadline:
          map['challengeSubTipeDeadline'] as String? ?? '', // ✅ Tangani null
      challengeSubDeadlineTime:
          map['challengeSubDeadlineTime'] as int?, // Bisa null
    );
  }

  /// Convert Object to Map (Serialization)
  Map<String, dynamic> toMap() {
    return {
      'challengeSubId': challengeSubId,
      'challengeSubName': challengeSubName,
      'challengeSubPoint': challengeSubPoint,
      'challengeSubTipeDeadline': challengeSubTypeDeadline,
      'challengeSubDeadlineTime': challengeSubDeadlineTime,
    };
  }
}
