package ru.sbt.mipt.oop.events;


import ru.sbt.mipt.oop.data_builder.RandomData;

public class RandomEventGenerate implements RandomData<SensorEvent> {
    public SensorEvent randomizeData(){
        Double randomNumber = Math.random();
        if (randomNumber < 0.05)
            return null; // null means end of event stream
        SensorEventType sensorEventType;

        if(4 * randomNumber % 2 == 0)
            sensorEventType =  SensorEventType.values()[(int) (4 * randomNumber) % 2];
        else
            sensorEventType = SensorEventType.values()[(int) (4 * randomNumber) % 2];

        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
