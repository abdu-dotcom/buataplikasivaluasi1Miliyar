import 'package:flutter/material.dart';

class ChallengeInfoCard extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    double screenWidth = MediaQuery.of(context).size.width;
    double boxWidth = (screenWidth - 64) / 4; // Hitung width setiap box

    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        _infoBox("1.5k", "Joined", boxWidth),
        _infoBox("1.5k", "Progress", boxWidth),
        _infoBox("1.5k", "Success", boxWidth),
        _infoBox("1.5k", "Failed", boxWidth),
      ],
    );
  }

  Widget _infoBox(String value, String label, double width) {
    return Container(
      width: width,
      height: 60, // Tambahkan tinggi agar tidak `MISSING`
      padding: EdgeInsets.all(8),
      decoration: BoxDecoration(
        color: Colors.grey[200],
        borderRadius: BorderRadius.circular(8),
      ),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center, // Pastikan center
        children: [
          FittedBox(
            fit: BoxFit.scaleDown,
            child: Text(
              value,
              style: TextStyle(fontSize: 14, fontWeight: FontWeight.bold),
            ),
          ),
          SizedBox(height: 4),
          Flexible(
            child: Text(
              label,
              style: TextStyle(fontSize: 12, color: Colors.grey[600]),
              textAlign: TextAlign.center,
              overflow: TextOverflow.ellipsis,
              maxLines: 1,
            ),
          ),
        ],
      ),
    );
  }
}
