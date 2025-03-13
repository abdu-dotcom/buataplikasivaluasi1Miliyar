import 'package:challangers/Widgets/challenge_info_card.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'package:challangers/provides/challenge_provide.dart';
import 'package:challangers/models/challenge_model.dart';

import '../Widgets/image_preview.dart';
import '../Widgets/sub_challenge_list.dart';
import '../screen/main_screen.dart';
import '../widgets/custom_button.dart';

class ChallengeDetailScreen extends StatefulWidget {
  final int challengeId;

  const ChallengeDetailScreen({
    super.key,
    required this.challengeId,
  });

  @override
  State<ChallengeDetailScreen> createState() => _ChallengeDetailScreenState();
}

class _ChallengeDetailScreenState extends State<ChallengeDetailScreen> {
  @override
  void initState() {
    super.initState();
    // Ambil data challenge berdasarkan challengeId
    Future.microtask(() =>
        Provider.of<ChallengeProvider>(context, listen: false)
            .fetchChallengeByChallengeId(widget.challengeId));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        scrolledUnderElevation: 0,
        leading: IconButton(
          icon: const Icon(Icons.arrow_back, color: Colors.black),
          onPressed: () => Navigator.pop(context),
        ),
        actions: [
          IconButton(
            icon: const Icon(Icons.share, color: Colors.black),
            onPressed: () {},
          ),
        ],
      ),
      body: SafeArea(
        child: Consumer<ChallengeProvider>(
          builder: (context, challengeProvider, child) {
            ChallengeModel? challenge = challengeProvider.challengeDetail;

            // Jika data masih loading, tampilkan indikator loading
            if (challengeProvider.isLoading) {
              return const Center(child: CircularProgressIndicator());
            }

            // Jika terjadi error atau data kosong
            if (challenge == null) {
              return const Center(
                child: Text("Challenge tidak ditemukan."),
              );
            }

            return SingleChildScrollView(
              padding: const EdgeInsets.symmetric(horizontal: 16.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    challenge.challengeName, // ✅ Nama challenge dari API
                    style: const TextStyle(
                      fontSize: 22,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  const SizedBox(height: 4),
                  Text(
                    "${challenge.challengeParticipation} XP", // ✅ XP dari API
                    style: TextStyle(fontSize: 16, color: Colors.grey[700]),
                  ),
                  const SizedBox(height: 16),
                  ChallengeInfoCard(
                    challengeDetail: challenge,
                  ), // ✅ Kirim data challenge
                  const SizedBox(height: 16),
                  Text(
                    challenge
                        .challengeDescription, // ✅ Deskripsi challenge dari API
                    style: const TextStyle(fontSize: 14, color: Colors.grey),
                  ),
                  const SizedBox(height: 16),
                  ImagePreview(), // ✅ (Gambar nanti bisa dihubungkan dengan API jika ada)
                  const SizedBox(height: 24),
                  const Text(
                    "Sub Challenge List",
                    style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
                  ),
                  const SizedBox(height: 8),

                  // **Tampilkan daftar Sub-Challenge jika ada**
                  if (challenge.subChallenges != null &&
                      challenge.subChallenges!.isNotEmpty)
                    SubChallengeList(subChallenges: challenge.subChallenges!)
                  else
                    const Text(
                      "Belum ada sub-challenge.",
                      style: TextStyle(fontSize: 14, color: Colors.grey),
                    ),

                  const SizedBox(height: 24),
                  CustomButton(
                    text: "Accept Challenge",
                    onPressed: () {
                      Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) => MainScreen()));
                    },
                  ),
                  const SizedBox(height: 24),
                ],
              ),
            );
          },
        ),
      ),
    );
  }
}
