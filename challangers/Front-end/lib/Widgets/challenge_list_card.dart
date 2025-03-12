import 'package:challangers/screen/challenge_detail_screen.dart';
import 'package:flutter/material.dart';
import 'package:challangers/models/challenge_model.dart';

class ChallengeListCard extends StatelessWidget {
  final ChallengeModel
      challenge; // 🛠 Ubah tipe data dari Map ke ChallengeModel

  const ChallengeListCard({super.key, required this.challenge});

  @override
  Widget build(BuildContext context) {
    return Card(
      color: Colors.white,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
      elevation: 2,
      margin: const EdgeInsets.only(bottom: 12),
      child: InkWell(
        onTap: () {
          print(
              "Card clicked: ${challenge.challengeId} - ${challenge.challengeName}");
          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => ChallengeDetailScreen(),
            ),
          );
        },
        borderRadius: BorderRadius.circular(10),
        splashColor: Colors.grey.withOpacity(0.2),
        highlightColor: Colors.transparent,
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    challenge.challengeName, // ✅ Gunakan properti yang sesuai
                    style: const TextStyle(
                        fontSize: 16, fontWeight: FontWeight.bold),
                  ),
                  Text(
                    "${challenge.challengeParticipation} Joined",
                    style: TextStyle(fontSize: 14, color: Colors.grey[700]),
                  ),
                ],
              ),
              const SizedBox(height: 8),
              Text("Level : ${challenge.challengeLevel}"),
            ],
          ),
        ),
      ),
    );
  }
}
