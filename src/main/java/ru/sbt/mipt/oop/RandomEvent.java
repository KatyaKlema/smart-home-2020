package ru.sbt.mipt.oop;

public class RandomEvent implements RandomData<SensorEvent> {
    public SensorEvent randomData(){
        Double randomNumber = Math.random();
        if (randomNumber < 0.05)
            return null; // null means end of event stream
        SensorEventTypeLight  sensorEventTypeLight = null;
        SensorEventTypeDoor sensorEventTypeDoor = null;

        if(4 * randomNumber % 2 == 0)
            sensorEventTypeLight =  SensorEventTypeLight.values()[(int) (4 * randomNumber) % 2];
        else
            sensorEventTypeDoor = SensorEventTypeDoor.values()[(int) (4 * randomNumber) % 2];

        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventTypeDoor, sensorEventTypeLight, objectId);
    }
}
