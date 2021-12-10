package state;

import state.concrete.AddState;
import state.concrete.DivideState;
import state.concrete.MultState;
import state.concrete.SubstractStrate;

public class StateManager {

    private State currentState;
    private AddState addState;
    private SubstractStrate substractStrate;
    private MultState multState;
    private DivideState divideState;

    public StateManager(){
        initialise();
    }

    private void initialise(){
        addState = new AddState();
        substractStrate = new SubstractStrate();
        multState = new MultState();
        divideState = new DivideState();
        currentState = addState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setAddState() {
        currentState = addState;
    }

    public void setSubstractStrate() {
        currentState = divideState;
    }

    public void setMultState() {
        currentState = divideState;
    }

    public void setDivideState() {
       currentState = divideState;
    }
}
