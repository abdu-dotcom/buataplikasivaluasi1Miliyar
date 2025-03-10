import '../data/challenge.dart';
import '../models/challenge_model.dart';
import 'package:flutter/material.dart';

class ExploreScreen extends StatelessWidget {
  ExploreScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    // Ubah challengeData menjadi List<ChallengeModel>
    List<ChallengeModel> challenges = sampleChallenges;

    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        title: const Text("Explore"),
        automaticallyImplyLeading: false, // ✅ Hilangkan tombol back
        backgroundColor: Colors.white,
        scrolledUnderElevation: 0, // ✅ Mencegah perubahan warna saat scroll
        elevation: 0,
        titleTextStyle: const TextStyle(
            fontSize: 24, fontWeight: FontWeight.bold, color: Colors.black),
      ),
      body: Column(
        children: [
          const Padding(
            padding: EdgeInsets.all(16.0),
            child: _FilterButtons(),
          ),
          Expanded(
            child: ListView.builder(
              itemCount: challenges.length,
              itemBuilder: (context, index) {
                return ChallengeCard(challenge: challenges[index]);
              },
            ),
          ),
        ],
      ),
    );
  }
}

// Widget untuk tombol filter (Other People & My Progress)
class _FilterButtons extends StatelessWidget {
  const _FilterButtons({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Expanded(
          child: ElevatedButton(
            onPressed: () {},
            style: ElevatedButton.styleFrom(
              backgroundColor: Colors.black,
              foregroundColor: Colors.white,
            ),
            child: const Text("Other People"),
          ),
        ),
        const SizedBox(width: 10),
        Expanded(
          child: ElevatedButton(
            onPressed: () {},
            style: ElevatedButton.styleFrom(
              backgroundColor: Colors.grey[300],
              foregroundColor: Colors.black,
            ),
            child: const Text("My Progress"),
          ),
        ),
      ],
    );
  }
}

// Widget ChallengeCard yang menerima ChallengeModel
class ChallengeCard extends StatelessWidget {
  final ChallengeModel challenge;

  const ChallengeCard({Key? key, required this.challenge}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      color: Colors.white,
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              challenge.challengeName,
              style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            Text("Category: ${challenge.categoriId}"),
            Text("User: NULL"),
            Text("Progress: 100%"),
          ],
        ),
      ),
    );
  }
}
