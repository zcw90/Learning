package zcw.com.lib_rx_java;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by 朱城委 on 2019/3/6.<br><br>
 */
public class Test {
    private static final String TAG = Test.class.getSimpleName();

    public static void main(String[] args) {
//        init();
        init2();
//        init3();
//        init4();
//        init5();
//        init6();
//        init7();
//        init8();
//        testStudent();
//        testStudent2();
//        errorTest();
    }

    private static void init() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    for (int i = 0; i < 5; i++) {
                        emitter.onNext(i);

                        if(i == 0) {
                            int a = 10 / 0;
                        }
                    }

                    emitter.onComplete();
                }
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    private static void init2() {
        // 观察者对象
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        // 被观察者对象
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("Hello");
                emitter.onNext("Hi");
                emitter.onNext("Aloha");
                emitter.onComplete();
            }
        });

        // 观察者订阅被观察者
        observable.subscribe(observer);
    }

    private static void init3() {
        Observable<String> observable = Observable.just("Hello", "Hi", "Aloha");

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("init3 - onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("init3 - onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("init3 - onError");
            }

            @Override
            public void onComplete() {
                System.out.println("init3 - onComplete");
            }
        };

        observable.subscribe(observer);
    }

    private static void init4() {
        String[] from = {"Hello", "Hi", "Aloha"};
        Observable<String> observable = Observable.fromArray(from);

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("init4 - onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("init4 - onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("init4 - onError");
            }

            @Override
            public void onComplete() {
                System.out.println("init4 - onComplete");
            }
        };

        observable.subscribe(observer);
    }

    private static void init5() {
        Consumer<String> consumerNext = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("consumerNext(): " + s);
            }
        };

        Consumer<Throwable> consumerError = new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.println("consumerError: " + throwable.getMessage());
            }
        };

        Action actionComplete = new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("consumerComplete.");
            }
        };

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("Hello");
                emitter.onNext("Hi");
                emitter.onNext("Aloha");
                emitter.onComplete();
            }
        });

        observable.subscribe(consumerNext);
        System.out.println("--------------------");

        observable.subscribe(consumerNext, consumerError);
        System.out.println("--------------------");

        observable.subscribe(consumerNext, consumerError, actionComplete);
        System.out.println("--------------------");
    }

    private static void init6() {
        String[] array = {
                "The first sentence.",
                "The second sentence.",
                "The third sentence.",
                "The fourth sentence.",
        };

        Disposable subscribe = Observable.fromArray(array).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
    }

    private static void init7() {
        Disposable subscribe = Observable.just(1, 2, 3, 4, 5)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("Result: " + integer);
                    }
                });
    }

    private static void init8() {
        Disposable subscribe = Observable.just("AAAAAAAAAA")
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Exception {
                        return s.length();
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("字符串长度：" + integer);
                    }
                });
    }

    private static void testStudent() {
        Student[] students = new Student[10];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student("Student " + (i + 1), i * 10);
        }

        Observer<String> observer = new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String name) {
                System.out.println("Student name: " + name);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        Observable.fromArray(students)
                .map(new Function<Student, String>() {
                    @Override
                    public String apply(Student student) throws Exception {
                        return student.getName();
                    }
                })
                .subscribe(observer);
    }

    private static void testStudent2() {
        Student[] students = new Student[10];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student("Student " + (i + 1), i * 10);
        }

        Observer<Course> observer = new Observer<Course>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Course name) {
                System.out.println("Curse name: " + name);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        Observable.fromArray(students)
                .flatMap(new Function<Student, ObservableSource<Course>>() {
                    @Override
                    public ObservableSource<Course> apply(Student student) throws Exception {
                        System.out.println("--------------------");
                        return Observable.fromIterable(student.getCourses());
                    }
                })
                .subscribe(observer);
    }

    private static void errorTest() {
        final String[] array = new String[]{
                "AAAAA",
                "BBBBB",
                "CCCCC",
                "DDDDD"
        };
//        Observable.fromArray(array)
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                for(int i = 0; i < array.length; i++) {
                    if(i == 2) {
//                        emitter.onError(new Throwable(array[i] + ".zcwThrowable"));
//                        emitter.onError(new RuntimeException(array[i] + " exception"));
//                        throw new Exception(array + ".zcwException");
                    }

                    emitter.onNext(array[i]);
                }

                emitter.onComplete();
            }
        })
//                .map(new Function<String, String>() {
//                    @Override
//                    public String apply(String s) throws Exception {
//                        if(s.equals("CCCCC")) {
//                            throw new RuntimeException("CCCCC exception");
//                        }
//                        return s + ".zcw";
//                    }
//                })
//                .onErrorReturn(new Function<Throwable, String>() {
//                    @Override
//                    public String apply(Throwable throwable) throws Exception {
//                        return throwable.getMessage() + ".zcwException";
//                    }
//                })
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        if(s.equals("CCCCC")) {
                            throw new Exception("CCCCC.apply.exception");
                        }
                        return s;
                    }
                })
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(String s) throws Exception {
//                        if(s.equals("BBBBB")) {
//                            return Observable.error(new Exception("BBBBB.apply.exception"));
//                        }
                        return Observable.just(s);
                    }
                })
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends String>>() {
                    @Override
                    public ObservableSource<? extends String> apply(Throwable throwable) throws Exception {
                        return Observable.fromArray("11111", "22222", "33333");
                    }
                })
//                .onExceptionResumeNext(Observable.fromArray("11111", "22222", "33333"))
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext:" + s);
                    }

                    @Override
                    public void onError(Throwable e) {
//                        System.out.println("onError: " + e.getMessage());
                        System.out.println("onError: ");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

    }
}
