import model.Calculator;
import model.DivideByZero;
import model.IncorrectOperation;
import java.util.Scanner;


public class Main {


    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        boolean requiredToStop = false;
        String input;
        while (!requiredToStop) {
            boolean isNotValid = true;
            String operation;
            double result;
            while (isNotValid) {
                try {
                    double firstValue = Calculator.inputOperand(sc, "першого");
                    System.out.println();
                    double secondValue = Calculator.inputOperand(sc, "другого");
                    System.out.println();
                    operation = Calculator.inputOperation(sc);
                    System.out.println();
                    result = Calculator.calculate(firstValue, secondValue, operation);
                    isNotValid = false;
                    System.out.println(firstValue + " " + operation + " " + secondValue + " = " + result);
                } catch (DivideByZero | IncorrectOperation | IllegalArgumentException e) {
                    System.out.println(e.getMessage() + "  Спробуйте ще раз." );
                    System.out.println();
                    isNotValid = true;
                }
            }
            System.out.println();
            System.out.print("Вкажіть 'N' для виходу з програми або будь-яку клавішу для продовження: ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("N")) {
                requiredToStop = true;
            } else  {
                requiredToStop  = false;
            }
            System.out.println();
        }
        sc.close();
    }
}