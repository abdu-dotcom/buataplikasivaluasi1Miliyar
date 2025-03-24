import 'package:challangers/provides/category_provide.dart';
import 'package:challangers/provides/challenge_provide.dart';
import 'package:challangers/provides/leaderboard_provide.dart';
import 'package:challangers/provides/user_challenge_provide.dart';
import 'package:challangers/provides/user_provide.dart';
import 'package:challangers/screen/leaderboard_screen.dart';
import 'package:challangers/screen/login_screen.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(
    MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_) => ChallengeProvider()),
        ChangeNotifierProvider(create: (_) => CategoryProvide()),
        ChangeNotifierProvider(create: (_) => UserProvider()),
        ChangeNotifierProvider(create: (_) => UserChallengeProvider()),
        ChangeNotifierProvider(create: (_) => LeaderboardProvider()),
      ],
      child: const MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Challenger App',
      theme: ThemeData(scaffoldBackgroundColor: Colors.white),
      home: const LeaderboardScreen(),
    );
  }
}
