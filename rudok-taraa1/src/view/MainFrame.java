package view;



import controller.action.ActionManager;
import errorHandler.ErrorFactory;
import errorHandler.ErrorType;
import errorHandler.MyError;
import model.workspace.Workspace;
import observer.ISubscriber;
import view.componentsView.PresentationView;
import view.componentsView.WorkSpace;
import view.componentsView.WorkspaceView;
import view.tree.model.TreeNodeImplementation;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements ISubscriber {

    private static MainFrame instance = null;
    Menu menu;
    Toolbar tb;
    private JTree tree;
    private TreeNodeImplementation tn;
    private JDesktopPane right;
    private ActionManager am;
    WorkSpace ws;
    ErrorFactory error;
    private PresentationView presentationView;
    private JSplitPane sp;

    public void setRight(JDesktopPane right) {
        this.right = right;
    }

    public JSplitPane getSp() {
        return sp;
    }

    public void setSp(JSplitPane sp) {
        this.sp = sp;
    }

    private MainFrame(){

    }

    public TreeNodeImplementation getTn() {
        return tn;
    }

    public ActionManager getAm() {
        return am;
    }

    private void inicijalizacija(){
        ws = new WorkspaceView();
        am = new ActionManager();
        tn = new TreeNodeImplementation();
        this.error = ErrorFactory.getInstance();
        this.error.addSubscriber(this);
        this.tree = tn.generate(this.ws.getWorkSpace());
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension size = tk.getScreenSize();

        setSize(size);
        setTitle("Rudok");
        menu = new Menu();
        setJMenuBar(menu);
        tb = new Toolbar();

        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(300, 300));
        left.setLayout(new BoxLayout(left, 1));
        JScrollPane skrol = new JScrollPane(this.tree);
        skrol.setMinimumSize(new Dimension(100,100));
        skrol.setVerticalScrollBarPolicy(20);
        left.add(skrol);
        right = new JDesktopPane();
        sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
        add(sp,BorderLayout.CENTER);
        add(tb, BorderLayout.NORTH);

    }

    public Menu getMenu(){
        return menu;
    }

    public Toolbar getTb(){
        return tb;
    }

    public JDesktopPane getRight() {
        return right;
    }

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
            instance.inicijalizacija();
        }
        return instance;
    }

    public JTree getTree() {
        return tree;
    }

    public PresentationView getPresentationView() {
        return presentationView;
    }

    public void setPresentationView(PresentationView presentationView) {
        this.presentationView = presentationView;
    }

    @Override
    public void update(Object notification, String string) {

        if(string == "cvor") {

            MyError error = (MyError) notification;
            showError(error);
        }
        if(string == "autor"){
            MyError error = (MyError) notification;
            showError(error);
        }
        if(string == "rename"){
            MyError error = (MyError) notification;
            showError(error);
        }
    }

    public void showError(MyError myError){
        JOptionPane.showMessageDialog(this, myError.getMessage());
    }
}
