import 'package:flutter/material.dart';
import 'custome_route.dart';

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final title = 'Basic List';

    return new MaterialApp(
      title: title,
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text(title),
        ),
        body: new ListView(
          children: <Widget>[
            new ListTile(
              leading: new Icon(Icons.map),
              title: new Text('弹出对话框'),
              onTap: (){
                showAlertDialog(context);
              },
            ),
            new ListTile(
              leading: new Icon(Icons.photo),
              title: new Text('打开新的页面'),
              onTap: () {

                 Navigator.of(context).push(CustomRoute(SecondePage()));
              },
            ),
            new ListTile(
              leading: new Icon(Icons.phone),
              title: new Text('Phone'),
            ),
          ],
        ),
      ),
    );
  }
}

class SecondePage extends StatelessWidget {
  
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("second"),
      ),
      body: Text("hello "),
    );
  }
}

void showAlertDialog(BuildContext context) {
  showDialog(
      context: context,
      builder: (_) => new AlertDialog(
          title: new Text("Dialog Title"),
          content: new Text("This is my content"),
          actions:<Widget>[
            new FlatButton(child:new Text("CANCEL"), onPressed: (){
              Navigator.of(context).pop();

            },),
            new FlatButton(child:new Text("OK"), onPressed: (){
              Navigator.of(context).pop();

            },)
          ]

      ));
}