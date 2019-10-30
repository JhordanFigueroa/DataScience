public class Flight {
    private int DayofMonth;
    private int DayofWeek;
    private String FlightDate;
    private String UniqueCarrier;
    private String TailNum;
    private String OriginAirportID;
    private String Origin;
    private String OriginStateName;
    private String DestAirportID;
    private String Destination;
    private String DestStateName;
    private int DepTime;
    private int DepDelay;
    private int WheelsOff;
    private int WheelsOn;
    private int ArrTime;
    private int ArrDelay;
    private int Cancelled;
    private String CancelledCode;
    private int Diverted;
    private int AirTime;
    private int Distance;

    public Flight(int DayofMonth, int DayofWeek, String FlightDate, String UniqueCarrier, String TailNum,
                  String OriginAirportID, String OriginLetters, String nameStateOrigin, String airportIDDest,
                  String destinationLetters, String stateNameDest, int timeDep, int delayDep, int offWheels,
                  int onWheels, int timeArr, int delayArr, int cancelled, String cancelledCode, int diverted,
                  int timeAir, int distance)
    {
        //flight constructor
        this.DayofMonth = DayofMonth;
        this.DayofWeek = DayofWeek;
        this.FlightDate = FlightDate;
        this.UniqueCarrier = UniqueCarrier;
        this.TailNum = TailNum;
        this.OriginAirportID = OriginAirportID;
        this.Origin = OriginLetters;
        this.OriginStateName = nameStateOrigin;
        this.DestAirportID = airportIDDest;
        this.Destination = destinationLetters;
        this.DestStateName = stateNameDest;
        this.DepTime = timeDep;
        this.DepDelay = delayDep;
        this.WheelsOff = offWheels;
        this.WheelsOn = onWheels;
        this.ArrTime = timeArr;
        this.ArrDelay = delayArr;
        this.Cancelled = cancelled;
        this.CancelledCode = cancelledCode;
        this.Diverted = diverted;
        this.AirTime = timeAir;
        this.Distance = distance;
    }

    @Override
    public String toString() {
        return OriginStateName;
    }
    public int getDayofMonth() {
        return DayofMonth;
    }

    public int getDayofWeek() {
        return DayofWeek;
    }

    public String getFlightDate() {
        return FlightDate;
    }

    public String getUniqueCarrier() {
        return UniqueCarrier;
    }

    public String getTailNum() {
        return TailNum;
    }

    public String getOriginAirportID() {
        return OriginAirportID;
    }

    public String getOrigin() {
        return Origin;
    }

    public String getOriginStateName() {
        return OriginStateName;
    }

    public String getDestAirportID() {
        return DestAirportID;
    }

    public String getDestination() {
        return Destination;
    }

    public String getDestStateName() {
        return DestStateName;
    }

    public int getDepTime() {
        return DepTime;
    }

    public int getDepDelay() {
        return DepDelay;
    }

    public int getWheelsOff() {
        return WheelsOff;
    }

    public int getWheelsOn() {
        return WheelsOn;
    }

    public int getArrTime() {
        return ArrTime;
    }

    public int getArrDelay() {
        return ArrDelay;
    }

    public int getCancelled() {
        return Cancelled;
    }

    public String getCancelledCode() {
        return CancelledCode;
    }

    public int getDiverted() {
        return Diverted;
    }

    public int getAirTime() {
        return AirTime;
    }

    public int getDistance() {
        return Distance;
    }
}
