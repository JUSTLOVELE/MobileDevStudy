package 组合模式;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu  extends MenuComponent{

	public ArrayList menuComponents = new ArrayList();
	String name;
	String description;
	
	public Menu(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	public void add(MenuComponent menuComponent){
		menuComponent.add(menuComponent);
	}
	
	public void remove(MenuComponent menuComponent){
		menuComponent.remove(menuComponent);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MenuComponent getChild(int i){
		return (MenuComponent) menuComponents.get(i);
	}
	
	public void print(){
		System.out.println(getName());
		System.out.println(getDescription());
		System.out.println("-----------------");
		Iterator iterator = menuComponents.iterator();
		while(iterator.hasNext()){
			MenuComponent menuComponent = (MenuComponent) iterator.next();
			menuComponent.print(); 
		}
	}
}
