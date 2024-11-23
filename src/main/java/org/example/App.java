package org.example;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Console calculator 1.0");
        ICalculator calculator = new NumberCalculator();
        processing(calculator);
    }

    private static void processing(ICalculator calculator) {//аргумент функции с типом
        printCommand();
        String input = null;
        while (!Objects.equals(input, "exit")) {
            input = requestNumberCommand();
            switch (input) {
                case "0":
                    System.out.println("Good bye!");
                    return;
                case "1":
                    executeOperation(calculator::add);
                    break;
                case "2":
                    executeOperation(calculator::subtract);
                    break;
                case "3":
                    executeOperation(calculator::multiply);
                    break;
                case "4":
                    executeOperation(calculator::divide);
                    break;
                case "i":
                    printCommand();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    private static String requestNumberCommand() {
        System.out.print("Please, enter a number command: ");

        String input = readLine();

        return input;
    }

    private static void printCommand() {
        System.out.println("Supported commands:");
        System.out.println("\t1. add");
        System.out.println("\t2. subtract");
        System.out.println("\t3. multiply");
        System.out.println("\t4. divide");
        System.out.println("\t-----------------------");
        System.out.println("\ti. print supported commands");
        System.out.println("\t0. exit");
    }

    private static void executeOperation(IMathOperation operation) {
        Number firstArgument = requestArgument();
        Number secondArgument = requestArgument();
        try
        {
            Number result = operation.execute(firstArgument, secondArgument);
            System.out.printf("Result: %s\n", result);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private static Number requestArgument() {
        while(true) {
            System.out.print("Please, enter an argument: ");
            String argument = readLine();
            try {
                return Double.parseDouble(argument);
            }
            catch(Exception e) {
                System.out.println(argument + " is wrong number!");
            }
        }
    }

    private static String readLine()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @FunctionalInterface
    public interface IMathOperation {
        Number execute(Number a, Number b);
    }
}
