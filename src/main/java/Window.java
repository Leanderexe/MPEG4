import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class Window {

    int heigth;
    int width;
    int blocksize;
    int number_of_blocks;
    int blocks_per_frame;
    JFrame window = new JFrame();
    Picture pic = new Picture();
    JTextArea b1= new JTextArea();JTextArea b2=new JTextArea();JTextArea b3=new JTextArea();JTextArea b4=new JTextArea();JTextArea b5=new JTextArea();JTextArea b6=new JTextArea();
    JTextArea b7=new JTextArea();JTextArea b8=new JTextArea();JTextArea b9=new JTextArea();JTextArea b10=new JTextArea();JTextArea b11=new JTextArea();JTextArea b12=new JTextArea();
    JTextArea b13=new JTextArea();JTextArea b14=new JTextArea();JTextArea b15=new JTextArea();JTextArea b16=new JTextArea();JTextArea b17=new JTextArea();JTextArea b18=new JTextArea();
    JTextArea b19=new JTextArea();JTextArea b20=new JTextArea();JTextArea b21=new JTextArea();JTextArea b22=new JTextArea();JTextArea b23=new JTextArea();JTextArea b24=new JTextArea();
    JTextArea b25=new JTextArea();JTextArea b26=new JTextArea();JTextArea b27=new JTextArea();JTextArea b28=new JTextArea();JTextArea b29=new JTextArea();JTextArea b30=new JTextArea();
    JTextArea b31=new JTextArea();JTextArea b32=new JTextArea();JTextArea b33=new JTextArea();JTextArea b34=new JTextArea();JTextArea b35=new JTextArea();JTextArea b36=new JTextArea();
    JTextArea b37=new JTextArea();JTextArea b38=new JTextArea();JTextArea b39=new JTextArea();JTextArea b40=new JTextArea();JTextArea b41=new JTextArea();JTextArea b42=new JTextArea();
    JTextArea b43=new JTextArea();JTextArea b44=new JTextArea();JTextArea b45=new JTextArea();JTextArea b46=new JTextArea();JTextArea b47=new JTextArea();JTextArea b48=new JTextArea();
    JTextArea b49=new JTextArea();JTextArea b50=new JTextArea();JTextArea b51=new JTextArea();JTextArea b52=new JTextArea();JTextArea b53=new JTextArea();JTextArea b54=new JTextArea();
    JTextArea b55=new JTextArea();JTextArea b56=new JTextArea();JTextArea b57=new JTextArea();JTextArea b58=new JTextArea();JTextArea b59=new JTextArea();JTextArea b60=new JTextArea();
    JTextArea b61=new JTextArea();JTextArea b62=new JTextArea();JTextArea b63=new JTextArea();JTextArea b64=new JTextArea();
    List Components = new ArrayList();


    public Window(int w, int h,int blocksz){
        heigth = h;
        width = w;
        blocksize = blocksz;
        number_of_blocks = heigth/blocksize;
        blocks_per_frame = number_of_blocks*number_of_blocks;
        Collections.addAll(Components,b1 ,b2 ,b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36, b37, b38, b39, b40,
                b41, b42, b43, b44, b45, b46, b47, b48, b49, b50, b51, b52, b53, b54, b55, b56, b57, b58, b59, b60, b61, b62, b63, b64);
    }



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

    public void build_blocks(int blocksize, int canvassize, String[][] canvas, String frametype, boolean BMC, String[] dir_vector, int location, boolean second_frame, boolean compress, String[] bmc_blocks){
        String[][] Blocks = new String[canvassize][canvassize];
        for (int i = 0; i < number_of_blocks; i++) {
            for (int p = 0; p < number_of_blocks; p++) {
                String Block = "";
                for (int j = blocksize * i; j < blocksize * i + blocksize; j++) {
                    for (int n = blocksize * p; n < blocksize * p + blocksize; n++) {
                        if (canvas[j][n].equals("+")){
                            Blocks[j][n] = "0x0000FF";
                        }
                        if (canvas[j][n].equals("A")){
                            Blocks[j][n] = "0xAA05F7";
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
        //System.out.println(canvas.toString());
        //System.out.println(Blocks);
        if (BMC){
            block_motion_comp(Blocks, frametype, dir_vector, location, second_frame, compress, bmc_blocks);
        }
        else{
            set_blocks(Blocks, frametype, location);
        }
    }

    public void set_blocks(String[][] blocks, String frametype, int location){
        //JFrame window = new JFrame();
        window.setTitle("MPEG4(" + frametype + " Frame)");
        window.setSize(1250, 1250);
        window.setLocation(location, 100);
        window.setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        List<JTextArea> comp = get_components(blocks_per_frame);


        int counter = 0;
        for (JTextArea jTextArea : comp) {
            build_pixel(blocks, jTextArea, counter);
            jTextArea.setBorder(border);
            jTextArea.setBackground(Color.BLACK);
            window.add(jTextArea);
            counter += 1;
        }

        Action Enter = new EnterAction();
        b1.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "EnterAction");
        b1.getActionMap().put("EnterAction", Enter);  // Perform an action when Enter Key is pressed.
        //public void EnterAction(){

        window.setLayout(new GridLayout(number_of_blocks,number_of_blocks));
        window.setVisible(true);

    }

    public void build_pixel(String[][] blocks, JTextArea area, int blocknumber){
        int i = (int) Math.floor(blocknumber/number_of_blocks);
        int p = blocknumber%number_of_blocks;
        //System.out.println(p + " " + i);
        area.setLayout(new GridLayout(blocksize,blocksize));
        for (int j = blocksize * i; j < blocksize * i + blocksize; j++) {
            for (int n = blocksize * p; n < blocksize * p + blocksize; n++) {
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

    public void block_motion_comp(String[][] blocks, String frametype, String[] bmc, int location, boolean second_frame, boolean compress, String[] bmc_blocks) {
        //JFrame window = new JFrame();
        //LayoutManager overlay = new OverlayLayout(window);
        //window.setLayout(overlay);
        window.setTitle("MPEG4(" + frametype + " Frame)");
        //window.setSize(1250, 1250);
        //window.setLocation(800, 100);
        window.setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        Border border_old = BorderFactory.createLineBorder(Color.RED);
        Border border_new = BorderFactory.createLineBorder(Color.WHITE);
        Border border_right = BorderFactory.createLineBorder(Color.GREEN);
        //Jpanel panel = new Panel();
        JLayeredPane lpane = new JLayeredPane();
        JPanel canvaspanel = new JPanel();
        List<JTextArea> comp = get_components(blocks_per_frame);


        int counter = 0;
        canvaspanel.setLayout(new GridLayout(number_of_blocks,number_of_blocks));

        for (JTextArea jTextArea : comp) {
        //int blocks_per_frame = number_of_blocks*number_of_blocks;
        //for (int i = 0; i < blocks_per_frame; i++) {
            //JTextArea b2= new JTextArea();
            build_pixel(blocks, jTextArea, counter);
            jTextArea.setBorder(border);
            //System.out.println( counter + "  " + old_block + "   " + new_block);


            if (counter == Integer.parseInt(bmc[1])){
                if (second_frame == true){
                    if (compress){
                        jTextArea.setBackground(Color.GREEN);
                        jTextArea.setBorder(border_right);
                    }
                    else {
                        jTextArea.setBackground(Color.GREEN);
                        jTextArea.setBorder(border_new);
                    }
                }
                else if (counter == Integer.parseInt(bmc[0])){
                    jTextArea.setBackground(Color.RED);
                    jTextArea.setBorder(border_old);
                }
                else{
                    jTextArea.setBackground(Color.BLACK);
                }
            }
            else if (counter < Integer.parseInt(bmc[1])){
                if (second_frame == true){
                    if(bmc_blocks[counter].equals("-1")){
                        jTextArea.setBackground(Color.RED);
                        jTextArea.setBorder(border_old);
                    }
                    else{
                        jTextArea.setBackground(Color.GREEN);
                        jTextArea.setBorder(border_right);
                    }
                }
                else if (counter == Integer.parseInt(bmc[0])){
                    if (compress){
                        jTextArea.setBackground(Color.GREEN);
                        jTextArea.setBorder(border_right);
                    }
                    else {
                        jTextArea.setBackground(Color.RED);
                        jTextArea.setBorder(border_old);
                    }
                }
                else{
                    jTextArea.setBackground(Color.BLACK);
                }
            }
            else if (counter == Integer.parseInt(bmc[0])){
                if (second_frame == false){
                    if (compress){
                        jTextArea.setBackground(Color.GREEN);
                        jTextArea.setBorder(border_right);
                    }
                    else{
                        jTextArea.setBackground(Color.RED);
                        jTextArea.setBorder(border_old);
                    }
                }
                else{
                    jTextArea.setBackground(Color.BLACK);
                }
            }
            else{
                jTextArea.setBackground(Color.BLACK);
            }


            canvaspanel.add(jTextArea);
            counter += 1;
        }
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
        //System.out.println("ich bin hier : "+ lpane.getLocation());
        window.pack();
        /*
        for(int i = 0; i < canvaspanel.getComponentCount(); i++){
            System.out.println(canvaspanel.getComponent(i).getX() + " ;" + canvaspanel.getComponent(i).getY());
            Integer[][] coordinates = new Integer[canvaspanel.getComponentCount()][2];
            Integer[] vec = {canvaspanel.getComponent(i).getX(), canvaspanel.getComponent(i).getY()};
            coordinates[i] = vec;
        }
        */

        if(compress) {
            Integer[] new_coord = {canvaspanel.getComponent(Integer.parseInt(bmc[1])).getX(), canvaspanel.getComponent(Integer.parseInt(bmc[1])).getY()};
            Integer[] old_coord = {canvaspanel.getComponent(Integer.parseInt(bmc[0])).getX(), canvaspanel.getComponent(Integer.parseInt(bmc[0])).getY()};
            int middle_point = (canvaspanel.getComponent(1).getX() - canvaspanel.getComponent(0).getX()) / 2;

            Grap graphig = new Grap(old_coord, new_coord, middle_point);
            graphig.setVisible(true);
            graphig.setOpaque(false);
            lpane.add(graphig, new Integer(1), 0); // Layer direction vector over the Canvas.
        }
        else{
            Integer[] coord = null;
            if (second_frame){
                coord = new Integer[]{canvaspanel.getComponent(Integer.parseInt(bmc[1])).getX(), canvaspanel.getComponent(Integer.parseInt(bmc[1])).getY()};
            }
            else{
                coord = new Integer[]{canvaspanel.getComponent(Integer.parseInt(bmc[0])).getX(), canvaspanel.getComponent(Integer.parseInt(bmc[0])).getY()};
            }
            int size = canvaspanel.getComponent(1).getX(); // The size of one block.

            Cross graphig = new Cross(coord, size);
            graphig.setVisible(true);
            graphig.setOpaque(false);
            lpane.add(graphig, new Integer(1), 0); // Layer direction vector over the Canvas.
        }
        window.setSize(1250, 1270);
        window.setLocation(location, 100);
        //window.add(canvaspanel);
        //lpane.setBounds(0, 0, 1250, 1250);
        //Graphics2D graphic = new Graphics2D();
    }

    class Grap extends JPanel implements ActionListener {
        float x_new;
        int x_new_end;
        int y_new_end;
        float y_new;
        float x_old;
        float y_old;
        float vx;
        float vy;
        Timer timer;
        int counter = 0;

        Grap(Integer[] old_coord, Integer[] new_coord, int mid_point){
            x_new_end = new_coord[0] + mid_point;
            x_new = old_coord[0] + mid_point;
            y_new_end = new_coord[1] + mid_point;
            y_new = old_coord[1] + mid_point;
            x_old = old_coord[0] + mid_point;
            y_old = old_coord[1] + mid_point;
            vx = (new_coord[0] + mid_point - x_old) / 100;
            vy = (new_coord[1] + mid_point - y_old) / 100;
            this.setSize(1250, 1250);
            this.setLocation(0, 0);
            this.setVisible(true);
            timer = new Timer(10,this);
            timer.start();

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
            if (x_new == x_old & y_new == y_old) { // The new block and old block are exactly the same so no arrow will be drawn.
            }
            else{
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

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (counter < 101){
                counter += 1;
                x_new = x_new + vx;
                y_new = y_new + vy;
                repaint();
            }
        }
    }

    class Cross extends JPanel implements ActionListener {
        float upleftx;
        float uplefty;
        float uprightx;
        float downleftx;
        float downrightx;
        float uprighty;
        float downlefty;
        float downrighty;
        float vx;
        float vy;
        Timer timer;
        int counter = 0;

        Cross(Integer[] coord, int size){
            upleftx = coord[0];
            uplefty = coord[1];
            uprightx = coord[0] + size;
            uprighty = coord[1];
            downleftx = coord[0] + size;
            downlefty = coord[1];
            downrightx = coord[0];
            downrighty = coord[1];
            vx = size / 25;
            //vy = (new_coord[1] + mid_point - y_old) / 100;
            this.setSize(1250, 1250);
            this.setLocation(0, 0);
            this.setVisible(true);
            timer = new Timer(10,this);
            timer.start();

        }

        public void paint(Graphics g) {
            super.paint(g);  // fixes the immediate problem.
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(Color.RED);
            g2.setStroke(new BasicStroke(5));
            Line2D lin = new Line2D.Float(upleftx, uplefty, downrightx, downrighty);
            g2.draw(lin);
            Line2D lin2 = new Line2D.Float(uprightx, uprighty, downleftx, downlefty);
            g2.draw(lin2);
            g2.setPaint(Color.RED);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (counter < 25){
                counter += 1;
                downleftx -= vx;
                downlefty += vx;
                downrightx += vx;
                downrighty += vx;
                //x_new = x_new + vx;
                //y_new = y_new + vy;
                repaint();
            }
        }
    }

    public class EnterAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println("hello");
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

    public void close_window(){
        window.dispose();
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public List<JTextArea> get_components(int quantity){
        List comp = new ArrayList();
        for(int i = 0; i < quantity; i++){
            comp.add(Components.get(i));
            //System.out.println(i);
        }
        return comp;
    }
}
