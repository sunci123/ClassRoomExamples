package tariff;

import java.util.ArrayList;
import java.util.Scanner;
import tariff.Duration;
import tariff.PhoneUsage;
import tariff.PrePayedPlan;

public class Level2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How much time did you on the phone last month? (hh:mm:ss)");
        Duration totalTime=new Duration(sc.next());
        System.out.print("How many messages (SMS) did you send? ");
        int totalSMS=sc.nextInt();
        PhoneUsage myUsage = new Usage(totalTime,totalSMS);

        ArrayList<PrePayedPlan> planOptions = PrePayedPlan.loadPlansFromFile(args[0]);

        PrePayedPlan bestOption = Planner.getBestPlan(planOptions,myUsage);

        System.out.println("Your best option for the last month is the plan " + bestOption.getName() + " and you will pay " + bestOption.getCost(myUsage) + " HUF.");
        sc.close();
    }
}
