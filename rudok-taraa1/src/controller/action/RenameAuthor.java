package controller.action;

import errorHandler.ErrorFactory;
import errorHandler.ErrorType;
import model.workspace.Presentation;
import view.MainFrame;
import view.componentsView.PresentationView;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;

public class RenameAuthor extends AbstractAction {


    @Override
    public void actionPerformed(ActionEvent e) {

        MyTreeNode myTreeNode = (MyTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
        if(myTreeNode == null){
            ErrorFactory.getInstance().generateError(ErrorType.SELECT);
            return;
        }
        if(!(myTreeNode.getR() instanceof Presentation)){
            ErrorFactory.getInstance().generateError(ErrorType.AUTOR);
            return;
        }
        ((Presentation)myTreeNode.getR()).setAuthor("");

    }
}
