//
//  LLBlueTooth.swift
//  SwiftStudy
//
//  Created by 杨祖亮 on 2020/6/19.
//  Copyright © 2020 杨祖亮. All rights reserved.
//

import Foundation
import CoreBluetooth
//参考资料:https://blog.csdn.net/FTD1120/article/details/83143385
extension LLBlueTooth: CBCentralManagerDelegate{
    
    func centralManagerDidUpdateState(_ central: CBCentralManager) {
        if #available(iOS 10.0, *) {
            switch central.state {
            case CBManagerState.poweredOn:
                print("蓝牙打开")
            case CBManagerState.unauthorized:
                print("没有蓝牙功能")
            case CBManagerState.poweredOff:
                print("蓝牙关闭")
            default:
                print("未知状态")
            }
        }
        // 手机蓝牙状态发生变化，可以发送通知出去。提示用户
    }
    
    func centralManager(_ central: CBCentralManager, didDiscover peripheral: CBPeripheral, advertisementData: [String : Any], rssi RSSI: NSNumber) {
        guard peripheral.name != nil, peripheral.name!.contains("蓝牙名称") else {
            return
        }
    }
    
    func centralManager(_ central: CBCentralManager, didConnect peripheral: CBPeripheral) {
        peripheral.delegate = self
        //开始发现服务
        peripheral.discoverServices(nil)
        //保存当前连接设备
        self.peripheral = peripheral
        //这里可以发通知出去告诉设备连接界面连接成功
    }
    
    func centralManager(_ central: CBCentralManager, didFailToConnect peripheral: CBPeripheral, error: Error?) {
        //这里可以发送通知出去告诉设备连接界面失败
    }
    
    func centralManager(_ central: CBCentralManager, didDisconnectPeripheral peripheral: CBPeripheral, error: Error?) {
        NotificationCenter.default.post(name:
            Notification.Name(rawValue: "DidDisConnectPeriphernalNotification"),
            object: nil,
            userInfo: ["deviceList": self.deviceList as AnyObject])
        //这里可以发通知出去告诉设备连接界面连接丢失
    }
}

extension LLBlueTooth: CBPeripheralDelegate {
    
    func peripheral(_ peripheral: CBPeripheral, didDiscoverServices error: Error?) {
        
        if error != nil {
            return
        }
        
        for service in peripheral.services! {
            peripheral.discoverCharacteristics(nil, for: service)
        }
    }
    
    func peripheral(_ peripheral: CBPeripheral, didDiscoverCharacteristicsFor service: CBService, error: Error?) {
        
        if (error != nil) {
            return
        }
        
        for characteristic in service.characteristics! {
            
            switch characteristic.uuid.description {
            case "具体特征值":
                // 订阅特征值，订阅成功后后续所有的值变化都会自动通知
                peripheral.setNotifyValue(true, for: characteristic)
            case "******":
                // 读区特征值，只能读到一次
                peripheral.readValue(for: characteristic)
            default:
                print("扫描到其他特征")
            }
        }
    }
    
}

class LLBlueTooth:NSObject {
    

    
    //单例对象
    internal static let instance = LLBlueTooth()
    //中心对象
    var central: CBCentralManager?
    //中心扫描到的设备都可以保存起来
    //扫描到新设备后可以通过通知的方式发送出去,连接设备界面可以接收通知,实时刷新设备列表
    var deviceList: NSMutableArray?
    //当前连接的设备
    var peripheral: CBPeripheral!
    //发送数据特征,连接到设备之后可以把需要用到的特征保存起来,方便使用
    var sendCharacteristic: CBCharacteristic?
    
    override init() {
        super.init()
        self.central = CBCentralManager.init(delegate: self, queue: nil, options: [CBCentralManagerOptionShowPowerAlertKey:false])
        self.deviceList = NSMutableArray()
    }
    
    
}
