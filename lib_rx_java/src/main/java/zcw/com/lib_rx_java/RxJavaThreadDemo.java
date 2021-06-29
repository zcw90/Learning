package zcw.com.lib_rx_java;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import sun.jvm.hotspot.runtime.Thread;

/**
 * Created by 朱城委 on 2019/12/21.<br><br>
 * RxJava 线程切换Demo
 */
public class RxJavaThreadDemo {
    public static void main(String[] arg) throws InterruptedException {
////        noThread();
//        threadDemo2();
//
//        Thread.sleep(1000 * 60 * 10);
////        Thread.sleep(1000);
    }

    public static void noThread() {
        Disposable disposable = Observable.just(1)
                .observeOn(Schedulers.single())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        System.out.println("Map-1 Thread name: " + Thread.currentThread().getName());
                        return integer + 10;
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        System.out.println("Map-2 Thread name: " + Thread.currentThread().getName());
                        return integer + 10;
                    }
                })
                .subscribeOn(Schedulers.io())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        System.out.println("Map-3 Thread name: " + Thread.currentThread().getName());
                        return integer + 10;
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

    public static void threadDemo() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                showThreadInfo("subscribe");
                emitter.onNext("Data1");
                emitter.onNext("Data2");
                emitter.onNext("Data3");
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .map(new Function<String, String>() {
                    @Override
                    public String apply(@NonNull String s) throws Exception {
                        showThreadInfo("apply");
                        return s + " Map";
                    }
                })
                .subscribeOn(Schedulers.newThread())
//                .observeOn(Schedulers.computation())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        showThreadInfo("onSubscribe");
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        showThreadInfo("onNext");
                        System.out.println("onNext: " + s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        showThreadInfo("onError");
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        showThreadInfo("onComplete");
                        System.out.println("onComplete");
                    }
                });
    }

    private static void threadDemo2() {
        Disposable disposable = Observable.just(1)
//                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.single())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        showThreadInfo(String.valueOf(integer));
                    }
                });
    }

    private static void showThreadInfo(String message) {
        System.out.println("\n--------------------");
        System.out.println("Thread info(" + message + "): " + Thread.currentThread().getName());
        System.out.println("--------------------");
    }

    private static void threadSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
