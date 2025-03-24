import 'dart:convert';

import 'package:challangers/services/log_service.dart';

class LeaderboardModel {
  final UserRank userRank;
  final List<RankLeaderboardModel> rankLeaderboardModel;

  LeaderboardModel({
    required this.userRank,
    required this.rankLeaderboardModel,
  });

  /// Convert JSON Map to Object (Deserialization)
  factory LeaderboardModel.fromJson(Map<String, dynamic> json) {
    LogService.logger.d("🛠️ Parsing LeaderboardModel: ${json}");

    return LeaderboardModel(
      userRank: UserRank.fromJson(json['user_rank']),
      rankLeaderboardModel: (json['leaderboard'] as List)
          .map((challenge) => RankLeaderboardModel.fromJson(challenge))
          .toList(),
    );
  }

  /// Convert Object to JSON Map (Serialization)
  Map<String, dynamic> toJson() {
    return {
      'user_rank': userRank.toJson(),
      'leaderboard': rankLeaderboardModel.map((rank) => rank.toJson()).toList(),
    };
  }
}

class UserRank {
  final int rank;
  final String userId;
  final int score;
  final DateTime recordAt;

  UserRank({
    required this.rank,
    required this.userId,
    required this.score,
    required this.recordAt,
  });

  /// Convert JSON Map to Object (Deserialization)
  factory UserRank.fromJson(Map<String, dynamic> json) {
    return UserRank(
      rank: json['rank'] ?? 0,
      userId: json['user_id'] ?? '',
      score: json['score'] ?? 0,
      recordAt: DateTime.parse(json['record_at']),
    );
  }

  /// Convert Object to JSON Map (Serialization)
  Map<String, dynamic> toJson() {
    return {
      'rank': rank,
      'user_id': userId,
      'score': score,
      'record_at': recordAt.toIso8601String(),
    };
  }
}

class RankLeaderboardModel {
  final int rank;
  final String userId;
  final int score;
  final DateTime recordAt;

  RankLeaderboardModel({
    required this.rank,
    required this.userId,
    required this.score,
    required this.recordAt,
  });

  /// Convert JSON Map to Object (Deserialization)
  factory RankLeaderboardModel.fromJson(Map<String, dynamic> json) {
    return RankLeaderboardModel(
      rank: json['rank'] ?? 0,
      userId: json['user_id'] ?? '',
      score: json['score'] ?? 0,
      recordAt: DateTime.parse(json['record_at']),
    );
  }

  /// Convert Object to JSON Map (Serialization)
  Map<String, dynamic> toJson() {
    return {
      'rank': rank,
      'user_id': userId,
      'score': score,
      'record_at': recordAt.toIso8601String(),
    };
  }
}

/// Fungsi helper untuk JSON Parsing
LeaderboardModel leaderboardModelFromJson(String str) =>
    LeaderboardModel.fromJson(json.decode(str));

String leaderboardModelToJson(LeaderboardModel data) =>
    json.encode(data.toJson());
