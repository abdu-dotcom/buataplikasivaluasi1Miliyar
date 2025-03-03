import 'package:challangers/screen/category_screen.dart';
import 'package:flutter/material.dart';

class OnboardingScreen extends StatefulWidget {
  @override
  _OnboardingScreenState createState() => _OnboardingScreenState();
}

class _OnboardingScreenState extends State<OnboardingScreen> {
  final _controller = TextEditingController();

  void _goToNextPage() {
    // Aksi untuk berpindah ke halaman berikutnya, misalnya:
    // Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => NextPage()));
    Navigator.push(context, MaterialPageRoute(builder: (context) => CategoryScreen()));
    // Ganti baris di atas dengan navigasi sesuai kebutuhan
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Onboarding"),
        backgroundColor: Colors.blue,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            // Field input (misalnya nama atau email)
            TextField(
              controller: _controller
            ),
            SizedBox(height: 20),
            // Tombol "Selanjutnya"
            ElevatedButton(
              onPressed: _goToNextPage,
              child: Text("Selanjutnya"),
              style: ElevatedButton.styleFrom(
                padding: EdgeInsets.symmetric(vertical: 15, horizontal: 30),
                textStyle: TextStyle(fontSize: 16),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
