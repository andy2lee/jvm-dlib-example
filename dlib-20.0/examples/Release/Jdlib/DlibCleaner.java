package Jdlib;

import java.lang.ref.Cleaner;
import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

public class DlibCleaner {
    private static final Cleaner cleaner = Cleaner.create();
    private final Cleaner.Cleanable cleanable;
    protected MemorySegment ptr_addr;
    
    private static class clean_state implements Runnable {
        private MemorySegment ptr = null;
        private MethodHandle clr_hlr = null;

        public clean_state(MethodHandle _clr_hlr, MemorySegment _ptr) {
            clr_hlr = _clr_hlr;
            ptr = _ptr;
        }
        @Override
        public void run() {
            if (clr_hlr == null) {
                return;
            }
            try {
                clr_hlr.invoke(ptr);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    

    public DlibCleaner(MethodHandle _clr_hlr, MemorySegment _ptr) {
        ptr_addr = _ptr;
        this.cleanable = cleaner.register(this, new clean_state(_clr_hlr, _ptr));
    }

    public void close() {
        cleanable.clean();
    }

    public MemorySegment na_ptr() {
        return ptr_addr;
    }
}

