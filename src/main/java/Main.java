import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        int resolution = Integer.parseInt(args[0]);
        int frames = Integer.parseInt(args[1]);
        int Geschwindigkeit = Integer.parseInt(args[2]);
        int animation = Integer.parseInt(args[3]);
        ArrayList<Integer> blocksizelist = new ArrayList<>();
        for (int i = 4; i < args.length; i++){
             blocksizelist.add(Integer.parseInt(args[i]));
        }
        Picture pic = new Picture(resolution, frames, Geschwindigkeit, animation, blocksizelist);
        pic.build();
    }
}