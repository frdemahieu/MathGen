package MathGen;

/**
 * Created by pierre on 29/03/17
 */
public class MathGen {
    public static MathTree generateProblem(MathLevel level){
        return genSubTree(level.getNumberOfNumber(), level);
    }
    
    private static MathTree genSubTree(int numberOfNode, MathLevel complexity){
        if(numberOfNode <= 1)
            return new MathTree(genNumber(complexity));
        MathTree operator = new MathTree(genSymbol(complexity));
        operator.setRight(genSubTree((int)Math.floor(numberOfNode/2.0),complexity));
        operator.setLeft(genSubTree((int)Math.ceil(numberOfNode/2.0),complexity));
        return operator;
    }
    
    private static char genSymbol(MathLevel ml){
        char [] symbols = ml.getAllPossibleSymbols();
        return symbols[(int)(Math.random()*symbols.length)];
    }
    
    private static int genNumber(MathLevel ml){//TODO maybe add negative nbr
        return (int)(Math.random()*ml.getMaxValue());
    }
    
}
