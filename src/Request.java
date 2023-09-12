import javax.swing.*;
import java.util.Random;

/**
 * The type Request.
 */
public class Request {
    /**
     * The Request.
     */
    JButton request ;
    /**
     * The Set.
     */
    Set set ;
    /**
     * The Response.
     */
    Response response ;

    /**
     * Instantiates a new Request.
     *
     * @param name   the name
     * @param jPanel the j panel
     */
    public Request(String name , JPanel jPanel ){
        request = new JButton(name) ;
        System.out.println("fff");
        set = new Set(jPanel);
        response = new Response(jPanel) ;
        jPanel.updateUI();
    }

    /**
     * Gets request.
     *
     * @return the request
     */
    public JButton getRequest() {
        return request;
    }
}
