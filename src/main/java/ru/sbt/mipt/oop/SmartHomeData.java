package ru.sbt.mipt.oop;

import java.io.IOException;

public interface SmartHomeData<T> {
    public T getData() throws IOException;

    public void writeData(String addr) throws IOException;
}
