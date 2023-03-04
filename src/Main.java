/* Date: 3/1/2020
Name: Deodatus Marcellino
---------------- Simple Slot Machine ----------------
* User starts with $10. At the beginning of the program the user is given the following choices:
* 1) Play the slot Machine
* 2) Cash Out
* Each play costs 25 cents. For each play, the slot machine will output a random three-digit number,
* where each digit ranges from 0 to 9.
* Combinations of 2 of a kind wins 50 cents.
* Combinations of 3 of a kind wins $10.
* If a player runs out of money, they will automatically cash out.
* Otherwise, when player chooses to cash out, the program will output the amount of money they have left
* */

import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        Random r = new Random();
        double balance = 10;
        int input = 0;
        int num1 = 0, num2 = 0, num3 = 0;

        // start loop here
        while (input != 2 && balance >= 0.25){

            input = menu(balance);

            // play the slot machine
            if (input == 1){
                // each play costs 25 cents
                balance -= 0.25;

                // generate random three-digit numbers
                num1 = Main.numberRoll(r);
                num2 = Main.numberRoll(r);
                num3 = Main.numberRoll(r);

                //output the result
                System.out.println("The Slot machine shows "+num1+""+num2+""+num3);

                if (num1 == num2 || num1 == num3 || num2 == num3)
                {
                    if (num1 == num2 && num2 == num3){
                        System.out.println("You win the big prize, $10.00!");
                        balance += 10;
                    }
                    else {
                        System.out.println("You win 50 cents!");
                        balance += 0.50;
                    }
                } else {
                    System.out.println("Sorry you don't win anything.");
                }
            } // end play
            System.out.println("");
        } // end while loop

        System.out.println("Thank you for playing! You end with $" +balance+"!");


    }// driver

    // Prints out the menu and returns the user's choice.
    public static int menu(double balance) {

        Scanner stdin = new Scanner(System.in);
        int ans = 0;

        // Loop until a valid choice is made by the user.
        while (ans <= 0 || ans > 2) {
            System.out.println("You have " + balance);
            System.out.println("Choose one of the following menu options:");
            System.out.println("1) Play the slot machine.");
            System.out.println("2) Cash Out.");
            ans = stdin.nextInt();
            if (ans <= 0 || ans > 2)
                System.out.println("Sorry that is not a valid choice.");
        }

        return ans;
    }//end menu

    public static int numberRoll(Random r) {
        return Math.abs(r.nextInt()) % 10;
    }

} // end class Main