import 'package:challangers/Widgets/category_card.dart';
import 'package:challangers/data/category.dart';
import 'package:challangers/screen/browse_challange.dart';
import 'package:challangers/widgets/custom_button.dart';
import 'package:flutter/material.dart';

class CategoryScreen extends StatefulWidget {
  const CategoryScreen({super.key});

  @override
  _CategoryScreenState createState() => _CategoryScreenState();
}

class _CategoryScreenState extends State<CategoryScreen> {
  String? selectedCategory;

  void selectCategory(String category) {
    setState(() {
      selectedCategory = category;
    });
  }

  @override
  Widget build(BuildContext context) {
    bool isButtonEnabled = selectedCategory != null;

    return Scaffold(
      body: Column(
        children: [
          /// 🔹 Bagian atas: Logo & Icon
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 16.0, vertical: 20),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: const [
                CircleAvatar(
                  radius: 24,
                  backgroundColor: Colors.grey,
                  child: Text("Logo"),
                ),
                CircleAvatar(
                  radius: 24,
                  backgroundColor: Colors.grey,
                  child: Text("Icon"),
                ),
              ],
            ),
          ),

          /// 🔹 Bagian Scrollable (Teks + Grid)
          Expanded(
              child: Center(
            child: SingleChildScrollView(
              child: Padding(
                padding: const EdgeInsets.symmetric(horizontal: 16.0),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    const Text(
                      "Choose Your Path to a Better You",
                      style:
                          TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                      textAlign: TextAlign.center,
                    ),
                    const SizedBox(height: 8),
                    const Text(
                      "Pilih area fokus untuk memulai perjalanan tantanganmu dan raih kebiasaan positif!",
                      textAlign: TextAlign.center,
                    ),
                    const SizedBox(height: 54), // Jarak sebelum Grid

                    /// 🔹 GridView
                    GridView.builder(
                      shrinkWrap: true,
                      physics: const NeverScrollableScrollPhysics(),
                      gridDelegate:
                          const SliverGridDelegateWithFixedCrossAxisCount(
                        crossAxisCount: 2,
                        childAspectRatio: 1,
                        crossAxisSpacing: 12,
                        mainAxisSpacing: 12,
                      ),
                      itemCount: categoryList.length,
                      itemBuilder: (context, index) {
                        final category = categoryList[index];
                        return CategoryCard(
                          title: category.categoryName,
                          icon: category.categoryImg,
                          description: category.categoryDesc,
                          isSelected: selectedCategory == category.categoryName,
                          onTap: () => setState(
                              () => selectedCategory = category.categoryName),
                        );
                      },
                    ),

                    const SizedBox(height: 54),

                    /// 🔹 Teks Motivasi
                    const Text(
                      "Tantang dirimu hari ini!\nRaih pencapaian baru setiap hari",
                      textAlign: TextAlign.center,
                    ),

                    const SizedBox(height: 16),
                  ],
                ),
              ),
            ),
          )),

          /// 🔹 Bagian bawah: Tombol (Tetap di bawah layar)
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: CustomButton(
              backgroundColor: isButtonEnabled
                  ? Colors.black
                  : const Color.fromARGB(255, 233, 233, 233),
              text: "Select & Continue",
              textColor: isButtonEnabled
                  ? Colors.white
                  : const Color.fromARGB(255, 29, 29, 29),
              onPressed: isButtonEnabled
                  ? () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (context) => BrowseChallengeScreen(),
                        ),
                      );
                    }
                  : () {},
            ),
          ),
        ],
      ),
    );
  }
}
