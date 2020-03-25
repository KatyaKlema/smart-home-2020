package ru.sbt.mipt.oop;

public class Button {
    private String id;
    private Instruction instruction;

    public Button(String id){
        this.id = id;
        this.instruction =new Nothing();
    }
    public void setInstruction(Instruction instruction){
        this.instruction = instruction;
    }
    public void press(){
        instruction.execute();
    }
}
