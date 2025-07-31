import java.util.Scanner;
import Jdlib.Dlib;
import Jdlib.Array2d;
import Jdlib.frontal_face_detector;
import Jdlib.image_window;
import Jdlib.rgb_pixel;
import Jdlib.vector_dlib_rectangle;

fun main(args: Array<String>) {
    val img_name = "images.jpg";
    face_detection_app(img_name);
}

fun face_detection_app(img_name: String) {
    val detector = Dlib.get_frontal_face_detector()
    val win = Dlib.image_window()
    val img = Dlib.array2d()
    Dlib.load_image(img, img_name)
    Dlib.pyramid_up(img)
    val dets = detector.apply(img)
    val det_size = dets.size()
    println("face nums: $det_size")
    win.clear_overlay()
    win.set_image(img)
    win.add_overlay(dets, Dlib.rgb_pixel(255, 0, 0))
    readln()
}
