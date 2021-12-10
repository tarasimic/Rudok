package controller.action;

import javax.swing.*;

public  class ActionManager {

    private InfoAction ia;
    private AddAction nova;
    private RenameAction rename;
    private DeleteNodeAction delete;
    private RenameAuthor renameAuthor;
    private BackgroundAction backgroundAction;




    public BackgroundAction getBackgroundAction() {
        return backgroundAction;
    }

    public ActionManager(){
        ia = new InfoAction();
        nova = new AddAction();
        rename = new RenameAction();
        delete = new DeleteNodeAction();
        renameAuthor = new RenameAuthor();
        backgroundAction = new BackgroundAction();

    }

    public AddAction getNova() {
        return nova;
    }

    public InfoAction getIa() {
        return ia;
    }

    public RenameAction getRename() {
        return rename;
    }

    public DeleteNodeAction getDelete() {
        return delete;
    }

    public RenameAuthor getRenameAuthor() {
        return renameAuthor;
    }
}
