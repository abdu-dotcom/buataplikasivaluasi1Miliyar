// screens/category_screen.dart;
import 'package:challangers/Widgets/category_card.dart';
import 'package:flutter/material.dart';
import 'package:logger/logger.dart';
import '../widgets/custom_button.dart';

class CategoryScreen extends StatefulWidget {
  const CategoryScreen({super.key});

  @override
  _CategoryScreenState createState() => _CategoryScreenState();
}

class _CategoryScreenState extends State<CategoryScreen> {
  final Logger log = Logger();
  String? selectedCategory;

  void selectCategory(String category) {
    setState(() {
      selectedCategory = category;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Choose Your Path")),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          const Text(
            "Choose Your Path to a Better You",
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 10),
          const Text(
            "Pilih area fokus untuk memulai perjalanan tantanganmu dan raih kebiasaan positif!",
            textAlign: TextAlign.center,
          ),
          const SizedBox(height: 20),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              CategoryCard(
                title: "Sports",
                icon: Icons.directions_run,
                description: "Tetap aktif & raih kebugaran!",
                isSelected: selectedCategory == "Sports",
                onTap: () => selectCategory("Sports"),
              ),
              const SizedBox(width: 10),
              CategoryCard(
                title: "Improvement",
                icon: Icons.psychology,
                description: "Develop your mind & skills!",
                isSelected: selectedCategory == "Improvement",
                onTap: () => selectCategory("Improvement"),
              ),
            ],
          ),
          const SizedBox(height: 30),
          const Text(
            "Tantang dirimu hari ini!\nRaih pencapaian baru setiap hari",
            textAlign: TextAlign.center,
          ),
          const SizedBox(height: 20),
          CustomButton(
            text: "Select & Continue",
            onPressed: selectedCategory != null
                ? () {
                    // TODO: Navigasi ke layar berikutnya
                    log.i("Selected Category: $selectedCategory");
                  }
                : () {}, // Fungsi kosong agar tidak error
          ),
        ],
      ),
    );
  }
}
