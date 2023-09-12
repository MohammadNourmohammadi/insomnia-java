import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The type Gui.
 */
public class Gui {
    /**
     * The J frame.
     */
    final JFrame jFrame ;
    /**
     * The Options.
     */
    final JMenuItem options ;
    /**
     * The Exit.
     */
    final JMenuItem exit ;
    /**
     * The Toggle full screen.
     */
    final JMenuItem toggleFullScreen ;
    /**
     * The Toggle sidebar.
     */
    final JMenuItem toggleSidebar ;
    /**
     * The Help item.
     */
    final JMenuItem helpItem ;
    /**
     * The About.
     */
    final JMenuItem about ;
    /**
     * The Main.
     */
    JPanel main ;
    /**
     * The Requestlist.
     */
    final public JPanel requestlist ;
    /**
     * The Request.
     */
    Request request ;
    /**
     * The Combo box.
     */
    JComboBox comboBox ;
    /**
     * The Url.
     */
    final JTextField url;
    /**
     * The Send.
     */
    final JButton send;

    /**
     * Instantiates a new Gui.
     */
    public Gui(){
        url = new JTextField();
        send = new JButton("Send");
        jFrame = new JFrame("insomnia") ;
        main = new JPanel();
        main.setBounds(0,0,1000,500);
        jFrame.setLayout(null);
        jFrame.setSize(1000 , 500 );
        jFrame.add(main);
        main.setLayout(null);
        jFrame.setLocation(220,150);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        final JMenuBar menuBar = new JMenuBar();
        final JMenu application = new JMenu("Application") ;
        application.setMnemonic('a');
        final JMenu view = new JMenu("View") ;
        view.setMnemonic('v');
        final JMenu help = new JMenu("Help") ;
        help.setMnemonic('h');
        options = new  JMenuItem("options") ;
        options.setMnemonic('o');
        Checkbox exitortry = new Checkbox("Exit Or Systemtry") ;
        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame opti = new JFrame();
                opti.setBounds(60, 60, 200,200);
                opti.setLayout(new GridLayout(2,1));

                Checkbox followRedirect = new Checkbox("follow redirect") ;
                opti.add(exitortry);
                opti.add(followRedirect) ;
                opti.setVisible(true);

            }
        });
        exit = new JMenuItem("exit") ;
        exit.setMnemonic('e');
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(exitortry.getState() == true)
                    System.exit(0);
                else
                    ;
            }
        });
        application.add(options) ;
        application.add(exit) ;

        toggleFullScreen = new JMenuItem("Toggle Full Screen");
        toggleFullScreen.setMnemonic('s');
        toggleSidebar = new JMenuItem("Toggle Sidebar");
        toggleSidebar.setMnemonic('l');
        toggleSidebar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(requestlist.isVisible())
                    requestlist.setVisible(false);
                else
                    requestlist.setVisible(true);
            }
        });
        view.add(toggleFullScreen);
        view.add(toggleSidebar);

        helpItem = new JMenuItem("Help");
        helpItem.setMnemonic('h');
        about = new JMenuItem("About");
        about.setMnemonic('b');
        help.add(helpItem);
        help.add(about);

        menuBar.add(application);
        menuBar.add(view);
        menuBar.add(help);
        jFrame.setJMenuBar(menuBar);

        jFrame.setVisible(true);
        requestlist = new JPanel();
        drawRequestList();
        drawtop();
        actionMenuItem();

    }

    /**
     * draw top
     */
    private void drawtop(){

        final JPanel jPaneltop = new JPanel();
        jPaneltop.setBounds(200 ,0,80,50);
        jPaneltop.setLayout(null);
        String item [] = {"GET", "DELETE" , "POST", "PUT", "PATCH"} ;

        url.setBounds(280 , 0 , 250,50);
        main.add(url);
        main.updateUI();

        send.setBounds(530,0,70,50);
        main.add(send);
        main.updateUI();

        comboBox = new JComboBox(item) ;
        comboBox.setBounds(5,5,70,40);
        comboBox.requestFocus();
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedIndex() == 0)
                    jPaneltop.setBackground(Color.blue);
                if (comboBox.getSelectedIndex() == 1)
                    jPaneltop.setBackground(Color.red);
                if (comboBox.getSelectedIndex() == 2)
                    jPaneltop.setBackground(Color.green);
                if (comboBox.getSelectedIndex() == 3)
                    jPaneltop.setBackground(Color.ORANGE);
                if (comboBox.getSelectedIndex() == 4)
                    jPaneltop.setBackground(Color.yellow);
            }
        });
        jPaneltop.add(comboBox) ;
        main.add(jPaneltop);
        main.updateUI();



    }
    /**
     * draw request list
     */
    private void drawRequestList(){

        requestlist.setSize(200, 450);
        requestlist.setLocation(0,50);
        requestlist.setBackground(Color.cyan);
        requestlist.setLayout(new GridLayout(14,1));
        final JButton add = new JButton("add new request");
        //add.setBounds(0,0,200,50);
        requestlist.add(add);
        add.requestFocus();
        requestlist.requestFocus();


        main.add(requestlist) ;
        main.updateUI();

        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = JOptionPane.showInputDialog("enter request name");
                request = new Request(name , main);
                requestlist.add(request.getRequest());
                main.updateUI();
                requestlist.updateUI();
            }
        });
        JLabel insomniaLabel = new JLabel("                       Insomnia") ;
        insomniaLabel.setSize(200,50);
        insomniaLabel.setLocation(0,0);
        insomniaLabel.setForeground(Color.MAGENTA);
        JPanel panelLabel = new JPanel() ;
        panelLabel.setLayout(null);
        panelLabel.setSize(200,50);
        panelLabel.setLocation(0,0);
        panelLabel.setBackground(Color.black);
        panelLabel.add(insomniaLabel);
        main.add(panelLabel) ;
        main.updateUI();






    }

    /**
     * action menu item
     */
    private void actionMenuItem(){
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFrame aboutframe =new  JFrame("About") ;
                final JTextArea abouttext = new JTextArea();
                abouttext.setText("                                         be name khoda \n\n");
                abouttext.append("  author : Mohammad nourmohammadi\n");
                abouttext.append("  ID : 9812054\n");
                abouttext.append("  Email : 2013nourmohammadi@gmail.com");
                abouttext.setBackground(Color.black);
                abouttext.setForeground(Color.MAGENTA);
                aboutframe.setSize(400,300);
                aboutframe.setLocation(50,50);
                aboutframe.setLayout(null);
                abouttext.setEditable(false);
                abouttext.setSize(360,280);
                abouttext.setLocation(10,10);
                aboutframe.add(abouttext) ;
                aboutframe.setVisible(true);

            }
        });
        helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFrame helpframe =new  JFrame("About") ;
                final JTextArea helptext = new JTextArea();
                helptext.setText("   Auxiliary descriptions of commands");
                helptext.setBackground(Color.black);
                helptext.setForeground(Color.MAGENTA);
                helpframe.setSize(600,400);
                helpframe.setLocation(50,50);
                helpframe.setLayout(null);
                helptext.setEditable(false);
                helptext.setSize(580,380);
                helptext.setLocation(10,10);
                helpframe.add(helptext) ;
                helpframe.setVisible(true);

            }
        });
    }

}
