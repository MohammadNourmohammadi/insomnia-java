import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Response {
    private JPanel main ;
    private JPanel top ;
    /**
     * The Tabbed pane.
     */
    JTabbedPane tabbedPane ;
    /**
     * The Raw.
     */
    JPanel raw ;
    /**
     * The Header.
     */
    JPanel header ;

    /**
     * Instantiates a new Response.
     *
     * @param jPanel the j panel
     */
    public Response(JPanel jPanel){
        main = jPanel ;
        top = new JPanel() ;
        raw = new JPanel() ;
        header = new JPanel();
        tabbedPane = new JTabbedPane() ;
        tabbedPane.setBounds(600,50,400,450);

        top.setBounds(600 , 0 , 400,50);
        top.setLayout(null);

        JLabel statuscode = new JLabel("200 OK");
        statuscode.setBounds(20,10,  60,30);
        top.add(statuscode);

        JLabel time = new JLabel("6.44 s") ;
        time.setBounds(90, 10, 60, 30);
        top.add(time);

        JLabel capacity = new JLabel("123 KB") ;
        capacity.setBounds(160 , 10 , 60 , 30);
        top.add(capacity);

        main.add(top);
        drawraw();
        drawheader();
        main.add(tabbedPane) ;
        jPanel.updateUI();

    }

    /**
     * draw header
     */
    private void drawheader(){
        header.setSize(400,450);
        tabbedPane.add("Header" , header);
        header.setLayout(new GridLayout(10,1));
        addheader();
        JButton copy = new JButton("copy to clipboard") ;
        copy.setSize(100,50);
        header.add(copy);
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
        JTextField value = new JTextField();
        value.setSize(150,50);
        item.add(value);

        header.add(item);
    }

    /**
     * draw raw
     */
    private void drawraw(){
        JTextField response = new  JTextField() ;
        response.setBounds(0,0,400,450);
        raw.setLayout(null);
        raw.add(response) ;
//        JMenuBar menuBar = new JMenuBar();
//        JMenu application = new JMenu("Mod") ;
//        JMenuItem rawitem = new JMenuItem("raw");
//        JMenuItem preview = new JMenuItem("preview") ;
        tabbedPane.add( "raw",raw) ;

    }
}
