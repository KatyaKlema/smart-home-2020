package ru.sbt.mipt.oop.remote;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import rc.RemoteControl;
import ru.sbt.mipt.oop.button.Button;
public class RemoteController implements RemoteControl {
    private final String[] buttons = { "1", "2", "3", "4","A", "B", "C", "D"};
    private String rcId;
    private Map<String, Button> buttonMap= new HashMap<>();

    public RemoteController(String rcId){
        this.rcId = rcId;
        for (String buttonId : buttons) {
            buttonMap.put(buttonId, new Button(buttonId));
        }
    }

    public String getId(){
        return this.rcId;
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        if(buttonMap.get(buttonCode) != null) {
            Button button = buttonMap.get(buttonCode);
            button.press();
        }
        else {
            System.out.println("It is not existed button");
        }
    }
}
