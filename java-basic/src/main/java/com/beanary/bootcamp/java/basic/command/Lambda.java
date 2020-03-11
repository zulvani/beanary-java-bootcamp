package com.beanary.bootcamp.java.basic.command;

import com.beanary.bootcamp.java.basic.lambda.MyEventListener;
import com.beanary.bootcamp.java.basic.lambda.Trade;

public class Lambda implements CommandHandler {

    private Trade t;

    @Override
    public void pre() {
        if(t == null) {
            MyEventListener el = new MyEventListener() {
                private int invokeCount = 0;

                @Override
                public void onStateChange(String oldState, String newState) {
                    this.invokeCount += 1;
                    System.out.println("from anonymous " + oldState + " => " + newState + " => " + this.invokeCount);
                }
            };

            t = new Trade();
            t.addEventListener(
                    (o, n) -> System.out.println("from lambda " + o + " => " + n)
            );
            t.addEventListener(el);
        }
    }

    @Override
    public void displayInput() {
    }

    @Override
    public void execute() {
        t.run();
    }
}
