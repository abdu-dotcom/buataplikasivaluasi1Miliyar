import 'package:challangers/Widgets/leaderboard_item.dart';
import 'package:challangers/data/leaderboard.dart';
import 'package:flutter/material.dart';

class LeaderboardScreen extends StatelessWidget {
  const LeaderboardScreen({super.key}); // ✅ Tambahkan const dan super.key

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Leaderboard")),
      body: ListView.builder(
        itemCount:
            sampleLeaderboard.length, // ✅ Langsung pakai sampleLeaderboard
        itemBuilder: (context, index) {
          return LeaderboardItem(
            leaderboardModel: sampleLeaderboard[index],
          ); // ✅ Pastikan sesuai
        },
      ),
    );
  }
}
