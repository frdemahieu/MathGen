package MathGen;

/**
 * Created by pierre on 29/03/17
 */
public class MathTree {
    private MathTree left, right;
    private boolean isOperator;
    private double value;
    private char operator;//+ - × ÷
    
    private static final double THRESHOLD = 0.1;
    
    
    public MathTree(double value){
        this.value = value;
        this.isOperator = false;
    }
    
    public MathTree(char operator){
        if(operator != '+' && operator != '-'
                && operator != '*' && operator != '/')
            throw new IllegalArgumentException("Symbol unrecognized ! ");
        this.operator = operator;
        this.isOperator = true;
    }
    
    public double getResult(){
        if(!isOperator)
            return value;
        switch(operator){
            case '+':
                return this.left.getResult() + this.right.getResult();
            case '-':
                return this.left.getResult() - this.right.getResult();
            case '*':
                return this.left.getResult() * this.right.getResult();
            case '/':
                return this.left.getResult() / this.right.getResult();
            default:
                System.err.println("Unexpected operation ! ("+operator+")");
        }
        return 0; 
    }
    
    public boolean isCorrect(double result){
        return Math.abs(result-getResult()) < THRESHOLD;
    }
    
    public MathTree getLeft() {
        return left;
    }
    
    public void setLeft(MathTree left) {
        this.left = left;
    }
    
    public MathTree getRight() {
        return right;
    }
    
    public void setRight(MathTree right) {
        this.right = right;
    }
    
    @Override
    public String toString(){
        if(isOperator)
            return "("+getRight().toString()+getDirtyOperator(operator)+getLeft().toString()+")";
        return ""+getProperValue(value);
    }
    
    private char getDirtyOperator(char operator){
        switch(operator) {
            case '*':
                return '×';
            case '/':
                return '÷';
            default:
                return operator;
        }
    }
    
    private String getProperValue(double value){
        if((value - ((int)value)) == 0)
            return ""+(int)value;
        return ""+value;
    }
     
    public static String removeExternalPeTrentheses(MathTree mt){
        StringBuilder sb = new StringBuilder(mt.toString());
        sb.deleteCharAt(sb.indexOf("("));
        sb.deleteCharAt(sb.lastIndexOf(")"));
        return sb.toString();
    }
}
