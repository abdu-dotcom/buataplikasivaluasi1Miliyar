import 'package:challangers/provides/user_challenge_provide.dart';
import 'package:challangers/provides/user_provide.dart';
import 'package:challangers/screen/category_screen.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../widgets/custom_button.dart';

class MyChallengeScreen extends StatelessWidget {
  const MyChallengeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final userId = Provider.of<UserProvider>(context).userId;

    /// ✅ Panggil `fetchUserChallenges` saat layar dibuka
    WidgetsBinding.instance.addPostFrameCallback((_) {
      Provider.of<UserChallengeProvider>(context, listen: false)
          .fetchUserChallenges(userId);
    });

    return Scaffold(
      backgroundColor: Colors.white,
      appBar: PreferredSize(
        preferredSize: const Size.fromHeight(kToolbarHeight),
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 8),
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
          padding: const EdgeInsets.only(left: 16, right: 16, bottom: 16),
          child: Consumer<UserChallengeProvider>(
            builder: (context, userChallengeProvider, _) {
              if (userChallengeProvider.isLoading) {
                return const Center(child: CircularProgressIndicator());
              }

              if (userChallengeProvider.errorMessage != null) {
                return Center(
                  child: Text(userChallengeProvider.errorMessage!,
                      style: const TextStyle(color: Colors.red)),
                );
              }

              final userChallenges =
                  userChallengeProvider.userChallengeResponse?.userChallenges ??
                      [];

              return Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  const Padding(
                    padding: EdgeInsets.symmetric(horizontal: 8),
                    child: Text(
                      'Pantau perjalananmu dan selesaikan sub-challenge harian untuk meraih XP lebih banyak!',
                      style: TextStyle(fontSize: 14, color: Colors.grey),
                    ),
                  ),
                  const SizedBox(height: 32),
                  Expanded(
                    child: userChallenges.isEmpty
                        ? const Center(
                            child: Text(
                                "Belum ada tantangan yang sedang berjalan."),
                          )
                        : ListView.builder(
                            itemCount: userChallenges.length,
                            itemBuilder: (context, index) {
                              final challenge = userChallenges[index];
                              return Card(
                                color: Colors.white,
                                elevation: 2,
                                shape: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(10),
                                ),
                                child: Padding(
                                  padding: const EdgeInsets.all(12.0),
                                  child: Column(
                                    crossAxisAlignment:
                                        CrossAxisAlignment.start,
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
                                            'Progress: ${challenge.progress}%',
                                            style: const TextStyle(
                                                fontSize: 14,
                                                color: Colors.black),
                                          ),
                                        ],
                                      ),
                                      const SizedBox(height: 5),
                                      Text(
                                        'Level: ${challenge.challengeLevel}',
                                        style: const TextStyle(
                                            fontSize: 14, color: Colors.black),
                                      ),
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
                        MaterialPageRoute(
                            builder: (context) => CategoryScreen()),
                      );
                    },
                  ),
                ],
              );
            },
          ),
        ),
      ),
    );
  }
}
