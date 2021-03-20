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
        for(Command c : cmd){
            c.undo();
        }
    }
    public void undo(){
        cmd.remove(cmd.size()-1);
        currentC = cmd.get(cmd.size()-1);
    }
    public void redo(){
        if(null != currentC)
            currentC.redo();
    }
}
