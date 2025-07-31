package Jdlib;

import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

public class vector_dlib_rectangle extends DlibCleaner {
    public vector_dlib_rectangle(MethodHandle _clr_hlr, MemorySegment _ptr) {
        super(_clr_hlr, _ptr);
    }

    public int size() {
        try {
            return (int) Dlib.dlib_dector_dets_size_hdlr.invoke(ptr_addr);
        } catch(Throwable e) {
            e.printStackTrace();
        }
        return -1;
    }
}
