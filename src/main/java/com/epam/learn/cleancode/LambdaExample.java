package com.epam.learn.cleancode;

public class LambdaExample {

    private void someHeavyCalculations() {
        //code we need to run
    }

    public void runThreadUsingAnonymousClass() {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                someHeavyCalculations();
            }
        };
        Thread thread = new Thread(target);
        thread.start();
    }


    public void runThreadUsingLambda() {
        Thread thread = new Thread(() -> someHeavyCalculations());
        thread.start();
    }

    public void runThreadUsingLambdaMethodReference() {
        Thread thread = new Thread(this::someHeavyCalculations);
        thread.start();
    }

}
