package edu.colorado.applepear.classes.commandClasses;

import java.util.ArrayList;
import java.util.List;

public class CommandDispatcher {
    private List<Command> cmd = new ArrayList<Command>();
    public CommandDispatcher(){ }
    private Command currentC = null;

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
            System.out.println("You have undone your latest move.");
        }else
            System.out.println("There are no moves to be undone.");
        if(cmd.size() != 0) {
            currentC = cmd.get(cmd.size() - 1);
        }else
            currentC = null;
    }
    public void redo(){
        if(currentC != null) {
            currentC.execute();
            cmd.remove(cmd.size() - 1);
            System.out.println("You have redone your latest move.");
        }else
            System.out.println("There are no moves to be redone.");
    }
}
