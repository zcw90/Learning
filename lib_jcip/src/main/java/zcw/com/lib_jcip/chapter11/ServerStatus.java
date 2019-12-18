package zcw.com.lib_jcip.chapter11;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 朱城委 on 2019/11/28.<br><br>
 */
public class ServerStatus {
    public final Set<String> users;
    public final Set<String> queries;

    public ServerStatus() {
        users = new HashSet<>();
        queries = new HashSet<>();
    }

    public void addUser(String user) {
        synchronized (users) {
            users.add(user);
        }
    }

    public void removeUser(String user) {
        synchronized (users) {
            users.remove(user);
        }
    }

    public void addQuery(String query) {
        synchronized (queries) {
            queries.add(query);
        }
    }

    public void removeQuery(String query) {
        synchronized (queries) {
            queries.remove(query);
        }
    }
}
