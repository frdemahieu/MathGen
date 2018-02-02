package MathGen;

import java.util.LinkedList;

/**
 * Created by pierre on 29/03/17
 */
public enum MathLevel{
    VERY_EASY(1,50,2),  //2+2 - max < 50, +-
    EASY(1,100,3),        //2+2+2 - max < 100, +-
    MEDIUM(2,100,2),      //2+2 - max < 100, +-*
    HARD(2,200,3),        //2+2+2 - max < 200, +-*
    VERY_HARD(3,200,2),  //2+2 - max < 200, +-*/
    IMPOSSIBLE(3,500,3);  //2+2+2, max < 500, +-*/
    
    private int operatorLevel; //0 = +, 1 = -, 2 = *, 3 = /
    private int maxValue;
    private int numberOfNumber;
    
    MathLevel(int operatorLevel, int maxValue, int numberOfNumber){
        this.operatorLevel = operatorLevel;
        this.maxValue = maxValue;
        this.numberOfNumber = numberOfNumber;
    }
    
    char[] getAllPossibleSymbols(){
        LinkedList<Character> operator = new LinkedList<Character>();
        if(this.operatorLevel >= 0)
            operator.add('+');
        if(this.operatorLevel >= 1)
            operator.add('-');
        if(this.operatorLevel >= 2)
            operator.add('*');
        if(this.operatorLevel >= 3)
            operator.add('/');
        
        Character [] temp = operator.toArray(new Character[0]);
        char result[] = new char[temp.length];
        for(int i = 0; i < temp.length; i++)
            result[i] = temp[i];
        
        return result;
    }
    
    int getMaxValue(){
        return this.maxValue;
    }
    
    int getNumberOfNumber(){
        return this.numberOfNumber;
    }
    
    @Override
    public String toString(){
        switch ( this ){
            case VERY_EASY:
                return "very easy";
            case EASY:
                return "easy";
            case MEDIUM:
                return "medium";
            case HARD:
                return "hard";
            case VERY_HARD:
                return "very hard CMB";
            case IMPOSSIBLE:
                return "impossible";
        }
        return "";
    }
}
