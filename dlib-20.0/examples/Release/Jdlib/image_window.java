package Jdlib;

import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

public class image_window extends DlibCleaner {
    public image_window(MethodHandle _clr_hlr, MemorySegment _ptr) {
        super(_clr_hlr, _ptr);
    }

    public void clear_overlay() {
        try {
            Dlib.dlib_image_window_clear_overlay_hdlr.invoke(ptr_addr);
        } catch (Throwable e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void set_image(Array2d arr2d) {
        try {
            Dlib.dlib_image_window_set_image_hdlr.invoke(ptr_addr, arr2d.na_ptr());
        } catch (Throwable e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void add_overlay(vector_dlib_rectangle vec_rect, rgb_pixel rgb) {
        try {
            Dlib.dlib_image_window_add_overlay_hdlr.invoke(ptr_addr, vec_rect.na_ptr(), rgb.na_ptr());
        } catch (Throwable e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}