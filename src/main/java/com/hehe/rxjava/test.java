package com.hehe.rxjava;


import io.reactivex.*;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

/**
 * @author 刘伟锋
 * @date 2022/03/04
 **/
@Slf4j
public class test {

    // 模拟出现背压情况
    public static void main(String[] args) {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                int i = 0;
                while (true) {
                    Thread.sleep(500);
                    i++;
                    e.onNext(i);
                    log.info("每500ms 发送一次数据：" + i);

                }

            }
        }).subscribeOn(Schedulers.newThread()) // 使被观察者存在独立的线程执行
                .observeOn(Schedulers.newThread()) // 使观察者存在独立的线程执行
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Thread.sleep(5000);
                        log.info("每5000ms接收一次数据:" + integer);
                    }
                });
        //使用Flowable BackpressureStrategy.ERROR 策略解决背压问题
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                for (int j = 0; j <= 150; j++) {
                    e.onNext(j);
                    log.info("发送数据" + j);
                    try {
                        Thread.sleep(50);
                    } catch (Exception ex) {

                    }
                }
            }
        }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        //观察者设置接收事件的数量，如果不设置接收不到
                        subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        log.info("Onnext ：" + (integer));

                    }

                    @Override
                    public void onError(Throwable throwable) {
                        log.error("onError :" + throwable.toString());

                    }

                    @Override
                    public void onComplete() {
                        log.error("onComplete");
                    }
                });

        Flowable.interval(50, TimeUnit.MICROSECONDS)
                .onBackpressureDrop() // 效果与Drop 类型一样
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(aLong -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("onNext：" + (aLong));
                });
    }
}
