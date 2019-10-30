import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class FlightAnalytics {
    ArrayList<Flight> flights = new ArrayList<>();

    public FlightAnalytics(String filename) {
        try {
            Scanner scanner = new Scanner(new FileReader(filename));
            String columNamesRow = scanner.nextLine(); // skip the column names
            while (scanner.hasNextLine()) {
                String rowData = scanner.nextLine();
                Flight flight = new Flight(columNamesRow, rowData);
                flights.add(flight);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Question3
    public String getPlaneFurthestMiles() {
        HashMap<String, Integer> planeToMilesMapping = new HashMap<>();
        ArrayList<String> planeIdentifiers = new ArrayList<>();
        // Get plane Ids
        for (Flight flight : flights) {
            String planeName = flight.getStringProperty("TailNum");
            boolean dataEntryExists = (planeName != null);
            if (dataEntryExists && !planeIdentifiers.contains(planeName)) {
                planeIdentifiers.add(planeName);
            }
        }
        // Zero out all planes
        planeIdentifiers.forEach((planeId) -> {
            Integer initialValue = 0;
            planeToMilesMapping.put(planeId, initialValue);
        });
        // Tally number of miles for each plane
        for (Flight flight : flights) {
            String planeName = flight.getStringProperty("TailNum");
            Integer numOfMilesFlown = flight.getNumericalProperty("Distance");
            boolean dataEntriesExists = (numOfMilesFlown != null && planeName != null);
            if (dataEntriesExists) {
                Integer currentMiles = planeToMilesMapping.get(planeName);
                Integer newAmountOfMiles = currentMiles + numOfMilesFlown;
                planeToMilesMapping.put(planeName, newAmountOfMiles);
            }
        }

        // Get Maximum
        String planeWithMaxMiles = "";
        Integer numberOfMaxMiles = 0;

        for (String key : planeToMilesMapping.keySet()) {
            Integer value = planeToMilesMapping.get(key);
            if (value > numberOfMaxMiles) {
                numberOfMaxMiles = value;
                planeWithMaxMiles = key;
            }
        }
        return planeWithMaxMiles;
    }

    //Question9
    public String getPlaneWithLeastMiles() {
        HashMap<String, Integer> planesToMap = new HashMap<>();
        ArrayList<String> planeTailNum = new ArrayList<>();
        //Get Plane Ids
        for (Flight flight : flights) {
            String planeID = flight.getStringProperty("TailNum");
            boolean dataEntryExists = (planeID != null);
            if (dataEntryExists && !planeTailNum.contains(planeID)) {
                planeTailNum.add(planeID);
            }
        }
        planeTailNum.forEach((planeNumID) -> {
            Integer initialValue = 0;
            planesToMap.put(planeNumID, initialValue);
        });
        for (Flight flight : flights) {
            String planeID = flight.getStringProperty("TailNum");
            Integer numOfMilesFlown = flight.getNumericalProperty("Distance");
            boolean dataEntriesExists = (numOfMilesFlown != null && planeID != null);
            if (dataEntriesExists) {
                Integer currentMiles = planesToMap.get(planeID);
                Integer newAmountOfMiles = currentMiles + numOfMilesFlown;
                planesToMap.put(planeID, newAmountOfMiles);
            }
        }
        // Get Minimum
        String planeWithMinMiles = "";
        Integer numberOfMinMiles = Integer.MAX_VALUE;
        for (String key : planesToMap.keySet()) {
            Integer value = planesToMap.get(key);
            if (value < numberOfMinMiles) {
                numberOfMinMiles = value;
                planeWithMinMiles = key;
            }
        }
        return "The plane with the least miles flown is: TailNum " + planeWithMinMiles + " with total miles: "
                + numberOfMinMiles;
    }

    //Question4
    public String getBusiestAirport() {
        ArrayList<String> originAndDestAirportIDs = new ArrayList<>();

        for (Flight flight : flights) {
            String airportID = flight.getStringProperty("OriginAirportID");
            String destinationID = flight.getStringProperty("DestAirportID");
            boolean dataEntryExists = (airportID != null && destinationID != null);
            if (dataEntryExists) {
                originAndDestAirportIDs.add(airportID);
                originAndDestAirportIDs.add(destinationID);
            }
        }

        HashMap<String, Integer> originMap = new HashMap<>();

        //Aggregate the total count for each airport
        for (String i : originAndDestAirportIDs) {
            Integer count = originMap.get(i);
            originMap.put(i, (count == null) ? 1 : count + 1);
        }

        //Get Maximum
        String airportWithMostFlights = "";
        Integer numberOfMostFlights = 0;

        for (String key : originMap.keySet()) {
            Integer value = originMap.get(key);
            if (value > numberOfMostFlights) {
                numberOfMostFlights = value;
                airportWithMostFlights = key;
            }
        }

        return airportWithMostFlights;
    }

    //Question2
    public String getMostCommonCauseOfCancellation() {
        ArrayList<String> reasonForCancellation = new ArrayList<>();

        for (Flight flight : flights) {
            String cancellationCode = flight.getStringProperty("CancellationCode");
            boolean dataEntryExists = (cancellationCode != null);
            if (dataEntryExists) {
                reasonForCancellation.add(cancellationCode);
            }
        }

        HashMap<String, Integer> reasonForCancellationMap = new HashMap<>();

        for (String i : reasonForCancellation) {
            Integer count = reasonForCancellationMap.get(i);
            reasonForCancellationMap.put(i, (count == null) ? 1 : count + 1);
        }
        //Get Maximum
        String mostCommonCancellationReason = "";
        Integer maxCancellationCode = 0;

        for (String key : reasonForCancellationMap.keySet()) {
            Integer value = reasonForCancellationMap.get(key);
            if (value > maxCancellationCode) {
                maxCancellationCode = value;
                mostCommonCancellationReason = key;
            }
        }
        return mostCommonCancellationReason;
    }

    //Question 5
    public String getBiggestSourceOfAirplanes() {
        ArrayList<String> originAirportIDList = new ArrayList<>();
        ArrayList<String> destinationAirportIDList = new ArrayList<>();

        for (Flight flight : flights) {
            String cancellationCode = flight.getStringProperty("CancellationCode");
            String originAirportID = flight.getStringProperty("OriginAirportID");
            Integer diverted = flight.getNumericalProperty("Diverted");
            boolean dataEntryExists = (originAirportID != null && cancellationCode == null) && diverted != 1;
            if (dataEntryExists) {
                originAirportIDList.add(originAirportID);
            }
        }

        for (Flight flight : flights) {
            String cancellationCode = flight.getStringProperty("CancellationCode");
            String destinationAirportID = flight.getStringProperty("DestAirportID");
            Integer diverted = flight.getNumericalProperty("Diverted");
            boolean dataEntryExists = (destinationAirportID != null && cancellationCode == null && diverted != 1);
            if (dataEntryExists) {
                destinationAirportIDList.add(destinationAirportID);
            }
        }

        HashMap<String, Integer> originAirportIDMap = new HashMap<>();
        for (String i : originAirportIDList) {
            Integer count = originAirportIDMap.get(i);
            originAirportIDMap.put(i, (count == null) ? 1 : count + 1);
        }

        HashMap<String, Integer> destinationAirportIDMap = new HashMap<>();
        for (String i : destinationAirportIDList) {
            Integer count = destinationAirportIDMap.get(i);
            destinationAirportIDMap.put(i, (count == null) ? 1 : count + 1);
        }

        //Compare Both HasMaps
        int sourceMaxValue = 0;
        int biggestSourceDifference = 0;
        String maxAirportID = "";
        String originAirportID = "";
        String destinationAirportID = "";
        for (String key : originAirportIDMap.keySet()) {
            Integer originMapID = originAirportIDMap.get(key);
            originAirportID = key;
            for (String i : destinationAirportIDMap.keySet()) {
                Integer destinationMapID = destinationAirportIDMap.get(i);
                destinationAirportID = i;
                if (originAirportID.equals(destinationAirportID)) {
                    biggestSourceDifference = originMapID - destinationMapID;
                }
                if (biggestSourceDifference > sourceMaxValue) {
                    sourceMaxValue = biggestSourceDifference;
                    maxAirportID = originAirportID;
                }
            }
        }

        return maxAirportID;
    }

    //Question 6
    public String airportBiggestSinkOfAirplanes() {
        ArrayList<String> outgoingAirportIDList = new ArrayList<>();
        ArrayList<String> incomingAirportIDList = new ArrayList<>();

        for (Flight flight : flights) {
            String cancellationCode = flight.getStringProperty("CancellationCode");
            String originAirportID = flight.getStringProperty("OriginAirportID");
            Integer diverted = flight.getNumericalProperty("Diverted");
            boolean dataEntryExists = (originAirportID != null && cancellationCode == null) && diverted != 1;
            if (dataEntryExists) {
                outgoingAirportIDList.add(originAirportID);
            }
        }

        for (Flight flight : flights) {
            String cancellationCode = flight.getStringProperty("CancellationCode");
            String destinationAirportID = flight.getStringProperty("DestAirportID");
            Integer diverted = flight.getNumericalProperty("Diverted");
            boolean dataEntryExists = (destinationAirportID != null && cancellationCode == null && diverted != 1);
            if (dataEntryExists) {
                incomingAirportIDList.add(destinationAirportID);
            }
        }

        HashMap<String, Integer> outgoingAirportIDMap = new HashMap<>();
        for (String i : outgoingAirportIDList) {
            Integer count = outgoingAirportIDMap.get(i);
            outgoingAirportIDMap.put(i, (count == null) ? 1 : count + 1);
        }

        HashMap<String, Integer> incomingAirportIDMap = new HashMap<>();
        for (String i : incomingAirportIDList) {
            Integer count = incomingAirportIDMap.get(i);
            incomingAirportIDMap.put(i, (count == null) ? 1 : count + 1);
        }
        int sinkMaxValue = 0;
        int biggestSinkDifference = 0;
        String sinkMaxAirportID = "";
        String sinkOriginAirportID = "";
        String sinkDestinationAirportID = "";

        for (String j : outgoingAirportIDMap.keySet()) {
            Integer sinkOriginMapID = outgoingAirportIDMap.get(j);
            sinkOriginAirportID = j;
            for (String value : incomingAirportIDMap.keySet()) {
                Integer sinkDestinationMapID = incomingAirportIDMap.get(value);
                sinkDestinationAirportID = value;
                if (sinkOriginAirportID.equals(sinkDestinationAirportID)) {
                    biggestSinkDifference = sinkDestinationMapID - sinkOriginMapID;
                }
                if (biggestSinkDifference > sinkMaxValue) {
                    sinkMaxValue = biggestSinkDifference;
                    sinkMaxAirportID = sinkOriginAirportID;
                }
            }
        }
        return sinkMaxAirportID;
    }

    //Question1
    public String highestPercentageOfCancelledFlights() {
        ArrayList<String> airlines = new ArrayList<>();
        ArrayList<String> airlineCancelled = new ArrayList<>();
        for (Flight flight : flights) {
            String carrierID = flight.getStringProperty("UniqueCarrier");
            Integer cancelled = flight.getNumericalProperty("Cancelled");
            boolean dataEntryExists = (carrierID != null);
            boolean dataEntryExistsDouble = (carrierID != null && cancelled == 1);
            if (dataEntryExists) {
                airlines.add(carrierID);
            }
            if (dataEntryExistsDouble) {
                airlineCancelled.add(carrierID);
            }
        }

        HashMap<String, Integer> airlineMap = new HashMap<>();

        for (String i : airlines) {
            Integer count = airlineMap.get(i);
            airlineMap.put(i, (count == null) ? 1 : count + 1);
        }

        HashMap<String, Integer> airlineCancelledMap = new HashMap<>();

        for (String i : airlineCancelled) {
            Integer count = airlineCancelledMap.get(i);
            airlineCancelledMap.put(i, (count == null) ? 1 : count + 1);
        }

        //Compare Both HashMaps
        double maxValue = 0;
        double cancelledPercentage = 0;
        String airlineWithHighestCancelledPercentage = "";
        String airlineTotal = "";
        String airlineCancelledTotal = "";

        for (String key : airlineMap.keySet()) {
            Integer airlineTotalID = airlineMap.get(key);
            airlineTotal = key;
            for (String i : airlineCancelledMap.keySet()) {
                Integer airlineCancelledTotalID = airlineCancelledMap.get(i);
                airlineCancelledTotal = i;
                if (airlineTotal.equals(airlineCancelledTotal)) {
                    cancelledPercentage = (double) airlineCancelledTotalID / airlineTotalID * 100;
                }
                if (cancelledPercentage > maxValue) {
                    maxValue = cancelledPercentage;
                    airlineWithHighestCancelledPercentage = airlineTotal;
                }
            }
        }
        return airlineWithHighestCancelledPercentage + "," + maxValue + "%";
    }

    //Question 7
    public int delayedAmericanAirlines() {
        ArrayList<String> americanAirlinesDelayedGreaterThan60 = new ArrayList<>();
        for (Flight flight : flights) {
            String americanAirlines = flight.getStringProperty("UniqueCarrier");
            Integer delayedDeparture = flight.getNumericalProperty("DepDelay");
            Integer delayedArrival = flight.getNumericalProperty("ArrDelay");
            boolean delDepartureExists = (delayedDeparture != null && delayedDeparture > 60);
            boolean delArrivalExists = (delayedArrival != null && delayedArrival > 60);
            if (americanAirlines.equals("AA")) {
                if (delDepartureExists || delArrivalExists) {
                    americanAirlinesDelayedGreaterThan60.add(americanAirlines);
                }
            }
        }
        return americanAirlinesDelayedGreaterThan60.size();
    }

    //Question 8
    public String largestDelayMadeUp() {
        int maxValue = 0;
        int biggestDifference = 0;
        String answer = "";
        for (Flight flight : flights) {
            Integer dayOfMonth = flight.getNumericalProperty("DayofMonth");
            Integer delayedDeparture = flight.getNumericalProperty("DepDelay");
            String tailNum = flight.getStringProperty("TailNum");
            Integer delayedArrival = flight.getNumericalProperty("ArrDelay");
            boolean delDepartureExists = (delayedDeparture != null && delayedDeparture > 0);
            boolean delArrivalExists = (delayedArrival != null && delayedArrival <= 0);
            if (delDepartureExists && delArrivalExists) {
             biggestDifference = delayedDeparture - delayedArrival;
            }
            if (biggestDifference > maxValue) {
                maxValue = biggestDifference;
                answer = dayOfMonth + "," + delayedDeparture + "," + tailNum;
            }
        }
        return answer;
    }
}