//
//  TableViewController.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/4/20.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class TableViewController: ViewController {
    
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

extension TableViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return diningHalls.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: reuseIdentifier, for: indexPath) as!DiningHallTableViewCell
        let diningHall = diningHalls[indexPath.row]
        //cell.nameLabel = diningHall.name
        cell.selectionStyle = .none
        cell.configure(for: diningHall)
        
        return cell
    }
}

extension TableViewController: UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return cellHeight
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        
        let diningHall = diningHalls[indexPath.row]
        diningHall.isFavorite.toggle()
        print("IsFavorite? \(diningHall.isFavorite)")
        
        
        let cell = tableView.cellForRow(at: indexPath)as! DiningHallTableViewCell
        cell.toggleImageView()
        
        
    }
}
