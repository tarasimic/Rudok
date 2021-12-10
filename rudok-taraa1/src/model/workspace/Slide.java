package model.workspace;

import model.node.RuNode;
import observer.ISubscriber;

public class Slide extends RuNode {

    private String name;


    public Slide(String ime, RuNode parent ) {
        super(ime, parent);
        this.name = ime;

    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public void addSubscriber(ISubscriber subscriber) {

    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {

    }

    @Override
    public void notifySubscriber(Object notification, String akcija) {

    }

    @Override
    public String toString() {
        return "Slide{" +
                "name='" + name + '\'' +
                '}';
    }
}
