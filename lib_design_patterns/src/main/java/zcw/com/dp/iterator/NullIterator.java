package zcw.com.dp.iterator;

import java.util.Iterator;

/**
 * Created by 朱城委 on 2019/1/18.<br><br>
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
