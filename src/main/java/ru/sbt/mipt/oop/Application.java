package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.ControlService;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static ControlService controlService;
    public Application(ControlService controlService){
        this.controlService = controlService;
    }
    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        JSONData tempJSON = new JSONData("smart-home-1.js");
        Gson gson = new Gson();
        SmartHome smartHome = gson.fromJson(tempJSON.getData(), SmartHome.class);
        smartHome.setAlarm(new Alarm(2));

        //Homework 3
        TriggerAlarmEventProcessor triggerAlarmEventProcessorLight = new TriggerAlarmEventProcessor(smartHome, new LightEventProcessor(smartHome));
        TriggerAlarmEventProcessor triggerAlarmEventProcessorDoor = new TriggerAlarmEventProcessor(smartHome, new DoorEventProcessor(smartHome));


        // начинаем цикл обработки событий
        Event event = new Event();
        List<Processor> processors = Arrays.asList(new LightEventProcessor(smartHome), new DoorEventProcessor(smartHome));
        SmartHomeHandler smartHomeHandler = new SmartHomeHandler(smartHome, event, processors);
        smartHomeHandler.runCycleForEvent();

        AdaptController adaptController1 = new AdaptController(1);
        AdaptController adaptController2 = new AdaptController(2);

        controlService.registerAdaptController(adaptController1, new Integer(adaptController1.getId()).toString());
        controlService.registerAdaptController(adaptController2, new Integer(adaptController2.getId()).toString());
    }
}
