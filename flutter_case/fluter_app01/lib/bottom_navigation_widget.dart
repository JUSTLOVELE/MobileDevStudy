import 'package:flutter/material.dart';
import 'pages/home_screen.dart';
import 'pages/email_screen.dart';
import 'pages/pages_screen.dart';
import 'pages/search_bar_screen.dart';

class BottomNavigationWidget extends StatefulWidget {
  @override
  _BottomNavigationWidgetState createState() => _BottomNavigationWidgetState();
}

class _BottomNavigationWidgetState extends State<BottomNavigationWidget> {
  final _BottomNavigationColor = Colors.blue;
  int _currentIndex = 0;
  List<Widget> list = List();

  @override
  void initState() {

    list
    ..add(HomeScreen())
    ..add(EmailScreen())
    ..add(PagesScreen())
    ..add(SearchBarSceen())
    ;
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: list[_currentIndex],
      bottomNavigationBar: BottomNavigationBar(items: [
        BottomNavigationBarItem(
            icon: Icon(
              Icons.home,
              color: _BottomNavigationColor,
            ),
            title: Text(
              'Home',
              style: TextStyle(color: _BottomNavigationColor),
            )),
        BottomNavigationBarItem(
            icon: Icon(
              Icons.email,
              color: _BottomNavigationColor,
            ),
            title: Text(
              '滑动效果',
              style: TextStyle(color: _BottomNavigationColor),
            )),
        BottomNavigationBarItem(
            icon: Icon(
              Icons.pages,
              color: _BottomNavigationColor,
            ),
            title: Text(
              '页面状态',
              style: TextStyle(color: _BottomNavigationColor),
            )),
        BottomNavigationBarItem(
            icon: Icon(
              Icons.search,
              color: _BottomNavigationColor,
            ),
            title: Text(
              'searchBar',
              style: TextStyle(color: _BottomNavigationColor),
            )),
      ],
      currentIndex: _currentIndex,
      onTap: (int index) {
        setState(() {
          _currentIndex = index;
        });
      },
      type: BottomNavigationBarType.fixed),
    );
  }
}
