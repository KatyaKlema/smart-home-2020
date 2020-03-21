package ru.sbt.mipt.oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSON implements Data<String>{
    private String jsonStr;

    public JSON(){
        jsonStr = "";
    }

    public JSON(String addr) throws IOException {
        jsonStr = new String(Files.readAllBytes(Paths.get(addr)));
    }

    public void JSONLoader(String addr) throws IOException {
        jsonStr = new String(Files.readAllBytes(Paths.get(addr)));
    }
    //getJSON
    public String getData(){
        return jsonStr;
    }

    //setJSON
    public void writeData(String addr) throws IOException {
        jsonStr = new String(Files.readAllBytes(Paths.get(addr)));
    }

}
