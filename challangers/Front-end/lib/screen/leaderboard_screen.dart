import '../Widgets/leaderboard_item.dart';
import '../data/leaderboard.dart';
import 'package:flutter/material.dart';

class LeaderboardScreen extends StatelessWidget {
  const LeaderboardScreen({super.key}); // ✅ Tambahkan const dan super.key

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        title: const Text("Global Leaderboard"),
        scrolledUnderElevation: 0,
        automaticallyImplyLeading: false, // ✅ Hilangkan tombol back
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16),
        child: Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
          const Text(
            'Lihat peringkatmu di antara para Challenger dan terus kumpulkan poin untuk naik ke puncak!',
            textAlign: TextAlign.left,
            style: TextStyle(
              fontSize: 14,
            ),
          ),
          const SizedBox(height: 14),
          Expanded(
            child: ListView.builder(
              itemCount: sampleLeaderboard
                  .length, // ✅ Langsung pakai sampleLeaderboard
              itemBuilder: (context, index) {
                return LeaderboardItem(
                  leaderboardModel: sampleLeaderboard[index],
                ); // ✅ Pastikan sesuai
              },
            ),
          ),
        ]),
      ),
    );
  }
}
