
package com.leeeryu.io;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import java.io.*;
import java.util.List;

public class DataReader {
    private ObjectMapper mapper;

    public DataReader() {
        this.mapper = new ObjectMapper();
    }

    public void readToConsole(byte[] data) throws IllegalArgumentException, IOException {
        readToWrite(data, "console", null);
    }
    public File readToFile(byte[] data, String filePath) {
        try {
            readToWrite(data, "file", filePath);

            return new File(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public <T> T readToObject(byte[] data, Class<T> returnType) throws IOException {
        if ((data == null || data.length == 0) ||
                (returnType == null)) {
            throw new IllegalArgumentException("data or clazz is not valid");
        }

        return this.mapper.readValue(data, this.mapper.getTypeFactory().constructType(returnType));
    }
    public <T> List<T> readToList(byte[] data, Class<T> returnType) throws IOException {
        final JavaType type = this.mapper.getTypeFactory().constructCollectionType(List.class,
                returnType);

        return this.mapper.readValue(data, type);
    }
    /**
     *
     * @param data
     * @param outputType
     * @param filePath
     * @throws IOException
     */
    private void readToWrite(byte[] data, String outputType, String filePath) throws IOException {
        if ((data == null || data.length == 0) ||
                (outputType == null || outputType.length() == 0)) {
            throw new IllegalArgumentException("data or outputType is not valid");
        }

        try (DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
            DataOutputStream dos = new DataOutputStream(DataTypeFactory.getTypeFactory(outputType, filePath)
                    .getOutputStream())) {

            byte[] buffer = new byte[1024 * 8];
            int length;

            try (BufferedOutputStream bos = new BufferedOutputStream(dos)) {
                while ((length = dis.read(buffer)) != -1) {
                    bos.write(buffer, 0, length);
                }
            }
        }
    }
}
