package Jdlib;

import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

public class rgb_pixel extends DlibCleaner {
    public rgb_pixel(MethodHandle _clr_hlr, MemorySegment _ptr) {
        super(_clr_hlr, _ptr);
    }
}
