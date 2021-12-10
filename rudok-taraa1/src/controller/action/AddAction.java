package controller.action;

import errorHandler.ErrorFactory;
import errorHandler.ErrorType;
import model.workspace.Presentation;
import model.workspace.Project;
import model.workspace.Slide;
import model.workspace.Workspace;
import view.MainFrame;
import view.tree.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {


        MyTreeNode mtn = (MyTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
        if(mtn == null){
            ErrorFactory.getInstance().generateError(ErrorType.SELECT);
            return;
        }

        if(mtn.getR() instanceof Workspace){


            Project p = new Project("Project" + ((Workspace) mtn.getR()).getDeca().size(), mtn.getR());

            MainFrame.getInstance().getTn().addProject(p);
        }else if(mtn.getR() instanceof Project){
            Presentation p = new Presentation("Presentation" + ((Project) mtn.getR()).getDeca().size(), mtn.getR());
            MainFrame.getInstance().getTn().addPresentation(p, mtn);
        }else if(mtn.getR() instanceof Presentation) {
            Slide s = new Slide("Slide" + ((Presentation) mtn.getR()).getDeca().size(), mtn.getR());
            MainFrame.getInstance().getTn().addSlide(s, mtn);
        }

    }
}
