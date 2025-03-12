import 'package:flutter/material.dart';

class ImagePreview extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(
      builder: (context, constraints) {
        double boxSize = constraints.maxWidth / 3.3; // Responsive size

        return Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: List.generate(
            3,
            (index) => Container(
              width: boxSize, // Ukuran responsif
              height: boxSize, // Menjaga proporsi
              decoration: BoxDecoration(
                color: Colors.grey[300],
                borderRadius: BorderRadius.circular(8),
              ),
              child:
                  Icon(Icons.image, color: Colors.black54, size: boxSize / 2),
            ),
          ),
        );
      },
    );
  }
}
