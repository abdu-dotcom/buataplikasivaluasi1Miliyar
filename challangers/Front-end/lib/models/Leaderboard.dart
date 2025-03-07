class LeaderboardModel {
  final int rank;
  final String username;
  final int completedChallenges;
  final String profileImage;

  LeaderboardModel({
    required this.rank,
    required this.username,
    required this.completedChallenges,
    required this.profileImage,
  });
}
