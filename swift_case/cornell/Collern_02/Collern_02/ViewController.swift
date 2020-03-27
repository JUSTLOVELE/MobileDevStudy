//
//  ViewController.swift
//  Collern_02
//
//  Created by 杨祖亮 on 2020/3/25.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    var nameLabel: UILabel!
    
    var imageView: UIImageView!
    
    var textView: UITextView!
    
    var followButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        view.backgroundColor = .white
        
        nameLabel = UILabel()
        nameLabel.text = "Bill Gates"
        nameLabel.textColor = .black
        nameLabel.font = UIFont.systemFont(ofSize: 20, weight: .bold)
        nameLabel.translatesAutoresizingMaskIntoConstraints = false
        
        imageView = UIImageView()
        textView = UITextView()
        followButton = UIButton()
        followButton.setTitle("Follow", for: .normal)
        followButton.setTitleColor(.blue, for: .normal)
        followButton.translatesAutoresizingMaskIntoConstraints = false
        followButton.layer.borderColor = UIColor.blue.cgColor
        followButton.addTarget(self, action: #selector(followButtonTapped) , for: .touchUpInside)
        followButton.layer.borderWidth = 1
        
        view.addSubview(nameLabel)
        view.addSubview(imageView)
        view.addSubview(followButton)
        
        setupConstraints()
    }
    
    @objc func followButtonTapped() {
        
        if followButton.titleLabel?.text == "Follow" {
            followButton.setTitle("Following", for: .normal)
            followButton.setTitleColor(.white, for: .normal)
            followButton.backgroundColor = .blue
        }else{
            followButton.setTitle("Follow", for: .normal)
            followButton.setTitleColor(.blue, for: .normal)
            followButton.backgroundColor = .white
        }
        
    }
    
    func setupConstraints() {
        
        NSLayoutConstraint.activate([
            nameLabel.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant:  15),
            nameLabel.centerXAnchor.constraint(equalTo: view.centerXAnchor)
        ])
        
        NSLayoutConstraint.activate(
            [followButton.topAnchor.constraint(equalTo: nameLabel.bottomAnchor, constant: 15),
            followButton.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            followButton.widthAnchor.constraint(equalToConstant: 100)]
        )
    }


}

