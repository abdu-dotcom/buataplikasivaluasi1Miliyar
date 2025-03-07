import 'package:challangers/screen/my_challenge.dart';
import 'package:flutter/material.dart';
import '../services/log_service.dart';
import '../Widgets/custom_text_field.dart';
import '../widgets/custom_button.dart';
import 'category.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  _LoginScreenState createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final TextEditingController usernameController =
      TextEditingController(); // Tambahkan controller

  @override
  void dispose() {
    usernameController
        .dispose(); // Pastikan untuk dispose controller agar tidak ada memory leak
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    LogService.logger.i("Layar login screen dibuka");

    return Scaffold(
      backgroundColor: Colors.white,
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.end,
          children: [
            const Text(
              'Welcome to CHALLENGER',
              style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 10),
            const Text(
              'Unlock your potential, embrace challenges, and rise with our community.',
              textAlign: TextAlign.center,
              style: TextStyle(fontSize: 14, color: Colors.grey),
            ),
            const SizedBox(height: 20),
            const CustomTextField(hintText: '#Guest0000000012', enabled: false),
            const SizedBox(height: 10),
            CustomTextField(
                controller: usernameController, hintText: 'Username'),
            const SizedBox(height: 20),
            CustomButton(
              text: 'Next',
              onPressed: () {
                String username =
                    usernameController.text.trim(); // Ambil input user
                LogService.logger.d("Tombol Next ditekan, Username: $username");

                if (username.isNotEmpty) {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => MyChallengeScreen()),
                  );
                } else {
                  // ScaffoldMessenger.of(context).showSnackBar(
                  //   SnackBar(content: Text("Username tidak boleh kosong!")),
                  // );
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => CategoryScreen()),
                  );
                }
              },
            ),
          ],
        ),
      ),
    );
  }
}
