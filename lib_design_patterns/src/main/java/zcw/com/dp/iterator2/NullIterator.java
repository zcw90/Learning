package zcw.com.dp.iterator2;

import java.util.Iterator;

/**
 * Created by 朱城委 on 2019/8/16.<br><br>
 */
public class NullIterator implements Iterator<MenuComponent> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComponent next() {
        return null;
    }
}
