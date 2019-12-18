package zcw.com.dp.iterator;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by 朱城委 on 2019/1/18.<br><br>
 */
public class ComponentIterator implements Iterator<MenuComponent> {
    Stack<Iterator<MenuComponent>> stack = new Stack<>();

    public ComponentIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if(stack.empty()) {
            return false;
        }
        else {
            Iterator<MenuComponent> iterator = stack.peek();
            if(!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            }
            else {
                return true;
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
        return null;
    }
}
