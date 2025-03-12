import 'package:challangers/Widgets/challenge_progress_card.dart';
import '../data/challenge.dart';
import '../models/challenge_model.dart';
import 'package:flutter/material.dart';

class ExploreScreen extends StatefulWidget {
  @override
  _ExploreScreenState createState() => _ExploreScreenState();
}

class _ExploreScreenState extends State<ExploreScreen> {
  bool isOtherPeopleSelected = true; // ✅ Untuk tracking tombol yang aktif

  @override
  Widget build(BuildContext context) {
    List<ChallengeModel> challenges = sampleChallenges;

    return Scaffold(
      backgroundColor: Colors.white,
      appBar: PreferredSize(
        preferredSize: const Size.fromHeight(kToolbarHeight),
        child: AppBar(
          title: const Text("Explore"),
          automaticallyImplyLeading: false,
          backgroundColor: Colors.white,
          scrolledUnderElevation: 0,
          elevation: 0,
          titleTextStyle: const TextStyle(
              fontSize: 24, fontWeight: FontWeight.bold, color: Colors.black),
        ),
      ),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              'Witness People Rise to the Challenge!',
              textAlign: TextAlign.left,
              style: TextStyle(
                fontSize: 14,
              ),
            ),
            const SizedBox(height: 24),
            _FilterButtons(
              isOtherPeopleSelected: isOtherPeopleSelected,
              onTabChanged: (bool isSelected) {
                setState(() {
                  isOtherPeopleSelected = isSelected;
                });
              },
            ),
            const SizedBox(height: 24),
            Expanded(
              child: isOtherPeopleSelected
                  ? _OtherPeoplePage(challenges: challenges)
                  : _MyProgressPage(challenges: challenges),
            ),
          ],
        ),
      ),
    );
  }
}

// Widget untuk tombol filter (Other People & My Progress)
class _FilterButtons extends StatelessWidget {
  final bool isOtherPeopleSelected;
  final ValueChanged<bool> onTabChanged;

  const _FilterButtons({
    Key? key,
    required this.isOtherPeopleSelected,
    required this.onTabChanged,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
          color: const Color.fromRGBO(243, 243, 243, 1),
          borderRadius: BorderRadius.all(Radius.circular(16))),
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Row(
          children: [
            Expanded(
              child: ElevatedButton(
                onPressed: () => onTabChanged(true),
                style: ElevatedButton.styleFrom(
                  padding: EdgeInsetsDirectional.symmetric(vertical: 16),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(12),
                  ),
                  backgroundColor:
                      isOtherPeopleSelected ? Colors.black : Colors.grey[350],
                  foregroundColor: Colors.white,
                ),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(Icons.people_alt_outlined, color: Colors.white),
                    SizedBox(width: 12),
                    Text("Other People")
                  ],
                ),
              ),
            ),
            const SizedBox(width: 5),
            Expanded(
              child: ElevatedButton(
                onPressed: () => onTabChanged(false),
                style: ElevatedButton.styleFrom(
                  padding: EdgeInsetsDirectional.symmetric(vertical: 16),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(12),
                  ),
                  backgroundColor:
                      isOtherPeopleSelected ? Colors.grey[350] : Colors.black,
                  foregroundColor: Colors.white,
                ),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(Icons.person_2_outlined, color: Colors.white),
                    SizedBox(width: 12),
                    Text("My Progress")
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

// Halaman Other People
class _OtherPeoplePage extends StatelessWidget {
  final List<ChallengeModel> challenges;

  const _OtherPeoplePage({required this.challenges});

  @override
  Widget build(BuildContext context) {
    return ScrollConfiguration(
      behavior: ScrollConfiguration.of(context).copyWith(scrollbars: false),
      child: ListView.builder(
        itemCount: challenges.length,
        itemBuilder: (context, index) {
          return ChallengeCard(challenge: challenges[index]);
        },
      ),
    );
  }
}

// Halaman My Progress
class _MyProgressPage extends StatelessWidget {
  final List<ChallengeModel> challenges;

  const _MyProgressPage({required this.challenges});

  @override
  Widget build(BuildContext context) {
    return ScrollConfiguration(
      behavior: ScrollConfiguration.of(context).copyWith(scrollbars: false),
      child: ListView.builder(
        itemCount: challenges.length,
        itemBuilder: (context, index) {
          return ChallengeCard(challenge: challenges[index]);
        },
      ),
    );
  }
}
