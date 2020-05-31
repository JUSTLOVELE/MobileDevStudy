//
//  Cornell08ViewController.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/5/29.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class Cornell08ViewController: ViewController {

    let photoImageView = UIImageView()
    let nameLabel = UILabel()
    let usernameLabel = UILabel()
    let emailLabel = UILabel()
    let phoneNumberLabel = UILabel()
    let lastUpdatedLabel = UILabel()
    let songImageView = UIImageView()
    let userTitleLabel = UILabel()
    let songTitleLabel = UILabel()
    let songNameLabel = UILabel()
    var colorItems: [UIColor] = [UIColor.silver, UIColor.space, UIColor.mauve, UIColor.redPurple, UIColor.salsa]
    var selectedColor: UIColor = UIColor.silver
    
    let userDefaults = UserDefaults.standard
    
    
    override func viewDidLoad() {
        
        super.viewDidLoad()
        self.view.backgroundColor = .white
        
        
        
        // Do any additional setup after loading the view.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
