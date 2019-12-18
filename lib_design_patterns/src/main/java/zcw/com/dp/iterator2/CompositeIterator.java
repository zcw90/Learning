package zcw.com.dp.iterator2;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by 朱城委 on 2019/8/16.<br><br>
 */
public class CompositeIterator implements Iterator<MenuComponent> {
    Stack<Iterator<MenuComponent>> stack = new Stack<>();

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if(stack.empty()) {
            return false;
        }
        else {
            Iterator<MenuComponent> iterator = stack.peek();
            if(iterator.hasNext()) {
                return true;
            }
            else {
                stack.pop();
                return hasNext();
            }
        }
    }

    @Override
    public MenuComponent next() {
        if(hasNext()) {
            Iterator<MenuComponent> iterator = stack.peek();
            MenuComponent menuComponent = iterator.next();
            if(menuComponent instanceof Menu) {
                stack.push(menuComponent.createIterator());
            }

            return menuComponent;
        }
        else {
            return null;
        }
    }
}
