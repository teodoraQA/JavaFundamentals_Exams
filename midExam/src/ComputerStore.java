import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sumPrices = 0;
        double taxes = 0;

        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                sumPrices += price;
                double tax = price * 0.2;
                taxes += tax;
            }
            input = scanner.nextLine();
        }

        String typeOfCustomer = input;
        double totalPrice = sumPrices + taxes;
        if (typeOfCustomer.equals("special")) {
            totalPrice *= 0.9;
        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            printreceipt(totalPrice, sumPrices, taxes);
        }
    }

    private static void printreceipt(double totalPrice, double sumPrices, double taxes) {
        String receipt = String.format("Congratulations you've just bought a new computer!%n" +
                "Price without taxes: %.2f$%n" + "Taxes: %.2f$%n-----------%n" +
                "Total price: %.2f$", sumPrices, taxes, totalPrice);
        System.out.println(receipt);
    }
}
