//
//  StartViewController.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/4/19.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit
//启动controller
//1.json解析
//2.http请求
//3.3des rsa加解密 调OC
//03、ex03
class StartViewController: UIViewController {
    
    var tableView: UITableView!
    
    let reuseIdentifier = "studyCase"
    
    let cellHeight: CGFloat = 50
    
    var studyCaseModel: [StudyCaseModel]!
    
    override func viewDidLoad() {
        
        super.viewDidLoad()
        title = "swift study case"
        view.backgroundColor = .white
        let cornell_ch02 = StudyCaseModel(name: "corenll ch02 lecture UIKit and AutoLayout", vc:Cornell02ViewController())
        let cornell_ch02_ex = StudyCaseModel(name: "corenll ch02 ex UIKit and AutoLayout", vc:Cornell02ExViewController())
        let cornell_ch03 = StudyCaseModel(name: "corenll ch03 lecture Navigation, MVC, and Delegation", vc:NavigationMVCandDelegationViewController())
        
        let cornell_ch03_ex = StudyCaseModel(name: "corenll ch03 ex Navigation, MVC, and Delegation", vc:NavigationMVCandDelegationExViewController())
        
        let cornell_ch04 = StudyCaseModel(name: "corenll ch04 lecture UITableViewStudyCase", vc: TableViewController())
        studyCaseModel = [cornell_ch02,
                          cornell_ch02_ex,
                          cornell_ch03,
                          cornell_ch03_ex,
                          cornell_ch04]
        tableView = UITableView()
        tableView.translatesAutoresizingMaskIntoConstraints = false
        tableView.register(StartTableViewCell.self, forCellReuseIdentifier: reuseIdentifier)
        tableView.dataSource = self
        tableView.delegate = self
        
        view.addSubview(tableView)
        setupConstraint()
        
    }
    
    func setupConstraint() {
        
        NSLayoutConstraint.activate([
            tableView.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            tableView.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            tableView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            tableView.bottomAnchor.constraint(equalTo: view.safeAreaLayoutGuide.bottomAnchor)
        ])
    }
}

extension StartViewController: UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return studyCaseModel.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: reuseIdentifier, for: indexPath) as!StartTableViewCell
        let model = studyCaseModel[indexPath.row]
        //cell.nameLabel = diningHall.name
        cell.configure(for: model)
        
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        let model: StudyCaseModel  = studyCaseModel[indexPath.row]
        navigationController?.pushViewController(model.vc, animated: true)
        
    }
}

extension StartViewController: UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return cellHeight
    }
}

