package com.builder.b;

public class Client {

	public static void main(String[] args) {
		//盖普通房子
		CommonHouse commonHouse = new CommonHouse();
		//准备创建房子的指挥者
		HouseDirector houseDirector = new HouseDirector(commonHouse);
		House house = houseDirector.constructHouse();
		System.out.println("------------------------");
		HighBuilding highBuilding = new HighBuilding();
		houseDirector.setHouseBuilder(highBuilding);
		house = houseDirector.constructHouse();
		System.out.println("------------------------");
	}
}
