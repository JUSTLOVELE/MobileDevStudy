//
//  EmojiMemoryGame.swift
//  Memorize
//
//  Created by 杨祖亮 on 2020/7/27.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import SwiftUI

class EmojiMemoryGame {
    
    private(set) var model: MemoryGame<String>
    
    var cards: Array<MemoryGame<String>.Card> {
        return model.cards
    }
    
    func choose(card: MemoryGame<String>.Card) {
        model.choose(card: card)
    }
    
    
}
