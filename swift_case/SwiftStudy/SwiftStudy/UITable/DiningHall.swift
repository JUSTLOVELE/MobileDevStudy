//
//  DiningHall.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/4/17.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import Foundation

enum Rating {
    case bad
    case okey
    case good
    case great
}

class DiningHall {
    
    var name: String
    var rating: Rating
    var isFavorite: Bool
    
    init(name: String, rating: Rating, isFavorite:Bool) {
        
        self.name = name
        self.rating = rating
        self.isFavorite = isFavorite
    }
    
    func getRatingString() -> String {
        
        switch rating {
        case .bad:
            return "Bad"
            
        case .okey:
            return "Okey"
            
        case .good:
            return "good"
            
        case .great:
            return "great"
        }
    }
    
}
