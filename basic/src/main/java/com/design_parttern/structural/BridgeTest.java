package com.design_parttern.structural;

import lombok.AllArgsConstructor;

public class BridgeTest {
    public static void main(String[] args) {
        Destination destination = new DestinationA();
        Bridge bridge = new Bridge(destination);
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

@AllArgsConstructor
class Bridge {
    private Destination destination;

    public void bridgeDestination() {
        destination.arrive();
    }
}