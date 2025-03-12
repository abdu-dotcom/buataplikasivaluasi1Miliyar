import 'package:flutter/material.dart';

class IconHelper {
  static final Map<String, IconData> iconMap = {
    'home': Icons.home,
    'star': Icons.star,
    'settings': Icons.settings,
    'search': Icons.search,
    'person': Icons.person,
    'favorite': Icons.favorite,
    'info': Icons.info,
    'error': Icons.error,
    'camera': Icons.camera_alt,
    'email': Icons.email,
    'phone': Icons.phone,
    'directions_run': Icons.directions_run,
    'self_improvement': Icons.self_improvement
  };

  /// Mengambil IconData berdasarkan string dari database
  static IconData getIconFromString(String iconName) {
    return iconMap[iconName] ??
        Icons.help_outline; // Default jika tidak ditemukan
  }
}
