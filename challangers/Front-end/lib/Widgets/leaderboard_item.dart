import 'package:challangers/models/leaderboard_model.dart';
import 'package:flutter/material.dart';

class LeaderboardItem extends StatelessWidget {
  final LeaderboardModel leaderboardModel; // Properti yang benar

  const LeaderboardItem({super.key, required this.leaderboardModel});

  @override
  Widget build(BuildContext context) {
    return Card(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
      margin: const EdgeInsets.symmetric(vertical: 5, horizontal: 10),
      child: ListTile(
        leading: CircleAvatar(
          backgroundImage:
              AssetImage('assets/images/sample_challenge.png'), // Perbaikan
        ),
        title: Text(
          leaderboardModel.userId, // Perbaikan
          style: const TextStyle(fontWeight: FontWeight.bold),
        ),
        subtitle: Text('GATAUUU 1Challenges Completed'), // Perbaikan
        trailing: Text(
          'RANKKKK', // Perbaikan
          style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
        ),
      ),
    );
  }
}
