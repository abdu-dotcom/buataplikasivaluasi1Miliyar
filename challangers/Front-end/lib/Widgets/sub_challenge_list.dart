import 'package:challangers/models/challenge_sub_model.dart';
import 'package:flutter/material.dart';

class SubChallengeList extends StatelessWidget {
  final List<ChallengeSubModel> subChallenges;

  const SubChallengeList({Key? key, required this.subChallenges})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: subChallenges.map((subChallenge) {
        return Card(
          color: Colors.grey[200],
          elevation: 0,
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
          margin: const EdgeInsets.symmetric(vertical: 4),
          child: ListTile(
            title: Text(
              subChallenge.challengeSubName,
              style: const TextStyle(fontSize: 14, color: Colors.black),
            ),
            trailing: Text(
              "${subChallenge.challengeSubPoint} XP",
              style: const TextStyle(fontSize: 14, fontWeight: FontWeight.bold),
            ),
          ),
        );
      }).toList(),
    );
  }
}
