//
//  ViewController.swift
//  Collern_02
//
//  Created by 杨祖亮 on 2020/3/25.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    var nameLabel: UILabel!
    
    var imageView: UIImageView!
    
    var textView: UITextView!
    
    var followButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        view.backgroundColor = .white
        
        nameLabel = UILabel()
        nameLabel.text = "Bill Gates"
        nameLabel.textColor = .black
        nameLabel.font = UIFont.systemFont(ofSize: 20, weight: .bold)
        nameLabel.translatesAutoresizingMaskIntoConstraints = false
        imageView = UIImageView()
        imageView.image = UIImage(named: "billgates")
        imageView.contentMode = .scaleAspectFill
        imageView.clipsToBounds = true
        imageView.translatesAutoresizingMaskIntoConstraints = false
        textView = UITextView()
        textView.text = "This article is about the co-founder of Microsoft. For other people of the same name, see Bill Gates (disambiguation).William Henry Gates III (born October 28, 1955) is an American business magnate, software developer, investor, and philanthropist. He is best known as the co-founder of Microsoft Corporation.[2][3] During his career at Microsoft, Gates held the positions of chairman, chief executive officer (CEO), president and chief software architect, while also being the largest individual shareholder until May 2014. He is one of the best-known entrepreneurs and pioneers of the microcomputer revolution of the 1970s and 1980s.Born and raised in Seattle, Washington, Gates co-founded Microsoft with childhood friend Paul Allen in 1975 in Albuquerque, New Mexico; it went on to become the world's largest personal computer software company.[4][a] Gates led the company as chairman and CEO until stepping down as CEO in January 2000, but he remained chairman and became chief software architect.[7] During the late 1990s, Gates had been criticized for his business tactics, which have been considered anti-competitive. This opinion has been upheld by numerous court rulings.[8] In June 2006, Gates announced that he would be transitioning to a part-time role at Microsoft and full-time work at the Bill & Melinda Gates Foundation, the private charitable foundation that he and his wife, Melinda Gates, established in 2000.[9] He gradually transferred his duties to Ray Ozzie and Craig Mundie.[10] He stepped down as chairman of Microsoft in February 2014 and assumed a new post as technology adviser to support the newly appointed CEO Satya Nadella.[11]Since 1987, he has been included in the Forbes list of the world's wealthiest documented individuals.[12][13] From 1995 to 2017, he held the Forbes title of the richest person in the world all but four of those years.[1] In October 2017, he was surpassed by Amazon founder and CEO Jeff Bezos, who had an estimated net worth of US$90.6 billion compared to Gates' net worth of US$89.9 billion at the time.[14] As of November 9, 2019, Gates had an estimated net worth of US$107.1 billion, making him the second wealthiest person in the world, behind Bezos.Later in his career and since leaving day-to-day operations at Microsoft in 2008, Gates pursued a number of philanthropic endeavors. He donated large amounts of money to various charitable organizations and scientific research programs through the Bill & Melinda Gates Foundation, reported to be the world's largest private charity.[15] In 2009, Gates and Warren Buffett founded The Giving Pledge, whereby they and other billionaires pledge to give at least half of their wealth to philanthropy.[16] The foundation works to save lives and improve global health, and is working with Rotary International to eliminate polio.[17]"
        textView.textColor = .black
        textView.textAlignment = .justified
        textView.translatesAutoresizingMaskIntoConstraints = false
        followButton = UIButton()
        followButton.setTitle("Follow", for: .normal)
        followButton.setTitleColor(.blue, for: .normal)
        followButton.translatesAutoresizingMaskIntoConstraints = false
        followButton.layer.borderColor = UIColor.blue.cgColor
        followButton.addTarget(self, action: #selector(followButtonTapped) , for: .touchUpInside)
        followButton.layer.borderWidth = 1
        
        view.addSubview(nameLabel)
        view.addSubview(imageView)
        view.addSubview(followButton)
        view.addSubview(textView)
        
        setupConstraints()
        test()
    }
    
    private func test() {
        
    }
    
    @objc func followButtonTapped() {
        
        if followButton.titleLabel?.text == "Follow" {
            followButton.setTitle("Following", for: .normal)
            followButton.setTitleColor(.white, for: .normal)
            followButton.backgroundColor = .blue
        }else{
            followButton.setTitle("Follow", for: .normal)
            followButton.setTitleColor(.blue, for: .normal)
            followButton.backgroundColor = .white
        }
        
    }
    
    func setupConstraints() {
        
        NSLayoutConstraint.activate([
            nameLabel.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant:  15),
            nameLabel.centerXAnchor.constraint(equalTo: view.centerXAnchor)
        ])
        
        NSLayoutConstraint.activate([
            imageView.topAnchor.constraint(equalTo: nameLabel.bottomAnchor, constant:  15),
            imageView.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            imageView.widthAnchor.constraint(equalToConstant: 200),
            imageView.heightAnchor.constraint(equalToConstant: 100)
        ])
        
        NSLayoutConstraint.activate(
            [followButton.topAnchor.constraint(equalTo: imageView.bottomAnchor, constant: 15),
            followButton.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            followButton.widthAnchor.constraint(equalToConstant: 100)]
        )
        
        NSLayoutConstraint.activate([
            textView.topAnchor.constraint(equalTo: followButton.bottomAnchor, constant:  15),
            textView.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            textView.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 15),
            textView.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -15),
            textView.bottomAnchor.constraint(equalTo: view.safeAreaLayoutGuide.bottomAnchor, constant: -5)
        ])
    }
}
