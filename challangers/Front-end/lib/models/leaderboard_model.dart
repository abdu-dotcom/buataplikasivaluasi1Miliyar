class LeaderboardModel {
  final int leaderboardId;
  final String userId;
  final int score;
  final DateTime recordAt;

  LeaderboardModel({
    required this.leaderboardId,
    required this.userId,
    required this.score,
    required this.recordAt,
  });

  /// Convert Map to Object (Deserialization)
  factory LeaderboardModel.fromMap(Map<String, dynamic> map) {
    return LeaderboardModel(
      leaderboardId: map['leaderboard_id'] as int,
      userId: map['user_id'] as String,
      score: map['score'] as int,
      recordAt: DateTime.parse(map['record_at']),
    );
  }

  /// Convert Object to Map (Serialization)
  Map<String, dynamic> toMap() {
    return {
      'leaderboard_id': leaderboardId,
      'user_id': userId,
      'score': score,
      'record_at': recordAt.toIso8601String(),
    };
  }
}
