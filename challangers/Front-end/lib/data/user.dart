import 'package:challangers/models/user_model.dart';

final List<UserModel> sampleUsers = [
  UserModel(
    userId: "CHALLENGE000001",
    username: "Abduh",
    email: "abduhbabaa50@gmail.com",
    createdAt: DateTime.now().subtract(Duration(days: 30)),
    updatedAt: DateTime.now(),
  ),
  UserModel(
    userId: "CHALLENGE000002",
    username: "Yusuf Basqara",
    email: null,
    createdAt: DateTime.now().subtract(Duration(days: 45)),
    updatedAt: DateTime.now().subtract(Duration(days: 2)),
  ),
];
