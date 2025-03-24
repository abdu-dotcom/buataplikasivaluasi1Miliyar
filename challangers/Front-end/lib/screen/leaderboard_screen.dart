import 'package:challangers/Widgets/leaderboard_item.dart';
import 'package:challangers/provides/leaderboard_provide.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class LeaderboardScreen extends StatefulWidget {
  const LeaderboardScreen({super.key});

  @override
  _LeaderboardScreenState createState() => _LeaderboardScreenState();
}

class _LeaderboardScreenState extends State<LeaderboardScreen> {
  @override
  void initState() {
    super.initState();

    // ✅ Ambil data leaderboard saat pertama kali layar dibuka
    Future.microtask(() {
      final provider = Provider.of<LeaderboardProvider>(context, listen: false);
      provider.loadLeaderboard(
          "CHALLENGE000095"); // Gantilah dengan userId yang sesuai
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        title: const Text("Global Leaderboard"),
        scrolledUnderElevation: 0,
        automaticallyImplyLeading: false,
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16),
        child: Consumer<LeaderboardProvider>(
          builder: (context, provider, child) {
            if (provider.isLoading) {
              return const Center(child: CircularProgressIndicator());
            }

            if (provider.errorMessage != null) {
              return Center(
                child: Text(
                  provider.errorMessage!,
                  style: const TextStyle(color: Colors.red),
                ),
              );
            }

            if (provider.leaderboard == null ||
                provider.leaderboard!.rankLeaderboardModel.isEmpty) {
              return const Center(child: Text("Belum ada data leaderboard."));
            }

            return Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                const Text(
                  'Lihat peringkatmu di antara para Challenger dan terus kumpulkan poin untuk naik ke puncak!',
                  textAlign: TextAlign.left,
                  style: TextStyle(fontSize: 14),
                ),
                const SizedBox(height: 14),
                Expanded(
                  child: ListView.builder(
                    itemCount:
                        provider.leaderboard!.rankLeaderboardModel.length,
                    itemBuilder: (context, index) {
                      return LeaderboardItem(
                          rankLeaderboardModel: provider
                              .leaderboard!.rankLeaderboardModel[index]);
                    },
                  ),
                ),
              ],
            );
          },
        ),
      ),
    );
  }
}
