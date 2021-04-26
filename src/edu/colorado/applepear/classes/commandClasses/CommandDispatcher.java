package edu.colorado.applepear.classes.commandClasses;

import java.util.ArrayList;
import java.util.List;

public class CommandDispatcher {

    /**
     * Attributes
     */
    private final List<Move> undoCMD = new ArrayList<Move>();
    private final List<Move> redoCMD = new ArrayList<Move>();

    public CommandDispatcher(){ }
    private Move currentC = null;

    /**
     * Setter
     * @param c
     */
    public void setCommands(Move c){
        currentC = c;
        c.execute();
        undoCMD.add(c);
    }

    /**
     * Undo all
     */
    public void undoAll(){
        if(undoCMD.size() == 0){
            System.out.println("There are no moves to be undone.");
            return;
        }
        for(Move c : undoCMD){
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
        } else if (redoCMD.size() != 0) {
            redoCMD.get(redoCMD.size() - 1).execute();
            redoCMD.remove(redoCMD.size() - 1);
            System.out.println("You have redone your latest move.");
        }else{
            System.out.println("There are no moves to be redone.");
        }
    }
}
