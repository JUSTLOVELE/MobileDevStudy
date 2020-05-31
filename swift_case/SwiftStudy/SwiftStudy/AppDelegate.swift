//
//  AppDelegate.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/4/13.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

//    var window: UIWindow?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Override point for customization after application launch.
        
//        let window = UIWindow(frame: UIScreen.main.bounds)
//        let viewController = ViewController()
//        window.rootViewController = viewController
//        window.makeKeyAndVisible()
//        self.window = window
        let userDefaults = UserDefaults.standard
        userDefaults.register(defaults: [
            Constants.UserDefaults.name: "yangzl",
            Constants.UserDefaults.username: "just_love_le",
            Constants.UserDefaults.email: "694105388@qq.com",
            Constants.UserDefaults.lastUpdated: Date(),
            Constants.UserDefaults.color: 0,
            Constants.UserDefaults.favoriteSong: Data()
        ])
        
        return true
    }

    // MARK: UISceneSession Lifecycle

    func application(_ application: UIApplication, configurationForConnecting connectingSceneSession: UISceneSession, options: UIScene.ConnectionOptions) -> UISceneConfiguration {
        // Called when a new scene session is being created.
        // Use this method to select a configuration to create the new scene with.
        return UISceneConfiguration(name: "Default Configuration", sessionRole: connectingSceneSession.role)
    }

    func application(_ application: UIApplication, didDiscardSceneSessions sceneSessions: Set<UISceneSession>) {
        // Called when the user discards a scene session.
        // If any sessions were discarded while the application was not running, this will be called shortly after application:didFinishLaunchingWithOptions.
        // Use this method to release any resources that were specific to the discarded scenes, as they will not return.
    }


}

