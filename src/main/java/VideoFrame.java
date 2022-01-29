import java.util.Arrays;
import java.util.List;

public class VideoFrame {
    int width;
    int height;
    String[][] canvas;
    String background;

    public VideoFrame(int w, int h, String bg){
        width = w;
        height = h;
        background = bg;
        canvas = new String[height][width]; // build up image frames.
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                canvas[i][j] = background;
            }
        }
    }

    public void attach(Sphere toAttach){
        int origin_w = width/2;
        int norm_w = 1/origin_w;
        int origin_h = height/2;
        int norm_h = 1/origin_h;
        int[] norm_coord_h = new int[height];
        int[] norm_coord_w = new int[width];
        for (int i = 0; i < width; i++) {
            norm_coord_w[i] = (-1 + norm_w * i);
            }
        for (int i = 0; i < height; i++) {
            norm_coord_h[i] = (-1 + norm_h * i);
        }



        for (Object i:norm_coord_h){
            for (Object j:norm_coord_w){
                double distance = Math.pow((int) j - (int) toAttach.origin.get(0), 2) + Math.pow((int) i - (int) toAttach.origin.get(1), 2);
                distance = Math.sqrt(distance);
                if (distance < toAttach.radius){
                    canvas[height - Arrays.asList(norm_coord_h).indexOf(i) - 1][Arrays.asList(norm_coord_w).indexOf(j)] = toAttach.color;
                }
            }
        }
    }

    public String render(){
        String output = "";
        String line = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                    line = line + canvas[i][j];
                }
                else{
                    line = line + " " + canvas[i][j];
                }

            }
            output += line + "\n";
            line = "";
        }
        return output;
    }



}

