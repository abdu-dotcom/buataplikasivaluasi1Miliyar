import 'dart:math';

import 'package:challangers/provides/user_provide.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../services/log_service.dart';
import '../widgets/custom_text_field.dart';
import '../widgets/custom_button.dart';
import 'category_screen.dart';
import 'main_screen.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  _LoginScreenState createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final TextEditingController usernameController = TextEditingController();
  String guestId = "#Guest0000000012"; // Guest ID default untuk validasi

  @override
  void dispose() {
    usernameController.dispose(); // Mencegah memory leak
    super.dispose();
  }

  void loginUser(BuildContext context, String username) {
    final userProvider = Provider.of<UserProvider>(context, listen: false);

    String username = usernameController.text.trim();
    String userId =
        username != 'superit' ? generateUserId() : "#CHALLENGE000095";

    userProvider.setUserData(userId, username);

    // Log dalam satu baris
    LogService.logger.d("✅ User Login | ID: $userId | Username: $username");

    // Navigasi berdasarkan apakah user menggunakan Guest ID atau tidak
    Widget nextScreen = userId == username ? CategoryScreen() : MainScreen();

    Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => nextScreen),
    );
  }

  String generateUserId() {
    Random random = Random();
    int randomNumber = random.nextInt(99999); // Generate angka antara 0-99999
    String formattedNumber =
        randomNumber.toString().padLeft(5, '0'); // Format jadi 5 digit

    return "CHALLENGE$formattedNumber";
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

            // Guest ID untuk validasi
            CustomTextField(hintText: guestId, enabled: false),
            const SizedBox(height: 10),

            // Username Input (Bebas)
            CustomTextField(
                controller: usernameController, hintText: 'Username'),
            const SizedBox(height: 20),

            CustomButton(
              text: 'Next',
              onPressed: () {
                String username = usernameController.text.trim();
                LogService.logger.d("Tombol Next ditekan, Username: $username");
                loginUser(context, username);
              },
            ),
          ],
        ),
      ),
    );
  }
}
