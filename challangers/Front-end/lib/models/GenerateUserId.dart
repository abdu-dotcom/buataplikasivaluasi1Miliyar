class GenerateUserId {
  final String userId; // ID unik untuk setiap challenge

    // Constructor untuk Challenge
  GenerateUserId({
    required this.userId
    });

  // Method untuk membuat object Challenge dari Map (misalnya untuk JSON parsing)
  factory GenerateUserId.fromMap(Map<String, dynamic> map) {
    return GenerateUserId(
      userId: map['userId'] ?? ''
    );
  }

  // Method untuk mengonversi object Challenge ke Map (misalnya untuk JSON encoding)
  Map<String, dynamic> toMap() {
    return {
      'userId': userId
    };
  }
}