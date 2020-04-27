//
//  SongEntity.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/4/27.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import Foundation

class SongEntity {
    
    var songName: String
    
    var artistName: String
    
    var album: String
    
    init(songName: String, artistName: String, album: String) {
        
        self.songName = songName
        self.artistName = artistName
        self.album = album
    }
}
