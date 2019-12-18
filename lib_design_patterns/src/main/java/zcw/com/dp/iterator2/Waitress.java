package zcw.com.dp.iterator2;

import java.util.Iterator;

/**
 * Created by 朱城委 on 2019/8/14.<br><br>
 */
public class Waitress {
    MenuComponent allMenu;

    public Waitress(MenuComponent allMenu) {
        this.allMenu = allMenu;
    }

    public void printMenu() {
        allMenu.print();
    }

    public void printVegetarianMenu() {
        Iterator<MenuComponent> iterator = allMenu.createIterator();
        System.out.println("\nVEGETARIAN MENU\n-----");
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            try {
                if(menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            }
            catch (UnsupportedOperationException e) {

            }
        }
    }
}
