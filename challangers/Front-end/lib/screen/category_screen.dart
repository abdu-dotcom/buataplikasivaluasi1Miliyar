import 'package:challangers/screen/browse_challange.dart';
import 'package:flutter/material.dart';

class CategoryScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Pilih Kategori"),
        backgroundColor: Colors.blue,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Center(
          child:  Container( 
          padding: EdgeInsets.all(16.0),
          child: GridView.count(
          crossAxisCount: 2, // Menampilkan dua kolom
          crossAxisSpacing: 16, // Spasi antar kolom
          mainAxisSpacing: 16, // Spasi antar baris
          shrinkWrap: true,
          children: [
            // Kategori Sport
            CategoryBox(
              categoryName: 'Sport',
              onTap: () {
                // Aksi saat kategori Sport dipilih
                print("Kategori Sport dipilih");
                // Navigasi ke halaman sport atau lainnya
              },
            ),
            // Kategori Self Improvement
            CategoryBox(
              categoryName: 'Self Improvement',
              onTap: () {
                // Aksi saat kategori Self Improvement dipilih
                print("Kategori Self Improvement dipilih");
                Navigator.push(context, MaterialPageRoute(builder: (context) => BrowseChallenge()));
                // Navigasi ke halaman self improvement atau lainnya
              },
            ),
          ],
        ),
          ),
      ),
      ),
    );
  }
}

// Widget untuk menampilkan kotak kategori
class CategoryBox extends StatelessWidget {
  final String categoryName;
  final VoidCallback onTap;

  const CategoryBox({required this.categoryName, required this.onTap});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: onTap,
      child: Container(
        decoration: BoxDecoration(
          color: Colors.blueAccent,
          borderRadius: BorderRadius.circular(16),
          boxShadow: [
            BoxShadow(
              color: Colors.black26,
              blurRadius: 4,
              offset: Offset(0, 4),
            ),
          ],
        ),
        child: Center(
          child: Text(
            categoryName,
            style: TextStyle(
              color: Colors.white,
              fontSize: 18,
              fontWeight: FontWeight.bold,
            ),
          ),
        ),
      ),
    );
  }
}
