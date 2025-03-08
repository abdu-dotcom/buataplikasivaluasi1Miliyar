import 'package:challangers/screen/challenge_detail_screen.dart';
import 'package:flutter/material.dart';

class BrowseChallengeScreen extends StatelessWidget {
  final List<Map<String, dynamic>> challenges = List.generate(
      5,
      (index) => {
            "id": index,
            "title": "30-Day Morning Run",
            "estimate": "30 Hari",
            "level": "Beginner",
          });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white, // Pastikan latar belakang putih
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        leading: IconButton(
          icon: Icon(Icons.arrow_back, color: Colors.black),
          onPressed: () => Navigator.pop(context),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              "Find Your Next Challenge",
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 8),
            Text(
              "Temukan tantangan baru untuk meningkatkan kebiasaan positifmu.",
              style: TextStyle(fontSize: 14, color: Colors.grey[600]),
            ),
            SizedBox(height: 16),
            Expanded(
              child: ListView.builder(
                itemCount: challenges.length,
                itemBuilder: (context, index) {
                  return GestureDetector(
                    onTap: () {
                      print("Tapped on: ${challenges[index]['title']}");
                    },
                    child: ChallengeCard(challenge: challenges[index]),
                  );
                },
              ),
            ),
            SizedBox(height: 16),
            Center(
              child: Text(
                '"Tubuh yang sehat adalah Jiwa yang Kuat.\nBangun diri menjadi lebih baik tanpa batas!"\nby Squidward',
                textAlign: TextAlign.center,
                style: TextStyle(fontSize: 12, color: Colors.grey[700]),
              ),
            ),
            SizedBox(height: 16),
          ],
        ),
      ),
    );
  }
}

class ChallengeCard extends StatelessWidget {
  final Map<String, dynamic> challenge;

  const ChallengeCard({required this.challenge});

  @override
  Widget build(BuildContext context) {
    return Card(
      color: Colors.white, // Pastikan warna putih
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
      elevation: 2,
      margin: EdgeInsets.only(bottom: 12),
      child: InkWell(
        onTap: () {
          print(
              "Card clicked: ${challenge['title']} with id: ${challenge['id']}");
          Navigator.push(context,
              MaterialPageRoute(builder: (context) => ChallengeDetailScreen()));
        },
        borderRadius: BorderRadius.circular(10),
        splashColor: Colors.grey.withOpacity(0.2), // Ubah warna efek klik
        highlightColor: Colors.transparent, // Hilangkan efek highlight ungu
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    challenge["title"],
                    style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
                  ),
                  Text(
                    "Estimasi : ${challenge["estimate"]}",
                    style: TextStyle(fontSize: 14, color: Colors.grey[700]),
                  ),
                ],
              ),
              SizedBox(height: 8),
              Text("Level : ${challenge["level"]}"),
            ],
          ),
        ),
      ),
    );
  }
}
