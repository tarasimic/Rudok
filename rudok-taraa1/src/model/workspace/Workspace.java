package model.workspace;



import model.node.RuNode;
import model.node.RuNode_Composite;

import java.util.ArrayList;

public class Workspace extends RuNode_Composite  {


    public Workspace(String ime) {
        super(ime, null);

    }

    @Override
    public void addChild(RuNode rn) {
        if(rn instanceof Project){
            Project projekat = (Project)rn;
            if(!this.getDeca().contains(projekat)){
                this.getDeca().add(projekat);
                notifySubscriber(projekat, "dodavanje");
            }
        }
    }

    @Override
    public void removeChild(RuNode rn) {
        if(rn instanceof Project){
            Project p = (Project) rn;
            if(this.getDeca().contains(p)){

                this.getDeca().remove(p);

            }
           notifySubscriber(this, "brisanje");

        }

    }



    @Override
    public String toString() {
        return "Workspace";
    }












}
