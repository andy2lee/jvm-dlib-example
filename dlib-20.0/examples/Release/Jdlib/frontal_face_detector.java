package Jdlib;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

public class frontal_face_detector extends DlibCleaner {
    public frontal_face_detector(MethodHandle _clr_hlr, MemorySegment _ptr) {
        super(_clr_hlr, _ptr);
    }

    public vector_dlib_rectangle apply(Array2d arr_2d) {
        try {
            MemorySegment detector_dets = (MemorySegment)Dlib.dlib_detector_dets_hdlr.invoke(this.ptr_addr, arr_2d.ptr_addr);
            return new vector_dlib_rectangle(Dlib.dlib_detector_dets_del_hdlr, detector_dets);
        } catch (Throwable e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
}
