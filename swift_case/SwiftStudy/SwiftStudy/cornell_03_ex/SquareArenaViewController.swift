//
//  SquareArenaViewController.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/4/21.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

protocol SaveNameAndColorProtocol: class {
    
    func saveName(newName: String)
    
    func setSquareColor(color: UIColor)
    
    func isCorner(isCorner: Bool)
    
    func setViewController(vc: NavigationMVCandDelegationExViewController)
}
class SquareArenaViewController: UIViewController {
    
    var color: UIColor!
    
    var isCorner: Bool!
    
    var arenaLabel: UILabel!
    
    var areanText: UITextField!
    
    var name: String!
    
    var controller: NavigationMVCandDelegationExViewController!
    
    override func viewDidLoad() {
        
        super.viewDidLoad()
        view.backgroundColor = .white
        
        let btn = UIButton()
        btn.setTitle("save", for: .normal)
        btn.setTitleColor(.blue, for: .normal)
        btn.addTarget(self, action: #selector(save), for: .touchUpInside)
        navigationItem.rightBarButtonItem = UIBarButtonItem(customView: btn)
        
        arenaLabel = UILabel();
        arenaLabel.text = "Arena Name:"
        arenaLabel.translatesAutoresizingMaskIntoConstraints = false
        
        areanText = UITextField()
        areanText.translatesAutoresizingMaskIntoConstraints = false
        areanText.text = name
        
        view.addSubview(arenaLabel)
        view.addSubview(areanText)
        setupConstraints()
    }
    
    @objc func save() {
        
        if areanText.text!.isEmpty {
            
            let alertController = UIAlertController(title: "提示", message: "输入不能为空", preferredStyle: .alert)
            let alertOK = UIAlertAction(title: "确认", style: .cancel, handler: nil)
            alertController.addAction(alertOK)
            present(alertController, animated: true, completion: nil)
            
            return
        }
        
        navigationController?.popViewController(animated: true)
        let s: String = areanText.text!
        
        if(isCorner) {
            controller.editBlueName(name: s)
            
        }else{
            controller.editRedName(name: s)
        }
        
        //        navigationController?.popToRootViewController(animated: true)
        //        let vc = self.presentingViewController
        
        
        
        //        if vc!.isKind(of: ViewController.self) {
        //
        //            let v: ViewController = vc as! ViewController
        //
        //            let s: String = areanText.text!
        //            print(s)
        //
        //            if(isCorner) {
        //                v.editBlueName(name: s)
        //
        //            }else{
        //                v.editRedName(name: s)
        //            }
        //        }
        
        
    }
    
    func setupConstraints() {
        
        NSLayoutConstraint.activate([
            //arenaLabel.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            //arenaLabel.centerYAnchor.constraint(equalTo: view.centerYAnchor)
            arenaLabel.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 30),
            //arenaLabel.trailingAnchor.constraint(equalTo: view.centerXAnchor)
            arenaLabel.leadingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.leadingAnchor, constant: 20)
        ])
        
        NSLayoutConstraint.activate([
            areanText.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 26),
            areanText.leadingAnchor.constraint(equalTo: arenaLabel.trailingAnchor, constant: 10)
        ])
    }
    
    //greenView.center = touches.first!.location(in: view)
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        
        let v = UIView(frame: CGRect(x: view.center.x, y: view.center.y, width: 30, height: 30))
        
        if(isCorner) {
            v.layer.cornerRadius = 10
        }
        
        v.backgroundColor = color
        v.center = touches.first!.location(in: view)
        view.addSubview(v)
    }
}

extension SquareArenaViewController: SaveNameAndColorProtocol {
    
    func setViewController(vc: NavigationMVCandDelegationExViewController) {
        self.controller = vc
    }
    
    
    func isCorner(isCorner: Bool) {
        self.isCorner = isCorner
    }
    
    
    func saveName(newName: String) {
        self.name = newName
    }
    
    func setSquareColor(color: UIColor) {
        self.color = color
    }
}
