//
//  HeaderView.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/5/6.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class HeaderView: UICollectionReusableView {
    
    var label: UILabel!
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        backgroundColor = .white
        
        label = UILabel()
        label.textAlignment = .center
        label.text = "This is my header view!"
        label.translatesAutoresizingMaskIntoConstraints = false
        
        addSubview(label)
        
        setupConstraints()
    }
    
    func setupConstraints() {
        NSLayoutConstraint.activate([
            label.leadingAnchor.constraint(equalTo: leadingAnchor),
            label.topAnchor.constraint(equalTo: topAnchor),
            label.trailingAnchor.constraint(equalTo: trailingAnchor),
            label.bottomAnchor.constraint(equalTo: bottomAnchor)
        ])
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}
