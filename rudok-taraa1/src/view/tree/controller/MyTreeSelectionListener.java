package view.tree.controller;

import model.node.RuNode_Composite;
import model.workspace.Presentation;
import model.workspace.Project;
import view.MainFrame;
import view.componentsView.PresentationView;
import view.componentsView.ProjectView;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

public class MyTreeSelectionListener extends MouseAdapter implements TreeSelectionListener {


    @Override
    public void valueChanged(TreeSelectionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() == 2) {

            JTree tree = MainFrame.getInstance().getTree();
            TreePath treePath = tree.getSelectionPath();

            MyTreeNode selected = (MyTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();


            if (selected.getR() instanceof Project) {
                RuNode_Composite p = ((RuNode_Composite)selected.getR());
                for (Component c : MainFrame.getInstance().getRight().getComponents()) {

                    if (c instanceof ProjectView) {

                        if (((ProjectView) c).getTitle().equals(p.getIme())) {
                            return;
                        }
                    }
                }

            ProjectView project = new ProjectView(p);
            MainFrame.getInstance().getRight().add(project);

            try {
                project.setSelected(true);

            } catch (PropertyVetoException e1) {
                e1.printStackTrace();
            }
            project.setVisible(true);

        }

    }
    }
}
