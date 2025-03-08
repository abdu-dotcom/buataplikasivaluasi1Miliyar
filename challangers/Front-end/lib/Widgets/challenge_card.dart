import 'package:challangers/models/challenge_model.dart';
import 'package:flutter/material.dart';

class ChallengeCard extends StatelessWidget {
  final ChallengeModel challenge;

  const ChallengeCard({Key? key, required this.challenge}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
      elevation: 2,
      margin: const EdgeInsets.symmetric(vertical: 10, horizontal: 15),
      child: Padding(
        padding: const EdgeInsets.all(10.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(
              children: [
                Container(
                  padding:
                      const EdgeInsets.symmetric(horizontal: 8, vertical: 4),
                  decoration: BoxDecoration(
                    color: Colors.grey[300],
                    borderRadius: BorderRadius.circular(10),
                  ),
                  child: Text("gatauu in iaaappaa",
                      style: const TextStyle(fontSize: 12)),
                ),
                const Spacer(),
                const Icon(Icons.more_vert),
              ],
            ),
            const SizedBox(height: 10),
            Image.asset('assets/images/sample_challenge.png',
                height: 120, fit: BoxFit.cover),
            const SizedBox(height: 10),
            Text("challenge title",
                style:
                    const TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
            const SizedBox(height: 5),
            Row(
              children: [
                Expanded(
                  child: LinearProgressIndicator(
                    value: 123,
                    backgroundColor: Colors.grey[300],
                    color: Colors.black,
                  ),
                ),
                const SizedBox(width: 10),
                Text("challenge progress"),
              ],
            ),
            const SizedBox(height: 10),
            Text("#USERRRIDDDDD DUMY",
                style: const TextStyle(fontWeight: FontWeight.bold)),
            Text(challenge.challengeDescription,
                style: const TextStyle(fontSize: 14, color: Colors.grey)),
          ],
        ),
      ),
    );
  }
}
