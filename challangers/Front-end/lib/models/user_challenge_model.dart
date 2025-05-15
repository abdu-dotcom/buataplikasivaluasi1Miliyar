class UserChallengeResponse {
  final String userId;
  final List<UserChallengeModel> userChallenges;

  UserChallengeResponse({
    required this.userId,
    required this.userChallenges,
  });

  /// Convert JSON Map to Object (Deserialization)
  factory UserChallengeResponse.fromJson(Map<String, dynamic> json) {
    return UserChallengeResponse(
      userId: json['userId'],
      userChallenges: (json['userChallenge'] as List)
          .map((challenge) => UserChallengeModel.fromJson(challenge))
          .toList(),
    );
  }

  /// Convert Object to JSON Map (Serialization)
  Map<String, dynamic> toJson() {
    return {
      'userId': userId,
      'userChallenge':
          userChallenges.map((challenge) => challenge.toJson()).toList(),
    };
  }
}

class UserChallengeModel {
  final String userChallengeId;
  final int challengeId;
  final String challengeName; // ✅ Tambahkan challengeName setelah challengeId
  final String challengeLevel;
  final String status;
  final DateTime joinedAt;
  final DateTime? finishedAt;
  final DateTime deadlineAt;
  final int progress;

  UserChallengeModel({
    required this.userChallengeId,
    required this.challengeId,
    required this.challengeName, // ✅ Tambahkan di constructor
    required this.challengeLevel,
    required this.status,
    required this.joinedAt,
    this.finishedAt,
    required this.deadlineAt,
    required this.progress,
  });

  /// Convert JSON Map to Object (Deserialization)
  factory UserChallengeModel.fromJson(Map<String, dynamic> json) {
    return UserChallengeModel(
      userChallengeId: json['userChallengeId'],
      challengeId: json['challengeId'],
      challengeName: json['challengeName'], // ✅ Ambil dari JSON
      challengeLevel: json['challengeLevel'],
      status: json['status'],
      joinedAt: DateTime.parse(json['joinedat']),
      finishedAt: json['finishedat'] != null
          ? DateTime.parse(json['finishedat'])
          : null,
      deadlineAt: DateTime.parse(json['deadlinedat']),
      progress: json['progress'],
    );
  }

  /// Convert Object to JSON Map (Serialization)
  Map<String, dynamic> toJson() {
    return {
      'userChallengeId': userChallengeId,
      'challengeId': challengeId,
      'challengeName': challengeName, // ✅ Tambahkan ke JSON
      'challengeLevel': challengeLevel,
      'status': status,
      'joinedat': joinedAt.toIso8601String(),
      'finishedat': finishedAt?.toIso8601String(),
      'deadlinedat': deadlineAt.toIso8601String(),
      'progress': progress,
    };
  }
}
