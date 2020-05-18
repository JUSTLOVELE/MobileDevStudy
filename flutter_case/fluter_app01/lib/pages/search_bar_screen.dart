import 'package:flutter/material.dart';


const searchList = [
  "jiejie-大长腿",
  "jiejie-水蛇腰",
  "gege1-帅气欧巴",
  "gege2-小鲜肉"
];

const recentSuggest = [
  "推荐-1",
  "推荐-2"
];

class SearchBarSceen extends StatefulWidget {
  _SearchBarSceen createState() => _SearchBarSceen();
}

class _SearchBarSceen extends State<SearchBarSceen> {

@override
Widget build(BuildContext context) {
  return Scaffold(

    appBar:AppBar(
      title: Text('search bar demo'),
      actions: <Widget>[
        IconButton(
          icon: Icon(Icons.search),
          onPressed: (){
           showSearch(context: context, delegate: searchBarDelegate());
          },
        )
      ],
    )
  );
}
}

class searchBarDelegate extends SearchDelegate<String> {

  //加一个clear图标,点击时清空数据
  @override
  List<Widget> buildActions(BuildContext context) {
    return [
      IconButton(
        icon: Icon(Icons.clear),
        onPressed: ()=> query = "",
      )
    ];
  }

  //左侧点击箭头关闭搜索页面
  @override
  Widget buildLeading(BuildContext context) {
    return IconButton(
      icon: AnimatedIcon(
        icon: AnimatedIcons.menu_arrow, progress: transitionAnimation
      ),
      onPressed: ()=> close(context, null)
    );
  }
  //结果展示
  @override
  Widget buildResults(BuildContext context) {
    
    return Container(
      width: 100.0,
      height: 100.0,
      child: Card(
        color: Colors.redAccent,
        child: Center(
          child: Text(query),
        ),
      ),
    );
  }

  //设置推荐
  @override
  Widget buildSuggestions(BuildContext context) {
    final suggestionList = query.isEmpty ? recentSuggest : searchList.where((input) => input.startsWith(query)).toList();
    return ListView.builder(
      itemCount: suggestionList.length,
      itemBuilder: (context, index) => ListTile(
        title: RichText(
          text: TextSpan(
            text: suggestionList[index].substring(0, query.length),
            style: TextStyle(
              color: Colors.black, fontWeight: FontWeight.bold
            ),
            children: [TextSpan(
              text: suggestionList[index].substring(query.length),
              style: TextStyle(color: Colors.grey)
            )]
          ),
        ),
      ),
      );
  }
}