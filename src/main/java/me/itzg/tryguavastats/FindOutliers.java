package me.itzg.tryguavastats;

import com.google.common.math.Stats;
import java.util.ArrayList;
import java.util.List;

public class FindOutliers {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please provide one more numerical arguments");
      System.exit(1);
    }

    final List<Double> values = new ArrayList<Double>();

    for (String arg : args) {
      try {
        values.add(Double.parseDouble(arg));
      } catch (NumberFormatException e) {
        System.out.printf("Unable to parse '%s' into a double%n", arg);
      }
    }

    final Stats stats = Stats.of(values);

    System.out.printf("mean=%f, stddev=%f%n", stats.mean(), stats.populationStandardDeviation());

    showOutliers(values, stats, 1);
    showOutliers(values, stats, 2);
  }

  private static void showOutliers(List<Double> values, Stats stats, int sigma) {
    System.out.printf("Outliers using %d sigma:%n", sigma);

    for (Double value : values) {
      if ((value > stats.mean() + stats.populationStandardDeviation()) ||
          (value < stats.mean() - stats.populationStandardDeviation())) {
        System.out.printf("%f%n", value);
      }
    }
  }
}
