import 'package:challangers/Widgets/challenge_progress_card.dart';

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
      appBar: PreferredSize(
          preferredSize: const Size.fromHeight(kToolbarHeight),
          child: AppBar(
            title: const Text("Explore"),
            automaticallyImplyLeading: false, // ✅ Hilangkan tombol back
            backgroundColor: Colors.white,
            scrolledUnderElevation: 0, // ✅ Mencegah perubahan warna saat scroll
            elevation: 0,
            titleTextStyle: const TextStyle(
                fontSize: 24, fontWeight: FontWeight.bold, color: Colors.black),
          )),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start, // ✅ Rata kiri semua
          children: [
            const Text(
              'Witness People Rise to the Challenge!',
              textAlign: TextAlign.left,
              style: TextStyle(
                fontSize: 14,
              ),
            ),
            const SizedBox(height: 24),
            _FilterButtons(),
            const SizedBox(height: 24),
            Expanded(
              child: ScrollConfiguration(
                behavior:
                    ScrollConfiguration.of(context).copyWith(scrollbars: false),
                child: ListView.builder(
                  itemCount: challenges.length,
                  itemBuilder: (context, index) {
                    return ChallengeCard(challenge: challenges[index]);
                  },
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

// Widget untuk tombol filter (Other People & My Progress)
class _FilterButtons extends StatelessWidget {
  const _FilterButtons({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Container(
          decoration: BoxDecoration(
              color: const Color.fromRGBO(243, 243, 243, 1),
              borderRadius: BorderRadius.all(Radius.circular(16))),
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Row(
              children: [
                Expanded(
                  child: ElevatedButton(
                    onPressed: () {},
                    style: ElevatedButton.styleFrom(
                      padding: EdgeInsetsDirectional.symmetric(vertical: 18),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(12),
                      ),
                      backgroundColor: Colors.black,
                      foregroundColor: Colors.white,
                    ),
                    child: const Text("Other People"),
                  ),
                ),
                const SizedBox(width: 5),
                Expanded(
                  child: ElevatedButton(
                    onPressed: () {},
                    style: ElevatedButton.styleFrom(
                      padding: EdgeInsetsDirectional.symmetric(vertical: 18),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(12),
                      ),
                      backgroundColor: Colors.grey[350],
                      foregroundColor: Colors.white,
                    ),
                    child: const Text("My Progress"),
                  ),
                ),
              ],
            ),
          ),
        ),
      ],
    );
  }
}
