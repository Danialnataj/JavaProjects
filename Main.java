import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int wins = 0, losses = 0;
        System.out.println("Welcome to dice game 12. You must roll 1-3 dice and try to get the sum of 12 ...\n");

        while (true) {
            Set<Integer> rolledDice = new HashSet<>();
            int[] diceValues = new int[3];
            int sum = 0, rolls = 0;

            while (rolls < 3) {
                System.out.print("Enter which dice you want to roll [1,2,3] (exit with q): ");
                String input = scanner.nextLine();

                if (input.equals("q")) {
                    System.out.println("#win: " + wins + " #loss: " + losses + "\nGame Over!");
                    scanner.close();
                    return;
                }

                try {
                    int diceChoice = Integer.parseInt(input);
                    if (diceChoice < 1 || diceChoice > 3 || !rolledDice.add(diceChoice)) {
                        System.out.println("Sorry, that is an invalid entry. Try again. Valid entries are 1, 2, 3, and q\n");
                        continue;
                    }

                    diceValues[diceChoice - 1] = random.nextInt(6) + 1;
                    sum += diceValues[diceChoice - 1];
                    rolls++;
                    System.out.println(Arrays.toString(diceValues).replaceAll("", "") + " sum: " + sum + " #win: " + wins + " #loss: " + losses);
                } catch (NumberFormatException e) {
                    System.out.println("Sorry, that is an invalid entry. Try again. Valid entries are 1, 2, 3, and q\n");
                }
            }

            System.out.println(sum == 12 ? "You won!!\n" : sum > 12 ? "You lost!!\n" : "You neither won nor lost the game.\n");
            if (sum == 12) wins++;
            if (sum > 12) losses++;
            System.out.println("Next round!\n");
        }
    }
}
