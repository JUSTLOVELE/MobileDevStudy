//
//  StartTableViewCell.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/4/19.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class StartTableViewCell: UITableViewCell {
    
    var nameLabel: UILabel!
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        nameLabel = UILabel()
        nameLabel.font = UIFont.boldSystemFont(ofSize: 16)
        nameLabel.translatesAutoresizingMaskIntoConstraints = false
        contentView.addSubview(nameLabel)
        
        setupConstraints()
    }
    
    func setupConstraints() {
        
        NSLayoutConstraint.activate([
//            nameLabel.topAnchor.constraint(equalTo: contentView.topAnchor, constant: 8),
//            nameLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 8),
//            nameLabel.heightAnchor.constraint(equalToConstant: 16)
            nameLabel.centerXAnchor.constraint(equalTo: contentView.centerXAnchor),
            nameLabel.centerYAnchor.constraint(equalTo: contentView.centerYAnchor)
        ])
    }
    
    func configure(for model: StudyCaseModel) {
        
        nameLabel.text = model.name
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
}
