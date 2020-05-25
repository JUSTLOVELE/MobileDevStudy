# 常见UI组件  
- 弹出层&对话框
- UITextField  
- UIButton  
- swift调用H5
- 用户缓存及json使用
---
## 弹出层&对话框  
注意,最后要present才会弹出对话框,然后是一个alertController里面加alertAction,可以有多个alertAction
底部弹出层  
```swift
let alertController = UIAlertController(title:"", message:"请选择类型", preferredStyle: .actionSheet)
let all = UIAlertAction(title: "全部", style: .default, handler: {
            (alert: UIAlertAction!) -> Void in
            print("全部")
        })
        
let paper = UIAlertAction(title: "论文", style: .default, handler: {
            (alert: UIAlertAction!) -> Void in
            print("论文")
        })
        
let lectureNote = UIAlertAction(title: "课件", style: .default, handler: {
            (alert: UIAlertAction!) -> Void in
            print("课件")
        })
        
let notice = UIAlertAction(title: "通知", style: .default, handler: {
            (alert: UIAlertAction!) -> Void in
            print("通知")
        })
        
let read = UIAlertAction(title: "阅读", style: .default, handler: {
            (alert: UIAlertAction!) -> Void in
            print("阅读")
        })
        
alertController.addAction(all)
alertController.addAction(paper)
alertController.addAction(lectureNote)
alertController.addAction(notice)
alertController.addAction(read)
present(alertController, animated:true, completion: nil)
```  
弹出确认框  
```swift 
let alertController = UIAlertController(title:"提示", message:"学生账号注册暂未开放", preferredStyle: .alert)
let alertOK = UIAlertAction(title: "好的", style: .cancel, handler:nil)
alertController.addAction(alertOK)
present(alertController, animated:true, completion: nil)
```  
## UITextField  
UITextField加placeholder:
```swift
textField.attributedPlaceholder = NSAttributedString.init(string:"请输入用户名", attributes: [
            NSAttributedString.Key.foregroundColor:UIColor.lightGray])
```

## UIButton  

```swift
returnBtn = UIButton()
returnBtn.setTitle("返回", for: .normal)
returnBtn.setTitleColor(.black, for: .normal)
//returnBtn.setImage(UIImage(named: "back"), for: .normal)
returnBtn.addTarget(self, action: #selector(goback), for: .touchUpInside)
navigationItem.leftBarButtonItem = UIBarButtonItem(customView: returnBtn)
```

## swift调用H5  
注意:新建的UIViewContrller一定要继承WKNavigationDelegate,WKScriptMessageHandler

```swift
import UIKit
import WebKit
class SwiftCallJSController: UIViewController,WKNavigationDelegate,WKScriptMessageHandler {
    lazy var webView: WKWebView = {
        let preferences = WKPreferences()
        //preferences.javaScriptEnabled = true
        let configuration = WKWebViewConfiguration()
        configuration.preferences = preferences
        configuration.userContentController = WKUserContentController()
        //注册AppFunc这个函数,让js调用
        configuration.userContentController.add(self, name: "AppFunc")
        var webView = WKWebView(frame: self.view.frame, configuration: configuration)
        webView.scrollView.bounces = true
        webView.scrollView.alwaysBounceVertical = true
        webView.navigationDelegate = self
        return webView
    }()
    override func viewDidLoad() {
        super.viewDidLoad()
        self.navigationController?.navigationBar.isTranslucent = false
        view.addSubview(webView)
        //        let myURL = URL(string:"http://192.168.1.235:8081/#/userAgreement")
        //        let myRequest = URLRequest(url: myURL!)
        //        webView.load(myRequest)
        let url = Bundle.main.url(forResource: "test", withExtension: "html")
        webView.load(URLRequest(url:url!))
     // 将页面内容转成string,方法3
        //        let TOPICDETAILHTML = try! String(contentsOfFile: Bundle.main.path(forResource: "index", ofType: "html")!, encoding: String.Encoding.utf8)
        //        webView.loadHTMLString(TOPICDETAILHTML, baseURL: Bundle.main.resourceURL)
        //方法4
        //        let path = Bundle.main.path(forResource: "testIndex", ofType: "html") ?? ""
        //        let p: String = path
        //        let url = URL(fileURLWithPath: p)
        //        print(url)
        //        webView.loadFileURL(url, allowingReadAccessTo: url)
    }
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        webView.evaluateJavaScript("testInput('userAgreement')") { (result, err) in
            print("js")
            print(result, err)
        }
        webView.evaluateJavaScript("forward('userAgreement')") { (result, err) in
            print("forward")
            print(result, err)
        }
webView.evaluateJavaScript("getUserInfoByIOS(" + s + ")", completionHandler: nil)
    }
    
    func userContentController(_ userContentController: WKUserContentController, didReceive message: WKScriptMessage) {
        print(message.body)
        print(message.name)//会显示注册的js函数名
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}
```
## 用户缓存及json使用  
在登录的地方设置缓存信息:
```swift
let user = UserDefaults.standard
user.set(userJSON[DOCTOR_NAME].string, forKey: DOCTOR_NAME)
user.set(userJSON[DEPT].string, forKey: DEPT)
user.set(userJSON[ORG_NAME].string, forKey: ORG_NAME)
user.set(userJSON[ORG_ID].string, forKey: ORG_ID)
user.set(userJSON[USER_OP_ID].string, forKey: USER_OP_ID)
user.set(userJSON[LEVEL].string, forKey: LEVEL)
user.set(userJSON[TECHNICAL_NAME].string, forKey: TECHNICAL_NAME)
user.set(userJSON[USER_ID].string, forKey: USER_ID)
user.set(userJSON[PHONE].string, forKey: PHONE)
user.set(userJSON[PHOTO_PATH].string, forKey: PHOTO_PATH)
user.set(userJSON[ORG_CLASS].string, forKey: ORG_CLASS)
user.set(userJSON[SEX].int, forKey: SEX)
user.set(userJSON[CATEGORY].string, forKey: CATEGORY)
user.set(userJSON[CATEGORY_LEVEL].string, forKey: CATEGORY_LEVEL)
user.set(userJSON[PASS_WORD].string, forKey: PASS_WORD)
user.set(userJSON[PARCTICE_CERT].string, forKey: PARCTICE_CERT)
user.set(userJSON[BG_IMG].string, forKey: BG_IMG)
```
需要使用时:  
```swift
let user = UserDefaults.standard
let json = JSON([
    DOCTOR_NAME: user.string(forKey: DOCTOR_NAME) as Any,
    DEPT: user.string(forKey: DEPT) as Any,
    ORG_NAME: user.string(forKey: ORG_NAME) as Any,
    ORG_ID: user.string(forKey: ORG_ID) as Any,
])
let s: String = json.rawString()!
```