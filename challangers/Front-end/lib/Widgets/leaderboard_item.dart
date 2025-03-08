import 'package:challangers/models/leaderboard_model.dart';
import 'package:flutter/material.dart';

class LeaderboardItem extends StatelessWidget {
  final LeaderboardModel leaderboardModel; // Pastikan nama variabel ini benar

  const LeaderboardItem(
      {super.key, required this.leaderboardModel}); // Perbaiki di sini

  @override
  Widget build(BuildContext context) {
    return Card(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
      margin: const EdgeInsets.symmetric(vertical: 5, horizontal: 10),
      child: ListTile(
        leading: CircleAvatar(
          backgroundImage: NetworkImage("as"), // ✅ Pastikan ada data gambar
        ),
        title: Text(
          leaderboardModel.userId, // ✅ Perbaiki akses nama
          style: const TextStyle(fontWeight: FontWeight.bold),
        ),
        subtitle: Text('Challenges Completed'), // ✅ Benar
        trailing: Text(
          '#asdasd', // ✅ Pastikan ada rank
          style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
        ),
      ),
    );
  }
}
