package ru.sbt.mipt.oop;

public class ActiveState extends AlarmState {
    public ActiveState(Alarm alarm){
        this.alarmStateType = AlarmStateType.ACTIVE;
        this.alarm = alarm;
    }

    @Override
    public void ALARM_ACTIVATE(Integer code) {
        if(!isIgnore) {
            if (isAlarm()) {
                System.out.println("Already the Alarm has been activated");
            }
        }
    }

    @Override
    public void ALARM_DEACTIVATE(Integer code) {
        if(!isIgnore) {
            if (code.equals(this.alarm.getCode())) {
                alarm.setAlarmState(code, new DeactiveState(alarm));
            } else {
                alarm.setAlarmState(code, new TriggerState(alarm));
                System.out.print("TRIGGER !");
            }
        }
    }

    @Override
    public void ALARM_TRIGGER() {
        if(!isIgnore) {
            if (isAlarm()) {
                alarm.setAlarmState(alarm.getCode(), new TriggerState(alarm));
                System.out.println("TRIGGER !");
            }
        }
    }
}
