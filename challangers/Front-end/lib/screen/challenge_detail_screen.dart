import 'package:challangers/Widgets/image_preview.dart';
import 'package:challangers/Widgets/sub_challenge_list.dart';
import 'package:challangers/widgets/challenge_info_card.dart';
import 'package:challangers/widgets/custom_button.dart';
import 'package:flutter/material.dart';

class ChallengeDetailScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        leading: IconButton(
          icon: Icon(Icons.arrow_back, color: Colors.black),
          onPressed: () => Navigator.pop(context),
        ),
        actions: [
          IconButton(
            icon: Icon(Icons.share, color: Colors.black),
            onPressed: () {},
          ),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              "Challenges First",
              style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 4),
            Text("160 XP",
                style: TextStyle(fontSize: 16, color: Colors.grey[700])),
            SizedBox(height: 8),
            ChallengeInfoCard(),
            SizedBox(height: 8),
            Text(
              "sed Donec vitae lobortis, nisl. quam vitae nibh Ut varius amet...",
              style: TextStyle(fontSize: 14, color: Colors.grey[600]),
            ),
            SizedBox(height: 12),
            ImagePreview(),
            SizedBox(height: 12),
            Text("Sub list challenge",
                style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
            SizedBox(height: 8),
            Expanded(child: SubChallengeList()),
            SizedBox(height: 12),
            CustomButton(text: "Accept challenge", onPressed: () {}),
          ],
        ),
      ),
    );
  }
}
