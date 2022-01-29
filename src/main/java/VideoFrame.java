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
        List norm_coord_h;
        List norm_coord_w;
        for (int i = 0; i < width; i++) {
            norm_coord_w.add(-1 + norm_w * i);
            }
        for (int i = 0; i < width; i++) {
            norm_coord_h.add(-1 + norm_h * i);
        }



        for (Object i:norm_coord_h){
            for (Object j:norm_coord_w){
                int distance = (Integer.parseInt(j) - toAttach.origin) ** 2 + (i - toAttach.origin[1]) ** 2
            }
        }
        # distance = (j - toAttach.origin[0])**2 + (i - toAttach.origin[1])**2 + (0 - toAttach.origin[2])**2
        distance = (j - toAttach.origin[0]) ** 2 + (i - toAttach.origin[1]) ** 2
        distance = round(math.sqrt(distance), 5)
        if distance < toAttach.radius:
        z = -(j - toAttach.origin[0]) ** 2 - (i - toAttach.origin[1]) ** 2 + toAttach.radius ** 2
        z = math.sqrt(z) + toAttach.origin[2]
        if self.z_Buffer[self.height - norm_coord_h.index(i) - 1][norm_coord_w.index(j)] == "":
        self.z_Buffer[self.height - norm_coord_h.index(i) - 1][norm_coord_w.index(j)] = z
        self.array[self.height - norm_coord_h.index(i) - 1][norm_coord_w.index(j)] = toAttach.color
        elif self.z_Buffer[self.height - norm_coord_h.index(i) - 1][norm_coord_w.index(j)] < z:
        self.z_Buffer[self.height - norm_coord_h.index(i) - 1][norm_coord_w.index(j)] = z
        self.array[self.height - norm_coord_h.index(i) - 1][norm_coord_w.index(j)] = toAttach.color
    }



}

