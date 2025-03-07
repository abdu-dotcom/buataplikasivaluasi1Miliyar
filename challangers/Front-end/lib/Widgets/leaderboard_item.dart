import 'package:challangers/models/Leaderboard.dart';
import 'package:flutter/material.dart';

class LeaderboardItem extends StatelessWidget {
  final LeaderboardModel user;

  const LeaderboardItem({super.key, required this.user});

  @override
  Widget build(BuildContext context) {
    return Card(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
      margin: const EdgeInsets.symmetric(vertical: 5, horizontal: 10),
      child: ListTile(
        leading: CircleAvatar(
          backgroundImage: AssetImage(user.profileImage),
        ),
        title: Text(
          user.username,
          style: const TextStyle(fontWeight: FontWeight.bold),
        ),
        subtitle: Text('${user.completedChallenges} Challenges Completed'),
        trailing: Text(
          '#${user.rank}',
          style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
        ),
      ),
    );
  }
}
