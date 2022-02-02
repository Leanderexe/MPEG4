import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Picture {

    public void build(){
        // first Frame.
        for (int i = 0; i < 10; i++) {
            double random = new Random().nextDouble();
            double random2 = new Random().nextDouble();
            VideoFrame c = new VideoFrame(31, 31, "+");
            List array = new ArrayList();
            array.add(random);
            array.add(random2);
            array.add(0.);
            Sphere l = new Sphere(array, 0.5, "A");
            c.attach(l);
            //System.out.print(Color.BLUE_BOLD);
            Window win = new Window();
            win.build_window(c.render());
            //System.out.println(c.render());



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
