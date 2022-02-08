import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Window {

    JFrame window = new JFrame();
    private JTextArea b1;

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

    public void build_blocks(int blocksize, int canvassize, String[][] canvas, String frametype){
        String[][] Blocks = new String[canvassize][canvassize];
        for (int i = 0; i < 4; i++) {
            for (int p = 0; p < 4; p++) {
                String Block = "";
                for (int j = 8 * i; j < 8 * i + blocksize; j++) {
                    for (int n = 8 * p; n < 8 * p + blocksize; n++) {
                        if (canvas[j][n].equals("+")){
                            Blocks[j][n] = "0x051BF7";
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
        build_blocks(Blocks, frametype);
    }

    public void build_blocks(String[][] blocks, String frametype){
        //JFrame window = new JFrame();
        window.setTitle("MPEG4(" + frametype + ")");
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
    public class EnterAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello");
            //Picture pic = new Picture();
            //pic.build();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.exit(0);
        }
    }
}
