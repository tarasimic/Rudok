package state.concrete;

import state.State;

public class AddState implements State {


    @Override
    public double calculate(int a, int b) {
        return a+b;
    }
}
