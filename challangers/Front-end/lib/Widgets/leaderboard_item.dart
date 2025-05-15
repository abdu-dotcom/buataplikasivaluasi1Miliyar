import 'package:flutter/material.dart';
import 'package:challangers/models/leaderboard_model.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

class LeaderboardItem extends StatelessWidget {
  final RankLeaderboardModel rankLeaderboardModel;

  const LeaderboardItem({
    super.key,
    required this.rankLeaderboardModel,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        color: const Color.fromARGB(249, 249, 249, 249),
        borderRadius: BorderRadius.circular(4),
      ),
      margin: const EdgeInsets.symmetric(vertical: 4),
      padding: const EdgeInsets.symmetric(horizontal: 10),
      child: ListTile(
        contentPadding: EdgeInsets.zero, // Hilangkan padding default
        leading: Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            if (rankLeaderboardModel.rank <= 3) //
              SizedBox(
                width: 35,
                child: Icon(
                  FontAwesomeIcons.medal,
                  size: 20,
                ),
              ) //
            else
              SizedBox(
                width: 35, // Lebar tetap untuk rank agar rapi
                child: Text(
                  rankLeaderboardModel.rank.toString(),
                  textAlign: TextAlign.center,
                  style: const TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 14,
                  ),
                ),
              ),
            const SizedBox(width: 10), // Jarak antara rank dan avatar
            Stack(
              alignment: Alignment.center,
              children: [
                CircleAvatar(
                  radius: 18,
                  backgroundColor: Colors.grey[300],
                  child: const Icon(Icons.person, color: Colors.black54),
                ),
              ],
            ),
          ],
        ),
        title: Text(
          rankLeaderboardModel.userId,
          style: const TextStyle(fontSize: 14),
        ),
        trailing: SizedBox(
          width: 70, // Lebar tetap supaya angka tetap sejajar
          child: Text(
            "${rankLeaderboardModel.score} pts",
            textAlign: TextAlign.right,
            style: const TextStyle(fontWeight: FontWeight.bold),
          ),
        ),
      ),
    );
  }
}
