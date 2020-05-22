import 'package:flutter/material.dart';

void main() => runApp(new Zhihu());

class Zhihu extends StatelessWidget {

  @override
  Widget build(BuildContext context) {

    return new MaterialApp(
      title: "高仿",
      home: new Index(),
    );
  }
}