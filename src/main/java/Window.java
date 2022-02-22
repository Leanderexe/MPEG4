import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Window {

    int heigth;
    int width;
    int blocksize;
    int number_of_blocks;
    int blocks_per_frame;
    JFrame window = new JFrame();
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
    JTextArea b65= new JTextArea();JTextArea b66=new JTextArea();JTextArea b67=new JTextArea();JTextArea b68=new JTextArea();JTextArea b69=new JTextArea();JTextArea b70=new JTextArea();
    JTextArea b71=new JTextArea();JTextArea b72=new JTextArea();JTextArea b73=new JTextArea();JTextArea b74=new JTextArea();JTextArea b75=new JTextArea();JTextArea b76=new JTextArea();
    JTextArea b77=new JTextArea();JTextArea b78=new JTextArea();JTextArea b79=new JTextArea();JTextArea b80=new JTextArea();JTextArea b81=new JTextArea();JTextArea b82=new JTextArea();
    JTextArea b83=new JTextArea();JTextArea b84=new JTextArea();JTextArea b85=new JTextArea();JTextArea b86=new JTextArea();JTextArea b87=new JTextArea();JTextArea b88=new JTextArea();
    JTextArea b89=new JTextArea();JTextArea b90=new JTextArea();JTextArea b91=new JTextArea();JTextArea b92=new JTextArea();JTextArea b93=new JTextArea();JTextArea b94=new JTextArea();
    JTextArea b95=new JTextArea();JTextArea b96=new JTextArea();JTextArea b97=new JTextArea();JTextArea b98=new JTextArea();JTextArea b99=new JTextArea();JTextArea b100=new JTextArea();
    JTextArea b101=new JTextArea();JTextArea b102=new JTextArea();JTextArea b103=new JTextArea();JTextArea b104=new JTextArea();JTextArea b105=new JTextArea();JTextArea b106=new JTextArea();
    JTextArea b107=new JTextArea();JTextArea b108=new JTextArea();JTextArea b109=new JTextArea();JTextArea b110=new JTextArea();JTextArea b111=new JTextArea();JTextArea b112=new JTextArea();
    JTextArea b113=new JTextArea();JTextArea b114=new JTextArea();JTextArea b115=new JTextArea();JTextArea b116=new JTextArea();JTextArea b117=new JTextArea();JTextArea b118=new JTextArea();
    JTextArea b119=new JTextArea();JTextArea b120=new JTextArea();JTextArea b121=new JTextArea();JTextArea b122=new JTextArea();JTextArea b123=new JTextArea();JTextArea b124=new JTextArea();
    JTextArea b125=new JTextArea();JTextArea b126=new JTextArea();JTextArea b127=new JTextArea();JTextArea b128=new JTextArea();
    List Components = new ArrayList();


    public Window(int w, int h,int blocksz){
        heigth = h;
        width = w;
        blocksize = blocksz;
        number_of_blocks = heigth/blocksize;
        blocks_per_frame = number_of_blocks*number_of_blocks;
        Collections.addAll(Components,b1 ,b2 ,b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36, b37, b38, b39, b40,
                b41, b42, b43, b44, b45, b46, b47, b48, b49, b50, b51, b52, b53, b54, b55, b56, b57, b58, b59, b60, b61, b62, b63, b64, b65, b66, b67, b68, b69, b70, b71, b72, b73, b74, b75, b76, b77, b78, b79, b80, b81, b82, b83,
                b84, b85, b86, b87, b88, b89, b90, b91, b92, b93, b94, b95, b96, b97, b98, b99, b100, b101, b102, b103, b104, b105, b106, b107, b108, b109, b110, b111, b112, b113, b114, b115, b116, b117, b118, b119, b120, b121, b122, b123, b124, b125,
                b126, b127, b128);
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

    public void build_blocks(int blocksize, int canvassize, String[][] canvas, String frametype, boolean BMC, String[] dir_vector, int location, boolean second_frame, boolean compress, String[] bmc_blocks, int animation){
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
            block_motion_comp(Blocks, frametype, dir_vector, location, second_frame, compress, bmc_blocks, animation);
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

        //Action Enter = new EnterAction();
        //b1.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "EnterAction");
        //b1.getActionMap().put("EnterAction", Enter);  // Perform an action when Enter Key is pressed.
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

    public void block_motion_comp(String[][] blocks, String frametype, String[] bmc, int location, boolean second_frame, boolean compress, String[] bmc_blocks, int animation) {
        window.setTitle(frametype + " Frame");
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
                        if (animation == 0){
                            jTextArea.setBackground(Color.RED);
                            jTextArea.setBorder(border_old);
                        }
                        else {
                            jTextArea.setBackground(Color.WHITE);
                            jTextArea.setBorder(border_new);
                        }
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



        window.setVisible(true);


        canvaspanel.setSize(1225, 1225);
        lpane.add(canvaspanel, new Integer(0), 0);

        window.add(lpane, BorderLayout.CENTER);
        window.pack();
        /*
        for(int i = 0; i < canvaspanel.getComponentCount(); i++){
            System.out.println(canvaspanel.getComponent(i).getX() + " ;" + canvaspanel.getComponent(i).getY());
            Integer[][] coordinates = new Integer[canvaspanel.getComponentCount()][2];
            Integer[] vec = {canvaspanel.getComponent(i).getX(), canvaspanel.getComponent(i).getY()};
            coordinates[i] = vec;
        }
        */


        if (animation == 0) {
            for (int i = 0; i < bmc_blocks.length; i++) {
                if (bmc_blocks[i].equals("-1")) {
                } else {
                    String[] block = {bmc_blocks[i], Integer.toString(i)};  // Old Block, new Block.
                    Integer[] new_coord = {canvaspanel.getComponent(Integer.parseInt(block[1])).getX(), canvaspanel.getComponent(Integer.parseInt(block[1])).getY()};
                    Integer[] old_coord = {canvaspanel.getComponent(Integer.parseInt(block[0])).getX(), canvaspanel.getComponent(Integer.parseInt(block[0])).getY()};
                    int middle_point = (canvaspanel.getComponent(1).getX() - canvaspanel.getComponent(0).getX()) / 2;

                    Grap graphig = new Grap(old_coord, new_coord, middle_point, false);
                    graphig.setVisible(true);
                    graphig.setOpaque(false);
                    lpane.add(graphig, new Integer(1), 0); // Layer direction vector over the Canvas.
                }
            }
        }
        else {
            if (compress){
            Integer[] new_coord = {canvaspanel.getComponent(Integer.parseInt(bmc[1])).getX(), canvaspanel.getComponent(Integer.parseInt(bmc[1])).getY()};
            Integer[] old_coord = {canvaspanel.getComponent(Integer.parseInt(bmc[0])).getX(), canvaspanel.getComponent(Integer.parseInt(bmc[0])).getY()};
            int middle_point = (canvaspanel.getComponent(1).getX() - canvaspanel.getComponent(0).getX()) / 2;

            Grap graphig = new Grap(old_coord, new_coord, middle_point, true);
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
        boolean animation;


        Grap(Integer[] old_coord, Integer[] new_coord, int mid_point, boolean animation){
            if (animation){
                x_new_end = new_coord[0] + mid_point;
                x_new = old_coord[0] + mid_point;
                y_new_end = new_coord[1] + mid_point;
                y_new = old_coord[1] + mid_point;
                x_old = old_coord[0] + mid_point;
                y_old = old_coord[1] + mid_point;
                vx = (new_coord[0] + mid_point - x_old) / 100;
                vy = (new_coord[1] + mid_point - y_old) / 100;
                timer = new Timer(10,this);
                timer.start();
            }
            else{
                y_new = new_coord[1] + mid_point;
                x_old = old_coord[0] + mid_point;
                y_old = old_coord[1] + mid_point;
                x_new = new_coord[0] + mid_point;
            }
            this.setSize(1250, 1250);
            this.setLocation(0, 0);
            this.setVisible(true);

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

    /*
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

     */

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
