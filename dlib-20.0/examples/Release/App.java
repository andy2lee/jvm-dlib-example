import java.util.Scanner;
import Jdlib.Dlib;

public class App {
    public static void main(String[] args) {
        var img_name = "images.jpg";
        face_detection_app(img_name);
        // System.gc();
    }

    public static void face_detection_app(String img_name) {
        var detector = Dlib.get_frontal_face_detector();
        var win = Dlib.image_window();
        var img = Dlib.array2d();
        Dlib.load_image(img, img_name);
        Dlib.pyramid_up(img);
        var dets = detector.apply(img);
        var det_size = dets.size();
        System.out.printf("face nums: %d\n", det_size);
        win.clear_overlay();
        win.set_image(img);
        win.add_overlay(dets, Dlib.rgb_pixel(255, 0, 0));
        // push enter to close apps
        new Scanner(System.in).nextLine();
    }
}
