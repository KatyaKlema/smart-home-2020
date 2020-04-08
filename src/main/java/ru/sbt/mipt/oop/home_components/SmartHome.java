package ru.sbt.mipt.oop.home_components;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.actionable.Actionable;
import ru.sbt.mipt.oop.actions.Action;
import ru.sbt.mipt.oop.alarm.Alarm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    Collection<Room> rooms;
    Alarm alarm;

    public SmartHome() {
        this.rooms = new ArrayList<>();
        this.alarm = null;
    }

    public SmartHome(Collection<Room> rooms, Alarm alarm) {
        this.rooms = rooms;
        this.alarm = alarm;
    }

    public void setRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public Alarm getAlarm(){
        return this.alarm;
    }

    public void setAlarm(Alarm alarm){
        this.alarm = alarm;
    }


    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
