package org.example.auxiliary;

import java.util.function.Supplier;

public class CustomAssertionErrorFactory {

    public static Supplier todoNotFoundError(String name) {
        return () -> new AssertionError("Todo not exists on page: " + name);
    }
}
