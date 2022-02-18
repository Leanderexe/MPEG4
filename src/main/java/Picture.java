import org.apache.commons.lang3.time.StopWatch;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Picture {
    StopWatch stopWatch = new StopWatch();
    List Canvas = new ArrayList();

    //##########################################################################
    // Stellen Sie die Auflösung ein (in Pixel), Resolution * Resolution = #Pixel.
    int resolution = 32; // Beispiel Animation = 2, zeigt Schritt für Schritt den Block Motion Compensation Algorithmus.
    //int resolution = 32; //Beispiel Animation = 1, zeigt alle Richtungsvektoren an;
    //int resolution = 256; // Beispiel Animation = 0, zeigt Kompressionsfaktor im Vergleich zur Berechnungsdauer.
    //##########################################################################

    //##########################################################################
    // Stelle Sie die blocksize ein (in Pixel). Es können mehrere Blocksizes in die Liste eingetragen werden.
    Integer[] blocksizelist = {8, 16, 32};  // Beispiel Animation = 2, zeigt Schritt für Schritt den Block Motion Compensation Algorithmus.
    //Integer[] blocksizelist = {8, 16}; // Beispiel Animation = 1, zeigt alle Richtungsvektoren an;
    //Integer[] blocksizelist = {2, 4, 8, 16, 32, 64, 128}; // Beispiel Animation = 0, zeigt Kompressionsfaktor im Vergleich zur Berechnungsdauer.
    //##########################################################################

    //##########################################################################
    // Stelle Sie die Anzahl an Frames ein, die die Videosequenz haben soll.
    int frames = 10;
    //##########################################################################

    //##########################################################################
    // Stelle Sie die Geschwindigkeit der Animationselemente ein (in Millisekunden).
    int Geschwindigkeit = 10000;
    //##########################################################################

    //##########################################################################
    // Stelle Sie ein, ob es eine Animation geben soll. 0 = keine Animation, 1 = nur Richtungsvektoren anzeigen, 2 = Schritt für Schritt Animation des BMC.
    int animation = 2; // Beispiel Animation = 2, zeigt Schritt für Schritt den Block Motion Compensation Algorithmus.
    //int animation = 1; // Beispiel Animation = 1, zeigt alle Richtungsvektoren an;
    //int animation = 0; // Beispiel Animation = 0, zeigt Kompressionsfaktoren im Vergleich zur Berechnungsdauer.
    //##########################################################################

    public void build() throws InterruptedException {
        // first Frame.
        build_frames();
        List comp_factor = new ArrayList();
        for (int z = 0; z < blocksizelist.length; z++) {
            Integer blocksize = blocksizelist[z];
            comp_factor.clear();
            stopWatch.reset();
            for (int i = 0; i < frames; i++) {
                if (animation == 0) {
                    if (i == 0){
                        stopWatch.start();
                    }
                    if (i > 0) {
                        String[] bmc = call_bmc(i, blocksize);
                        comp_factor.add(Hits(bmc));
                    }
                    if (i == (frames-1)){
                        stopWatch.stop();
                    }

                } else {
                    String frametype = i + 1 + ". ";
                    String frame = i + ". ";
                    if (i > 0) {
                        String[] bmc = call_bmc(i, blocksize);
                        if (animation == 2) {
                            Animation(bmc, i, blocksize);
                        } else if (animation == 1) {
                            if (bmc[bmc.length - 1].equals("-1")) {
                                String[] block = {String.valueOf(bmc.length - 1), String.valueOf(bmc.length - 1)};  // Old Block, new Block.
                                Window win2 = new Window(resolution, resolution, blocksize);
                                win2.build_blocks(blocksize, resolution, (String[][]) Canvas.get(i - 1), frame, true, block, 0, false, false, bmc, 0);
                                Window win3 = new Window(resolution, resolution, blocksize);
                                win3.build_blocks(blocksize, resolution, (String[][]) Canvas.get(i), frametype, true, block, 1300, true, false, bmc, 0);
                                TimeUnit.MILLISECONDS.sleep(Geschwindigkeit);
                                win2.close_window();
                                win3.close_window();
                            } else {
                                String[] block = {bmc[bmc.length - 1], Integer.toString(bmc.length - 1)};  // Old Block, new Block.
                                Window win2 = new Window(resolution, resolution, blocksize);
                                win2.build_blocks(blocksize, resolution, (String[][]) Canvas.get(i - 1), frame, true, block, 0, false, true, bmc, 0);
                                Window win3 = new Window(resolution, resolution, blocksize);
                                win3.build_blocks(blocksize, resolution, (String[][]) Canvas.get(i), frametype, true, block, 1300, true, true, bmc, 0);
                                TimeUnit.MILLISECONDS.sleep(Geschwindigkeit);
                                win2.close_window();
                                win3.close_window();
                            }
                        }
                        comp_factor.add(Hits(bmc));

                    }

                }
            }
            compression_factor(comp_factor, blocksize);
        }
    }


    public String[] call_bmc(int framenumber, int blocksize){
        MotionCompensation comp = new MotionCompensation(resolution, resolution, blocksize);
        List Blocks1 = comp.build_blocks((String[][]) Canvas.get(framenumber-1));
        List Blocks2 = comp.build_blocks((String[][]) Canvas.get(framenumber));
        String[] compensation = comp.compare_blocks(Blocks1, Blocks2);
        Integer[][] vector = comp.direction_vector(Arrays.asList(compensation));
        for (int i = 0; i < vector.length; i++){
            //System.out.println(Arrays.toString(vector[i]));
        }
        return compensation;
    }

    public int Hits(String[] comp){
        int counter = 0;
        for(int i = 0; i < comp.length; i++){
            if (comp[i].equals("-1")){
            }
            else{
                counter += 1;
            }
        }
        return counter;
    }

    public void Animation(String[] bmc, int i, int blocksize) throws InterruptedException {
        String frametype = i + 1 + ". ";
        String frame = i + ". ";
        for (int k = 0; k < bmc.length; k++){
            for (int j = 0; j < bmc.length; j++) {
                if (bmc[k].equals(Integer.toString(j))) {
                    String[] block = {bmc[k], Integer.toString(k)};  // Old Block, new Block.
                    Window win2 = new Window(resolution, resolution, blocksize);
                    win2.build_blocks(blocksize, resolution, (String[][]) Canvas.get(i - 1), frame, true, block, 0, false, true, bmc, 1);
                    Window win3 = new Window(resolution, resolution, blocksize);
                    win3.build_blocks(blocksize, resolution, (String[][]) Canvas.get(i), frametype, true, block, 1300, true, true, bmc, 1);
                    TimeUnit.MILLISECONDS.sleep(Geschwindigkeit * 3);
                    win2.close_window();
                    win3.close_window();
                    break;
                } else {
                    String[] block = {String.valueOf(j), String.valueOf(k)};  // Old Block, new Block.
                    Window win2 = new Window(resolution, resolution, blocksize);
                    win2.build_blocks(blocksize, resolution, (String[][]) Canvas.get(i - 1), frame, true, block, 0, false, false, bmc, 1);
                    Window win3 = new Window(resolution, resolution, blocksize);
                    win3.build_blocks(blocksize, resolution, (String[][]) Canvas.get(i), frametype, true, block, 1300, true, false, bmc, 1);
                    TimeUnit.MILLISECONDS.sleep(Geschwindigkeit);
                    win2.close_window();
                    win3.close_window();
                }
            }
        }
    }

    public Integer compression_factor(List comp_factor, int blocksize){
        int block_hits = 0;
        for (int i = 0; i < comp_factor.size(); i++){
            block_hits += (Integer)comp_factor.get(i);
        }
        //win.build_blocks(blocksize, 32, c.get_Canvas(), "Intra", false, null, 0, false, false, null);
        System.out.println("###################################### Blockgröße: " + blocksize + " ######################################");
        System.out.println("Anzahl an durch Motion Compensation komprimierte Blöcken: " + block_hits + " von " + (resolution/blocksize)*(resolution/blocksize)*frames + " Blöcken");
        if (block_hits == 0){
            System.out.println("Kompremierungsfaktor: " +  0);
        }
        System.out.println("Kompressionsfaktor: " +  (double)block_hits/((resolution/blocksize)*(resolution/blocksize)*frames));
        if (animation == 0){
            System.out.println("Die Kompression hat "+ stopWatch.getTime(TimeUnit.MINUTES) + "m " + stopWatch.getTime(TimeUnit.SECONDS) + "s " +  stopWatch.getTime(TimeUnit.MILLISECONDS) + "ms gedauert.");

        }
        System.out.println("############################################################################################");
        System.out.println();
        return block_hits;
    }

    public void build_frames() {
        for (int i = 0; i < frames; i++) {
            double random_int1 = new Random().nextInt(2) - 1; // Create a random integer number between -1 and 0.
            double random_int2 = new Random().nextInt(2) - 1;
            double random_int3 = new Random().nextInt(2) - 1;
            double random_int4 = new Random().nextInt(2) - 1;
            double random = new Random().nextDouble() + random_int1; // Creates a random number between -1 and 1.
            double random2 = new Random().nextDouble() + random_int2;
            double random3 = new Random().nextDouble() + random_int3;
            double random4 = new Random().nextDouble() + random_int4;
            VideoFrame c = new VideoFrame(resolution, resolution, "+");
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
        }
    }


    public void print_frames(int i, int blocksize) throws InterruptedException {
        Window win = new Window(resolution, resolution, blocksize);
        String frametype = i + 1 + ". ";
        String frame = i + ". ";
        if (i % 2 == 0) {
            win.build_blocks(blocksize, resolution, (String[][]) Canvas.get(i), frametype, false, null, 0, false, false, null, 1);
        } else {
            win.build_blocks(blocksize, resolution, (String[][]) Canvas.get(i), frametype, false, null, 1300, true, false, null, 1);
        }
        TimeUnit.MILLISECONDS.sleep(Geschwindigkeit);
        win.close_window();
    }
}
