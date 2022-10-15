package dev.logchange.eir.shared;

public class FileNotSupportedException extends RuntimeException {
    public FileNotSupportedException(String fileName) {
        super(fileName);
    }
}
