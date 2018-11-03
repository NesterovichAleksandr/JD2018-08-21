package by.it.kisielev.jd02_04.v2;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String cmd;
        Parser parser=new Parser();
        Printer printer=new Printer();
        while (!(cmd= scanner.next()).equalsIgnoreCase("END")){
            Var result= null;
            try {
                result = parser.calcOneOperat(cmd);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
            printer.print(result);
        }
    }
}
