package ru.sbt.mipt.oop.remote;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import rc.RemoteControl;
import ru.sbt.mipt.oop.button.Button;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.remote_instructions.*;

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
    public void smartHomeRemote(SmartHome smartHome){
        Instruction hallDoorCloseInstruction = new HallDoorCloseInstruction(smartHome);
        Instruction allLightOnInstruction = new AllLightOnInstruction(smartHome);
        Instruction hallLightOnInstruction = new HallLightOnInstruction(smartHome);
        Instruction allLightOffInstruction = new AllLightOffInstruction(smartHome);
        Instruction alarmActivateInstruction = new AlarmActivateInstruction(smartHome, 1);
        Instruction triggerAlarmInstruction = new TriggerAlarmInstruction(smartHome);

        Instruction nothing = new Nothing();

        Instruction[] commands = new Instruction[]{hallDoorCloseInstruction, allLightOnInstruction, hallLightOnInstruction,
                allLightOffInstruction, alarmActivateInstruction, triggerAlarmInstruction};
        //по идее лишняя проверка, но на будущее
        if (commands.length > buttons.length) {
            System.out.println(String.format("your remote can bind only %s commands", buttons.length ));
            return;
        }

        for (int i = 0; i < commands.length; i++) { // остальные копки остануться пустыми
            //по идее лишняя проверка, но на будущее
            if (buttonMap.get(buttons[i]) == null) {
                System.out.println("there is not such button");
                continue;
            }
            buttonMap.get(buttons[i]).setInstruction(commands[i]);
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
