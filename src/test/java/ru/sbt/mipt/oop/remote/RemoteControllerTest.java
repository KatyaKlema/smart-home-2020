package ru.sbt.mipt.oop.remote;

import org.junit.Test;
import ru.sbt.mipt.oop.LoaderForTest;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm_states.ActiveState;
import ru.sbt.mipt.oop.alarm_states.DeactiveState;
import ru.sbt.mipt.oop.home_components.SmartHome;

import java.io.IOException;

import static org.junit.Assert.*;

public class RemoteControllerTest {
    private RemoteController testRemoteController = new RemoteController("1");
    private SmartHome testSmartHome;
    private SmartHome masterSmartHome;

    @Test
    public void onButtonPressed() throws IOException {

        testSmartHome = LoaderForTest.JSONLoadSmartHome("src/test/resources/sh_doors_open_lights_on.json");
        testRemoteController.smartHomeRemote(testSmartHome);

        testRemoteController.onButtonPressed("3", "3'");
        assertEquals(testSmartHome, LoaderForTest.JSONLoadSmartHome("src/test/resources/sh_hall_door_closed_lights_on.json"));

        testRemoteController.onButtonPressed("2", "1");
        assertEquals(testSmartHome, LoaderForTest.JSONLoadSmartHome("src/test/resources/sh_hall_door_closed_lights_hall_on.json"));


        testRemoteController.onButtonPressed("1", "2");
        assertEquals(testSmartHome, LoaderForTest.JSONLoadSmartHome("src/test/resources/sh_hall_door_closed_lights_off.json"));

        testRemoteController.onButtonPressed("A", "1");
        assertEquals(testSmartHome, LoaderForTest.JSONLoadSmartHome("src/test/resources/sh_hall_door_closed_lights_off.json"));


        testRemoteController.onButtonPressed("4", "7");
        assertEquals(testSmartHome, LoaderForTest.JSONLoadSmartHome("src/test/resources/sh_hall_door_closed_lights_off.json"));

        Alarm alarm = new Alarm(1, new DeactiveState());

        Alarm activeAlarm = new Alarm(1, new ActiveState());
        masterSmartHome.setAlarm(activeAlarm);
        assertEquals(testSmartHome.getAlarm().getAlarmState(), masterSmartHome.getAlarm().getAlarmState());


        testSmartHome.setAlarm(alarm);
        testRemoteController.onButtonPressed("A", "2");
        masterSmartHome = LoaderForTest.JSONLoadSmartHome("src/test/resources/sh_hall_door_closed_lights_off.json");

        testRemoteController.onButtonPressed("B", "1");
        masterSmartHome.getAlarm().triggerAlarm();
        assertEquals(testSmartHome, masterSmartHome);
        assertEquals(testSmartHome.getAlarm().getAlarmState(), masterSmartHome.getAlarm().getAlarmState());

        testRemoteController.onButtonPressed("C", "7");
        testRemoteController.onButtonPressed("D", "9");
        assertEquals(testSmartHome, masterSmartHome);
        assertEquals(testSmartHome.getAlarm().getAlarmState(), masterSmartHome.getAlarm().getAlarmState());


    }
}