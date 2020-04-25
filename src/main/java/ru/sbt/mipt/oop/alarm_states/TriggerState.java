package ru.sbt.mipt.oop.alarm_states;

import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlarmState;
import ru.sbt.mipt.oop.alarm.AlarmStateType;

public class TriggerState extends AlarmState {
    public TriggerState(Alarm alarm){
        this.alarmStateType = AlarmStateType.TRIGGER;
        this.alarm = alarm;
    }

    @Override
    public void alarmActivate(Integer code) {
        if (isAlarm()) {
            Alarm tempAlarm = new Alarm(code);
            alarm.setAlarmState(tempAlarm, new ActiveState(alarm));
        }
    }

    @Override
    public void alarmDeactivate(Integer code) {
        if (isAlarm()) {
            System.out.print("The Alarm is deactivated");
        }
    }

    @Override
    public void alarmTrigger() {
        if (isAlarm()) {
            System.out.println("Already the Alarm has been triggered");
        }
    }
}
