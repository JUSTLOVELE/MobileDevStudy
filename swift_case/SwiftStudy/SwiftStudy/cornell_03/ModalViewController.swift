//
//  ModalViewController.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/4/21.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class ModalViewController: UIViewController {

    
     var button: UIButton!
     var textField: UITextField!
     var titleString: String?
     
     weak var delegate: SaveNewNameProtocol?
     
     init(delegate: SaveNewNameProtocol?, titleString: String) {
         super.init(nibName: nil, bundle: nil)
         self.titleString = titleString
         self.delegate = delegate
     }
     
     required init?(coder: NSCoder) {
         fatalError("init(coder:) has not been implemented")
     }
     
     override func viewDidLoad() {
         super.viewDidLoad()
         view.backgroundColor = .red
         
         textField = UITextField()
         textField.translatesAutoresizingMaskIntoConstraints = false
         textField.placeholder = titleString
         textField.borderStyle = .roundedRect
         textField.backgroundColor = .white
         textField.textAlignment = .center
         textField.clearsOnBeginEditing = true
         view.addSubview(textField)
         
         button = UIButton()
         button.translatesAutoresizingMaskIntoConstraints = false
         button.setTitle("Dismiss and save text", for: .normal)
         button.backgroundColor = .white
         button.setTitleColor(.red, for: .normal)
         
         // When the button is pressed, dismiss this ModalViewController and change the button name
         button.addTarget(self, action: #selector(dismissViewControllerAndSaveText), for: .touchUpInside)
         view.addSubview(button)
         
         setupConstraints()
     }
     
     func setupConstraints() {
         // textField constraints
         NSLayoutConstraint.activate([
             textField.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 24),
             textField.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 16),
             textField.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -16),
             textField.heightAnchor.constraint(equalToConstant: 24)
         ])
         
         // button constraints
         NSLayoutConstraint.activate([
             button.topAnchor.constraint(equalTo: textField.bottomAnchor, constant: 16),
             button.centerXAnchor.constraint(equalTo: view.centerXAnchor),
             button.heightAnchor.constraint(equalToConstant: 48)
         ])
     }
     
     @objc func dismissViewControllerAndSaveText() {
         
         
         delegate?.saveNewName(newName: textField.text!)
         dismiss(animated: true, completion: nil)
     }

}
