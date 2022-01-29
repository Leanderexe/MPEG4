import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import org.opencv.core.Mat;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.opencv.imgcodecs.Imgcodecs.imread;

public class Main {


    public static void main(String[] args) {

        VideoFrame c = new VideoFrame(31,11, "+");
        List array = Collections.singletonList(new double[]{0., -0.5, 0.});
        Sphere l = new Sphere(array, 0.5, "A");
        c.attach(l);
        System.out.println(c.render());
    }
}