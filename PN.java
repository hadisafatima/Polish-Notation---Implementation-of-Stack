public class PN {
    private Node1 top ;
    private int size ;
    class Node1{
        private String data ;
        private Node1 next ;

        public Node1(String data, Node1 next) {
            this.data = data;
            this.next = next;
        }
    }

    public void push(String data){
        top = new Node1(data, top) ;
        size++ ;
    }

    public String pop(){
        if (top == null) return null ;
        else{
            String oldTop = top.data ;
            top = top.next ;
            --size;
            return oldTop ;
        }
    }

    public String peek(){
        if (top == null) return null ;
        else return top.data ;
    }

    static class PolishNotation{

        PN pn = new PN() ;
        public PolishNotation(String[] expression){
            for (int i = expression.length - 1 ; i >= 0 ; i--){
                String input = expression[i] ;
                if (isAnOperator(input)){
                    double x = Double.parseDouble(pn.pop()) ;
                    double y = Double.parseDouble(pn.pop()) ;
                    double z = evaluate(x,y,input) ;

                    pn.push("" + z);
                }else pn.push(input);
            }
        }

        public boolean isAnOperator(String input){
            return ( input.length() == 1 && "AMSD".indexOf(input) >= 0 ) ;
        }

        public double evaluate(double x, double y, String op){
            double result = 0.0 ;

            if (op.equals("A")) result = x + y ;
            else if (op.equals("S")) result = x - y ;
            else if (op.equals("M")) result = x * y ;
            else result = x / y ;

            System.out.println(x + " " + op + " " + y + " = " + result);
            return result ;
        }
    }

    public static void main(String[] args) {
        String[] expression = {"A","3","6"} ;
        PolishNotation polish = new PolishNotation(expression) ;
    }
}
