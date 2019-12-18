package zcw.com.dp.iterator;

import java.util.Iterator;

/**
 * Created by 朱城委 on 2019/1/17.<br><br>
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
        while(iterator.hasNext()) {
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
