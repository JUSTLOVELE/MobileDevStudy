//
//  ViewController.swift
//  AccountBook
//
//  Created by 杨祖亮 on 2020/4/13.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import UIKit

class ViewController:UIViewController,UITableViewDataSource,UITableViewDelegate {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let tableView = UITableView(frame: view.bounds, style: .grouped)
        tableView.backgroundColor = UIColor.white;
        view.addSubview(tableView)
        tableView.dataSource = self
        tableView.delegate = self
    }

//MARK: UITableViewDataSource
    // cell的个数
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 10
    }
    // UITableViewCell
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cellid = "testCellID"
        var cell = tableView.dequeueReusableCell(withIdentifier: cellid)
        if cell==nil {
            cell = UITableViewCell(style: .subtitle, reuseIdentifier: cellid)
        }
        
        cell?.textLabel?.text = "这个是标题~"
        cell?.textLabel?.textColor = .red
        cell?.detailTextLabel?.text = "这里是内容了油~"
        cell?.imageView?.image = UIImage(named:"Expense_success")
        return cell!
    }
  
//MARK: UITableViewDelegate
    // 设置cell高度
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 44.0
    }
    // 选中cell后执行此方法
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        print(indexPath.row)
        let cell: UITableViewCell = tableView.cellForRow(at: indexPath)!
        print(cell.textLabel?.text)
    }
    
}


