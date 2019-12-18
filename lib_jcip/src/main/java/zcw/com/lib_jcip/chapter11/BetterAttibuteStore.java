package zcw.com.lib_jcip.chapter11;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by 朱城委 on 2019/11/28.<br><br>
 */
public class BetterAttibuteStore {
    private final Map<String, String> attibutes = new HashMap<>();

    public boolean userLocationMatches(String name, String regexp) {
        String key = "user." + name + ".location";
        String location;
        synchronized (this) {
            location = attibutes.get(key);
        }

        if(location == null) {
            return false;
        }
        else {
            return Pattern.matches(regexp, location);
        }
    }
}
