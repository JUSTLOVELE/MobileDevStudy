//
//  Song.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/6/4.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import Foundation

class  Song: NSObject, Codable {
    let name: String
    let artist: String
    
    init(name: String, artist: String) {
        self.name = name
        self.artist = artist
    }
}
