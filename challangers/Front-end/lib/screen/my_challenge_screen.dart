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
        appBar: PreferredSize(
          preferredSize: const Size.fromHeight(kToolbarHeight),
          child: Padding(
            padding:
                const EdgeInsets.symmetric(horizontal: 8), // ✅ Sama dengan body
            child: AppBar(
              automaticallyImplyLeading: false,
              backgroundColor: Colors.white,
              elevation: 0,
              scrolledUnderElevation: 0,
              title: const Text(
                'My Challenges List',
                style: TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.bold,
                  color: Colors.black,
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
            ),
          ),
        ),
        body: SafeArea(
          child: Padding(
            padding:
                const EdgeInsets.only(left: 16, right: 16, top: 0, bottom: 16),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 8),
                  child: const Text(
                    'Pantau perjalananmu dan selesaikan sub-challenge harian untuk meraih XP lebih banyak!',
                    style: TextStyle(fontSize: 14, color: Colors.grey),
                  ),
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
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceBetween,
                                children: [
                                  Text(
                                    challenge.challengeName,
                                    style: const TextStyle(
                                        fontSize: 16,
                                        fontWeight: FontWeight.bold),
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
        ));
  }
}
