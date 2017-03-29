package MathGen;

/**
 * Created by pierre on 29/03/17
 */
public class CustomTests{
    public static void main(String ... args){
        int nbr = 20;
        int i = 0;
        while(i < nbr){
            MathTree mt = MathGen.generateProblem(MathLevel.HARD);
            System.out.println(MathTree.removeExternalPerentheses(mt)+" = "+mt.getResult());
            i++;
        }
    
    }
}
