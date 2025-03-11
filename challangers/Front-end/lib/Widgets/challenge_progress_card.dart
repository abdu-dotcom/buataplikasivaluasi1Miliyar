import 'package:challangers/models/challenge_model.dart';
import 'package:flutter/material.dart';

class ChallengeCard extends StatelessWidget {
  final ChallengeModel challenge;

  const ChallengeCard({super.key, required this.challenge});

  @override
  Widget build(BuildContext context) {
    return Card(
      color: Colors.white,
      margin: EdgeInsets.symmetric(vertical: 12),
      elevation: 0.8,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Stack(
            children: [
              SizedBox(
                height: 300,
                child: ClipRRect(
                  borderRadius: BorderRadius.circular(12),
                  child: Image.asset(
                    'lib/assets/image/sample_challenge.png',
                    width: double.infinity,
                    height: double.infinity,
                    fit: BoxFit.cover,
                  ),
                ),
              ),
              Positioned(
                  bottom: 0,
                  left: 0,
                  right: 0,
                  top: 0,
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Padding(
                        padding: const EdgeInsets.symmetric(
                            vertical: 12, horizontal: 12),
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: [
                            Container(
                              padding: EdgeInsets.symmetric(
                                  vertical: 5, horizontal: 14),
                              decoration: BoxDecoration(
                                  border: Border.all(
                                      color: Colors.black, width: 0.5),
                                  borderRadius:
                                      BorderRadius.all(Radius.circular(8)),
                                  color: Colors.white.withOpacity(0.8)),
                              child: Text(
                                "Sports",
                                style: TextStyle(
                                    fontWeight: FontWeight.w900, fontSize: 10),
                              ),
                            ),
                            Container(
                              padding: EdgeInsets.all(0),
                              child: const Icon(Icons.more_vert),
                            )
                          ],
                        ),
                      ),
                      Container(
                        decoration: BoxDecoration(
                          color: Colors.white.withOpacity(0.5),
                        ),
                        child: Padding(
                          padding: const EdgeInsets.symmetric(
                              vertical: 12, horizontal: 12),
                          child: Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: [
                              Container(
                                width: MediaQuery.of(context).size.width *
                                    0.4, // 40% of screen width
                                child: const Text(
                                  "Challanges First",
                                  overflow: TextOverflow.ellipsis,
                                  style: TextStyle(fontWeight: FontWeight.bold),
                                ), // NAMA CHALLENGE
                              ),
                              Container(
                                width: MediaQuery.of(context).size.width *
                                    0.3, // 40% of screen width
                                child: Row(
                                  children: [
                                    Expanded(
                                      child: LinearProgressIndicator(
                                        value: 0.4,
                                        backgroundColor: Colors.grey[300],
                                        color: Colors.black,
                                      ),
                                    ),
                                    const SizedBox(
                                      width: 10,
                                    ),
                                    const Text("50%") // PROGRESS CHALLENGE
                                  ],
                                ),
                              ),
                            ],
                          ),
                        ),
                      )
                    ],
                  )),
            ],
          ),
          const SizedBox(
            height: 24,
          ),
          const Text("#GuestId00000012312",
              style: TextStyle(fontWeight: FontWeight.bold, fontSize: 14)),
          const SizedBox(
            height: 8,
          ),
          const Text(
              "I have completed one lorem ipsum sub-challenge. This people from .... already achieve some of chievment. Want to join Challange"),
          const SizedBox(
            height: 24,
          )
        ],
      ),
    );
  }
}
