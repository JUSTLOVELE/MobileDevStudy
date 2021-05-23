import 'package:flutter/material.dart';

class HomePage extends StatefulWidget{
  @override
  State<StatefulWidget> createState() => new _HomePageState();
}

class _HomePageState extends State<HomePage> {

  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text('首页'),
          actions: <Widget>[
            new Container()
          ],
        ),
        body: new Center(
          child: null,
        ),
      ),
    );
  }
}