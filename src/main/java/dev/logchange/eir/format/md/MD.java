package dev.logchange.eir.format.md;

public interface MD {
    default String toMD() {
        return toString();
    }
}
