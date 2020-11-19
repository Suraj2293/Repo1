/*package com.journaldev.corejava;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Wissen {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
    int numLines = Integer.parseInt(scanner.nextLine());
    int currentLine = 0;
    while (currentLine++ < numLines) {
        final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
        final Set<String> apps = new TreeSet<>();

        String line = scanner.nextLine();
        String[] inputs = line.split(",");
        for (int i = 0; i < inputs.length; ++i) {
            String[] tokens = inputs[i].split(" ");
            final String app = tokens[0];
            apps.add(app);
            final int runs = Integer.parseInt(tokens[1]);

            stats.putNewRating(app, runs);

        }

        for (String app : apps) {
            System.out.println(
                    String.format("%s %.2f %d", app, stats.getAverageRating(app), stats.getRatingsCount(app)));
        }

    }
    scanner.close();

}
}

*/