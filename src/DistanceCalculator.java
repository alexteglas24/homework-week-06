import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DistanceCalculator {
    private static final Pattern UNIT_PATTERN = Pattern.compile("(mm|cm|dm|m|km)");

    public static int calculateDistance(Object... args) {
        int totalDistanceInMm = 0;

        for (int i = 0; i < args.length; i += 2) {
            int value = (Integer) args[i];
            String unit = (String) args[i + 1];

            Matcher matcher = UNIT_PATTERN.matcher(unit);
            if (!matcher.matches()) {
                continue; // Ignore invalid units
            }

            switch (unit) {
                case "mm":
                    totalDistanceInMm += value;
                    break;
                case "cm":
                    totalDistanceInMm += value * 10;
                    break;
                case "dm":
                    totalDistanceInMm += value * 100;
                    break;
                case "m":
                    totalDistanceInMm += value * 1000;
                    break;
                case "km":
                    totalDistanceInMm += value * 1000000;
                    break;
            }
        }

        return totalDistanceInMm;
    }
}