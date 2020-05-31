import 'package:flutter/material.dart';
import 'package:flutter_app/global_config.dart';
import 'article.dart';

class Follow extends StatefulWidget {
  Follow({Key key}) : super(key: key);

  @override
  _FollowState createState() => _FollowState();
}

class _FollowState extends State<Follow> {

  Widget wordsCard(Article article) {

    Widget markWidget;

    if (article.imgUrl == null) {
      markWidget = new Text(
        article.mark,
        style: new TextStyle(height: 1.3, color: GlobalConfig.fontColor),
      );
    } else {
      markWidget = new Row(
        children: <Widget>[
          new Expanded(
            flex: 2,
            child: new Container(
              child: new Text(
                article.mark,
                style: TextStyle(height: 1.3, color: GlobalConfig.fontColor),
              ),
            ),
          ),
          new Expanded(
              flex: 1,
              child: AspectRatio(
                aspectRatio: 3.0 / 2.0,
                child: new Container(
                  foregroundDecoration: BoxDecoration(
                    image: new DecorationImage(
                      image: NetworkImage(article.imgUrl),
                      centerSlice:
                          new Rect.fromLTRB(270.0, 180.0, 1360.0, 730.0),
                    ),
                    borderRadius:
                        const BorderRadius.all(const Radius.circular(6.0)),
                  ),
                ),
              ))
        ],
      );
    }

    return new Container(
      color: GlobalConfig.cardBackgroundColor,
      margin: const EdgeInsets.only(top: 5.0, bottom: 5.0),
      child: new FlatButton(
        onPressed: (){
          // Navigator.of(context).push(new MaterialPageRoute(
          //   builder: (context) {
          //     return new ReplyPage();
          //   },
          // ));
        }, 
        //child: null
      ),
    );
  }

  Widget billboard() {
    return Container(

      
    );
  }

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: new Container(
        margin: const EdgeInsets.only(top: 5.0),
        child: new Column(
          children: <Widget>[
            wordsCard(articleList[0]),
            wordsCard(articleList[1]),
            wordsCard(articleList[2]),
            billboard(),
            wordsCard(articleList[3])
          ],
        ),
      ),
    );
  }
}
