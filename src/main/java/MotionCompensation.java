import java.util.ArrayList;
import java.util.List;

public class MotionCompensation {
    int heigth;
    int width;
    int blocksize;
    int number_of_blocks;

    public MotionCompensation(int w, int h,int blocksz){
        heigth = h;
        width = w;
        blocksize = blocksz;
        number_of_blocks = heigth/blocksize;
    }

    public List build_blocks(String[][] canvas){
        List Blocks = new ArrayList();
        for (int i = 0; i < number_of_blocks; i++) {
            for (int p = 0; p < number_of_blocks; p++) {
                String Block = "";
                for (int j = blocksize * i; j < blocksize * i + blocksize; j++) {
                    for (int n = blocksize * p; n < blocksize * p + blocksize; n++) {
                        //System.out.println("hihihihgffffffffffffffffffff");
                        Block += canvas[j][n];
                    }
                    Block += "\n";
                }
                Blocks.add(Block);
                //System.out.println(Block);
            }
        }
        //System.out.println(canvas.toString());
        //System.out.println(Blocks);
        //build_blocks(Blocks, frametype);
        return Blocks;
    }

    public String[] compare_blocks(List prev_blocks, List new_blocks){
        String[] compensation = new String[new_blocks.size()]; // If the previous frame has a Block that is equal to a block in the next frame, the position of that block in the previous frame will be stored at the position of the block in the new frame.  If a block is not in the previous frame -1 will be added to the list.
        for (int i = 0; i < new_blocks.size(); i++){
            compensation[i] = "-1";
            for (int j= 0; j < prev_blocks.size(); j++){
                if(new_blocks.get(i).equals(prev_blocks.get(j))){
                    compensation[i] = String.valueOf(j);
                    j = new_blocks.size(); // break the loop.
            }
            }
        }
        return compensation;

    }

    public Integer[][] direction_vector(List comp){
        Integer[][] vector = new Integer[comp.size()][2];
        for(int i = 0; i < comp.size(); i++){
            if (comp.get(i).equals("-1")){
                Integer[] novec = {-1337, -1337};
                vector[i] = novec;
            }
            else{
                int x_new = i % number_of_blocks; // Formel zur Berechnung der Position des nten-Blocks:  n : 4 = y Rest x
                int y_new = i / number_of_blocks;
                //System.out.println(x_new + ", " + y_new);

                int x_old = Integer.parseInt((String) comp.get(i)) % number_of_blocks; // Formel zur Berechnung der Position des nten-Blocks: n : 4 = y Rest x
                int y_old = Integer.parseInt((String) comp.get(i)) / number_of_blocks;

                //System.out.println(x_old + ", " + y_old);

                Integer[] vec = {x_new - x_old, y_new - y_old};
                vector[i] = vec;
            }
        }
        return vector;
    }

}
