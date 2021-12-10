package model.node;

import model.node.RuNode;
import observer.IPublisher;
import observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public abstract class RuNode_Composite extends RuNode implements IPublisher {

    private ArrayList<RuNode> runode;
    private ArrayList<RuNode> deca;
    private List<ISubscriber> subscribers;
    public RuNode_Composite(String ime, RuNode parent) {
        super(ime, parent);
        runode = new ArrayList<>();
        deca = new ArrayList<>();
        subscribers = new ArrayList<>();
    }

    public abstract void addChild(RuNode rn);
    public abstract void removeChild(RuNode rn);

    public ArrayList<RuNode> getDeca() {
        return deca;
    }

    public void setDeca(ArrayList<RuNode> deca) {
        this.deca = deca;
    }
    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if(subscriber == null){
            return;
        }
        if(!subscribers.contains(subscriber)){
            subscribers.add(subscriber);
        }
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        if(subscribers.contains(subscriber)){
            subscribers.remove(subscriber);
        }
    }

    @Override
    public void notifySubscriber(Object notification, String akcija) {
        for(ISubscriber sub : subscribers){
            sub.update(notification, akcija);
        }
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }
}
