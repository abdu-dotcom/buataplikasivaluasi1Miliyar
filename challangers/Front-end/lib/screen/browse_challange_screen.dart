import 'package:flutter/material.dart';
import 'package:challangers/data/challenge.dart';
import 'package:challangers/widgets/challenge_list_card.dart';

class BrowseChallengeScreen extends StatelessWidget {
  const BrowseChallengeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
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
              child: ListView.builder(
                itemCount: sampleChallenges.length,
                itemBuilder: (context, index) {
                  return ChallengeListCard(
                    challenge: sampleChallenges[index],
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
