package ru.sbt.mipt.oop;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class AdaptController implements RemoteController {
    private final String[] buttons = { "1", "2", "3", "4","A", "B", "C", "D"};
    private int id;
    private Map<String, Button> buttonMap= new HashMap<>();
    public AdaptController(int id){
        this.id = id;
        for (String buttonId : buttons) {
            buttonMap.put(buttonId, new Button(buttonId));
        }
    }

    public int getId(){
        return this.id;
    }

    @Override
    public void pressButton(String buttonId) {
        if(buttonMap.get(buttonId) != null) {
            Button button = buttonMap.get(buttonId);
            button.press();
        }
        else {
            System.out.println("It is not existed button");
        }
    }
}
