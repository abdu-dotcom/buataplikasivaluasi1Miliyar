import '../Widgets/image_preview.dart';
import '../Widgets/sub_challenge_list.dart';
import '../screen/main_screen.dart';
import '../widgets/challenge_info_card.dart';
import 'package:flutter/material.dart';
import '../widgets/custom_button.dart';

class ChallengeDetailScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        scrolledUnderElevation:
            0, // ✅ Mencegah AppBar berubah warna saat scroll
        leading: IconButton(
          icon: const Icon(Icons.arrow_back, color: Colors.black),
          onPressed: () => Navigator.pop(context),
        ),
        actions: [
          IconButton(
            icon: const Icon(Icons.share, color: Colors.black),
            onPressed: () {},
          ),
        ],
      ),
      body: SafeArea(
          child: Container(
        color: Colors.white,
        child: SingleChildScrollView(
          // ✅ Seluruh halaman bisa di-scroll
          padding: const EdgeInsets.symmetric(horizontal: 16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              const Text(
                "Challenges First",
                style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 4),
              Text("160 XP",
                  style: TextStyle(fontSize: 16, color: Colors.grey[700])),
              const SizedBox(height: 16),
              ChallengeInfoCard(),
              const SizedBox(height: 16),
              const Text(
                "sed Donec vitae lobortis, nisl. quam vitae nibh Ut varius amet, Cras Nam ultrices amet, risus elit. urna luctus ullamcorper nec lorem. malesuada vitae diam Ut ",
                style: TextStyle(fontSize: 14, color: Colors.grey),
              ),
              const SizedBox(height: 16),
              ImagePreview(),
              const SizedBox(height: 24),
              const Text(
                "Sub list challenge",
                style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 8),

              SubChallengeList(), // ✅ Tidak pakai `Expanded`, mengikuti tinggi kontennya

              const SizedBox(height: 24),
              CustomButton(
                  text: "Accept challenge",
                  onPressed: () {
                    Navigator.push(context,
                        MaterialPageRoute(builder: (context) => MainScreen()));
                  }),
              const SizedBox(height: 24),
            ],
          ),
        ),
      )),
    );
  }
}
