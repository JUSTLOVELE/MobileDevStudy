//
//  ViewController.swift
//  exercise_02
//
//  Created by 杨祖亮 on 2020/3/31.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit


extension UITextField {

    open override var intrinsicContentSize: CGSize {

        return CGSize(width: CGFloat(100), height: CGFloat(30))
    }

}

class ViewController: UIViewController {
    


    var groceryLabel: UILabel!
    
    var groceryTextfield: UITextField!
    
    var quantityLabel: UILabel!
    
    var quantityTextfield: UITextField!
    
    var button: UIButton!
    
    //var quantityLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .white
        
        start()
        setupConstraints()
    }
    
    func start() {
        
        groceryLabel = UILabel()
        groceryLabel.translatesAutoresizingMaskIntoConstraints = false
        groceryLabel.text = "Grocery:"
        groceryLabel.textColor = .black
        groceryLabel.font = UIFont.systemFont(ofSize: 20)
        
        groceryTextfield = UITextField()
        groceryTextfield.translatesAutoresizingMaskIntoConstraints = false
        groceryTextfield.backgroundColor = .lightGray
        groceryTextfield.borderStyle = .roundedRect
        groceryTextfield.becomeFirstResponder()
        
        quantityLabel = UILabel()
        quantityLabel.translatesAutoresizingMaskIntoConstraints = false
        quantityLabel.text = "quantityLabel:"
        quantityLabel.textColor = .black
        quantityLabel.font = UIFont.systemFont(ofSize: 20)
        
        quantityTextfield = UITextField()
        quantityTextfield.translatesAutoresizingMaskIntoConstraints = false
        quantityTextfield.backgroundColor = .lightGray
        quantityTextfield.borderStyle = .roundedRect
        
        button = UIButton()
        button.setTitle("add item", for: .normal)
        button.setTitleColor(.blue, for: .normal)
        button.titleLabel?.font = UIFont.systemFont(ofSize: 24)
        button.translatesAutoresizingMaskIntoConstraints = false
        
    
        view.addSubview(groceryLabel)
        view.addSubview(groceryTextfield)
        view.addSubview(quantityLabel)
        view.addSubview(quantityTextfield)
        view.addSubview(button)
    }
    
    func setupConstraints() {

        
        NSLayoutConstraint.activate([
            groceryLabel.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 15),
            //groceryLabel.leadingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.leadingAnchor, constant: 15)
            groceryLabel.trailingAnchor.constraint(equalTo: view.centerXAnchor)
        ])

        NSLayoutConstraint.activate([
           groceryTextfield.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 15),
           groceryTextfield.leadingAnchor.constraint(equalTo: groceryLabel.trailingAnchor,constant: 15),
         //  groceryTextfield.trailingAnchor.constraint(equalTo: view.trailingAnchor)
            //groceryTextfield.trailingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.trailingAnchor, constant: 50)
            
        ])
        
        NSLayoutConstraint.activate([
            quantityLabel.topAnchor.constraint(equalTo: groceryLabel.bottomAnchor, constant: 30),
            //quantityLabel.leadingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.leadingAnchor, constant: 15)
            quantityLabel.trailingAnchor.constraint(equalTo: view.centerXAnchor)
        ])
        
        NSLayoutConstraint.activate([
            quantityTextfield.topAnchor.constraint(equalTo: groceryTextfield.bottomAnchor, constant: 30),
            quantityTextfield.leadingAnchor.constraint(equalTo: quantityLabel.trailingAnchor, constant: 15),
           // quantityTextfield.trailingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.trailingAnchor, constant: 15)
        ])
        
        NSLayoutConstraint.activate([
            button.topAnchor.constraint(equalTo: quantityLabel.bottomAnchor, constant: 50),
            button.centerXAnchor.constraint(equalTo: view.safeAreaLayoutGuide.centerXAnchor)
        ])
        
    }


}

