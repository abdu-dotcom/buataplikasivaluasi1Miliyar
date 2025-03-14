import 'package:flutter/foundation.dart';

class UserProvider with ChangeNotifier {
  String _userId = "";
  String _username = "";

  String get userId => _userId;
  String get username => _username;

  void setUserData(String id, String name) {
    _userId = id;
    _username = name;
    notifyListeners(); // Memberi tahu widget lain kalau state berubah
  }
}
