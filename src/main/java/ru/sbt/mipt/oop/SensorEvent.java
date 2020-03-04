package ru.sbt.mipt.oop;

public class SensorEvent {
    private final SensorEventTypeDoor typeDoor;
    private final SensorEventTypeLight typeLight;
    private final String objectId;

    public SensorEvent(SensorEventTypeDoor _typeDoor, SensorEventTypeLight _typeLight, String objectId) {
        this.typeDoor = _typeDoor;
        this.typeLight = _typeLight;
        this.objectId = objectId;
    }

    public SensorEventTypeLight getTypeLight() {
        return typeLight;
    }

    public SensorEventTypeDoor getTypeDoor(){
        return typeDoor;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {

        return "SensorEvent{" +
                "type=" + (typeDoor == null ? typeLight : typeDoor) +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
