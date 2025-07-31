package Jdlib;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

public class Dlib {
    public static final Linker linker = Linker.nativeLinker();
    public static final Arena arena = Arena.ofShared();
    public static SymbolLookup lookup = null;
    public static MethodHandle dlib_get_frontal_face_detector_hdlr = null;
    public static MethodHandle dlib_get_frontal_face_detector_del_hdlr = null;
    public static MethodHandle dlib_image_window_hdlr = null;
    public static MethodHandle dlib_image_window_del_hdlr = null;
    public static MethodHandle dlib_array2d_hdlr = null;
    public static MethodHandle dlib_array2d_del_hdlr = null;
    public static MethodHandle dlib_load_image_hdlr = null;
    public static MethodHandle dlib_pyramid_up_hdlr = null;
    public static MethodHandle dlib_detector_dets_hdlr = null;
    public static MethodHandle dlib_detector_dets_del_hdlr = null;
    public static MethodHandle dlib_dector_dets_size_hdlr = null;
    public static MethodHandle dlib_image_window_clear_overlay_hdlr = null;
    public static MethodHandle dlib_image_window_set_image_hdlr = null;
    public static MethodHandle dlib_image_window_add_overlay_hdlr = null;
    public static MethodHandle dlib_rgb_pixel_hdlr = null;
    public static MethodHandle dlib_rgb_pixel_del_hdlr = null;

    static {
        try {
            lookup = SymbolLookup.libraryLookup("dlibintf", arena);
            dlib_get_frontal_face_detector_hdlr = linker.downcallHandle(
                lookup.find("dlib_get_frontal_face_detector").orElseThrow(),
                FunctionDescriptor.of(ValueLayout.ADDRESS));
            
            dlib_get_frontal_face_detector_del_hdlr = linker.downcallHandle(
                lookup.find("dlib_get_frontal_face_detector_del").orElseThrow(),
                FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));

            dlib_image_window_hdlr = linker.downcallHandle(
                lookup.find("dlib_image_window").orElseThrow(),
                FunctionDescriptor.of(ValueLayout.ADDRESS));

            dlib_image_window_del_hdlr = linker.downcallHandle(
                lookup.find("dlib_image_window_del").orElseThrow(),
                FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));

            dlib_array2d_hdlr = linker.downcallHandle(
                 lookup.find("dlib_array2d").orElseThrow(),
                 FunctionDescriptor.of(ValueLayout.ADDRESS));

            dlib_array2d_del_hdlr = linker.downcallHandle(
                 lookup.find("dlib_array2d_del").orElseThrow(),
                 FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));

            dlib_load_image_hdlr = linker.downcallHandle(
                 lookup.find("dlib_load_image").orElseThrow(),
                 FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS));

            dlib_pyramid_up_hdlr = linker.downcallHandle(
                 lookup.find("dlib_pyramid_up").orElseThrow(),
                 FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));

            dlib_detector_dets_hdlr = linker.downcallHandle(
                 lookup.find("dlib_detector_dets").orElseThrow(),
                 FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));

            dlib_detector_dets_del_hdlr = linker.downcallHandle(
                 lookup.find("dlib_detector_dets_del").orElseThrow(),
                 FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));

            dlib_dector_dets_size_hdlr = linker.downcallHandle(
                 lookup.find("dlib_dector_dets_size").orElseThrow(),
                 FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));

            dlib_image_window_clear_overlay_hdlr = linker.downcallHandle(
                 lookup.find("dlib_image_window_clear_overlay").orElseThrow(),
                 FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));

            dlib_image_window_set_image_hdlr = linker.downcallHandle(
                 lookup.find("dlib_image_window_set_image").orElseThrow(),
                 FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS));

            dlib_image_window_add_overlay_hdlr = linker.downcallHandle(
                 lookup.find("dlib_image_window_add_overlay").orElseThrow(),
                 FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));

            dlib_rgb_pixel_hdlr = linker.downcallHandle(
                 lookup.find("dlib_rgb_pixel").orElseThrow(),
                 FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            
            dlib_rgb_pixel_del_hdlr = linker.downcallHandle(
                 lookup.find("dlib_rgb_pixel_del").orElseThrow(),
                 FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
        
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    public static frontal_face_detector get_frontal_face_detector() {
        try {
            return new frontal_face_detector(dlib_get_frontal_face_detector_del_hdlr, (MemorySegment) dlib_get_frontal_face_detector_hdlr.invoke());
        } catch (Throwable e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    public static image_window image_window() {
        try {
            return new image_window(dlib_image_window_del_hdlr, (MemorySegment) dlib_image_window_hdlr.invoke());
        } catch (Throwable e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    public static Array2d array2d() {
        try {
            return new Array2d(dlib_array2d_del_hdlr, (MemorySegment) dlib_array2d_hdlr.invoke());
        } catch (Throwable e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    public static void load_image(Array2d arr2d, String argv) {
        try {
            dlib_load_image_hdlr.invoke(arr2d.na_ptr(), arena.allocateFrom(argv));
        } catch (Throwable e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void pyramid_up(Array2d arr2d) {
        try {
            dlib_pyramid_up_hdlr.invoke(arr2d.na_ptr());
        } catch (Throwable e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static rgb_pixel rgb_pixel(int r, int g, int b) {
        try {
            return new rgb_pixel(dlib_rgb_pixel_del_hdlr, (MemorySegment)dlib_rgb_pixel_hdlr.invoke(r, g, b));
        } catch (Throwable e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
}
