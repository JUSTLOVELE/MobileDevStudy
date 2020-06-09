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
        
        NSLayoutConstraint.activate([
            userTitleLabel.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 24),
            userTitleLabel.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 24),
            userTitleLabel.heightAnchor.constraint(equalToConstant: 24),
            userTitleLabel.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -24)
        ])
        
        NSLayoutConstraint.activate([
            photoImageView.topAnchor.constraint(equalTo: userTitleLabel.bottomAnchor, constant: 12),
            photoImageView.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -48),
            photoImageView.heightAnchor.constraint(equalToConstant: 130),
            photoImageView.widthAnchor.constraint(equalToConstant: 130)
        ])
        
        NSLayoutConstraint.activate([
            nameLabel.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 72),
            nameLabel.heightAnchor.constraint(equalToConstant: 24),
            nameLabel.leadingAnchor.constraint(equalTo: userTitleLabel.leadingAnchor),
            nameLabel.trailingAnchor.constraint(equalTo: photoImageView.leadingAnchor, constant: -42)
        ])
        
        NSLayoutConstraint.activate([
            usernameLabel.topAnchor.constraint(equalTo: nameLabel.bottomAnchor, constant: 6),
            usernameLabel.heightAnchor.constraint(equalTo: nameLabel.heightAnchor),
            usernameLabel.leadingAnchor.constraint(equalTo: nameLabel.leadingAnchor),
            usernameLabel.trailingAnchor.constraint(equalTo: nameLabel.trailingAnchor)
        ])
        
        NSLayoutConstraint.activate([
            emailLabel.topAnchor.constraint(equalTo: usernameLabel.bottomAnchor, constant: 6),
            emailLabel.heightAnchor.constraint(equalTo: nameLabel.heightAnchor),
            emailLabel.leadingAnchor.constraint(equalTo: nameLabel.leadingAnchor),
            emailLabel.trailingAnchor.constraint(equalTo: nameLabel.trailingAnchor)
        ])
        
        NSLayoutConstraint.activate([
            phoneNumberLabel.topAnchor.constraint(equalTo: emailLabel.bottomAnchor, constant: 6),
            phoneNumberLabel.heightAnchor.constraint(equalTo: nameLabel.heightAnchor),
            phoneNumberLabel.leadingAnchor.constraint(equalTo: nameLabel.leadingAnchor),
            phoneNumberLabel.trailingAnchor.constraint(equalTo: nameLabel.trailingAnchor)
        ])
        
        NSLayoutConstraint.activate([
            songTitleLabel.topAnchor.constraint(equalTo: phoneNumberLabel.bottomAnchor, constant: 48),
            songTitleLabel.leadingAnchor.constraint(equalTo: userTitleLabel.leadingAnchor),
            songTitleLabel.heightAnchor.constraint(equalToConstant: 30),
            songTitleLabel.trailingAnchor.constraint(equalTo: userTitleLabel.trailingAnchor)
        ])

        NSLayoutConstraint.activate([
            songImageView.topAnchor.constraint(equalTo: songTitleLabel.bottomAnchor, constant: 12),
            songImageView.leadingAnchor.constraint(equalTo: nameLabel.leadingAnchor),
            songImageView.heightAnchor.constraint(equalToConstant: 130),
            songImageView.widthAnchor.constraint(equalToConstant: 130)
        ])

        NSLayoutConstraint.activate([
            songNameLabel.topAnchor.constraint(equalTo: songImageView.topAnchor),
            songNameLabel.heightAnchor.constraint(equalToConstant: 24),
            songNameLabel.leadingAnchor.constraint(equalTo: songImageView.trailingAnchor, constant: 24),
            songNameLabel.trailingAnchor.constraint(equalTo: photoImageView.trailingAnchor)
        ])

        NSLayoutConstraint.activate([
            songArtistLabel.topAnchor.constraint(equalTo: songNameLabel.bottomAnchor, constant: 6),
            songArtistLabel.heightAnchor.constraint(equalTo: songNameLabel.heightAnchor),
            songArtistLabel.leadingAnchor.constraint(equalTo: songNameLabel.leadingAnchor),
            songArtistLabel.trailingAnchor.constraint(equalTo: songNameLabel.trailingAnchor)
        ])


        NSLayoutConstraint.activate([
            emailLabel.topAnchor.constraint(equalTo: usernameLabel.bottomAnchor, constant: 6),
            emailLabel.heightAnchor.constraint(equalTo: nameLabel.heightAnchor),
            emailLabel.leadingAnchor.constraint(equalTo: nameLabel.leadingAnchor),
            emailLabel.trailingAnchor.constraint(equalTo: nameLabel.trailingAnchor)
        ])

        NSLayoutConstraint.activate([
            lastUpdatedLabel.topAnchor.constraint(equalTo: songImageView.bottomAnchor, constant: 48),
            lastUpdatedLabel.heightAnchor.constraint(equalToConstant: 30),
            lastUpdatedLabel.leadingAnchor.constraint(equalTo: nameLabel.leadingAnchor),
            lastUpdatedLabel.trailingAnchor.constraint(equalTo: photoImageView.trailingAnchor)
        ])
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        fillUserLabelValues()
        fillSongLabelValues()
        fillAppColor()
    }
    
    @objc func pushProfileViewController() {
        let settingViewController = SettingsViewController()
        navigationController?.pushViewController(settingViewController, animated: true)
    }
    
    func fillUserLabelValues() {
        
        if let name = userDefaults.string(forKey: Constants.UserDefaults.name),
            let username = userDefaults.string(forKey: Constants.UserDefaults.username),
            let email = userDefaults.string(forKey: Constants.UserDefaults.email),
            let lastUpdated = userDefaults.value(forKey: Constants.UserDefaults.lastUpdated) as? Date {
            nameLabel.text = name
            usernameLabel.text = username
            emailLabel.text = email
            lastUpdatedLabel.text = "Last Updated \(lastUpdated)"
        }
    }
    
    func fillSongLabelValues() {
        
        let decoder = JSONDecoder()
        
        if let favoriteSong = userDefaults.data(forKey: Constants.UserDefaults.favoriteSong) {
            if let song = try? decoder.decode(Song.self, from: favoriteSong) {
                songNameLabel.text = song.name
                songArtistLabel.text = song.artist
            }
        }
    }
    
    func fillAppColor() {
        let colorIndex = userDefaults.integer(forKey: Constants.UserDefaults.color)
        photoImageView.backgroundColor = colorItems[colorIndex]
        songImageView.backgroundColor = colorItems[colorIndex]
    }
  

}
