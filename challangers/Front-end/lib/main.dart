import 'package:challangers/screen/login_screen.dart';
// import 'package:challangers/screen/main_screen.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        title: 'Challenger App',
        theme: ThemeData(scaffoldBackgroundColor: Colors.white),
        home: LoginScreen());
  }
}
