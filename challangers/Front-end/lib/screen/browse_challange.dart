import 'package:challangers/models/Challenge.dart';
import 'package:flutter/material.dart';

class BrowseChallenge extends StatelessWidget {
  final List<Challenge> challenges = [
    Challenge(
        id: '1',
        name: 'Tantangan Fitness',
        description: 'Tantangan fitness dalam 30 hari.',
        participants: 150),
    Challenge(
        id: '2',
        name: 'Tantangan Membaca',
        description: 'Membaca 20 buku dalam 6 bulan.',
        participants: 50),
    // Tambahkan tantangan lainnya
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Browse Challenge'),
      ),
      body: ListView.builder(
        itemCount: challenges.length,
        itemBuilder: (context, index) {
          final challenge = challenges[index];
          return ListTile(
            title: Text(challenge.name),
            subtitle: Text(
                '${challenge.description}\nJoined: ${challenge.participants} people'),
          );
        },
      ),
    );
  }
}
