//
//  ModalViewController.swift
//  exercise_03
//
//  Created by 杨祖亮 on 2020/4/13.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class ModalViewController: UIViewController {
    
    var greenView: UIView!

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .red
        
        greenView = UIView(frame: CGRect(x: 0, y: 0, width: 50, height: 100))
        greenView.backgroundColor = .green
        view.addSubview(greenView)
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        greenView.center = touches.first!.location(in: view)
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
