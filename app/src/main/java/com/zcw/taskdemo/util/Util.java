package com.zcw.taskdemo.util;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by 朱城委 on 2019/8/16.<br><br>
 */
public class Util {

    public static String getEvent(int action) {
        String result = "Unknown";

        switch (action) {
            case 0:
                result = "ACTION_DOWN";
                break;

            case 1:
                result = "ACTION_UP";
                break;

            case 2:
                result = "ACTION_MOVE";
                break;
        }

        return result;
    }

    public static int viewLevel(View view) {
        if(view == null) {
            return -1;
        }

        int level = 0;
        Queue<View> queue = new LinkedList<>();
        queue.offer(view);

        int i;
        List<ViewGroup> viewGroupList = new ArrayList<>();
        View viewTemp;
        while (queue.size() != 0) {
            level++;

            viewGroupList.clear();
            viewTemp = queue.poll();
            while (viewTemp != null) {
                if(viewTemp instanceof ViewGroup) {
                    viewGroupList.add((ViewGroup) viewTemp);
                }

                viewTemp = queue.poll();
            }

            for(ViewGroup viewGroup : viewGroupList) {
                for(i = 0; i < viewGroup.getChildCount(); i++) {
                    queue.offer(viewGroup.getChildAt(i));
                }
            }
        }

        return level;
    }
}
