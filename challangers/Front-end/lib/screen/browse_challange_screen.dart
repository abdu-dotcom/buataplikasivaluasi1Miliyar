import 'package:challangers/provides/challenge_provide.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../widgets/challenge_list_card.dart';

class BrowseChallengeScreen extends StatefulWidget {
  final int categoryId; // ⬅ Tambahkan ini

  const BrowseChallengeScreen({super.key, required this.categoryId});

  @override
  State<BrowseChallengeScreen> createState() => _BrowseChallengeScreenState();
}

class _BrowseChallengeScreenState extends State<BrowseChallengeScreen> {
  @override
  void initState() {
    super.initState();

    // Memanggil fetchChallenges() saat layar pertama kali dibuka
    Future.microtask(() =>
        Provider.of<ChallengeProvider>(context, listen: false)
            .fetchChallengeByCategoryAndId(widget.categoryId));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        scrolledUnderElevation: 0, // ✅ Mencegah perubahan warna saat scroll
        leading: IconButton(
          icon: const Icon(Icons.arrow_back, color: Colors.black),
          onPressed: () => Navigator.pop(context),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              "Find Your Next Challenge",
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 8),
            Text(
              "Temukan tantangan baru untuk meningkatkan kebiasaan positifmu.",
              style: TextStyle(fontSize: 14, color: Colors.grey[600]),
            ),
            const SizedBox(height: 16),

            // Expanded untuk daftar tantangan
            Expanded(
              child: Consumer<ChallengeProvider>(
                builder: (context, provider, child) {
                  if (provider.isLoading) {
                    return const Center(child: CircularProgressIndicator());
                  }

                  if (provider.challenges.isEmpty) {
                    return const Center(child: Text("No Challenges Available"));
                  }

                  return ListView.builder(
                    itemCount: provider.challenges.length,
                    itemBuilder: (context, index) {
                      return ChallengeListCard(
                        challenge: provider.challenges[index],
                      );
                    },
                  );
                },
              ),
            ),

            // Footer Motivasi
            Padding(
              padding: const EdgeInsets.only(top: 16.0, bottom: 24.0),
              child: Column(
                children: [
                  const Divider(), // Garis pemisah
                  const SizedBox(height: 8),
                  Text(
                    "“Tantangan terbesar adalah mengalahkan diri sendiri.”",
                    style: TextStyle(
                      fontSize: 14,
                      fontStyle: FontStyle.italic,
                      color: Colors.grey[700],
                    ),
                    textAlign: TextAlign.center,
                  ),
                  const SizedBox(height: 8),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
