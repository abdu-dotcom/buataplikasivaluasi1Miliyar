import 'package:challangers/models/challenge_model.dart';
import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';

class DatabaseHelper {
  static Database? _database;
  static const String _tableName = "challenges";

  Future<Database> get database async {
    if (_database != null) return _database!;
    _database = await _initDatabase();
    return _database!;
  }

  Future<Database> _initDatabase() async {
    final path = join(await getDatabasesPath(), 'challenger.db');
    return await openDatabase(
      path,
      version: 1,
      onCreate: (db, version) async {
        await db.execute('''
          CREATE TABLE $_tableName (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            title TEXT NOT NULL,
            description TEXT NOT NULL
          )
        ''');
      },
    );
  }

  Future<int> insertChallenge(ChallengeModel challenge) async {
    final db = await database;
    return await db.insert(_tableName, challenge.toMap());
  }

  Future<List<ChallengeModel>> getChallenges() async {
    final db = await database;
    List<Map<String, dynamic>> result = await db.query(_tableName);
    return result.map((json) => ChallengeModel.fromMap(json)).toList();
  }

  Future<int> deleteChallenge(int id) async {
    final db = await database;
    return await db.delete(_tableName, where: "id = ?", whereArgs: [id]);
  }
}
