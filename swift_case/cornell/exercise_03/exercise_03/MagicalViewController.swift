//
//  MagicalViewController.swift
//  exercise_03
//
//  Created by 杨祖亮 on 2020/4/15.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class MagicalViewController: UIViewController {

    override func viewDidLoad() {
        
        super.viewDidLoad()
        
        view.backgroundColor = UIColor(displayP3Red: CGFloat(Float(arc4random()) / Float(UINT32_MAX)), green: CGFloat(Float(arc4random()) / Float(UINT32_MAX)), blue: CGFloat(Float(arc4random()) / Float(UINT32_MAX)), alpha: 1)
        // Do any additional setup after loading the view.
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        
        let v = UIView(frame: CGRect(x: view.center.x, y: view.center.y, width: 30, height: 30))
        v.backgroundColor = UIColor(displayP3Red: CGFloat(Float(arc4random()) / Float(UINT32_MAX)), green: CGFloat(Float(arc4random()) / Float(UINT32_MAX)), blue: CGFloat(Float(arc4random()) / Float(UINT32_MAX)), alpha: 1)
        v.center = touches.first!.location(in: view)
        view.addSubview(v)
    }

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
