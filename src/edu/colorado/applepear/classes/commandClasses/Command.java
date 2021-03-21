package edu.colorado.applepear.classes.commandClasses;

public interface Command {
    public void execute();
    public default void redo(){ System.out.println("Redo your last action!"); }
    public default void undo(){
        System.out.println("Undo your last action!");
    }

}
