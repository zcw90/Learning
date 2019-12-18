//package zcw.com.dp.iterator;
//
//import java.util.Hashtable;
//import java.util.Iterator;
//
///**
// * Created by 朱城委 on 2019/1/17.<br><br>
// */
//public class CafeMenu implements Menu<MenuItem> {
//    private Hashtable<String, MenuItem> menuItems = new Hashtable<>();
//
//    public CafeMenu() {
//        addItem("Veggies Burger and Air Fries", "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 3.99);
//        addItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.69);
//        addItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29);
//    }
//
//    public void addItem(String name, String description, boolean vegetarian, double price) {
//        MenuItem item = new MenuItem(name, description, vegetarian, price);
//        menuItems.put(item.getName(), item);
//    }
//
//    @Override
//    public Iterator<MenuItem> createIterator() {
//        return menuItems.values().iterator();
//    }
//}
