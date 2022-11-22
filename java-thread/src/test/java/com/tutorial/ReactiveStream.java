package com.tutorial;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ReactiveStream {

    @Test
    void publish() throws InterruptedException {
        var publisher = new SubmissionPublisher<String>();
        var subscriber = new PrintSubscriber("A",1000L);
        publisher.subscribe(subscriber);

        var executor = Executors.newFixedThreadPool(10);

        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                publisher.submit("Aqib-"+i);
                System.out.println(Thread.currentThread().getName()+": Send Aqib-"+i);
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        Thread.sleep(100*1000);
    }

    public static class PrintSubscriber implements Flow.Subscriber<String>{

        private Flow.Subscription subscription;

        private String name;
        private Long sleep;

        public PrintSubscriber(String name, Long sleep){
            this.name = name;
            this.sleep = sleep;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" : "+this.name+" : "+item);
                this.subscription.request(1);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.println(Thread.currentThread().getName()+": DONE");
        }
    }
}
