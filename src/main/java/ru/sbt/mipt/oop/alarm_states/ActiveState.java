package ru.sbt.mipt.oop.alarm_states;

import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlarmState;
import ru.sbt.mipt.oop.alarm.AlarmStateType;

public class ActiveState extends AlarmState {
    public ActiveState(Alarm alarm){
        this.alarmStateType = AlarmStateType.ACTIVE;
        this.alarm = alarm;
    }

    @Override
    public void alarmActivate(Integer code) {
        if(!isIgnore) {
            if (isAlarm()) {
                System.out.println("Already the Alarm has been activated");
            }
        }
    }

    @Override
    public void alarmDeactivate(Integer code) {
        if(!isIgnore) {
            if (alarm.isEqual(code)) {
                alarm.setAlarmState(alarm, new DeactiveState(alarm));
            } else {
                alarm.setAlarmState(alarm, new TriggerState(alarm));
                System.out.print("TRIGGER !");
            }
        }
    }

    @Override
    public void alarmTrigger() {
        if(!isIgnore) {
            if (isAlarm()) {
                alarm.setAlarmState(alarm, new TriggerState(alarm));
                System.out.println("TRIGGER !");
            }
        }
    }
}
