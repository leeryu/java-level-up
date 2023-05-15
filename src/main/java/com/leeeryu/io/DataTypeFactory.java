package com.leeeryu.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Objects;

class DataTypeFactory {
    public static DataType getTypeFactory(String type, String filePath) {
        if (type.equals("file")) {
            return new FileDataType(filePath);
        } else if (type.equals("console")) {
            return new ConsoleDataType();
        } else {
            throw new IllegalArgumentException("type is not valid");
        }
    }
}

interface DataType {
    OutputStream getOutputStream() throws FileNotFoundException;
}

class FileDataType implements DataType {
    private String filePath;

    public FileDataType(String filePath) {
        Objects.requireNonNull(filePath, "filePath is null");
        this.filePath = filePath;
    }

    @Override
    public OutputStream getOutputStream() throws FileNotFoundException {
        return new FileOutputStream(this.filePath);
    }
}

class ConsoleDataType implements DataType {
    @Override
    public OutputStream getOutputStream() {
        return System.out;
    }
}

