package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class TipsNoNameCalculations {
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


        System.out.println("Enter total coefficient: ");
        Scanner scannerCoefficient = new Scanner(System.in);
        double coefficient = scannerCoefficient.nextDouble();

        final int cleaningTips = 1200;
        final int ragsTips = 200;
        int barTips = (int) (dirtyTips * 0.1);
        int dishwasherTips = (int) (dirtyTips * 0.02);
        int cashierTips = (int) (dirtyTips * 0.04);
        int whiteTips = dirtyTips - cleaningTips - ragsTips - barTips - dishwasherTips - cashierTips;
        int seniorPercentTips = (int) (whiteTips / coefficient * 1.25);
        int halfSeniorPercentTips = (int) (whiteTips / coefficient * 0.625);
        int hundredPercentTips = (int) (whiteTips / coefficient);
        int seventyFivePercentTips = (int) (whiteTips / coefficient * 0.75);
        int halfSeventyFivePercentTips = (int) (whiteTips / coefficient * 0.375);
        int fiftyPercentTips = (int) (whiteTips / coefficient * 0.5);
        int twentyFivePercentTips = (int) (whiteTips / coefficient * 0.25);
        int twelveAndHalfFivePercentTips = (int) (whiteTips / coefficient * 0.125);
        System.out.println();
        // ---------------------------------------------
        System.out.println("Date: " + LocalDate.now());
        System.out.println("Coefficient: " + coefficient);
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
        System.out.println("Tips for 125% (1.25): " + seniorPercentTips);
        System.out.println("Tips for 62.5% (0.625): " + halfSeniorPercentTips);
        System.out.println("Tips for 100% (1): " + hundredPercentTips);
        System.out.println("Tips for 75% (0.75): " + seventyFivePercentTips);
        System.out.println("Tips for 37.5% (0.375): " + halfSeventyFivePercentTips);
        System.out.println("Tips for 50% (0.5): " + fiftyPercentTips);
        System.out.println("Tips for 25% (0.25): " + twentyFivePercentTips);
        System.out.println("Tips for 12.5% (0.125): " + twelveAndHalfFivePercentTips);
    }

    public static void main(String[] args) {
        TipsNoNameCalculations tips = new TipsNoNameCalculations();
        tips.generate();
    }
}



