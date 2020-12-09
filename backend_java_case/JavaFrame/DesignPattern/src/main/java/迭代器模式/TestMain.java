package 迭代器模式;

import java.util.ArrayList;

public class TestMain {
	
	public static void main(String[] args) {
		PancakeHouseMenu pan = new PancakeHouseMenu();
		ArrayList alist = pan.getMenuItems();
		
		DinerMenu din = new DinerMenu();
		MenuItem[] lunch = din.getMenuItems();
		
		for(int i=0; i< alist.size(); i++){
			MenuItem menuItem = (MenuItem) alist.get(i);
			System.out.println(menuItem.getDescription());
			System.out.println(menuItem.getName());
			System.out.println(menuItem.getPrice());
			System.out.println(menuItem.isVegetarian());
		}
		System.out.println("*************");
		for(int i=0; i< 4; i++){
			MenuItem menuItem = (MenuItem) alist.get(i);
			System.out.println(menuItem.getDescription());
			System.out.println(menuItem.getName());
			System.out.println(menuItem.getPrice());
			System.out.println(menuItem.isVegetarian());
		}
		
	}

}
