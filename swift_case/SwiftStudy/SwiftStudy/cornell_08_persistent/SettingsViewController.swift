//
//  SettingsViewController.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/6/2.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class SettingsViewController: UIViewController {

    let profileLabel = UILabel()
    let nameLabel = UILabel()
    let userNameLabel = UILabel()
    let emailLabel = UILabel()
    let songTitleLabel = UILabel()
    let songArtistLabel = UILabel()
    let nameTextField = UITextField()
    let userNameTextField = UITextField()
    let emailTextField = UITextField()
    let songTitleTextField = UITextField()
    let songArtistTextField = UITextField()
    let songLabel = UILabel()
    let saveProfileButton = UIButton()
    let saveSongButton = UIButton()
    let saveSettingsButton = UIButton()
    let settingsLabel = UILabel()
    let settingsColorLabel = UILabel()
    var colorsCollectionView: UICollectionView!

    let colorReuseIdentifier = "colorReuseIdentifier"
    var colorItems: [UIColor] = [.silver, .space, .mauve, .redPurple, .salsa]
    var selectedColor: UIColor = .silver
    let userDefaults = UserDefaults.standard
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .white
        self.title = "Settings"
        
        profileLabel.text = "UserProfile"
        profileLabel.translatesAutoresizingMaskIntoConstraints = false
        profileLabel.font = .boldSystemFont(ofSize: 18)
        profileLabel.textAlignment = .left
        view.addSubview(profileLabel)
        
        nameLabel.text = "Name"
        nameLabel.textColor = .black
        nameLabel.translatesAutoresizingMaskIntoConstraints = false
        nameLabel.sizeToFit()
        view.addSubview(nameLabel)
        
        userNameLabel.text = "Username"
        userNameLabel.textColor = .black
        userNameLabel.translatesAutoresizingMaskIntoConstraints = false
        userNameLabel.sizeToFit()
        view.addSubview(userNameLabel)
        
        emailLabel.text = "Email"
        emailLabel.textColor = .black
        emailLabel.translatesAutoresizingMaskIntoConstraints = false
        emailLabel.sizeToFit()
        view.addSubview(emailLabel)
        
        nameTextField.layer.cornerRadius = 4
        nameTextField.layer.borderWidth = 1
        nameTextField.layer.borderColor = UIColor.black.cgColor
        nameTextField.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(nameTextField)
        
        userNameTextField.layer.cornerRadius = 4
        userNameTextField.layer.borderWidth = 1
        userNameTextField.layer.borderColor = UIColor.black.cgColor
        userNameTextField.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(userNameTextField)
        
        emailTextField.layer.cornerRadius = 4
        emailTextField.layer.borderWidth = 1
        emailTextField.layer.borderColor = UIColor.black.cgColor
        emailTextField.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(emailTextField)
        
        songLabel.text = "Favorite Song"
        songLabel.translatesAutoresizingMaskIntoConstraints = false
        songLabel.font = .boldSystemFont(ofSize: 18)
        songLabel.textAlignment = .left
        view.addSubview(songLabel)
        
        songTitleLabel.text = "Song Title"
        songTitleLabel.textColor = .black
        songTitleLabel.translatesAutoresizingMaskIntoConstraints = false
        songTitleLabel.sizeToFit()
        view.addSubview(songTitleLabel)
        
        songTitleTextField.layer.cornerRadius = 4
        songTitleTextField.layer.borderWidth = 1
        songTitleTextField.layer.borderColor = UIColor.black.cgColor
        songTitleTextField.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(songTitleTextField)

        songArtistLabel.text = "Song Artist"
        songArtistLabel.textColor = .black
        songArtistLabel.translatesAutoresizingMaskIntoConstraints = false
        songArtistLabel.sizeToFit()
        view.addSubview(songArtistLabel)

        songArtistTextField.layer.cornerRadius = 4
        songArtistTextField.layer.borderWidth = 1
        songArtistTextField.layer.borderColor = UIColor.black.cgColor
        songArtistTextField.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(songArtistTextField)

        saveProfileButton.setTitle("Save", for: .normal)
        saveProfileButton.setTitleColor(.white, for: .normal)
        saveProfileButton.titleLabel?.font = .boldSystemFont(ofSize: 18)
        saveProfileButton.backgroundColor = selectedColor
        saveProfileButton.layer.cornerRadius = 10
        saveProfileButton.addTarget(self, action: #selector(saveProfile), for: .touchUpInside)
        saveProfileButton.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(saveProfileButton)

        saveSettingsButton.setTitle("Save", for: .normal)
        saveSettingsButton.setTitleColor(.white, for: .normal)
        saveSettingsButton.titleLabel?.font = .systemFont(ofSize: 18)
        saveSettingsButton.backgroundColor = selectedColor
        saveSettingsButton.layer.cornerRadius = 10
        saveSettingsButton.addTarget(self, action: #selector(saveSettings), for: .touchUpInside)
        saveSettingsButton.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(saveSettingsButton)

        saveSongButton.setTitle("Save", for: .normal)
        saveSongButton.setTitleColor(.white, for: .normal)
        saveSongButton.titleLabel?.font = .systemFont(ofSize: 18)
        saveSongButton.backgroundColor = selectedColor
        saveSongButton.layer.cornerRadius = 10
        saveSongButton.addTarget(self, action: #selector(saveSong), for: .touchUpInside)
        saveSongButton.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(saveSongButton)

        settingsLabel.text = "App Settings"
        settingsLabel.translatesAutoresizingMaskIntoConstraints = false
        settingsLabel.font = .systemFont(ofSize: 18)
        settingsLabel.textAlignment = .left
        view.addSubview(settingsLabel)

        settingsColorLabel.text = "Color Theme"
        settingsColorLabel.textColor = .black
        settingsColorLabel.translatesAutoresizingMaskIntoConstraints = false
        settingsColorLabel.sizeToFit()
        view.addSubview(settingsColorLabel)

        let colorsLayout = UICollectionViewFlowLayout()
        colorsLayout.minimumLineSpacing = 10
        colorsLayout.minimumInteritemSpacing = 10

        colorsCollectionView = UICollectionView(frame: .zero, collectionViewLayout: colorsLayout)
        colorsCollectionView.translatesAutoresizingMaskIntoConstraints = false
        colorsCollectionView.register(UICollectionViewCell.self, forCellWithReuseIdentifier: colorReuseIdentifier)
        colorsCollectionView.backgroundColor = .white
        colorsCollectionView.dataSource = self
        colorsCollectionView.delegate = self
        view.addSubview(colorsCollectionView)

        setUpConstraints()
    }
    
    func setUpConstraints() {
    
        NSLayoutConstraint.activate([
            profileLabel.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 24),
            profileLabel.heightAnchor.constraint(equalToConstant: 30),
            profileLabel.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 24),
            profileLabel.trailingAnchor.constraint(equalTo: view.centerXAnchor)
        ])

        NSLayoutConstraint.activate([
            saveProfileButton.topAnchor.constraint(equalTo: profileLabel.topAnchor),
            saveProfileButton.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -24),
            saveProfileButton.heightAnchor.constraint(equalTo: profileLabel.heightAnchor),
            saveProfileButton.widthAnchor.constraint(equalToConstant: 75)
        ])

        NSLayoutConstraint.activate([
            nameLabel.topAnchor.constraint(equalTo: profileLabel.bottomAnchor, constant: 24),
            nameLabel.heightAnchor.constraint(equalToConstant: 30),
            nameLabel.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 24)
        ])

        NSLayoutConstraint.activate([
            userNameLabel.topAnchor.constraint(equalTo: nameLabel.bottomAnchor, constant: 12),
            userNameLabel.heightAnchor.constraint(equalTo: nameLabel.heightAnchor),
            userNameLabel.leadingAnchor.constraint(equalTo: nameLabel.leadingAnchor)
        ])

        NSLayoutConstraint.activate([
            emailLabel.topAnchor.constraint(equalTo: userNameLabel.bottomAnchor, constant: 12),
            emailLabel.heightAnchor.constraint(equalTo: nameLabel.heightAnchor),
            emailLabel.leadingAnchor.constraint(equalTo: nameLabel.leadingAnchor)
        ])

        NSLayoutConstraint.activate([
            nameTextField.topAnchor.constraint(equalTo: nameLabel.topAnchor),
            nameTextField.heightAnchor.constraint(equalTo: nameLabel.heightAnchor),
            nameTextField.leadingAnchor.constraint(equalTo: view.centerXAnchor, constant: -36),
            nameTextField.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -24)
        ])

        NSLayoutConstraint.activate([
            userNameTextField.topAnchor.constraint(equalTo: userNameLabel.topAnchor),
            userNameTextField.heightAnchor.constraint(equalTo: userNameLabel.heightAnchor),
            userNameTextField.leadingAnchor.constraint(equalTo: nameTextField.leadingAnchor),
            userNameTextField.trailingAnchor.constraint(equalTo: nameTextField.trailingAnchor)
        ])

        NSLayoutConstraint.activate([
            emailTextField.topAnchor.constraint(equalTo: emailLabel.topAnchor),
            emailTextField.heightAnchor.constraint(equalTo: emailLabel.heightAnchor),
            emailTextField.leadingAnchor.constraint(equalTo: nameTextField.leadingAnchor),
            emailTextField.trailingAnchor.constraint(equalTo: nameTextField.trailingAnchor)
        ])

        NSLayoutConstraint.activate([
            songLabel.topAnchor.constraint(equalTo: emailLabel.bottomAnchor, constant: 24),
            songLabel.heightAnchor.constraint(equalTo: profileLabel.heightAnchor),
            songLabel.leadingAnchor.constraint(equalTo: profileLabel.leadingAnchor),
            songLabel.trailingAnchor.constraint(equalTo: profileLabel.trailingAnchor)
        ])

        NSLayoutConstraint.activate([
            saveSongButton.topAnchor.constraint(equalTo: songLabel.topAnchor),
            saveSongButton.trailingAnchor.constraint(equalTo: saveProfileButton.trailingAnchor),
            saveSongButton.heightAnchor.constraint(equalTo: saveProfileButton.heightAnchor),
            saveSongButton.widthAnchor.constraint(equalTo: saveProfileButton.widthAnchor)
        ])

        NSLayoutConstraint.activate([
            songTitleLabel.topAnchor.constraint(equalTo: songLabel.bottomAnchor, constant: 24),
            songTitleLabel.heightAnchor.constraint(equalTo: nameLabel.heightAnchor),
            songTitleLabel.leadingAnchor.constraint(equalTo: nameLabel.leadingAnchor)
        ])

        NSLayoutConstraint.activate([
            songTitleTextField.topAnchor.constraint(equalTo: songTitleLabel.topAnchor),
            songTitleTextField.heightAnchor.constraint(equalTo: nameLabel.heightAnchor),
            songTitleTextField.leadingAnchor.constraint(equalTo: nameTextField.leadingAnchor),
            songTitleTextField.trailingAnchor.constraint(equalTo: nameTextField.trailingAnchor)
        ])

        NSLayoutConstraint.activate([
            songArtistLabel.topAnchor.constraint(equalTo: songTitleLabel.bottomAnchor, constant: 12),
            songArtistLabel.heightAnchor.constraint(equalTo: nameLabel.heightAnchor),
            songArtistLabel.leadingAnchor.constraint(equalTo: nameLabel.leadingAnchor)
        ])

        NSLayoutConstraint.activate([
            songArtistTextField.topAnchor.constraint(equalTo: songArtistLabel.topAnchor),
            songArtistTextField.heightAnchor.constraint(equalTo: nameLabel.heightAnchor),
            songArtistTextField.leadingAnchor.constraint(equalTo: nameTextField.leadingAnchor),
            songArtistTextField.trailingAnchor.constraint(equalTo: nameTextField.trailingAnchor)
        ])

        NSLayoutConstraint.activate([
            settingsLabel.topAnchor.constraint(equalTo: songArtistLabel.bottomAnchor, constant: 24),
            settingsLabel.heightAnchor.constraint(equalTo: profileLabel.heightAnchor),
            settingsLabel.leadingAnchor.constraint(equalTo: profileLabel.leadingAnchor),
            settingsLabel.trailingAnchor.constraint(equalTo: profileLabel.trailingAnchor)
        ])

        NSLayoutConstraint.activate([
            saveSettingsButton.topAnchor.constraint(equalTo: settingsLabel.topAnchor),
            saveSettingsButton.trailingAnchor.constraint(equalTo: saveProfileButton.trailingAnchor),
            saveSettingsButton.heightAnchor.constraint(equalTo: saveProfileButton.heightAnchor),
            saveSettingsButton.widthAnchor.constraint(equalTo: saveProfileButton.widthAnchor)
        ])

        NSLayoutConstraint.activate([
            settingsColorLabel.topAnchor.constraint(equalTo: settingsLabel.bottomAnchor, constant: 24),
            settingsColorLabel.heightAnchor.constraint(equalTo: nameLabel.heightAnchor),
            settingsColorLabel.leadingAnchor.constraint(equalTo: nameLabel.leadingAnchor)
        ])

        NSLayoutConstraint.activate([
            colorsCollectionView.topAnchor.constraint(equalTo: settingsColorLabel.bottomAnchor, constant: 24),
            colorsCollectionView.bottomAnchor.constraint(equalTo: view.safeAreaLayoutGuide.bottomAnchor, constant: -48),
            colorsCollectionView.leadingAnchor.constraint(equalTo: nameLabel.leadingAnchor),
            colorsCollectionView.trailingAnchor.constraint(equalTo: nameTextField.trailingAnchor)
        ])
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        setProfileLabelText()
        setSongLabelText()
        setColor()
        
    }
    
    func setColor() {
        
        let colorIndex = userDefaults.integer(forKey: Constants.UserDefaults.color)
        saveProfileButton.backgroundColor = colorItems[colorIndex]
        saveSongButton.backgroundColor = colorItems[colorIndex]
        saveSettingsButton.backgroundColor = colorItems[colorIndex]
    }
    
    func setSongLabelText() {
        
        let decoder = JSONDecoder()
        if let favoriteSong = userDefaults.data(forKey: Constants.UserDefaults.favoriteSong) {
            if let song = try? decoder.decode(Song.self, from: favoriteSong){
                songTitleTextField.text = song.name
                songTitleTextField.text = song.artist
            }
        }
    }
    
    func updateColors() {
        saveProfileButton.backgroundColor = selectedColor
        saveSongButton.backgroundColor = selectedColor
        saveSettingsButton.backgroundColor = selectedColor
    }
    
    @objc func saveProfile() {
        
        if let nameText = nameTextField.text,
            let usernameText = userNameTextField.text,
            let emailText = emailTextField.text {
            userDefaults.set(nameText, forKey: Constants.UserDefaults.name)
            userDefaults.set(usernameText, forKey: Constants.UserDefaults.username)
            userDefaults.set(emailText, forKey: Constants.UserDefaults.email)
            userDefaults.set(Date(), forKey: Constants.UserDefaults.lastUpdated)
        }
    }
    
    @objc func saveSettings() {
        let index = colorItems.firstIndex(of: selectedColor)
        userDefaults.set(index, forKey: Constants.UserDefaults.color)
    }

    // TODO: Save song values to UserDefault
    @objc func saveSong() {
        if let songTitle = songTitleTextField.text,
            let songArtist = songArtistTextField.text {
            let favoriteSong = Song(name: songTitle, artist: songArtist)
            let encoder = JSONEncoder()
            if let encodedObject = try? encoder.encode(favoriteSong) {
                userDefaults.set(encodedObject, forKey: Constants.UserDefaults.favoriteSong)
            }
        }
    }

    // TODO: Update profile label text
    func setProfileLabelText() {
        if let name = userDefaults.string(forKey: Constants.UserDefaults.name),
            let username = userDefaults.string(forKey: Constants.UserDefaults.username),
            let email = userDefaults.string(forKey: Constants.UserDefaults.email) {
            nameTextField.text = name
            userNameTextField.text = username
            emailTextField.text = email
        }
    }
    
}

extension SettingsViewController: UICollectionViewDelegate, UICollectionViewDataSource, UICollectionViewDelegateFlowLayout{
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return colorItems.count
    }

    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: 60, height: 60)
    }

    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: colorReuseIdentifier, for: indexPath as IndexPath)
        let color = colorItems[indexPath.item]
        cell.layer.cornerRadius = 30
        cell.backgroundColor = color
        if (color == selectedColor) {
            cell.layer.borderColor = UIColor.black.cgColor
            cell.layer.borderWidth = 3
        } else {
            cell.layer.borderWidth = 0
        }
        return cell
    }

    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        selectedColor = colorItems[indexPath.item]
        colorsCollectionView.reloadData()
        updateColors()
    }
}
