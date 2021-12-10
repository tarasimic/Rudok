package model.workspace;

import model.node.RuNode;
import model.node.RuNode_Composite;


import java.net.URL;
import java.util.ArrayList;

public class Presentation extends RuNode_Composite {

    private ArrayList<Slide> slajdovi;
    private String name;
    private String author;
    private String url;

    public Presentation(String ime, RuNode parent) {
        super(ime, parent);
        slajdovi = new ArrayList<>();
    }

    @Override
    public void addChild(RuNode rn) {
        if(rn instanceof Slide){
            Slide slajd = (Slide) rn;
            if(!this.getDeca().contains(slajd)){
                this.getDeca().add(slajd);
                notifySubscriber(this, "dodavanje");
            }
        }
    }

    @Override
    public void removeChild(RuNode rn) {
        if(rn instanceof Slide){
            Slide s = (Slide) rn;
            if(this.getDeca().contains(s)){
                this.getDeca().remove(s);
                notifySubscriber(this, "brisanje");
            }
        }
    }
    public void addUrl() {
        notifySubscriber(this,"background");
    }
    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;

    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
        notifySubscriber(this, "rename");
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        notifySubscriber(this, "editAuthor");

    }

}