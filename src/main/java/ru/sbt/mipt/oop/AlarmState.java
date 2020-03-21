package ru.sbt.mipt.oop;

public abstract class AlarmState {
    protected Alarm alarm;
    protected AlarmStateType alarmStateType;
    public boolean isIgnore = false;

    public abstract void ALARM_ACTIVATE(Integer instruction);
    public abstract void ALARM_DEACTIVATE(Integer instruction);
    public abstract void ALARM_TRIGGER();
    public void ignore(){
        this.isIgnore = true;
    }

    public AlarmStateType getAlarmStateType(){
        return this.alarmStateType;
    }

    public Alarm getAlarm(){
        return this.alarm;
    }

    public boolean isSame(AlarmState otherAlarmState){
        return this.alarm == otherAlarmState.getAlarm() && this.alarmStateType == otherAlarmState.getAlarmStateType();
    }

    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        else if(object instanceof AlarmState){
            AlarmState otherAlarmState = (AlarmState) object;
            return this.isSame(otherAlarmState);
        }
        else {
            return false;
        }
    }

    public boolean isAlarm(){
        if (this.alarm == null) {
            System.out.println("Error: Alarm is empty");
            return false;
        }
        else{
            return true;
        }
    }
}
