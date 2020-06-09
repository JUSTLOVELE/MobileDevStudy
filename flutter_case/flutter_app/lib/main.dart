import 'package:flutter/material.dart';
import 'index/index.dart';

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: "知乎-高仿版",
      home: new Index(),
    );
  }

}
