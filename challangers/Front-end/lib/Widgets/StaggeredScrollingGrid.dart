import 'dart:async';
import 'package:challangers/services/log_service.dart';
import 'package:flutter/material.dart';

class StaggeredScrollingGrid extends StatefulWidget {
  @override
  _StaggeredScrollingGridState createState() => _StaggeredScrollingGridState();
}

class _StaggeredScrollingGridState extends State<StaggeredScrollingGrid> {
  final ScrollController _leftController = ScrollController();
  final ScrollController _centerController = ScrollController();
  final ScrollController _rightController = ScrollController();

  final List<String> imageUrls = List.generate(
      15, (index) => 'https://picsum.photos/200/300?random=$index');

  @override
  void initState() {
    super.initState();

    Future.delayed(Duration(milliseconds: 500), () {
      _startAutoScroll(_leftController, reverse: false);
      _startAutoScroll(_centerController, reverse: true);
      _startAutoScroll(_rightController, reverse: false);
    });
  }

  void _startAutoScroll(ScrollController controller,
      {bool reverse = false}) async {
    while (mounted) {
      if (!controller.hasClients) break;

      try {
        double minExtent = controller.position.minScrollExtent;
        double maxExtent = controller.position.maxScrollExtent;
        double totalScrollDistance = maxExtent - minExtent;

        int durationSeconds = (totalScrollDistance / 15).round();

        if (!mounted || !controller.hasClients) break;

        // Scroll to end
        await controller.animateTo(
          reverse ? minExtent : maxExtent,
          duration: Duration(seconds: durationSeconds),
          curve: Curves.linear,
        );

        if (!mounted || !controller.hasClients) break;

        // Scroll back to start
        await controller.animateTo(
          reverse ? maxExtent : minExtent,
          duration: Duration(seconds: durationSeconds),
          curve: Curves.linear,
        );
      } catch (e) {
        break; // Hentikan loop jika ada error
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Row(
        children: [
          _buildColumn(_leftController, false),
          _buildColumn(_centerController, true),
          _buildColumn(_rightController, false),
        ],
      ),
    );
  }

  Widget _buildColumn(ScrollController controller, bool reverse) {
    return Expanded(
      child: ScrollConfiguration(
        behavior:
            ScrollBehavior().copyWith(scrollbars: false, overscroll: false),
        child: ListView.builder(
          controller: controller,
          physics: const NeverScrollableScrollPhysics(), // Disable scrolling
          reverse: reverse,
          itemCount: imageUrls.length,
          itemBuilder: (context, index) {
            return Padding(
              padding: const EdgeInsets.all(4.0),
              child: ClipRRect(
                borderRadius: BorderRadius.circular(8),
                child: Image.network(
                  imageUrls[index],
                  fit: BoxFit.cover,
                  height: 170,
                ),
              ),
            );
          },
        ),
      ),
    );
  }

  @override
  void dispose() {
    _leftController.dispose();
    _centerController.dispose();
    _rightController.dispose();
    super.dispose();
  }
}
