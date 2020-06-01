//
//  UIColor.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/6/1.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

extension UIColor {

    static let silver = colorFromCode(0xC0BCB5)
    static let space = colorFromCode(0x4A6C6F)
    static let mauve = colorFromCode(0x846075)
    static let redPurple = colorFromCode(0xAF5D63)
    static let salsa = colorFromCode(0xED474A)

    public static func colorFromCode(_ code: Int) -> UIColor {
        let red = CGFloat(((code & 0xFF0000) >> 16)) / 255
        let green = CGFloat(((code & 0xFF00) >> 8)) / 255
        let blue = CGFloat((code & 0xFF)) / 255
        return UIColor(red: red, green: green, blue: blue, alpha: 1)
    }

}
