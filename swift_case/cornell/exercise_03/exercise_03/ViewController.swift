//
//  ViewController.swift
//  exercise_03
//
//  Created by 杨祖亮 on 2020/4/13.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

protocol EditName: class {
    
    func editRedName(name: String)
    
    func editBlueName(name: String)
}

class ViewController: UIViewController {

    var redSquareArena: UIButton!
    
    var blueCircleArena: UIButton!
    
    var magicalArena: UIButton!
    
    override func viewDidLoad() {
        
        super.viewDidLoad()
        view.backgroundColor = .white
        title = "Drawning Arena"
        redSquareArena = UIButton()
        redSquareArena.translatesAutoresizingMaskIntoConstraints = false
        redSquareArena.setTitle("Red Square Arena", for: .normal)
        redSquareArena.setTitleColor(.red, for: .normal)
        redSquareArena.addTarget(self, action: #selector(openNewView), for: .touchUpInside)
        
        blueCircleArena = UIButton()
        blueCircleArena.translatesAutoresizingMaskIntoConstraints = false
        blueCircleArena.setTitleColor(.blue, for: .normal)
        blueCircleArena.setTitle("Blue Circle Arena", for: .normal)
        blueCircleArena.addTarget(self, action: #selector(openBlueView), for: .touchUpInside)
        
        magicalArena = UIButton()
        magicalArena.translatesAutoresizingMaskIntoConstraints = false
        magicalArena.setTitle("magicalArena", for: .normal)
        magicalArena.setTitleColor(.black, for: .normal)
        magicalArena.addTarget(self, action: #selector(openMagicalView), for: .touchUpInside)
        
        view.addSubview(redSquareArena)
        view.addSubview(blueCircleArena)
        view.addSubview(magicalArena)
        setupConstraints()
    }
    
    func setupConstraints() {
        
        NSLayoutConstraint.activate([
            redSquareArena.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            redSquareArena.centerYAnchor.constraint(equalTo: view.centerYAnchor),
            redSquareArena.heightAnchor.constraint(equalToConstant: 24)
        ])
        
        NSLayoutConstraint.activate([
            blueCircleArena.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            blueCircleArena.topAnchor.constraint(equalTo: redSquareArena.bottomAnchor, constant: 16),
            blueCircleArena.heightAnchor.constraint(equalToConstant: 24)
        ])
        
        NSLayoutConstraint.activate([
            magicalArena.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            magicalArena.topAnchor.constraint(equalTo: blueCircleArena.bottomAnchor, constant: 16),
            magicalArena.heightAnchor.constraint(equalToConstant: 24)
        ])
    }
    
    @objc func openMagicalView() {
        
        let vc = MagicalViewController()
        self.navigationController?.pushViewController(vc, animated: true)
    }
    
    @objc func openBlueView() {
        
        let vc = SquareArenaViewController()
        vc.setSquareColor(color: .blue)
        vc.isCorner(isCorner: true)
        vc.saveName(newName: "Blue Circle Arena")
        vc.setViewController(vc: self)
        self.navigationController?.pushViewController(vc, animated: true)
    }
    
    @objc func openNewView() {
        
        let vc = SquareArenaViewController()
        vc.setSquareColor(color: .red)
        vc.isCorner(isCorner: false)
        vc.setViewController(vc: self)
        vc.saveName(newName: "Red Square Arena")
        self.navigationController?.pushViewController(vc, animated: true)
    }
}

extension ViewController: EditName {
    func editRedName(name: String) {
        redSquareArena.setTitle(name, for: .normal)
    }
    
    func editBlueName(name: String) {
        blueCircleArena.setTitle(name, for: .normal)
    }
}

