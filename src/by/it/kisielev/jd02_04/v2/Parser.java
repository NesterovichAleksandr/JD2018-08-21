package by.it.kisielev.jd02_04.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {


    private Var calcOneOperat(String strOne, String operation, String strTwo) throws CalcException {
        //2+2    -2*2       2.0-2.22          -3/4.9
        //{2,7,8,6}+2    -2*2       2.0-2.22          -3/4.9

        Var two=Var.createVar(strTwo);
        if (operation.contains("=")){
            Var.saveVar(strOne,two);
            return two;
        }
        Var one=Var.createVar(strOne);
        if (one==null || two==null){
            //todo Create error unknow operation
            System.out.println("Переменная не распозана");
            return null;
        }

            switch (operation) {
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }


        //todo Create error unknow operation
        System.out.println("Операция не распозана");
        return null;
    }

    private final String[] priority={"=","+","-","*","/"};

    private int currentOperationIndex(List<String> operations){
        int currentResult=-1;
        int currentPrior=-1;
        for (int i = 0; i <operations.size(); i++) {
            int pr=1;
            String op=operations.get(i);
            for (int j = 0; j <priority.length ; j++) {
                if (priority[j].equals(op)) {
                    pr = j;
                    break;
                }
            }
                if (currentPrior<pr){
                    currentPrior=pr;
                    currentResult=i;
                }
            }
       return  currentResult;
    }

    Var calcOneOperat(String expression)throws CalcException {
        String[] tmp=expression.split(Patterns.OPERATION);
        List<String> operands=new ArrayList<>(Arrays.asList(tmp));
        List<String> operations=new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find())
            operations.add(matcher.group());
            while (operands.size()>0) {
                int index = currentOperationIndex(operations);
                String op=operations.remove(index);
                String one=operands.remove(index);
                String two=operands.remove(index);
                Var var=calcOneOperat(one, op, two);
                operands.add(index,var.toString());
            }
            return Var.createVar(operands.get(0));
        }
    }

