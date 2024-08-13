package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class TipsCalculations {
    public void generate () {
        System.out.println("Percentage variants:");
        System.out.println("125% = 1.25");
        System.out.println("125% / 2 = 62.5% = 0.625");
        System.out.println("100% = 1");
        System.out.println("75% = 0.75");
        System.out.println("75% / 2 = 37.5% = 0.375");
        System.out.println("50% = 0.5");
        System.out.println("25% = 0.25");
        System.out.println("25% / 2 = 12.5% = 0.125");
        System.out.println();
        //------------------------------------------------------
        System.out.println("Enter dirty tips: ");
        Scanner scannerDirtyTips = new Scanner(System.in);
        int dirtyTips = scannerDirtyTips.nextInt();

        System.out.println("Enter number of staff: ");
        Scanner scannerStaff = new Scanner(System.in);
        int staffNumber = scannerStaff.nextInt();

        System.out.println("Enter total coefficient: ");
        Scanner scannerCoefficient = new Scanner(System.in);
        double coefficient = scannerCoefficient.nextDouble();

        final int cleaningTips = 1200;
        final int ragsTips = 200;
        int barTips = (int) (dirtyTips * 0.1);
        int dishwasherTips = (int) (dirtyTips * 0.02);
        int cashierTips = (int) (dirtyTips * 0.04);
        int whiteTips = dirtyTips - cleaningTips - ragsTips - barTips - dishwasherTips - cashierTips;
        int hundredPercentTips = (int) (whiteTips / coefficient);
        System.out.println();
        // ---------------------------------------------
        System.out.println("Date: " + LocalDate.now());
        System.out.println("Staff: " + staffNumber + " (" + coefficient + ")");
        System.out.println("Dirty tips: " + dirtyTips);
        System.out.println("WHITE TIPS: " + whiteTips);
        System.out.println("Tips for 100%: " + hundredPercentTips);
        System.out.println();
        // ------------------------------------------------
        System.out.println("Bar (10%): " + barTips);
        System.out.println("Cashier (4%): " + cashierTips);
        System.out.println("Cleaning: " + cleaningTips);
        System.out.println("Dishwasher (2%): " + dishwasherTips);
        System.out.println("Rags: " + ragsTips);
        System.out.println();
        // -------------------------------------------------

        for (int i = 0; i < staffNumber; i++) {
            System.out.println("Enter staff name: ");
            Scanner scannerName = new Scanner(System.in);
            String staffName = scannerName.nextLine();

            System.out.println("Enter coefficient for " + staffName + ": ");
            Scanner scannerPersonalCoefficient = new Scanner(System.in);
            double staffPersonalCoefficient = scannerPersonalCoefficient.nextDouble();
            int staffPersonalTips = (int) (hundredPercentTips * staffPersonalCoefficient);

            System.out.println("Tips for " + staffName + " (" + staffPersonalCoefficient * 100 + "%) (" + staffPersonalCoefficient + "): " + staffPersonalTips);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TipsCalculations tips = new TipsCalculations();
        tips.generate();
    }
}


