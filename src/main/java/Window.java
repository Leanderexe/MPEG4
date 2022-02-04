import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window {

    private JTextArea b1;

    public void build_window(String frame){
        JFrame window = new JFrame();
        window.setTitle("MPEG4");
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

    public void build_blocks(int blocksize, int canvassize, String[][] canvas){
        List Blocks = new ArrayList();
        for (int i = 0; i < 4; i++) {
            for (int p = 0; p < 4; p++) {
                String Block = "";
                for (int j = 8 * i; j < 8 * i + blocksize; j++) {
                    for (int n = 8 * p; n < 8 * p + blocksize; n++) {
                        System.out.println("hihihihgffffffffffffffffffff");
                        Block += canvas[j][n];
                    }
                    Block += "\n";
                }
                Blocks.add(Block);
                System.out.println(Block);
            }
        }
        System.out.println(canvas.toString());
        System.out.println(Blocks);
        build_blocks(Blocks);
    }

    public void build_blocks(List blocks){
        JFrame window = new JFrame();
        window.setTitle("MPEG4");
        window.setSize(1000, 1000);
        window.setLocation(500, 500);
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 1, 1));
        System.out.println(blocks.size());
        JTextArea b1= new JTextArea((String) blocks.get(0));
        b1.setBackground(Color.RED);
        b1.setColumns(1);
        JTextArea b2=new JTextArea((String) blocks.get(1));
        b2.setBackground(Color.BLACK);
        JTextArea b3=new JTextArea((String) blocks.get(2));
        b3.setBackground(Color.BLUE);
        JTextArea b4=new JTextArea((String) blocks.get(3));
        b4.setBackground(Color.CYAN);
        JTextArea b5=new JTextArea((String) blocks.get(4));
        b5.setBackground(Color.GREEN);
        JTextArea b6=new JTextArea((String) blocks.get(5));
        b6.setBackground(Color.MAGENTA);
        JTextArea b7=new JTextArea((String) blocks.get(6));
        b7.setBackground(Color.DARK_GRAY);
        JTextArea b8=new JTextArea((String) blocks.get(7));
        b8.setBackground(Color.YELLOW);
        JTextArea b9=new JTextArea((String) blocks.get(8));
        b9.setBackground(Color.ORANGE);
        JTextArea b10=new JTextArea((String) blocks.get(9));
        b10.setBackground(Color.white);
        JTextArea b11=new JTextArea((String) blocks.get(10));
        b11.setBackground(Color.gray);
        JTextArea b12=new JTextArea((String) blocks.get(11));
        b12.setBackground(Color.PINK);
        JTextArea b13=new JTextArea((String) blocks.get(12));
        b13.setBackground(Color.lightGray);
        JTextArea b14=new JTextArea((String) blocks.get(13));
        b14.setBackground(Color.cyan);
        JTextArea b15=new JTextArea((String) blocks.get(14));
        b15.setBackground(Color.orange);
        JTextArea b16=new JTextArea((String) blocks.get(15));
        b16.setBackground(Color.green);
        // b16.setForeground(Color.green);
        /*
        JTextArea b17=new JTextArea((String) blocks.get(16));
        JTextArea b18=new JTextArea((String) blocks.get(17));
        JTextArea b19=new JTextArea((String) blocks.get(18));
        JTextArea b20=new JTextArea((String) blocks.get(19));
        JTextArea b21=new JTextArea((String) blocks.get(20));
        JTextArea b22=new JTextArea((String) blocks.get(21));
        JTextArea b23=new JTextArea((String) blocks.get(22));
        JTextArea b24=new JTextArea((String) blocks.get(23));
        JTextArea b25=new JTextArea((String) blocks.get(24));
        JTextArea b26=new JTextArea((String) blocks.get(25));
        JTextArea b27=new JTextArea((String) blocks.get(26));
        JTextArea b28=new JTextArea((String) blocks.get(27));
        JTextArea b29=new JTextArea((String) blocks.get(28));
        JTextArea b30=new JTextArea((String) blocks.get(29));
        JTextArea b31=new JTextArea((String) blocks.get(30));
        JTextArea b32=new JTextArea((String) blocks.get(31));

         */


        window.add(b1); window.add(b2); window.add(b3);
        window.add(b4); window.add(b5); window.add(b6);
        window.add(b7); window.add(b8);window.add(b9); window.add(b10); window.add(b11);
        window.add(b12); window.add(b13); window.add(b14);
        window.add(b15); window.add(b16);

        window.setLayout(new GridLayout(4,4));
        window.setSize(300,600);
        window.setVisible(true);

    }
}
