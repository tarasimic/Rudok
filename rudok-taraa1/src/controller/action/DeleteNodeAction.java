package controller.action;

import errorHandler.ErrorFactory;
import errorHandler.ErrorType;
import model.node.RuNode_Composite;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;
import view.MainFrame;
import view.tree.model.MyTreeNode;
import view.tree.view.MyTree;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;

public class DeleteNodeAction extends AbstractAction {


    @Override
    public void actionPerformed(ActionEvent e) {

        MyTreeNode treeNode = (MyTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
        if(treeNode == null) {
            ErrorFactory.getInstance().generateError(ErrorType.SELECT);
            return;
        }
        Object selektovani = null;
        if (!(treeNode.getR() instanceof Workspace)) {
           selektovani  = ((MyTreeNode)((MyTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent()).getParent()).getR();
        }

        if ((treeNode.getR() instanceof Workspace)) {

            ((Workspace)(RuNode_Composite) treeNode.getR()).getDeca().clear();
        }

        else if (treeNode.getR() instanceof Project) {

            ((Workspace)(RuNode_Composite)selektovani).removeChild((Project)treeNode.getR());
        }

        else if (treeNode.getR() instanceof Presentation) {
            ((Project)selektovani).removeChild((Presentation)treeNode.getR());
        }else if(treeNode.getR() instanceof Slide){
            ((Presentation)selektovani).removeChild((Slide)treeNode.getR());
        }

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
    }
}
