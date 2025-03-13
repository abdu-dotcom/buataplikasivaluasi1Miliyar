import 'dart:convert';

import 'package:challangers/models/challenge_sub_model.dart';

class ChallengeModel {
  final int challengeId;
  final String challengeName;
  final String challengeDescription;
  final String challengeLevel;
  final int challengeParticipation;
  final int challengeParticipationOnProgress;
  final int challengeParticipationFinished;
  final int challengeParticipationFailed;
  final int categoryId;
  final DateTime createdAt;
  final DateTime updatedAt;
  final List<ChallengeSubModel>? subChallenges; // Bisa null

  ChallengeModel({
    required this.challengeId,
    required this.challengeName,
    required this.challengeDescription,
    required this.challengeLevel,
    required this.challengeParticipation,
    required this.challengeParticipationOnProgress,
    required this.challengeParticipationFinished,
    required this.challengeParticipationFailed,
    required this.categoryId,
    required this.createdAt,
    required this.updatedAt,
    this.subChallenges,
  });
  factory ChallengeModel.fromMap(Map<String, dynamic> json) {
    return ChallengeModel(
      challengeId: json['challengeId'] ?? 0,
      challengeName: json['challengeName'] ?? '',
      challengeDescription: json['challengeDescription'] ?? '',
      challengeLevel: json['challengeLevel'] ?? '',
      challengeParticipation: json['challengeParticipation'] ?? 0,
      challengeParticipationOnProgress:
          json['challengeParticipationOnProgress'] ?? 0,
      challengeParticipationFinished:
          json['challengeParticipationFinished'] ?? 0,
      challengeParticipationFailed: json['challengeParticipationFailed'] ?? 0,
      categoryId: json['categoryId'] ?? 0,
      createdAt: DateTime.fromMillisecondsSinceEpoch(json['createdAt'] ?? 0),
      updatedAt: DateTime.fromMillisecondsSinceEpoch(json['updatedAt'] ?? 0),
      subChallenges: (json['subChallenges'] as List? ?? [])
          .map(
              (item) => ChallengeSubModel.fromMap(item as Map<String, dynamic>))
          .toList(),
    );
  }
  Map<String, dynamic> toMap() {
    return {
      'challengeId': challengeId,
      'challengeName': challengeName,
      'challengeDescription': challengeDescription,
      'challengeLevel': challengeLevel,
      'challengeParticipation': challengeParticipation,
      'challengeParticipationOnProgress': challengeParticipationOnProgress,
      'challengeParticipationFinished': challengeParticipationFinished,
      'challengeParticipationFailed': challengeParticipationFailed,
      'categoryId': categoryId,
      'createdAt': createdAt.toIso8601String(),
      'updatedAt': updatedAt.toIso8601String(),
      'subChallenges': subChallenges?.map((item) => item.toMap()).toList(),
    };
  }

  ChallengeModel copyWith({
    int? challengeId,
    String? challengeName,
    String? challengeDescription,
    String? challengeLevel,
    int? challengeParticipation,
    int? challengeParticipationOnProgress,
    int? challengeParticipationFinished,
    int? challengeParticipationFailed,
    int? categoryId,
    DateTime? createdAt,
    DateTime? updatedAt,
    List<ChallengeSubModel>? subChallenges,
  }) {
    return ChallengeModel(
      challengeId: challengeId ?? this.challengeId,
      challengeName: challengeName ?? this.challengeName,
      challengeDescription: challengeDescription ?? this.challengeDescription,
      challengeLevel: challengeLevel ?? this.challengeLevel,
      challengeParticipation:
          challengeParticipation ?? this.challengeParticipation,
      challengeParticipationOnProgress: challengeParticipationOnProgress ??
          this.challengeParticipationOnProgress,
      challengeParticipationFinished:
          challengeParticipationFinished ?? this.challengeParticipationFinished,
      challengeParticipationFailed:
          challengeParticipationFailed ?? this.challengeParticipationFailed,
      categoryId: categoryId ?? this.categoryId,
      createdAt: createdAt ?? this.createdAt,
      updatedAt: updatedAt ?? this.updatedAt,
      subChallenges: subChallenges ?? this.subChallenges,
    );
  }

  static DateTime _parseDate(dynamic dateValue) {
    if (dateValue == null) return DateTime.now();
    if (dateValue is int) {
      return DateTime.fromMillisecondsSinceEpoch(dateValue);
    }
    if (dateValue is String) {
      try {
        return DateTime.parse(dateValue);
      } catch (e) {
        return DateTime.now();
      }
    }
    return DateTime.now();
  }
}

// Fungsi helper untuk JSON
ChallengeModel challengeModelFromJson(String str) =>
    ChallengeModel.fromMap(json.decode(str));

String challengeModelToJson(ChallengeModel data) => json.encode(data.toMap());
