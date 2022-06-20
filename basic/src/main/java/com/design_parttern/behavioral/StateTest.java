package com.design_parttern.behavioral;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 一个对象内部状态改变其对象行为
 */
public class StateTest {
    public static void main(String[] args) {
        State state = new State();
        SelfContext context = new SelfContext(state);


        state.setState("A");
        System.out.println(context.invoke(state));


    }
}

@Data
class State {
    private String state;
}


@AllArgsConstructor
class SelfContext {
    private State state;

    public String invoke(State state) {
        return state.getState();
    }

}



