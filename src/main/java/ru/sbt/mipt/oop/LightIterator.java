package ru.sbt.mipt.oop;

public class LightIterator implements Iterator<Event> {
    SmartHome smartHome;
    public LightIterator(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    @Override
    public void iterate(Event event) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getEvent().getObjectId())) {
                    PrintLightInformation.printLight(event, light, room);
                }
            }
        }
    }
}
