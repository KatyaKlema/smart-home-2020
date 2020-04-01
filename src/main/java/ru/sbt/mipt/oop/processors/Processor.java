package ru.sbt.mipt.oop.processors;
import ru.sbt.mipt.oop.events.SensorEvent;

public interface Processor{
    public void processing(SensorEvent event);
}
