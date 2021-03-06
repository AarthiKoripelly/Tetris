import java.util.*;
/**
 * Write a description of class MoveList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MoveList
{
    private double value;
    private List<Move> moves;
    public MoveList(List<Move> m){
        moves = m;
    }
    
    public MoveList(List<Move> m, double val){
        moves = m;
        value = val;
    }
    
    public void add(Move m){
        if(m == Move.RIGHT){
            if(moves.remove(Move.LEFT)){
                return;
            }
        }else if(m == Move.LEFT){
            if(moves.remove(Move.RIGHT)){
                return;
            }
        }
        moves.add(m);
    }
    
    public Move get(int indx){
        return moves.get(indx);
    }
    
    public Move remove(int indx){
        return moves.remove(indx);
    }
    
    public void setValue(double val){
        value = val;
    }
    
    public double getValue(){
            return value;
    }
    
    public int size(){
        return moves.size();
    }
    
    public List<Move> getList(){
        return moves;
    }
    
    public MoveList getEquivMoveList(){
        List<Move> boiz = new ArrayList<Move>();
        for(int i = 0; i<moves.size(); i++){
            boiz.add(moves.get(i));
        }
        return new MoveList(boiz, value);
    }
    
    public void Clear(){
        moves = null;
        value = 0.0;
    }
}
