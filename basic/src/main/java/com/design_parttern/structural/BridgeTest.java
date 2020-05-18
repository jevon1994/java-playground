package com.design_parttern.structural;

import lombok.AllArgsConstructor;

public class BridgeTest {
    public static void main(String[] args) {
        Destination destinationA = new DestinationA();
        Destination destinationB = new DestinationB();
        Bridge bridge = new Bridge(destinationB);
        bridge.bridgeDestination();
    }
}

interface Destination {
    void arrive();
}

class DestinationA implements Destination {

    @Override
    public void arrive() {
        System.out.println("A");
    }
}

class DestinationB implements Destination {

    @Override
    public void arrive() {
        System.out.println("B");
    }
}

class Bridge {
    private Destination destination;
    public Bridge(Destination destination){
        this.destination = destination;
    }
    public void bridgeDestination() {
        destination.arrive();
    }
}