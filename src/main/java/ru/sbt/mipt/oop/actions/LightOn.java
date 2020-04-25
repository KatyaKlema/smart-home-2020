package ru.sbt.mipt.oop.actions;


import ru.sbt.mipt.oop.home_components.Light;

public class LightOn implements Action {
    @Override
    public void execute(Object object) {
        if(object instanceof Light){
            Light light = (Light) object;
            light.setOn(true);
        }
    }
}
