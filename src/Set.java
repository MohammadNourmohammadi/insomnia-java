import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Set {

    /**
     * The Tabbed pane.
     */
    public JTabbedPane tabbedPane ;
    /**
     * The Form.
     */
    public JPanel form ;
    private JTextField curtextheader ;
    private JTextField curtextform;
    private JPanel main ;
    /**
     * The Header.
     */
    public JPanel header ;

    /**
     * Instantiates a new Set.
     *
     * @param jPanel the j panel
     */
    public Set( JPanel jPanel){
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(200,50,400,450);
        drawForm();
        jPanel.updateUI();
        main = jPanel;
        drawHeader();
        main.updateUI();
        jPanel.add(tabbedPane);
        jPanel.updateUI();
    }

    /**
     * draw header
     */
    private void drawHeader (){
        header = new JPanel();
        header.setSize(400,450);
        tabbedPane.add("Header" , header);
        header.setLayout(new GridLayout(10,1));
        addheader();
    }

    /**
     * draw form
     */
    private void drawForm(){
        form = new JPanel();
        form.setSize(400,450);
        tabbedPane.add("Form" , form);
        form.setLayout(new GridLayout(10,1));
        addform();


    }

    /**
     * add header
     */
    private void addheader(){
        JPanel item = new JPanel();
        item.setSize(400,50);
        item.setLayout(new GridLayout(1,4));
        JTextField key = new JTextField();
        key.setSize(150 , 50);
        item.add(key);
        curtextheader= key;
        curtextheader.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                addheader();

            }
        });
        JTextField value = new JTextField();
        value.setSize(150,50);
        item.add(value);
        Checkbox checkbox = new Checkbox();
        checkbox.setSize(50,50);
        item.add(checkbox);
        JButton delete = new JButton("delete");
        delete.setSize(50,50);
        item.add(delete);
        header.add(item);
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                header.remove(item);
                main.updateUI();
            }
        });


    }

    /**
     * add form
     */
    private void addform(){
        JPanel item = new JPanel();
        item.setSize(400,50);
        item.setLayout(new GridLayout(1,4));
        JTextField key = new JTextField();
        key.setSize(150 , 50);
        item.add(key);
        curtextform= key;
        curtextform.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                addform();

            }
        });
        JTextField value = new JTextField();
        value.setSize(150,50);
        item.add(value);
        Checkbox checkbox = new Checkbox();
        checkbox.setSize(50,50);
        item.add(checkbox);
        JButton delete = new JButton("delete");
        delete.setSize(50,50);
        item.add(delete);
        form.add(item);
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                form.remove(item);
                main.updateUI();
            }
        });

    }
}
