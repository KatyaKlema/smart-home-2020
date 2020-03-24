package ru.sbt.mipt.oop;

public class HallDoorIterator implements Iterator<Room> {
    private SmartHome smartHome;
    public HallDoorIterator(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    @Override
    public void iterate(Room room) {
        for (Room homeRoom : smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                SendCommand sendCommand = new SendCommand(command);
            }
        }
    }
}
