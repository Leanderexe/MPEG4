import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Picture {

    public void build(){
        // first Frame.
        for (int i = 0; i < 10; i++) {
            List Canvas = new ArrayList();
            double random_int1 = new Random().nextInt(2) - 1; // Create a random integer number between -1 and 0.
            double random_int2 = new Random().nextInt(2) - 1;
            double random_int3 = new Random().nextInt(2) - 1;
            double random_int4 = new Random().nextInt(2) - 1;
            double random = new Random().nextDouble() + random_int1; // Creates a random number between -1 and 1.
            double random2 = new Random().nextDouble() + random_int2;
            double random3 = new Random().nextDouble() + random_int3;
            double random4 = new Random().nextDouble() + random_int4;
            VideoFrame c = new VideoFrame(32, 32, "+");
            List array = new ArrayList();
            array.add(random);
            array.add(random2);
            array.add(0.);
            List array2 = new ArrayList();
            array2.add(random3);
            array2.add(random4);
            array2.add(0.);
            Sphere l = new Sphere(array, 0.5, "A");
            Sphere l2 = new Sphere(array2, 0.7, "B");
            c.attach(l);
            c.attach(l2);
            //System.out.print(Color.BLUE_BOLD);
            Window win = new Window();
            win.build_blocks(8, 32, c.get_Canvas(), "P");
            Canvas.add(c);
            //win.build_window(c.render());
            System.out.println(c.render());
            //Scanner in = new Scanner(System.in);
            //String str = in.nextLine();
            /*
            for (int p = 0; p < Canvas.size(); p++){
                VideoFrame vid = (VideoFrame) Canvas.get(p);
                System.out.println("Hellopepe" + vid.render());
            } */
        }

        // second Frame.
        VideoFrame c2 = new VideoFrame(31,31, "+");
        List array2 = new ArrayList();
        array2.add(-0.5);
        array2.add(-0.5);
        array2.add(0.);
        Sphere l2 = new Sphere(array2, 0.5, "A");
        c2.attach(l2);
        System.out.print(Colors.BLUE_BOLD);
        System.out.println(c2.render());
    }

}
