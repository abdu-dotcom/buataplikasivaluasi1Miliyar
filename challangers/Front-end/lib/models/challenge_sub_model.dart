class ChallengeSubModel {
  final int challengeSubId;
  final int challengeId;
  final String challengeSubName;
  final int challengeSubPoint;
  final String challengeSubTypeDeadline;
  final DateTime challengeSubDeadlineTime;

  ChallengeSubModel({
    required this.challengeSubId,
    required this.challengeId,
    required this.challengeSubName,
    required this.challengeSubPoint,
    required this.challengeSubTypeDeadline,
    required this.challengeSubDeadlineTime,
  });

  /// Convert Map to Object (Deserialization)
  factory ChallengeSubModel.fromMap(Map<String, dynamic> map) {
    return ChallengeSubModel(
      challengeSubId: map['challenge_sub_id'] as int,
      challengeId: map['challenge_id'] as int,
      challengeSubName: map['challenge_sub_name'] as String,
      challengeSubPoint: map['challenge_sub_point'] as int,
      challengeSubTypeDeadline: map['challenge_sub_tipe_deadlne'] as String,
      challengeSubDeadlineTime:
          DateTime.parse(map['challenge_sub_deadline_time']),
    );
  }

  /// Convert Object to Map (Serialization)
  Map<String, dynamic> toMap() {
    return {
      'challenge_sub_id': challengeSubId,
      'challenge_id': challengeId,
      'challenge_sub_name': challengeSubName,
      'challenge_sub_point': challengeSubPoint,
      'challenge_sub_tipe_deadlne': challengeSubTypeDeadline,
      'challenge_sub_deadline_time': challengeSubDeadlineTime.toIso8601String(),
    };
  }
}
