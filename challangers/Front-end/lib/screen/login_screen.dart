// screens/login_screen.dart
import 'package:challangers/screen/category_screen.dart';
import 'package:flutter/material.dart';
import '../Widgets/custom_text_field.dart';
import '../widgets/custom_button.dart';

class LoginScreen extends StatelessWidget {
  const LoginScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
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
            const CustomTextField(hintText: 'username'),
            const SizedBox(height: 20),
            CustomButton(
              text: 'Next',
              onPressed: () {
                // Handle login
                Navigator.push(context, MaterialPageRoute(builder: (context) => CategoryScreen()));
              },
            ),
          ],
        ),
      ),
    );
  }
}
