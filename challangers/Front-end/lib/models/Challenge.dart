class Challenge {
  final String id; // ID unik untuk setiap challenge
  final String name; // Nama dari challenge
  final String description; // Deskripsi dari challenge
  final int participants; // Jumlah orang yang bergabung dalam challenge

  // Constructor untuk Challenge
  Challenge({
    required this.id,
    required this.name,
    required this.description,
    required this.participants,
  });

  // Method untuk membuat object Challenge dari Map (misalnya untuk JSON parsing)
  factory Challenge.fromMap(Map<String, dynamic> map) {
    return Challenge(
      id: map['id'] ?? '',
      name: map['name'] ?? '',
      description: map['description'] ?? '',
      participants: map['participants'] ?? 0,
    );
  }

  // Method untuk mengonversi object Challenge ke Map (misalnya untuk JSON encoding)
  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'name': name,
      'description': description,
      'participants': participants,
    };
  }
}
