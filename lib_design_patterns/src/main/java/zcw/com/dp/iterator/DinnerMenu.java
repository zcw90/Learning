//package zcw.com.dp.iterator;
//
//import java.util.Iterator;
//
///**
// * Created by 朱城委 on 2019/1/16.<br><br>
// */
//public class DinnerMenu implements Menu<MenuItem> {
//    private static final int MAX_ITEMS = 6;
//    private int numberOfItems = 0;
//    private MenuItem[] menuItems;
//
//    public DinnerMenu() {
//        menuItems = new MenuItem[MAX_ITEMS];
//
//        addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
//        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
//        addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29);
//        addItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05);
//    }
//
//    public void addItem(String name, String description, boolean vegetarian, double price) {
//        if(numberOfItems >= MAX_ITEMS) {
//            System.err.println("Sorry, menu is full! Can't add item to menu");
//        }
//        else {
//            MenuItem item = new MenuItem(name, description, vegetarian, price);
//            menuItems[numberOfItems] = item;
//            numberOfItems++;
//        }
//    }
//
//    @Override
//    public Iterator<MenuItem> createIterator() {
//        return new DinnerMenuIterator(menuItems);
//    }
//}
