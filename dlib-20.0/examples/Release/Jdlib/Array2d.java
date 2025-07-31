package Jdlib;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

public class Array2d extends DlibCleaner {
    public Array2d(MethodHandle _clr_hlr, MemorySegment _ptr) {
        super(_clr_hlr, _ptr);
    }
}