import 'package:challangers/models/Leaderboard.dart';
import 'package:flutter/material.dart';
import '../services/leaderboard_service.dart';
import '../widgets/leaderboard_item.dart';

class LeaderboardScreen extends StatelessWidget {
  const LeaderboardScreen({super.key});

  @override
  Widget build(BuildContext context) {
    List<LeaderboardModel> leaderboard =
        LeaderboardService.getLeaderboardData();

    return Scaffold(
        appBar: AppBar(title: const Text('Leaderboard')),
        body: ListView.builder(
          itemCount: leaderboard.length,
          itemBuilder: (context, index) {
            return LeaderboardItem(user: leaderboard[index]);
          },
        ));
  }
}
