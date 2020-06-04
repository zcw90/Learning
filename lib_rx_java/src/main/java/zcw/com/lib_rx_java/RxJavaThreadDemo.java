package zcw.com.lib_rx_java;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 朱城委 on 2019/12/21.<br><br>
 * RxJava 线程切换Demo
 */
public class RxJavaThreadDemo {
    public static void main(String[] arg) {
        noThread();
    }

    public static void noThread() {
        Observable.just(1)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        System.out.println("Map-1 Thread name: " + Thread.currentThread().getName());
                        return null;
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        System.out.println("Map-2 Thread name: " + Thread.currentThread().getName());
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        System.out.println("Map-3 Thread name: " + Thread.currentThread().getName());
                        return null;
                    }
                })
                .subscribeOn(Schedulers.computation())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("subscribe Thread name: " + Thread.currentThread().getName());
                    }
                });

    }
}
