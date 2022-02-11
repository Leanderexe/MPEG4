import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.Arrays;
import java.util.List;

public class Window {

    JFrame window = new JFrame();
    private JTextArea b1;
    Picture pic = new Picture();



    public void build_window(String frame, String frametype){
        JFrame window = new JFrame();
        window.setTitle("MPEG4" + frametype);
        window.setSize(1000, 1000);
        window.setLocation(500, 500);
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        Button button = new Button("nächstes Bild");
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.LEADING,1, 1));
        buttonPane.setBackground(Color.RED);
        buttonPane.add(button);
        window.add(buttonPane, BorderLayout.NORTH);
        //window.add(button);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 1, 1));
        JTextArea area = new JTextArea(frame);
        contentPane.setBackground(Color.BLUE);
        contentPane.add(area);
        // area.setLayout(new FlowLayout(area, BoxLayout.PAGE_AXIS));
        window.add(area, BorderLayout.SOUTH);
    }

    public void build_blocks(int blocksize, int canvassize, String[][] canvas, String frametype, boolean BMC, String[] dir_vector){
        String[][] Blocks = new String[canvassize][canvassize];
        for (int i = 0; i < 4; i++) {
            for (int p = 0; p < 4; p++) {
                String Block = "";
                for (int j = 8 * i; j < 8 * i + blocksize; j++) {
                    for (int n = 8 * p; n < 8 * p + blocksize; n++) {
                        if (canvas[j][n].equals("+")){
                            Blocks[j][n] = "0x0000FF";
                        }
                        if (canvas[j][n].equals("A")){
                            Blocks[j][n] = "0xE74C3C";
                        }
                        if (canvas[j][n].equals("B")){
                            Blocks[j][n] = "0xF7CB05";
                        }
                        //System.out.println("hihihihgffffffffffffffffffff");
                        //Block += canvas[j][n];
                    }
                    //Block += "\n";
                }
                //Blocks.add(Block);
                //System.out.println(Block);
            }
        }
        System.out.println(canvas.toString());
        System.out.println(Blocks);
        if (BMC){
            block_motion_comp(Blocks, frametype, dir_vector);
        }
        else{
            set_blocks(Blocks, frametype);
        }
    }

    public void set_blocks(String[][] blocks, String frametype){
        //JFrame window = new JFrame();
        window.setTitle("MPEG4(" + frametype + " Frame)");
        window.setSize(1250, 1250);
        window.setLocation(800, 100);
        window.setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK);


        JTextArea b1= new JTextArea();
        build_pixel(blocks, b1, 0);
        JTextArea b2=new JTextArea();
        build_pixel(blocks, b2, 1);
        JTextArea b3=new JTextArea();
        build_pixel(blocks, b3, 2);
        JTextArea b4=new JTextArea();
        build_pixel(blocks, b4, 3);
        JTextArea b5=new JTextArea();
        build_pixel(blocks, b5, 4);
        JTextArea b6=new JTextArea();
        build_pixel(blocks, b6, 5);
        JTextArea b7=new JTextArea();
        build_pixel(blocks, b7, 6);
        JTextArea b8=new JTextArea();
        build_pixel(blocks, b8, 7);
        JTextArea b9=new JTextArea();
        build_pixel(blocks, b9, 8);
        JTextArea b10=new JTextArea();
        build_pixel(blocks, b10, 9);
        JTextArea b11=new JTextArea();
        build_pixel(blocks, b11, 10);
        JTextArea b12=new JTextArea();
        build_pixel(blocks, b12, 11);
        JTextArea b13=new JTextArea();
        build_pixel(blocks, b13, 12);
        JTextArea b14=new JTextArea();
        build_pixel(blocks, b14, 13);
        JTextArea b15=new JTextArea();
        build_pixel(blocks, b15, 14);
        JTextArea b16=new JTextArea();
        build_pixel(blocks, b16, 15);


        for (JTextArea jTextArea : Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16)) {
            jTextArea.setBorder(border);
            jTextArea.setBackground(Color.BLACK);
            window.add(jTextArea);
        }

        Action Enter = new EnterAction();
        b1.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "EnterAction");
        b1.getActionMap().put("EnterAction", Enter);  // Perform an action when Enter Key is pressed.
        //public void EnterAction(){

        window.setLayout(new GridLayout(4,4));
        window.setVisible(true);

    }

    public void build_pixel(String[][] blocks, JTextArea area, int blocknumber){
        int blocksize = 8;
        int i = (int) Math.floor(blocknumber/4);
        int p = blocknumber%4;
        System.out.println(p + " " + i);
        area.setLayout(new GridLayout(8,8));
        for (int j = 8 * i; j < 8 * i + blocksize; j++) {
            for (int n = 8 * p; n < 8 * p + blocksize; n++) {
                Border border = BorderFactory.createLineBorder(Color.GRAY);
                JTextArea h1 = new JTextArea();
                h1.setBorder(border);
                h1.setBackground(Color.decode(blocks[j][n]));
                area.add(h1);
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("Hello");
        }
    }

    public void block_motion_comp(String[][] blocks, String frametype, String[] bmc) {
        //JFrame window = new JFrame();
        //LayoutManager overlay = new OverlayLayout(window);
        //window.setLayout(overlay);
        window.setTitle("MPEG4(" + frametype + " Frame)");
        //window.setSize(1250, 1250);
        //window.setLocation(800, 100);
        window.setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        Border border_old = BorderFactory.createLineBorder(Color.RED);
        Border border_new = BorderFactory.createLineBorder(Color.GREEN);
        //Jpanel panel = new Panel();
        JLayeredPane lpane = new JLayeredPane();
        JPanel canvaspanel = new JPanel();

        JTextArea b1= new JTextArea();
        build_pixel(blocks, b1, 0);
        JTextArea b2=new JTextArea();
        build_pixel(blocks, b2, 1);
        JTextArea b3=new JTextArea();
        build_pixel(blocks, b3, 2);
        JTextArea b4=new JTextArea();
        build_pixel(blocks, b4, 3);
        JTextArea b5=new JTextArea();
        build_pixel(blocks, b5, 4);
        JTextArea b6=new JTextArea();
        build_pixel(blocks, b6, 5);
        JTextArea b7=new JTextArea();
        build_pixel(blocks, b7, 6);
        JTextArea b8=new JTextArea();
        build_pixel(blocks, b8, 7);
        JTextArea b9=new JTextArea();
        build_pixel(blocks, b9, 8);
        JTextArea b10=new JTextArea();
        build_pixel(blocks, b10, 9);
        JTextArea b11=new JTextArea();
        build_pixel(blocks, b11, 10);
        JTextArea b12=new JTextArea();
        build_pixel(blocks, b12, 11);
        JTextArea b13=new JTextArea();
        build_pixel(blocks, b13, 12);
        JTextArea b14=new JTextArea();
        build_pixel(blocks, b14, 13);
        JTextArea b15=new JTextArea();
        build_pixel(blocks, b15, 14);
        JTextArea b16=new JTextArea();
        build_pixel(blocks, b16, 15);

        String old_block = "b" + (Integer.parseInt(bmc[0]) + 1);
        String new_block = "b" + (Integer.parseInt(bmc[1]) + 1);
        System.out.println("old_block " + old_block + "   " + new_block);


        int counter = 0;
        for (JTextArea jTextArea : Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16)) {
            jTextArea.setBorder(border);
            System.out.println( counter + "  " + old_block + "   " + new_block);

            if (counter == Integer.parseInt(bmc[1])){
                jTextArea.setBackground(Color.GREEN);
                jTextArea.setBorder(border_new);

            }
            else if (counter == Integer.parseInt(bmc[0])){
                jTextArea.setBackground(Color.RED);
                jTextArea.setBorder(border_old);

            }
            else{
                jTextArea.setBackground(Color.BLACK);
            }
            canvaspanel.add(jTextArea);
            counter += 1;
        }
        canvaspanel.setLayout(new GridLayout(4,4));
        //window.add(lpane);

        Action Enter = new EnterAction();
        b1.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "EnterAction");
        b1.getActionMap().put("EnterAction", Enter);  // Perform an action when Enter Key is pressed.
        //public void EnterAction(){

        //window.setLayout(new GridLayout(4,4));
        window.setVisible(true);


        canvaspanel.setSize(1225, 1225);
        //lpane.setOpaque(true);
        lpane.add(canvaspanel, new Integer(0), 0);
        //graphig.setBounds(200, 100, 100, 100);

        window.add(lpane, BorderLayout.CENTER);
        System.out.println("ich bin hier : "+ lpane.getLocation());
        window.pack();
        /*
        for(int i = 0; i < canvaspanel.getComponentCount(); i++){
            System.out.println(canvaspanel.getComponent(i).getX() + " ;" + canvaspanel.getComponent(i).getY());
            Integer[][] coordinates = new Integer[canvaspanel.getComponentCount()][2];
            Integer[] vec = {canvaspanel.getComponent(i).getX(), canvaspanel.getComponent(i).getY()};
            coordinates[i] = vec;
        }
        */

        Integer[] new_coord = {canvaspanel.getComponent(Integer.parseInt(bmc[1])).getX(), canvaspanel.getComponent(Integer.parseInt(bmc[1])).getY()};
        Integer[] old_coord = {canvaspanel.getComponent(Integer.parseInt(bmc[0])).getX(), canvaspanel.getComponent(Integer.parseInt(bmc[0])).getY()};
        int middle_point = (canvaspanel.getComponent(1).getX() - canvaspanel.getComponent(0).getX()) / 2;

        Grap graphig = new Grap(old_coord, new_coord, middle_point);
        graphig.setVisible(true);
        graphig.setOpaque(false);
        lpane.add(graphig, new Integer(1), 0); // Layer direction vector over the Canvas.
        window.setSize(1250, 1250);
        window.setLocation(800, 100);
        //window.add(canvaspanel);
        //lpane.setBounds(0, 0, 1250, 1250);
        //Graphics2D graphic = new Graphics2D();
    }

    class Grap extends JPanel implements ActionListener {
        int x_new;
        int y_new;
        int x_old;
        int y_old;
        int vx = 1;
        int vy = 1;
        Timer timer;

        Grap(Integer[] old_coord, Integer[] new_coord, int mid_point){
            x_new = new_coord[0] + mid_point;
            y_new = new_coord[1] + mid_point;
            x_old = old_coord[0] + mid_point;
            y_old = old_coord[1] + mid_point;
            int i = 0;
            this.setSize(1250, 1250);
            this.setLocation(0, 0);
            this.setVisible(true);
            timer = new Timer(100,null);

        }

        public void paint(Graphics g) {
            super.paint(g);  // fixes the immediate problem.
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(Color.GREEN);
            g2.setStroke(new BasicStroke(5));
            Line2D lin = new Line2D.Float(x_old, y_old, x_new, y_new);
            g2.draw(lin);
            //Polygon arrowPolygon = new Polygon();
            //arrowPolygon.addPoint(x_new, y_old);
            //g2.draw(arrowPolygon);
            g2.setPaint(Color.GREEN);

            // Source: https://itqna.net/questions/3389/how-draw-arrow-using-java2d

            Polygon arrowHead = new Polygon();
            AffineTransform tx = new AffineTransform();
            arrowHead.addPoint(0, 5);
            arrowHead.addPoint(-10, -10);
            arrowHead.addPoint(10, -10);

            tx.setToIdentity();
            double angle = Math.atan2(y_new - y_old, x_new - x_old);
            tx.translate(x_new, y_new);
            tx.rotate(angle - Math.PI / 2d);

            g2.setTransform(tx);
            g2.fill(arrowHead);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            x_new = x_new + vx;
            y_new = y_new + vy;
            repaint();
        }
    }


    public class EnterAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello");
            try {
                pic.build();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            //Picture pic = new Picture();
            //pic.build();
            //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.exit(0);

        }
    }

    public void load_picture(){
        try {
            pic.build();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
