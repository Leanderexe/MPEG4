import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Picture {
    int heigth = 32;
    int width = 32;
    int blocksize = 8;
    List Canvas = new ArrayList();

    public void build() throws InterruptedException {
        // first Frame.
        for (int i = 0; i < 2; i++) {
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
            Canvas.add(c.get_Canvas());
            //System.out.print(Color.BLUE_BOLD);
            Window win = new Window();
            if (i%2 == 0){
                win.build_blocks(8, 32, c.get_Canvas(), "Intra", false, null, 0);
            }
            else{
                win.build_blocks(8, 32, c.get_Canvas(), "Intra", false, null, 1300);
            }
            TimeUnit.SECONDS.sleep(5);
            //win.build_window(c.render());
            System.out.println(c.render());
            if (i > 0){
                String[] bmc = call_bmc();
                for (int k = 0; k < bmc.length; k++){
                    if (bmc[k].equals("-1")){
                    }
                    else{
                        String[] block = {bmc[k], Integer.toString(k)};  // Old Block, new Block.
                        Window win2 = new Window();
                        win2.build_blocks(8, 32, (String[][]) Canvas.get(0), "Intra", true, block, 0);
                        //TimeUnit.SECONDS.sleep(1);
                        Window win3 = new Window();
                        win3.build_blocks(8, 32, (String[][]) Canvas.get(1), "Predictive", true, block, 1300);
                        TimeUnit.SECONDS.sleep(5);
                    }
                }

            }

            //Scanner in = new Scanner(System.in);
            //String str = in.nextLine();
            /*
            for (int p = 0; p < Canvas.size(); p++){
                VideoFrame vid = (VideoFrame) Canvas.get(p);
                System.out.println("Hellopepe" + vid.render());
            } */
        }
    }


    public String[] call_bmc(){
        MotionCompensation comp = new MotionCompensation(width, heigth, blocksize);
        List Blocks1 = comp.build_blocks((String[][]) Canvas.get(0));
        List Blocks2 = comp.build_blocks((String[][]) Canvas.get(1));
        String[] compensation = comp.compare_blocks(Blocks1, Blocks2);
        Integer[][] vector = comp.direction_vector(Arrays.asList(compensation));
        for (int i = 0; i < vector.length; i++){
            System.out.println(Arrays.toString(vector[i]));
        }
        System.out.println("hihihihi" + Arrays.toString(comp.compare_blocks(Blocks1, Blocks2)));
        return compensation;
    }

}
