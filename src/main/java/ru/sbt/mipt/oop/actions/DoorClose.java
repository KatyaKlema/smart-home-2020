package ru.sbt.mipt.oop.actions;


import ru.sbt.mipt.oop.home_components.Door;

public class DoorClose implements Action {
    @Override
    public void execute(Object object) {
        if(object instanceof Door){
            Door door = (Door) object;
            door.setOpen(false);
        }
    }
}
