package win.yulongsun.demo.utils.rxjava;

import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author Sun.YuLong on 2018/6/8.
 */
public class RxjavaHelloWorldTest {


    @Test
    public void testHelloWord() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("World");
                subscriber.onCompleted();
            }
        });
        //
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError," + throwable);
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };
        //
        observable.subscribe(observer);
    }


    @Test
    public void testCreateObservable() {
//        Observable<String> observable = Observable.just("Hello", "SunYuLong");
        /**
         * 创建Observable的方式：
         * 1、create()
         * 2、just()
         * 3、from()
         */
        String[]           str        = {"Hello", "SunYuLong"};
        Observable<String> observable = Observable.from(str);
        //
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError," + throwable);
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };
        //
        observable.subscribe(observer);
    }


    @Test
    public void testUnCompleteObserver() {
//        Observable.just("Hello", "World")
//                .subscribe(System.out::println);
        //
        Observable<String> observable = Observable.just("Hello", "World");
        //
        //lambda: Action1<String> onNextAction = System.out::println
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };
        //
        //lambda: Action1<Throwable> onThrowableAction = throwable -> System.out.println("throwable" + throwable);
        Action1<Throwable> onThrowableAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                System.out.println("throwable" + throwable);
            }
        };
        //
        //lambda: Action0 onCompleteAction = () -> System.out.print("completed");
        Action0 onCompleteAction = new Action0() {
            @Override
            public void call() {
                //没有入参，所有是completed
                System.out.println("completed");
            }
        };
        //订阅关系
        observable.subscribe(onNextAction, onThrowableAction, onCompleteAction);
    }

    /**
     * Scheduler 调度器 = 线程控制器
     * <p>
     * subscribeOn()
     * observeOn() -->指定
     */
    @Test
    public void testScheduler() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("被观察者observable在" + Thread.currentThread().getName());
                subscriber.onNext("Hello");
            }
        });
        //
        observable.subscribeOn(Schedulers.newThread());//被观察者所在的线程
        observable.observeOn(Schedulers.newThread());  //观察者所在的线程
        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("观察者observe在" + Thread.currentThread().getName());
                System.out.println(s);
            }
        });
    }

    @Test
    public void testMap() {
        Observable<String> observable = Observable.just("1", "2", "3");
        observable.map(new Func1<String, Person>() {
            @Override
            public Person call(String s) {
                return new Person(s);
            }
        }).subscribe(new Action1<Person>() {
            @Override
            public void call(Person person) {
                System.out.println(person.getName());
            }
        });
    }

    class Person {
        private String name;

        Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Test
    public void testLift(){

    }
}
