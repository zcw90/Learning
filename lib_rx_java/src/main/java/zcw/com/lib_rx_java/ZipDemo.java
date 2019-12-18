package zcw.com.lib_rx_java;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import zcw.com.lib_rx_java.bean.AA;
import zcw.com.lib_rx_java.bean.BB;
import zcw.com.lib_rx_java.bean.CC;

/**
 * Created by 朱城委 on 2019/12/18.<br><br>
 */
public class ZipDemo {

    public static void main(String[] args) {
        Observable.zip(new ObservableSource<AA>() {
                           @Override
                           public void subscribe(Observer<? super AA> observer) {
                               for(int i = 0; i < 5; i++) {
                                   AA aa = new AA();
                                   aa.aa = "AA" + i;
                                   observer.onNext(aa);
                               }
                               observer.onComplete();
                           }
                       },
                new ObservableSource<BB>() {
                    @Override
                    public void subscribe(Observer<? super BB> observer) {
                        for(int i = 0; i < 10; i++) {
                            BB bb = new BB();
                            bb.bb = "BB" + i;
                            observer.onNext(bb);
                        }
                        observer.onComplete();
                    }
                },
                new BiFunction<AA, BB, CC>() {
                    @Override
                    public CC apply(AA aa, BB bb) throws Exception {
                        CC cc = new CC();
                        cc.cc = aa.aa + "-" + bb.bb;
                        return cc;
                    }
                })
                .subscribe(new Consumer<CC>() {
                    @Override
                    public void accept(CC cc) throws Exception {
                        System.out.println(cc.cc);
                    }
                });
    }
}