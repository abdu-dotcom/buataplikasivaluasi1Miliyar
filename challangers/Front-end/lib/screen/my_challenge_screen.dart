import 'package:challangers/screen/category_screen.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import '../data/challenge.dart';
import '../widgets/custom_button.dart';

class MyChallengeScreen extends StatelessWidget {
  const MyChallengeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        automaticallyImplyLeading: false, // ✅ Hilangkan tombol back
        backgroundColor: Colors.white, // ✅ Tetap putih
        scrolledUnderElevation: 0, // ✅ Mencegah perubahan warna saat scroll
        elevation: 0, // ✅ Hilangkan bayangan
        title: const Text(
          'My Challenges List',
          style: TextStyle(
            fontSize: 18,
            fontWeight: FontWeight.bold,
            color: Colors.black, // ✅ Warna teks tetap hitam
          ),
        ),
        actions: [
          IconButton(
            icon: const Icon(Icons.share, color: Colors.black),
            onPressed: () {
              // Handle share action
            },
          ),
        ],
        systemOverlayStyle: SystemUiOverlayStyle.light.copyWith(
          statusBarColor: Colors.white, // ✅ Status bar tetap putih
          statusBarIconBrightness: Brightness.dark, // ✅ Ikon tetap hitam
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.only(left: 16, right: 16, bottom: 16, top: 0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              'Pantau perjalananmu dan selesaikan sub-challenge harian untuk meraih XP lebih banyak!',
              style: TextStyle(fontSize: 14, color: Colors.grey),
            ),
            const SizedBox(height: 32),
            Expanded(
              child: ListView.builder(
                itemCount: sampleChallenges.length,
                itemBuilder: (context, index) {
                  final challenge = sampleChallenges[index];

                  return Card(
                    color: Colors.white,
                    elevation: 2,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(12.0),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: [
                              Text(
                                challenge.challengeName,
                                style: const TextStyle(
                                    fontSize: 16, fontWeight: FontWeight.bold),
                              ),
                              Text(
                                'Progress: ${challenge.challengeParticipationProgress}%',
                                style: const TextStyle(
                                    fontSize: 14, color: Colors.black),
                              ),
                            ],
                          ),
                          const SizedBox(height: 5),
                          Text(
                            'Level: ${challenge.challengeLevel}',
                            style: const TextStyle(
                                fontSize: 14, color: Colors.black),
                          ),
                          const SizedBox(height: 10),
                        ],
                      ),
                    ),
                  );
                },
              ),
            ),
            const SizedBox(height: 32),
            CustomButton(
              text: 'New challenge',
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => CategoryScreen()),
                );
              },
            ),
          ],
        ),
      ),
    );
  }
}
