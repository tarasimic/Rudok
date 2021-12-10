package app;

import errorHandler.ErrorFactory;
import view.MainFrame;
import view.componentsView.WorkSpace;
import view.componentsView.WorkspaceView;

public class Application {

    public static void main(String[] args) {

        MainFrame mf = MainFrame.getInstance();
        ErrorFactory errorFactory = ErrorFactory.getInstance();
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
    }

}
