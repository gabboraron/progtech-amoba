package potyogosamoba;

import java.util.Vector;

/**
 *
 * @author Sándor
 */
class TicTac {
    private Vector tickTack;
    private boolean currentIsTick = true;

    public TicTac() {
        tickTack = new Vector();
    }
    
    
    
    /**
     * Return true if Tick won, return false if not.
     * Tick won the game if have 4 elements in a row/col near each other.
     * @return 
     */
    public boolean isItDoneByTick(){
        //4 same element in a row
        for(int idx=0; idx<tickTack.size(); ++idx){
            int counter = 1;
            int interValSize = 0;
            coordinate tmp = ((tick) tickTack.get(idx)).getCoordinate();
            boolean thisIsTick = ((tick) tickTack.get(idx)).isTick();
            for(int idxF=0; idxF<tickTack.size(); ++idxF){
                coordinate tmpElem = ((tick) tickTack.get(idxF)).getCoordinate();
                boolean thisElemIsTick = ((tick) tickTack.get(idxF)).isTick();
                if(!tmp.equals(tmpElem)){                           //not the same elem
                    if(thisIsTick && thisElemIsTick){               //the same tick type
                        interValSize = tmpElem.x-tmp.x;
                        //if((interValSize<4) && (interValSize>(-4)))
                        if(interValSize<4)
                           ++counter;
                    }
                }
            }
            if(counter >= 4)
                return true;
            counter = 1;
        }
        
        //4 same element in a column
        for(int idx=0; idx<tickTack.size(); ++idx){
            int counter = 1;
            int interValSize = 0;
            coordinate tmp = ((tick) tickTack.get(idx)).getCoordinate();
            boolean thisIsTick = ((tick) tickTack.get(idx)).isTick();
            for(int idxF=0; idxF<tickTack.size(); ++idxF){
                coordinate tmpElem = ((tick) tickTack.get(idxF)).getCoordinate();
                boolean thisElemIsTick = ((tick) tickTack.get(idxF)).isTick();
                if(!tmp.equals(tmpElem)){                           //not the same elem
                    if(thisIsTick && thisElemIsTick){               //the same tick type
                        interValSize = tmpElem.y-tmp.y;
                        if(interValSize<4)
                           ++counter;
                    }
                }
            }
            if(counter >= 4)
                return true;
            counter = 1;
        }
        
        return false;
    }
    
    /**
     * Add a new elem by cordinates.
     * @param coord 
     */
    public void addElem(coordinate coord){
        if(currentIsTick){
            tick t;
            t = new tick(coord, "tick");
            currentIsTick = false;
            System.out.println(t);
            tickTack.add(t);
        } else {
            tick t;
            t = new tick(coord, "tack");
            currentIsTick = true;
            System.out.println(t);
            tickTack.add(t);
        }
    }

    /**
     * Get if current element is "tick", return true if yes, false if is "tack"
     * @return 
     */
    public boolean isCurrentIsTick() {
        return currentIsTick;
    }

    /**
     * Delete all elements.
     */
    void reset() {
        tickTack.removeAllElements();
        currentIsTick = true;
    }
    
}
