package controller.action;

import errorHandler.ErrorFactory;
import errorHandler.ErrorType;
import model.workspace.Project;
import model.workspace.Workspace;
import view.MainFrame;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;

public class RenameAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        TreePath treePath = MainFrame.getInstance().getTree().getSelectionPath();

        MainFrame.getInstance().getTree().startEditingAtPath(treePath);
    }
}
