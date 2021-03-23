package edu.colorado.applepear.classes.commandClasses;

import edu.colorado.applepear.classes.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandDispatcher {
    private final List<Command> undoCMD = new ArrayList<Command>();
    private final List<Command> redoCMD = new ArrayList<Command>();

    public CommandDispatcher(){ }
    private Command currentC = null;
    private int countUndo = 0;

    public void setCommands(Command c){
        currentC = c;
        c.execute();
        undoCMD.add(c);
    }

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

    public void redo() {
        if(undoCMD.size() == 0){
            System.out.println("You should call at least one undo to redo.");
            return;
        } else if (redoCMD.size() != 0) { //if undo is called at least once
            redoCMD.get(redoCMD.size() - 1).execute();
            //undoCMD.add(redoCMD.get(redoCMD.size() - 1));
            redoCMD.remove(redoCMD.size() - 1);
            System.out.println("You have redone your latest move.");
        }else{
            System.out.println("There are no moves to be redone.");
        }
    }
}
