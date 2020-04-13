//
//  SquareArenaViewController.swift
//  exercise_03
//
//  Created by 杨祖亮 on 2020/4/13.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit


protocol SaveNameAndColorProtocol: class {
    
    func saveName(newName: String)
    
    func setSquareColor(color: UIColor)
}

class SquareArenaViewController: UIViewController {
    
    var color: UIColor!

//    weak var delegate: SaveNameAndColorProtocol?
//    
//    init(delegate: SaveNameAndColorProtocol) {
//        
//        super.init(nibName: nil, bundle: nil)
//        self.delegate = delegate
//    }
//    
//    required init?(coder: NSCoder) {
//        fatalError("init(coder:) has not been implemented")
//    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .white
        
    }
    //greenView.center = touches.first!.location(in: view)
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        
        let v = UIView(frame: CGRect(x: view.center.x, y: view.center.y, width: 30, height: 30))
        v.backgroundColor = color
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

extension SquareArenaViewController: SaveNameAndColorProtocol {
    
    func saveName(newName: String) {
    }
    
    func setSquareColor(color: UIColor) {
        self.color = color
    }
}
