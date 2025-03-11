import 'explore_screen.dart';
import 'my_challenge_screen.dart';
import 'package:flutter/material.dart';
import 'leaderboard_screen.dart';

class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  _MainScreenState createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  int _selectedIndex = 1;

  // List halaman yang akan ditampilkan
  final List<Widget> _screens = [
    MyChallengeScreen(),
    ExploreScreen(),
    LeaderboardScreen()
  ];

  void _onItemTapped(int index) {
    debugPrint("Tapped Index: $index");
    setState(() {
      _selectedIndex = index; // Update index halaman aktif
    });
  }

  @override
  void initState() {
    super.initState();
    assert(
        _screens.isNotEmpty, "Screens list must not be empty!"); // ✅ Debugging
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: _screens[_selectedIndex], // Tampilkan halaman yang sesuai
      bottomNavigationBar: BottomNavigationBar(
        backgroundColor: Colors.white,
        currentIndex: _selectedIndex,
        onTap: _onItemTapped, // Panggil fungsi saat item diklik
        selectedItemColor: Colors.black,
        unselectedItemColor: Colors.grey,
        selectedFontSize: 0, // ✅ Hilangkan ruang untuk teks
        unselectedFontSize: 0, // ✅ Hilangkan ruang untuk teks
        type: BottomNavigationBarType.fixed,
        items: const [
          BottomNavigationBarItem(
            icon: Padding(
              padding: EdgeInsets.only(bottom: 0),
              child: Icon(Icons.home),
            ),
            label: "",
          ),
          BottomNavigationBarItem(
            icon: Padding(
              padding: EdgeInsets.only(bottom: 0),
              child: Icon(Icons.search),
            ),
            label: "",
          ),
          BottomNavigationBarItem(
            icon: Padding(
              padding: EdgeInsets.only(bottom: 0),
              child: Icon(Icons.leaderboard),
            ),
            label: "",
          ),
        ],
      ),
    );
  }
}
