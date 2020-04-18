//
//  StudyCaseModel.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/4/19.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import Foundation

class StudyCaseModel {
    
    var name: String!
    
    var vc: ViewController!
    
    init(name: String, vc: ViewController) {
        self.name = name
        self.vc = vc
    }
}
