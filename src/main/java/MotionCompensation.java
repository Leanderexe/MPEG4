import java.util.ArrayList;
import java.util.List;

public class MotionCompensation {
    int heigth;
    int width;
    int blocksize;

    public MotionCompensation(int w, int h,int blocksz){
        heigth = h;
        width = w;
        blocksize = blocksz;
    }

    public List build_blocks(String[][] canvas){
        List Blocks = new ArrayList();
        for (int i = 0; i < 4; i++) {
            for (int p = 0; p < 4; p++) {
                String Block = "";
                for (int j = 8 * i; j < 8 * i + blocksize; j++) {
                    for (int n = 8 * p; n < 8 * p + blocksize; n++) {
                        //System.out.println("hihihihgffffffffffffffffffff");
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
}
