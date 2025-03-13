import 'package:challangers/models/challenge_model.dart';
import 'package:challangers/models/challenge_sub_model.dart';

final List<ChallengeModel> sampleChallenges = [
  ChallengeModel(
    challengeId: 1,
    challengeName: "30-Day Fitness Challenge",
    challengeDescription: "Complete a set of fitness exercises every day.",
    challengeLevel: "Intermediate",
    challengeParticipation: 150,
    challengeParticipationOnProgress: 50,
    challengeParticipationFinished: 80,
    challengeParticipationFailed: 20,
    categoryId: 101,
    createdAt: DateTime.now().subtract(Duration(days: 60)),
    updatedAt: DateTime.now(),
    subChallenges: [
      ChallengeSubModel(
        challengeSubId: 1,
        challengeSubName: "Push-up Challenge",
        challengeSubPoint: 10,
        challengeSubTypeDeadline: "D",
        challengeSubDeadlineTime: 7,
      ),
      ChallengeSubModel(
        challengeSubId: 2,
        challengeSubName: "Squat Challenge",
        challengeSubPoint: 15,
        challengeSubTypeDeadline: "D",
        challengeSubDeadlineTime: 7,
      ),
    ],
  ),
  ChallengeModel(
    challengeId: 2,
    challengeName: "Self-Improvement Challenge",
    challengeDescription: "Read one book and apply the lessons.",
    challengeLevel: "Beginner",
    challengeParticipation: 200,
    challengeParticipationOnProgress: 90,
    challengeParticipationFinished: 100,
    challengeParticipationFailed: 10,
    categoryId: 102,
    createdAt: DateTime.now().subtract(Duration(days: 40)),
    updatedAt: DateTime.now().subtract(Duration(days: 5)),
    subChallenges: [
      ChallengeSubModel(
        challengeSubId: 3,
        challengeSubName: "Read a Chapter a Day",
        challengeSubPoint: 20,
        challengeSubTypeDeadline: "D",
        challengeSubDeadlineTime: 10,
      ),
      ChallengeSubModel(
        challengeSubId: 4,
        challengeSubName: "Summarize Learnings",
        challengeSubPoint: 25,
        challengeSubTypeDeadline: "D",
        challengeSubDeadlineTime: 14,
      ),
    ],
  ),
];
