import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceCalculatorTest {

    @Test
    public void calculateDistance() {
        assertEquals(1090, DistanceCalculator.calculateDistance(10, "cm", 1, "m", -10, "mm"));
        assertEquals(1000500, DistanceCalculator.calculateDistance(1, "km", 5, "dm"));
        assertEquals(200, DistanceCalculator.calculateDistance(10, "cm", 1, "dm"));
        assertEquals(2001001, DistanceCalculator.calculateDistance(2, "km", 1, "m", 1, "mm"));
        assertEquals(999000, DistanceCalculator.calculateDistance(1, "km", -1, "m"));
        assertEquals(1100, DistanceCalculator.calculateDistance(1, "m", 10, "cm"));
    }

    @Test
    public void calculateDistanceWithEmptyExpression() {
        assertEquals(0, DistanceCalculator.calculateDistance());
    }

    @Test
    public void calculateDistanceWithInvalidUnits() {
        assertEquals(1000, DistanceCalculator.calculateDistance(1, "m", 10, "xyz"));
    }

    @Test
    public void calculateDistanceWithNegativeValues() {
        assertEquals(900, DistanceCalculator.calculateDistance(1, "m", -10, "cm"));
    }
}