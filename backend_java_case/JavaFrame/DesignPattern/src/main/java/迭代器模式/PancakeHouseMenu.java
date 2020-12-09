package 迭代器模式;

import java.util.ArrayList;

public class PancakeHouseMenu {
	
	ArrayList menuItems;
	
	public PancakeHouseMenu(){
		menuItems = new ArrayList();
		addItem("KB1", "1111", true, 2.65);
		addItem("KB2", "2222", true, 2.65);
		addItem("KB3", "3333", true, 2.65);
		addItem("KB4", "4444", true, 2.65);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price){
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}
	
	public ArrayList getMenuItems(){
		return menuItems;
	}

}
