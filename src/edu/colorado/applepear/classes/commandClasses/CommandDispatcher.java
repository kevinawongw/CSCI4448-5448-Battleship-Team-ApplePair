package edu.colorado.applepear.classes.commandClasses;

import java.util.ArrayList;
import java.util.List;

public class CommandDispatcher {


    /**
     * Class Attributes
     */
    private final List<Command> undoCMD;
    private final List<Command> redoCMD;
    private Command currentC;
    private final int countUndo;


    /**
     * Constructor
     */
    public CommandDispatcher(){
        undoCMD = new ArrayList<>();
        redoCMD = new ArrayList<>();
        currentC = null;
        countUndo = 0;
    }

    /**
     * Set Commands
     * @param c - Command
     */
    public void setCommands(Command c){
        currentC = c;
        c.execute();
        undoCMD.add(c);
    }

    /**
     * Undo All - Multi Level Undo
     */
    public void undoAll(){
        if(undoCMD.size() == 0){
            System.out.println("There are no moves to be undone.");
            return;
        }
        for(Command c : undoCMD){
            c.undo();
        }
        System.out.println("You have undone all your moves.");
    }

    /**
     * Undo
     */
    public void undo(){
        if(undoCMD.size() != 0) {
            undoCMD.get(undoCMD.size() - 1).undo();
            redoCMD.add(undoCMD.get(undoCMD.size() - 1));
            undoCMD.remove(undoCMD.size() - 1);
            System.out.println("You have undone your latest move.");
        }else{
            System.out.println("There are no moves to be undone.");
        }
    }

    /**
     * Redo
     */
    public void redo() {
        if(undoCMD.size() == 0){
            System.out.println("You should call at least one undo to redo.");
            return;
        } else if (redoCMD.size() != 0) { //if undo is called at least once
            redoCMD.get(redoCMD.size() - 1).execute();
            undoCMD.add(redoCMD.get(redoCMD.size() - 1));
            redoCMD.remove(redoCMD.size() - 1);
            System.out.println("You have redone your latest move.");
        }else{
            System.out.println("There are no moves to be redone.");
        }
    }
}
