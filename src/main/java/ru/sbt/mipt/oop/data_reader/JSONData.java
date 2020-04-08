package ru.sbt.mipt.oop.data_reader;


import ru.sbt.mipt.oop.smart_home.SmartHomeData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONData implements SmartHomeData<String> {
    private String jsonStr;

    public JSONData(){
        jsonStr = "";
    }

    public JSONData(String addr) throws IOException {
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
