public class Solution {
    public static void main(String[] args) {
        double celsius = 36.50;
        double[] temperatures = convertTemperature(celsius);
        for (double temperature : temperatures) {
            System.out.println(temperature);
        }
    }

    static double[] convertTemperature(double celsius) {
        double[] temperatures = { celsius + 273.15, celsius * 1.80 + 32.00 };
        return temperatures;
    }
}
