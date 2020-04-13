//
//  ViewController.swift
//  exercise_03
//
//  Created by 杨祖亮 on 2020/4/13.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit



class ViewController: UIViewController {

    var redSquareArena: UIButton!
    
    var blueCircleArena: UIButton!
    
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
        
        view.addSubview(redSquareArena)
        view.addSubview(blueCircleArena)
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
    }
    
    @objc func openNewView() {
        
        let vc = SquareArenaViewController()
        vc.setSquareColor(color: .blue)
        self.navigationController?.pushViewController(vc, animated: true)
    }
}

