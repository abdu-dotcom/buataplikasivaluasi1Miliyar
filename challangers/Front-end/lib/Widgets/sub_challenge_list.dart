import 'package:flutter/material.dart';

class SubChallengeList extends StatelessWidget {
  final List<Map<String, String>> subChallenges = List.generate(
    5,
    (index) => {
      "title": "Subs Challenge ${index + 1}",
      "xp": "20 XP",
    },
  );

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: subChallenges.length,
      itemBuilder: (context, index) {
        return Card(
          color: Colors.grey[200],
          elevation: 0,
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
          margin: EdgeInsets.symmetric(vertical: 4),
          child: ListTile(
            title: Text(
              subChallenges[index]["title"]!,
              style: TextStyle(fontSize: 14, color: Colors.black),
            ),
            trailing: Text(
              subChallenges[index]["xp"]!,
              style: TextStyle(fontSize: 14, fontWeight: FontWeight.bold),
            ),
          ),
        );
      },
    );
  }
}
