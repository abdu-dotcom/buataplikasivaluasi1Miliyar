import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:dio/dio.dart';

import 'package:challangers/Widgets/challenge_info_card.dart';
import 'package:challangers/Widgets/image_preview.dart';
import 'package:challangers/Widgets/sub_challenge_list.dart';
import 'package:challangers/widgets/custom_button.dart';
import 'package:challangers/core/api/api_service.dart';
import 'package:challangers/provides/user_provide.dart';
import 'package:challangers/provides/challenge_provide.dart';
import 'package:challangers/services/log_service.dart';
import 'package:challangers/models/challenge_model.dart';

class ChallengeDetailScreen extends StatefulWidget {
  final int challengeId;
  const ChallengeDetailScreen({super.key, required this.challengeId});

  @override
  State<ChallengeDetailScreen> createState() => _ChallengeDetailScreenState();
}

class _ChallengeDetailScreenState extends State<ChallengeDetailScreen> {
  @override
  void initState() {
    super.initState();
    _fetchChallenge();
  }

  void _fetchChallenge() {
    Future.microtask(() =>
        Provider.of<ChallengeProvider>(context, listen: false)
            .fetchChallengeByChallengeId(widget.challengeId));
  }

  Future<void> _acceptChallenge() async {
    final userId = Provider.of<UserProvider>(context, listen: false).userId;
    if (userId.isEmpty) {
      _showSnackBar("User ID tidak ditemukan, silakan login.");
      return;
    }

    // 🔹 Panggil API dan tangani response
    final response =
        await ApiService().acceptChallenge(userId, widget.challengeId);
    _showSnackBar(response['message']);
  }

  void _showSnackBar(String message) {
    if (mounted) {
      ScaffoldMessenger.of(context)
          .showSnackBar(SnackBar(content: Text(message)));
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: _buildAppBar(),
      body: SafeArea(child: _buildBody()),
    );
  }

  AppBar _buildAppBar() {
    return AppBar(
      backgroundColor: Colors.white,
      elevation: 0,
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
    );
  }

  Widget _buildBody() {
    return Consumer<ChallengeProvider>(
      builder: (context, challengeProvider, child) {
        if (challengeProvider.isLoading) {
          return const Center(child: CircularProgressIndicator());
        }

        final challenge = challengeProvider.challengeDetail;
        if (challenge == null) {
          return const Center(child: Text("Challenge tidak ditemukan."));
        }

        return _buildChallengeDetails(challenge);
      },
    );
  }

  Widget _buildChallengeDetails(ChallengeModel challenge) {
    return SingleChildScrollView(
      padding: const EdgeInsets.symmetric(horizontal: 16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(challenge.challengeName,
              style:
                  const TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
          const SizedBox(height: 4),
          Text("${challenge.challengeParticipation} XP",
              style: TextStyle(fontSize: 16, color: Colors.grey[700])),
          const SizedBox(height: 16),
          ChallengeInfoCard(challengeDetail: challenge),
          const SizedBox(height: 16),
          Text(challenge.challengeDescription,
              style: const TextStyle(fontSize: 14, color: Colors.grey)),
          const SizedBox(height: 16),
          ImagePreview(),
          const SizedBox(height: 24),
          const Text("Sub Challenge List",
              style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
          const SizedBox(height: 8),
          challenge.subChallenges?.isNotEmpty ?? false
              ? SubChallengeList(subChallenges: challenge.subChallenges!)
              : const Text("Belum ada sub-challenge.",
                  style: TextStyle(fontSize: 14, color: Colors.grey)),
          const SizedBox(height: 24),
          CustomButton(text: "Accept Challenge", onPressed: _acceptChallenge),
          const SizedBox(height: 24),
        ],
      ),
    );
  }
}
