    package model.node;

import observer.IPublisher;
import observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public abstract class RuNode implements IPublisher{

    private String ime;
    private RuNode parent;



   public RuNode(String ime, RuNode parent){
       this.ime = ime;
       this.parent = parent;

   }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime)   {
        this.ime = ime;
    }

    public RuNode getParent() {
        return parent;
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
    }
}
