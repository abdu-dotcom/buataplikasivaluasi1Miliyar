import 'package:challangers/models/challenge_model.dart';
import 'package:flutter/material.dart';

class ChallengeInfoCard extends StatelessWidget {
  final ChallengeModel challengeDetail;

  const ChallengeInfoCard({super.key, required this.challengeDetail});

  @override
  Widget build(BuildContext context) {
    double screenWidth = MediaQuery.of(context).size.width;
    double boxWidth = (screenWidth - 64) / 4; // Hitung width setiap box

    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        _infoBox(challengeDetail.challengeParticipation, "Joined", boxWidth),
        _infoBox(challengeDetail.challengeParticipationOnProgress, "Progress",
            boxWidth),
        _infoBox(challengeDetail.challengeParticipationFinished, "Success",
            boxWidth),
        _infoBox(
            challengeDetail.challengeParticipationFailed, "Failed", boxWidth),
      ],
    );
  }

  Widget _infoBox(int value, String label, double width) {
    return Container(
      width: width,
      height: 60,
      padding: const EdgeInsets.all(8),
      decoration: BoxDecoration(
        color: Colors.grey[200],
        borderRadius: BorderRadius.circular(8),
      ),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          FittedBox(
            fit: BoxFit.scaleDown,
            child: Text(
              value.toString(),
              style: const TextStyle(fontSize: 14, fontWeight: FontWeight.bold),
            ),
          ),
          const SizedBox(height: 4),
          Flexible(
            child: Text(
              label,
              style: TextStyle(fontSize: 12, color: Colors.grey[600]),
              textAlign: TextAlign.center,
              overflow: TextOverflow.ellipsis,
              maxLines: 1,
            ),
          ),
        ],
      ),
    );
  }
}
