package zcw.com.lib_jcip.chapter11;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 朱城委 on 2019/11/28.<br><br>
 */
public class ServerStatusBeforeSplit {
    public final Set<String> users;
    public final Set<String> queries;

    public ServerStatusBeforeSplit() {
        users = new HashSet<>();
        queries = new HashSet<>();
    }

    public synchronized void addUser(String user) {
        users.add(user);
    }

    public synchronized void addQuery(String query) {
        queries.add(query);
    }

    public synchronized void removeUser(String user) {
        users.remove(user);
    }

    public synchronized void removeQuery(String query) {
        queries.remove(query);
    }
}
