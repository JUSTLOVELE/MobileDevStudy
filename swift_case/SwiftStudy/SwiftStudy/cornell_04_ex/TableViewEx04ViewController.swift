//
//  TableViewEx04ViewController.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/4/27.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class TableViewEx04ViewController: ViewController {

    var tableView: UITableView!
    
    var reuseId = "reuseId"
    
    let cellHeight: CGFloat = 70
    
    var songs: [SongEntity]!
    
    override func viewDidLoad() {
        
        super.viewDidLoad()
        title = "swift5 tableview case"
        view.backgroundColor = .white
        let jay01 = SongEntity(songName: "可爱女人", artistName: "周杰伦", album: "七里香")
        let jay02 = SongEntity(songName: "爱在西元前", artistName: "周杰伦", album: "七里香")
        let jay03 = SongEntity(songName: "忍者", artistName: "周杰伦", album: "七里香")
        let jay04 = SongEntity(songName: "双节棍", artistName: "周杰伦", album: "七里香")
        songs = [jay01, jay02, jay03, jay04]
        tableView = UITableView()
        tableView.translatesAutoresizingMaskIntoConstraints = false
        tableView.register(SongTableViewCell.self, forCellReuseIdentifier: reuseId)
        tableView.dataSource = self
        tableView.delegate = self
        
        view.addSubview(tableView)
        setupConstraint()
    }
    
    func setupConstraint() {
        
        NSLayoutConstraint.activate([
            tableView.leadingAnchor.constraint(equalTo: view.leadingAnchor),
            tableView.trailingAnchor.constraint(equalTo: view.trailingAnchor),
            tableView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor),
            tableView.bottomAnchor.constraint(equalTo: view.safeAreaLayoutGuide.bottomAnchor)
        ])
    }
}

extension TableViewEx04ViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return songs.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: reuseId, for: indexPath) as!SongTableViewCell
        let song = songs[indexPath.row]
        //cell.selectionStyle = .none
        cell.configure(for: song)
        return cell
    }
}

extension TableViewEx04ViewController: UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
       // let song = songs[indexPath.row]
        
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return cellHeight
    }
}
