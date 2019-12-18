package zcw.com.lib_rx_java;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import zcw.com.lib_rx_java.bean.AA;

/**
 * Created by 朱城委 on 2019/12/18.<br><br>
 */
public class FlatMapDemo {
    public static void main(String[] arg) {
        String[] array = {"111", "222", "333", "444"};
        Observable.just(array)
                .flatMap(new Function<String[], ObservableSource<AA>>() {
                    @Override
                    public ObservableSource<AA> apply(final String[] strings) throws Exception {
                        return new ObservableSource<AA>() {
                            @Override
                            public void subscribe(Observer<? super AA> observer) {
                                for(int i = 0; i < strings.length; i++) {
                                    AA aa = new AA();
                                    aa.aa = strings[i];
                                    observer.onNext(aa);
                                }
                                observer.onComplete();
                            }
                        };
                    }
                })
                .subscribe(new Consumer<AA>() {
                    @Override
                    public void accept(AA aa) throws Exception {
                        System.out.println(aa.aa);
                    }
                });
    }
}
