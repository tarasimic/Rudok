package view.componentsView;

import model.workspace.Workspace;
import observer.ISubscriber;
import view.MainFrame;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;

public class WorkspaceView implements ISubscriber, WorkSpace {

    private  Workspace koren;
    public WorkspaceView(){
        koren = new Workspace("Workspace");
        koren.addSubscriber(this);
    }
    @Override
    public void update(Object notification, String string) {
        if(string == "brisanje") {

            JTree tree = MainFrame.getInstance().getTree();
            MyTreeNode putnja = (MyTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
            for(Component komponent : MainFrame.getInstance().getRight().getComponents()){
                MainFrame.getInstance().getRight().remove(komponent);
            }
            MainFrame.getInstance().getRight().updateUI();

        }
    }

    public Workspace getKoren() {
        return koren;
    }

    public void setKoren(Workspace koren) {
        this.koren = koren;
    }

    @Override
    public Workspace getWorkSpace() {
        return koren;
    }
}
