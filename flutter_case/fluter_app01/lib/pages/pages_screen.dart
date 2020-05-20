import 'package:flutter/material.dart';

class PagesScreen extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    // return Scaffold(
    //   appBar: AppBar(title: Text('pages')),
    //   body: Center(child: Text('pages')),
    // );
    return MaterialApp(
      theme: ThemeData(primarySwatch: Colors.blue),
      title: "keep alive",
      home: KeepAliveDemo(),
    );
  }
}
class KeepAliveDemo extends StatefulWidget {
  _KeepAliveDemoState createState() => _KeepAliveDemoState();
}

class _KeepAliveDemoState extends State<KeepAliveDemo> with SingleTickerProviderStateMixin {

  TabController _controller;

  @override
  void initState() { 
    super.initState();
    _controller = TabController(length: 3, vsync: this);    
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar:AppBar(
        title:Text('Keep Alive Demo'),
        bottom:TabBar(
          controller: _controller,
          tabs:[
            Tab(icon:Icon(Icons.directions_car)),
            Tab(icon:Icon(Icons.directions_transit)),
            Tab(icon:Icon(Icons.directions_bike)),
          ],
        )
      ),
      body:TabBarView(
        controller: _controller,
        children: <Widget>[
         MyHomePage(),
         MyHomePage(),
         MyHomePage()
        ],
      )
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
   return _MyHomePageState();
  }
}

class _MyHomePageState extends State<MyHomePage> with AutomaticKeepAliveClientMixin{

  int _counter = 0;
  //常驻内存保持活跃状态
  @override
  bool get wantKeepAlive => true;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
         child: Column(
           mainAxisAlignment: MainAxisAlignment.center,
           children: <Widget>[
             Text('点加一'),
             Text(
               '$_counter',
               style: Theme.of(context).textTheme.display1,
             )
           ]
         ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: Icon(Icons.add),
      ),
    );
  }
}