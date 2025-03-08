import 'package:challangers/models/leaderboard_model.dart';

final List<LeaderboardModel> sampleLeaderboard = [
  LeaderboardModel(
    leaderboardId: 1,
    userId: "CHALLENGE000001",
    score: 250,
    recordAt: DateTime.now().subtract(Duration(days: 1)),
  ),
  LeaderboardModel(
    leaderboardId: 2,
    userId: "CHALLENGE000002",
    score: 300,
    recordAt: DateTime.now().subtract(Duration(days: 2)),
  ),
];
