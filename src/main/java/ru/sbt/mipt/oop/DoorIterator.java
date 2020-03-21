package ru.sbt.mipt.oop;

public class DoorIterator implements Iterator<Event> {
    SmartHome smartHome;
    DoorIterator(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    @Override
    public void iterate(Event event) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getEvent().getObjectId())) {
                    DoorInformation doorInformation = new DoorInformation();
                    doorInformation.toggleDoorLight(event, door, smartHome, room);
                }
            }
        }
    }
}
