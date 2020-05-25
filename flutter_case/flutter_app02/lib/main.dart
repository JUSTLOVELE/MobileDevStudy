import 'package:flutter/material.dart';
import 'index/index.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '高仿',
      home: new Scaffold(

        appBar: new AppBar(title: Text("wel"),),
      ),
    );
  }
}
