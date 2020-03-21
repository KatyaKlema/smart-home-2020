package ru.sbt.mipt.oop;

import java.io.IOException;

public interface Data<T> {
    public T getData() throws IOException;

    public void writeData(String addr) throws IOException;
}
