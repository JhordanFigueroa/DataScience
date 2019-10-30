public class ApplicationRunner {

    public static void main(String[] args) {
        FlightAnalytics analytics = new FlightAnalytics("flights_small");

        FormattedOutput output = new FormattedOutput();
        output.addAnswer(1, analytics.highestPercentageOfCancelledFlights());
        output.addAnswer(2, analytics.getMostCommonCauseOfCancellation());
        output.addAnswer(3, analytics.getPlaneFurthestMiles());
        output.addAnswer(4, analytics.getBusiestAirport());
        output.addAnswer(5, analytics.getBiggestSourceOfAirplanes());
        output.addAnswer(6, analytics.airportBiggestSinkOfAirplanes());
        output.addAnswer(7, analytics.delayedAmericanAirlines());
        output.addAnswer(8, analytics.largestDelayMadeUp());
        output.addAnswer(9, analytics.getPlaneWithLeastMiles());
        output.writeAnswers();
    }

    public static void printString(String s) { System.out.println(s); }

    public static void printInt (int i) {System.out.println(i);}


}