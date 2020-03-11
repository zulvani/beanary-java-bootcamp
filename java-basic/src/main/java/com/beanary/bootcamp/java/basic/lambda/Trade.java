package com.beanary.bootcamp.java.basic.lambda;

import java.util.ArrayList;
import java.util.List;

public class Trade {

    List<MyEventListener> listeners = new ArrayList<>();

    public void addEventListener(MyEventListener e){
        listeners.add(e);
    }

    public void run(){
        for(MyEventListener e : listeners){
            e.onStateChange("CANCELLED", "CLOSED");
        }
    }
}
