package model.workspace;

import model.node.RuNode;
import model.node.RuNode_Composite;
import observer.IPublisher;
import observer.ISubscriber;

import java.util.ArrayList;

public class Project extends RuNode_Composite implements IPublisher {

    private String name;


    private boolean changed;

    public Project(String ime, RuNode parent) {
        super(ime, parent);
        this.name = ime;

        this.changed = false;
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public void addChild(RuNode rn) {
        if(rn instanceof Presentation){
            Presentation p = (Presentation) rn;
            if(!this.getDeca().contains(p)){
                this.getDeca().add(p);
                notifySubscriber(p, "dodavanje");
            }
        }
    }

    @Override
    public void removeChild(RuNode rn) {
        if(rn instanceof Presentation){
            Presentation p = (Presentation) rn;
            if(this.getDeca().contains(p)){
                this.getDeca().remove(p);
            }
            notifySubscriber(this, "brisanje");
        }
    }


    public void setName(String name) {
        this.name = name;
        notifySubscriber(this,"rename");
    }

    public String getName() {
        return name;
    }
    @Override
    public void addSubscriber(ISubscriber subscriber) {

        if(subscriber == null){
            return;
        }
        if(!this.getSubscribers().contains(subscriber)){
            this.getSubscribers().add(subscriber);
        }
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        if(this.getSubscribers().contains(subscriber)){
            this.getSubscribers().remove(subscriber);
        }
    }

    @Override
    public void notifySubscriber(Object notification, String akcija) {
        for(ISubscriber sub : this.getSubscribers()){
            sub.update(notification, akcija);
        }
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }
}
