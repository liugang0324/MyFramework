package test.liugang.com.myframework.utils;

import org.greenrobot.eventbus.EventBus;

import test.liugang.com.myframework.app.Event;


/**
 * @类的用途：
 * @author: 刘刚
 * @date: 2017/7/10
 */

public class EventBusUtil {

    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    public static void sendEvent(Event event) {
        EventBus.getDefault().post(event);
    }

    public static void sendStickyEvent(Event event) {
        EventBus.getDefault().postSticky(event);
    }

    // 其他
}
