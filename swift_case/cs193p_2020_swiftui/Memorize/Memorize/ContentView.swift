//
//  ContentView.swift
//  Memorize
//
//  Created by 杨祖亮 on 2020/7/5.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import SwiftUI

struct ContentView: View {
    //some View是一种类型,类似int,String等等
    var body: some View {
        
        return HStack{
            ForEach(0..<4){ index in
                CardView(isFaceUp: false)
            }
        }
        
        
            .padding()
            .foregroundColor(Color.orange)//内容是橘色的
            .font(Font.largeTitle)
        
        
        //return Text("👻")
    }
}

struct CardView: View {
    var isFaceUp: Bool
    var body: some View {
    
        ZStack{
            
            if isFaceUp {
                RoundedRectangle(cornerRadius: 10.0).fill(Color.white)
                RoundedRectangle(cornerRadius: 10.0).stroke(lineWidth: 3)
                Text("👻")
            }else{
                RoundedRectangle(cornerRadius: 10.0).fill()
            }
            

            
        }
    }
}

















struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
