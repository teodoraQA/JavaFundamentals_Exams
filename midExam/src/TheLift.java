import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleOnQueue = Integer.parseInt(scanner.nextLine());
        String[] inputLift = scanner.nextLine().split("\\s+");
        int liftSize = inputLift.length;

        int[] lift = new int[liftSize];
        parseInputLift(inputLift, liftSize, lift);

        boolean queueIsEmpty = false;
        boolean liftIsFull = false;
        int maxPeoplePerWagon = 4;

        for (int i = 0; i < liftSize; i++) {

            int currentWagon = lift[i];
            if (currentWagon < maxPeoplePerWagon) {
                int freeSeats = maxPeoplePerWagon - currentWagon;
                if (peopleOnQueue < freeSeats) {
                    lift[i] += peopleOnQueue;
                    peopleOnQueue = 0;
                } else {
                    peopleOnQueue -= freeSeats;
                    lift[i] += freeSeats;
                }
            }
            if (i == liftSize - 1 && lift[i] == maxPeoplePerWagon) {
                liftIsFull = true;
            }
            if (peopleOnQueue == 0) {
                queueIsEmpty = true;
                break;
            }
        }

        if (!queueIsEmpty && liftIsFull) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleOnQueue);
            printLift(lift);
        } else if (queueIsEmpty && !liftIsFull) {
            System.out.println("The lift has empty spots!");
            printLift(lift);
        } else {
            printLift(lift);
        }
    }

    private static void printLift(int[] lift) {
        for (int wagon : lift) {
            System.out.print(wagon + " ");
        }
    }

    private static void parseInputLift(String[] inputLift, int liftSize, int[] lift) {
        for (int i = 0; i < liftSize; i++) {
            lift[i] = Integer.parseInt(inputLift[i]);
        }
    }
}
