//
//  SongTableViewCell.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/4/27.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class SongTableViewCell: UITableViewCell {
    
    var songNameLabel: UILabel!
    
    var artistNameLabel: UILabel!
    
    var albumLabel: UILabel!
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        songNameLabel = UILabel()
        songNameLabel.font = UIFont.boldSystemFont(ofSize: 16)
        songNameLabel.translatesAutoresizingMaskIntoConstraints = false
        contentView.addSubview(songNameLabel)
        
        artistNameLabel = UILabel()
        artistNameLabel.font = UIFont.systemFont(ofSize: 16)
        artistNameLabel.translatesAutoresizingMaskIntoConstraints = false
        contentView.addSubview(artistNameLabel)
        
        albumLabel = UILabel()
        albumLabel.font = UIFont.systemFont(ofSize: 16)
        albumLabel.translatesAutoresizingMaskIntoConstraints = false
        contentView.addSubview(albumLabel)
        setupConstraints()
    }
    
    func setupConstraints() {
        
        let padding: CGFloat = 8
        let labelHeight: CGFloat = 16
        
        NSLayoutConstraint.activate([
            albumLabel.topAnchor.constraint(equalTo: contentView.topAnchor, constant: padding),
            albumLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: padding),
            albumLabel.heightAnchor.constraint(equalToConstant: labelHeight)
        ])
        
        NSLayoutConstraint.activate([
            artistNameLabel.topAnchor.constraint(equalTo: albumLabel.bottomAnchor, constant: padding),
            artistNameLabel.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: padding),
            artistNameLabel.heightAnchor.constraint(equalToConstant: labelHeight)
        ])
        
        NSLayoutConstraint.activate([
            songNameLabel.topAnchor.constraint(equalTo: albumLabel.bottomAnchor, constant: padding),
            songNameLabel.leadingAnchor.constraint(equalTo: artistNameLabel.trailingAnchor, constant: padding),
            songNameLabel.heightAnchor.constraint(equalToConstant: labelHeight)
        ])
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func configure(for song: SongEntity) {
        songNameLabel.text = song.songName
        artistNameLabel.text = song.artistName
        albumLabel.text = song.album
    }

}
