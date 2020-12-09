package 迭代器模式;

public class DinerMenu {
	
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;
	
	public DinerMenu(){
		menuItems = new MenuItem[MAX_ITEMS];
		addItem("KBq1", "1111", true, 2.65);
		addItem("KBq2", "2222", true, 2.65);
		addItem("KBq3", "3333", true, 2.65);
		addItem("KBq4", "4444", true, 2.65);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price){
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if(numberOfItems >= MAX_ITEMS){
			System.out.println("error");
		}
		else{
			menuItems[numberOfItems] = menuItem;
			numberOfItems ++;
		}
	}
	
	public MenuItem[] getMenuItems(){
		return menuItems;
	}


}
