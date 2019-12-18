//package zcw.com.dp.iterator;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
///**
// * Created by 朱城委 on 2019/1/16.<br><br>
// */
//public class PancakeHouseMenu implements Menu<MenuItem> {
//    private ArrayList<MenuItem> menuItems;
//
//    public PancakeHouseMenu() {
//        menuItems = new ArrayList<>();
//
//        addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
//        addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
//        addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);
//        addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
//    }
//
//    public void addItem(String name, String description, boolean vegetarian, double price) {
//        MenuItem item = new MenuItem(name, description, vegetarian, price);
//        menuItems.add(item);
//    }
//
//    @Override
//    public Iterator<MenuItem> createIterator() {
//        return menuItems.iterator();
//    }
//}
