//
//  ViewController.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/4/13.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

//1.json解析
//2.http请求
//3.3des rsa加解密 调OC
class ViewController: UIViewController {
    
    var tableView: UITableView!
    
    let reuseIdentifier = "dininghallCellReuse"
    
    let cellHeight: CGFloat = 50
    
    var diningHalls: [DiningHall]!

    override func viewDidLoad() {
        
        super.viewDidLoad()
        title = "swift study case"
        view.backgroundColor = .white
        let apple = DiningHall(name: "Apple", rating: .great, isFavorite: false)
        let rpcc = DiningHall(name: "RPCC", rating: .good, isFavorite: false)
        let rose = DiningHall(name: "Rose", rating: .great, isFavorite: false)
        let bethe = DiningHall(name: "Bethe", rating: .okey, isFavorite: false)
        let keeton = DiningHall(name: "Keeton", rating: .bad, isFavorite: false)
        diningHalls = [apple, rpcc, rose, bethe, keeton]
        
        tableView = UITableView()
        tableView.translatesAutoresizingMaskIntoConstraints = false
        tableView.register(DiningHallTableViewCell.self, forCellReuseIdentifier: reuseIdentifier)
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

extension ViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return diningHalls.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: reuseIdentifier, for: indexPath) as!DiningHallTableViewCell
        let diningHall = diningHalls[indexPath.row]
        //cell.nameLabel = diningHall.name
        cell.configure(for: diningHall)
        
        return cell
    }
}

extension ViewController: UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return cellHeight
    }
}
