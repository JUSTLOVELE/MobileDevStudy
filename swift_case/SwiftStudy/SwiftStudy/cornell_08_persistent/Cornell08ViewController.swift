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
    let songArtistLabel = UILabel()
    var colorItems: [UIColor] = [UIColor.silver, UIColor.space, UIColor.mauve, UIColor.redPurple, UIColor.salsa]
    var selectedColor: UIColor = UIColor.silver
    let userDefaults = UserDefaults.standard
    
    override func viewDidLoad() {
        
        super.viewDidLoad()
        navigationController?.navigationBar.prefersLargeTitles = true
        self.view.backgroundColor = .white
        self.title = "Home"
        
        navigationItem.rightBarButtonItem = UIBarButtonItem(title: "Edit", style: .plain, target: self, action: #selector(pushProfileViewController))
        userTitleLabel.text = "User"
        userTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        userTitleLabel.font = UIFont.systemFont(ofSize: 28, weight: .bold)
        view.addSubview(userTitleLabel)
        
        photoImageView.image = UIImage(named: "profile")
        photoImageView.layer.cornerRadius = 65
        photoImageView.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(photoImageView)
        
        nameLabel.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(nameLabel)
        
        usernameLabel.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(usernameLabel)
        
        emailLabel.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(emailLabel)
        
        phoneNumberLabel.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(phoneNumberLabel)
        
        lastUpdatedLabel.font = .systemFont(ofSize: 12)
        lastUpdatedLabel.textColor = .gray
        lastUpdatedLabel.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(lastUpdatedLabel)
        
        songTitleLabel.text = "song"
        songTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        songTitleLabel.font = UIFont.systemFont(ofSize: 28, weight: .bold)
        view.addSubview(songTitleLabel)
        
        songImageView.image = UIImage(named: "music")
        songImageView.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(songImageView)
        
        songNameLabel.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(songNameLabel)
        
        songArtistLabel.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(songArtistLabel)
        setUpConstraints()
    }
    
    func setUpConstraints() {
        
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
