//
//  ViewController.swift
//  Cornell_03
//
//  Created by 杨祖亮 on 2020/4/7.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

protocol SaveNewNameProtocol: class {
    
    func saveNewName(newName: String)
}

class ViewController: UIViewController {
    
    var pushNavViewControllerButton: UIButton!
    var presentModalViewControllerButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .white
        
        // Set the navigation controller's title!
        
        pushNavViewControllerButton = UIButton()
        pushNavViewControllerButton.translatesAutoresizingMaskIntoConstraints = false
        pushNavViewControllerButton.setTitle("Push Navigation VC", for: .normal)
        pushNavViewControllerButton.setTitleColor(.blue, for: .normal)
        pushNavViewControllerButton.addTarget(self, action: #selector(pushNavViewController), for: .touchUpInside)
        view.addSubview(pushNavViewControllerButton)
        
        presentModalViewControllerButton = UIButton()
        presentModalViewControllerButton.translatesAutoresizingMaskIntoConstraints = false
        presentModalViewControllerButton.setTitle("Present Modal VC [change my name]", for: .normal)
        presentModalViewControllerButton.setTitleColor(.red, for: .normal)
        presentModalViewControllerButton.addTarget(self, action: #selector(presentModalViewController), for: .touchUpInside)
        view.addSubview(presentModalViewControllerButton)
        
        setupConstraints()
    }
    
    func setupConstraints() {
        NSLayoutConstraint.activate([
            pushNavViewControllerButton.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            pushNavViewControllerButton.centerYAnchor.constraint(equalTo: view.centerYAnchor),
            pushNavViewControllerButton.heightAnchor.constraint(equalToConstant: 24)
        ])
        
        NSLayoutConstraint.activate([
            presentModalViewControllerButton.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            presentModalViewControllerButton.topAnchor.constraint(equalTo: pushNavViewControllerButton.bottomAnchor, constant: 16),
            presentModalViewControllerButton.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    @objc func pushNavViewController() {
        
        let vc = BlueViewController()
        navigationController?.pushViewController(vc, animated: true)
        
    }
    
    @objc func presentModalViewController() {
        
        let vc = ModalViewController(delegate: self, titleString:  (presentModalViewControllerButton.titleLabel?.text)!)
        self.present(vc, animated: true, completion: nil)
    }
}

extension ViewController: SaveNewNameProtocol {
    
    func saveNewName(newName: String) {
        presentModalViewControllerButton.setTitle(newName, for: .normal)
    }
}
