package controller.action;

import model.workspace.Presentation;
import view.MainFrame;
import view.tree.model.MyTreeNode;
import view.tree.view.MyTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.URL;

public class BackgroundAction extends AbstractAction {



    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode treeNode = (MyTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
        ((Presentation)treeNode.getR()).addUrl();
    }
}
