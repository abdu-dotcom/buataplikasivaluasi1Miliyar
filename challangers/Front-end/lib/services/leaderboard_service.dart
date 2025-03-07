import 'package:challangers/models/Leaderboard.dart';

class LeaderboardService {
  static List<LeaderboardModel> getLeaderboardData() {
    return [
      LeaderboardModel(
          rank: 1,
          username: 'Abduh',
          completedChallenges: 50,
          profileImage: 'assets/avatar1.png'),
      LeaderboardModel(
          rank: 2,
          username: 'Yusuf Basqara',
          completedChallenges: 45,
          profileImage: 'assets/avatar2.png'),
      LeaderboardModel(
          rank: 3,
          username: 'Aisyah',
          completedChallenges: 40,
          profileImage: 'assets/avatar3.png'),
      LeaderboardModel(
          rank: 4,
          username: 'Budi',
          completedChallenges: 38,
          profileImage: 'assets/avatar4.png'),
      LeaderboardModel(
          rank: 5,
          username: 'Siti',
          completedChallenges: 35,
          profileImage: 'assets/avatar5.png'),
    ];
  }
}
