//
//  MemoryGame.swift
//  Memorize
//
//  Created by 杨祖亮 on 2020/7/27.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import Foundation

struct MemoryGame<CardContent> {
    
    var cards: Array<Card>
    
    func choose(card: Card) -> String{
        print("card chosen: \(card)")
    }
    
    struct Card {
        var isFaceUp: Bool
        var isMatched: Bool
        var content: CardContent
    }
}
