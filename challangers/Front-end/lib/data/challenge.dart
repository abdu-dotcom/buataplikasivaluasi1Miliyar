import 'package:challangers/models/challenge_model.dart';

final List<ChallengeModel> sampleChallenges = [
  ChallengeModel(
    challengeId: 1,
    challengeName: "30-Day Fitness Challenge",
    challengeDescription: "Complete a set of fitness exercises every day.",
    challengeLevel: "Intermediate",
    challengeParticipation: 150,
    challengeParticipationProgress: 50,
    challengeParticipationFinished: 80,
    challengeParticipationFailed: 20,
    categoriId: 101,
    createAt: DateTime.now().subtract(Duration(days: 60)),
    updateAt: DateTime.now(),
  ),
  ChallengeModel(
    challengeId: 2,
    challengeName: "Self-Improvement Challenge",
    challengeDescription: "Read one book and apply the lessons.",
    challengeLevel: "Beginner",
    challengeParticipation: 200,
    challengeParticipationProgress: 90,
    challengeParticipationFinished: 100,
    challengeParticipationFailed: 10,
    categoriId: 102,
    createAt: DateTime.now().subtract(Duration(days: 40)),
    updateAt: DateTime.now().subtract(Duration(days: 5)),
  ),
];
