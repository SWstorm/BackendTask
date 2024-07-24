import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число a");
        double a = in.nextDouble();
        in.nextLine();
        System.out.println("Введите число b");
        double b = in.nextDouble();
        in.nextLine();

        Calculator calculator = new Calculator(new Adder());
        double sum = calculator.calc(a, b);
        System.out.println("Результат сложения a и b: " + sum);

        calculator = new Calculator(new Subtractor());
        double diff = calculator.calc(a, b);
        System.out.println("Результат вычитания a и b: " + diff);

        calculator = new Calculator(new Multipler());
        double part = calculator.calc(a, b);
        System.out.println("Результат умножения a и b: " + part);

        calculator = new Calculator(new Divider());
        double prod = calculator.calc(a, b);
        System.out.println("Результат деления a и b: " + prod);
    }
}