package edu.colorado.applepear.classes.commandClasses;

import edu.colorado.applepear.classes.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandDispatcher {
    private final List<Command> cmd = new ArrayList<Command>();
    public CommandDispatcher(){ }
    private Command currentC = null;
    private int countUndo = 0;

    public void setCommands(Command c){
        currentC = c;
        c.execute();
        cmd.add(c);
    }
    public void undoAll(){
        if(cmd.size() == 0){
            System.out.println("There are no moves to be undone.");
            return;
        }
        for(Command c : cmd){
            c.undo();
        }
        System.out.println("You have undone all your moves.");
    }
    public void undo(){
        if(cmd.size() != 0) {
            cmd.get(cmd.size() - 1).undo();
            currentC = cmd.get(cmd.size() - 1);
            countUndo+=1;
            System.out.println("You have undone your latest move.");

        }else{
            currentC = null;
            System.out.println("There are no moves to be undone.");
        }


    }
    public void redo() {
        if (countUndo != 0) { //if undo is called at least once
            if (currentC != null) {
                currentC.execute();
                cmd.remove(cmd.size() - 1);
                System.out.println("You have redone your latest move.");
            } else
                System.out.println("There are no moves to be redone.");
        }
        else{
            System.out.println("You should call at least one undo to redo.");
        }
    }
}
