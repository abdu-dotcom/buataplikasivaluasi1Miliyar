class UserChallengeModel {
  final int userChallengeId;
  final int challengeId;
  final String challengeLevel;
  final String status;
  final DateTime joinedAt;
  final DateTime? finishedAt;
  final DateTime deadlineAt;
  final int progres;

  UserChallengeModel(
      {required this.userChallengeId,
      required this.challengeId,
      required this.challengeLevel,
      required this.status,
      required this.joinedAt,
      this.finishedAt,
      required this.deadlineAt,
      required this.progres});

  /// Convert Map to Object (Deserialization)
  factory UserChallengeModel.fromMap(Map<String, dynamic> map) {
    return UserChallengeModel(
        userChallengeId: map['user_challenge_id'] as int,
        challengeId: map['challenge_id'] as int,
        challengeLevel: map['challenge_level'] as String,
        status: map['status'] as String,
        joinedAt: DateTime.parse(map['joined_at']),
        finishedAt: map['finished_at'] != null
            ? DateTime.parse(map['finished_at'])
            : null,
        deadlineAt: DateTime.parse(map['deadline_at']),
        progres: map['progress']);
  }

  /// Convert Object to Map (Serialization)
  Map<String, dynamic> toMap() {
    return {
      'user_challenge_id': userChallengeId,
      'challenge_id': challengeId,
      'status': status,
      'joined_at': joinedAt.toIso8601String(),
      'finished_at': finishedAt?.toIso8601String(),
      'deadline_at': deadlineAt.toIso8601String(),
      'progress': progres
    };
  }
}
