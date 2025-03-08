class UserChallengeProgressModel {
  final int progressId;
  final int userChallengeId;
  final int challengeSubId;
  final String caption;
  final String proofUrl;
  final String status;
  final DateTime startedAt;
  final DateTime? completedAt;
  final DateTime deadlineAt;

  UserChallengeProgressModel({
    required this.progressId,
    required this.userChallengeId,
    required this.challengeSubId,
    required this.caption,
    required this.proofUrl,
    required this.status,
    required this.startedAt,
    this.completedAt,
    required this.deadlineAt,
  });

  /// Convert Map to Object (Deserialization)
  factory UserChallengeProgressModel.fromMap(Map<String, dynamic> map) {
    return UserChallengeProgressModel(
      progressId: map['progress_id'] as int,
      userChallengeId: map['user_challange_id'] as int,
      challengeSubId: map['challenge_sub_id'] as int,
      caption: map['caption'] as String,
      proofUrl: map['proof_url'] as String,
      status: map['status'] as String,
      startedAt: DateTime.parse(map['started_at']),
      completedAt: map['completed_at'] != null
          ? DateTime.parse(map['completed_at'])
          : null,
      deadlineAt: DateTime.parse(map['deadline_at']),
    );
  }

  /// Convert Object to Map (Serialization)
  Map<String, dynamic> toMap() {
    return {
      'progress_id': progressId,
      'user_challange_id': userChallengeId,
      'challenge_sub_id': challengeSubId,
      'caption': caption,
      'proof_url': proofUrl,
      'status': status,
      'started_at': startedAt.toIso8601String(),
      'completed_at': completedAt?.toIso8601String(),
      'deadline_at': deadlineAt.toIso8601String(),
    };
  }
}
