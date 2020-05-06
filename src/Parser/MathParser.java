package Parser;


import java.util.HashMap;
import java.util.Map;

public class MathParser {

    private Map<String, Double> variables;

    public MathParser(){
        this.variables = new HashMap<>();
    }

    public void setVariables(String variable, Double value) {
        variables.put(variable, value);
    }

    public Double getVariableValue(String variable) {
        if (!variables.containsKey(variable)){
            System.out.println("Error");
            return 0.0;
        }
        return variables.get(variable);
    }

    public double Parse(String s) throws Exception {
        Result result = PlusMinus(s);
        if (!result.getRest().isEmpty()){
            System.out.println("Error");
        }
        return result.getAcc();
    }

    private Result PlusMinus(String s) throws Exception {
        Result current = MulDiv(s);
        double acc = current.getAcc();

        while (current.getRest().length() > 0){
            if (!(current.getRest().charAt(0) == '+' || current.getRest().charAt(0) == '-'))
                break;
            char sign = current.getRest().charAt(0);
            String next = current.getRest().substring(1);

            acc = current.getAcc();

            current = MulDiv(next);
            if (sign == '+') {
                acc += current.getAcc();
            }else{
                acc -= current.getAcc();
            }
            current.setAcc(acc);
        }
        return new Result(current.getAcc(), current.getRest());
    }

    private Result MulDiv(String s) throws Exception{
        Result current = Bracket(s);

        double acc = current.getAcc();
        while (true) {
            if (current.getRest().length() == 0){
                return current;
            }
            char sign = current.getRest().charAt(0);
            if (sign != '*' && sign != '/')
                return current;
            String next = current.getRest().substring(1);
            Result right = Bracket(next);

            if (sign == '*') {
                acc *= right.getAcc();
            } else {
                acc /= right.getAcc();
            }

            current = new Result(acc, right.getRest());

        }

    }

    private Result Bracket(String s) throws Exception {
        char zeroChar = s.charAt(0);
        if (zeroChar == '(') {
            Result r = PlusMinus(s.substring(1));
            if (!r.getRest().isEmpty() && r.getRest().charAt(0) == ')'){
                r.setRest(r.getRest().substring(1));
            }else{
                System.out.println("Error: Not close bracket");
            }
            return r;
        }
        return FunctionalVariable(s);
    }

    private Result FunctionalVariable(String s) throws Exception{
        String f = "";
        int i = 0;

        while (i < s.length() && (Character.isLetter(s.charAt(i)) || (Character.isDigit(s.charAt(i)) && i > 0 ))){
            f += s.charAt(i);
            i ++;
        }

        if (!f.isEmpty()){
            if (s.length() > i && s.charAt(i) == '('){

                Result r = Bracket(s.substring(f.length()));
                return proccessFunction(f, r);
            }else{
                return new Result(getVariableValue(f), s.substring(f.length()));
            }
        }
        return Num(s);
    }


    private Result Num(String s) throws Exception {
        int i = 0; //Счётчик количества элементов
        int dot_count = 0; //Счётчик точек
        boolean negative = false; //Положительное число

        //Проверка, что число  начинается с минуса
        if (s.charAt(0) == '-'){
            negative = true;
            s = s.substring(1);
        }

        while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')){
            if ( s.charAt(i) == '.' && ++dot_count > 1){
                throw new Exception("Число записано неверно");
            }
            i ++;
        }

        if (i == 0){
            throw new Exception("Не увидел числа");
        }

        double num = Double.parseDouble(s.substring(0, i));
        if (negative)
            num = - num;
        String restPart = s.substring(i);

        return  new Result(num, restPart);
    }

    private Result proccessFunction(String func, Result r){
        if (func.equals("sin")) {
            return new Result(Math.sin(r.getAcc()), r.getRest());
        } else if (func.equals("cos")) {
            return new Result(Math.cos(r.getAcc()), r.getRest());
        } else if (func.equals("tan")) {
            return new Result(Math.tan(r.getAcc()), r.getRest());
        } else {
            System.err.println("function '" + func + "' is not defined");
        }
        return r;
    }
}
