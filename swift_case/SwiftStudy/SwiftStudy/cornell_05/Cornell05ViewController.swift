//
//  Cornell05ViewController.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/5/6.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class Cornell05ViewController: ViewController {
    
    var collectionView: UICollectionView!
    
    let personCellReuseIdentifier = "personCellReuseIdentifier"
    
    let headerReuseIdentifier = "headerReuseIdentifier"
    
    let headerHeight: CGFloat = 30
    
    let padding: CGFloat = 8
    
    var people: [Person] = []
    
    let bill = Person(imageName: "billgates", personName: "Bill Gates")
    
    let melinda = Person(imageName: "melinda", personName: "Melinda Gates")

    override func viewDidLoad() {
        super.viewDidLoad()

        title = "Photos"
        view.backgroundColor = .white
        people = [bill, melinda,bill, melinda,bill, melinda,bill, melinda,bill, melinda, bill, melinda,bill, melinda,bill, melinda,bill, melinda,bill, melinda]
        
        let layout = UICollectionViewFlowLayout()
        //水平滚动或者垂直滚动
        //layout.scrollDirection = .horizontal
        layout.scrollDirection = .vertical
        layout.minimumLineSpacing = padding
        layout.minimumInteritemSpacing = padding
        
        collectionView = UICollectionView(frame: .zero, collectionViewLayout: layout)
        collectionView.register(PersonCollectionViewCell.self, forCellWithReuseIdentifier: personCellReuseIdentifier)
        collectionView.register(HeaderView.self, forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: headerReuseIdentifier)
        collectionView.dataSource = self
        collectionView.delegate = self
        collectionView.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(collectionView)
        
        
        
        
        
        setupConstraints()
    }
    
    func setupConstraints() {
        
        NSLayoutConstraint.activate([
            collectionView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: padding),
            collectionView.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: padding),
            collectionView.bottomAnchor.constraint(equalTo: view.bottomAnchor),
            collectionView.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -padding)
        ])
    }


}

extension Cornell05ViewController: UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return people.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: personCellReuseIdentifier, for: indexPath) as! PersonCollectionViewCell
        cell.configure(person: people[indexPath.item])
        
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        let headerView = collectionView.dequeueReusableSupplementaryView(ofKind: UICollectionView.elementKindSectionHeader, withReuseIdentifier: headerReuseIdentifier, for: indexPath) as! HeaderView
        
        return headerView
    }
}


extension Cornell05ViewController: UICollectionViewDelegateFlowLayout {
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        // We want: | padding CELL padding CELL padding CELL padding |
        let size = (collectionView.frame.width - 2 * padding) / 3.0
        return CGSize(width: size, height: size)
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, referenceSizeForHeaderInSection section: Int) -> CGSize {
        return CGSize(width: collectionView.frame.width, height: headerHeight)
    }

}

extension Cornell05ViewController: UICollectionViewDelegate {
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        let person = people[indexPath.item]
        print(person.personName)
        
        if person.personName == "Bill Gates" {
            people[indexPath.item] = melinda
        } else if person.personName == "Melinda Gates" {
            people[indexPath.item] = bill
        }
        
        collectionView.reloadData()
    }
    
}
