class ChallengeModel {
  final int challengeId;
  final String challengeName;
  final String challengeDescription;
  final String challengeLevel;
  final int challengeParticipation;
  final int challengeParticipationProgress;
  final int challengeParticipationFinished;
  final int challengeParticipationFailed;
  final int categoriId;
  final DateTime createAt;
  final DateTime updateAt;

  ChallengeModel({
    required this.challengeId,
    required this.challengeName,
    required this.challengeDescription,
    required this.challengeLevel,
    required this.challengeParticipation,
    required this.challengeParticipationProgress,
    required this.challengeParticipationFinished,
    required this.challengeParticipationFailed,
    required this.categoriId,
    required this.createAt,
    required this.updateAt,
  });

  /// Convert Map to Object (Deserialization)
  factory ChallengeModel.fromMap(Map<String, dynamic> map) {
    return ChallengeModel(
      challengeId: map['challengeId'] as int,
      challengeName: map['challengeName'] as String,
      challengeDescription: map['challengeDescription'] as String,
      challengeLevel: map['challengeLevel'] as String,
      challengeParticipation: map['challengeParticipation'] as int,
      challengeParticipationProgress:
          map['challengeParticipationProgress'] as int,
      challengeParticipationFinished:
          map['challengeParticipationFinished'] as int,
      challengeParticipationFailed: map['challengeParticipationFailed'] as int,
      categoriId: map['categoriId'] as int,
      createAt: DateTime.parse(map['createAt']),
      updateAt: DateTime.parse(map['updateAt']),
    );
  }

  /// Convert Object to Map (Serialization)
  Map<String, dynamic> toMap() {
    return {
      'challengeId': challengeId,
      'challengeName': challengeName,
      'challengeDescription': challengeDescription,
      'challengeLevel': challengeLevel,
      'challengeParticipation': challengeParticipation,
      'challengeParticipationProgress': challengeParticipationProgress,
      'challengeParticipationFinished': challengeParticipationFinished,
      'challengeParticipationFailed': challengeParticipationFailed,
      'categoriId': categoriId,
      'createAt': createAt.toIso8601String(),
      'updateAt': updateAt.toIso8601String(),
    };
  }
}
