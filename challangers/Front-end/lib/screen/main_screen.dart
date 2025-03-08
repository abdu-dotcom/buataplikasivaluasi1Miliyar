import 'package:challangers/screen/explore_screen.dart';
import 'package:challangers/screen/my_challenge_screen.dart';
import 'package:flutter/material.dart';
import 'leaderboard_screen.dart';

class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  _MainScreenState createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  int _selectedIndex = 0;

  // List halaman yang akan ditampilkan
  final List<Widget> _screens = [
    MyChallengeScreen(),
    ExploreScreen(),
    LeaderboardScreen()
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index; // Update index halaman aktif
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: _screens[_selectedIndex], // Tampilkan halaman yang sesuai
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _selectedIndex,
        onTap: _onItemTapped, // Panggil fungsi saat item diklik
        selectedItemColor: Colors.black,
        unselectedItemColor: Colors.grey,
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: "",
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.search),
            label: "",
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.leaderboard),
            label: "",
          ),
        ],
      ),
    );
  }
}
