import java.util.ArrayList;
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
        double origin_w = width/2;
        double norm_w = 1/origin_w;
        double origin_h = height/2;
        double norm_h = 1/origin_h;
        List norm_coord_h = new ArrayList();
        List norm_coord_w = new ArrayList();
        for (int i = 0; i < width; i++) {
            norm_coord_w.add((-1 + norm_w * i) * 1.0);
            }
        for (int i = 0; i < height; i++) {
            norm_coord_h.add((-1 + norm_h * i) * 1.0);
        }



        for (Object i:norm_coord_h){
            for (Object j:norm_coord_w){
                //System.out.println(i + ", " + j + ", "  + toAttach.origin.get(0) + ", " + toAttach.origin.get(1));
                double distance = Math.pow((double) j - (double) toAttach.origin.get(0), 2) + Math.pow((double) i - (double) toAttach.origin.get(1), 2);
                distance = Math.round(Math.sqrt(distance) * 100000d) / 100000d; // Rounding the number to 5 digits.
                //System.out.println(distance);
                if (distance < toAttach.radius){
                    canvas[height - norm_coord_h.indexOf(i) - 1][norm_coord_w.indexOf(j)] = toAttach.color;
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

