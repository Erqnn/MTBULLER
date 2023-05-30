import java.util.*;
import java.io.Serializable;
import java.time.*;

public class TravelPackage implements Serializable {
    private LocalDate startdate;
    private int packageID;
    static int nextID = 1;
    private int custID;
    private String name;
    private int days;
    private boolean liftpass;
    private double liftprice;
    private Accommodation accommodation;
    private double pricePerDay;
    private int lessons;
    private int lessonprice;
    private double total;
    private String skiiLevel;
    private String type;
    private String liftType;
    private String lessonType;

    private static ArrayList<Customer> customers;
    private static ArrayList<Accommodation> accommodations;

    public TravelPackage() {

    }

    public TravelPackage(Accommodation accommodation, LocalDate startdate, int days, double total, Customer customer) {
        this.startdate = startdate;
        this.custID = customer.getCustID();
        this.name = customer.getName();
        this.skiiLevel = customer.getSkiiLevel();
        this.type = accommodation.getType();
        this.total = total;
        packageID = nextID++;
        this.days = days;
        this.liftpass = false;
        this.liftprice = 0;
        this.lessonprice = 0;
        this.accommodation = accommodation;
    }

    public void addLiftPass(String liftType, int liftPrice) {
        this.liftpass = true;
        this.liftprice = liftPrice;
        this.liftType = liftType;
        this.total += liftPrice;
    }

    public void addLessonFees(String lessonType, int lessonDuration) {
        this.lessons = lessonDuration;
        this.lessonType = lessonType;
        this.lessonprice = calculateLessonPrice(lessonType, lessonDuration);
        this.total += lessonprice;
    }

    private int calculateLessonPrice(String lessonType, int lessonDuration) {
        int pricePerHour;
        if (lessonType.equalsIgnoreCase("private")) {
            pricePerHour = 50;
        } else if (lessonType.equalsIgnoreCase("group")) {
            pricePerHour = 30;
        } else {
            // Handle invalid lesson types
            return 0;
        }
    
        return pricePerHour * lessonDuration;
    }


    public boolean hasLiftPass() {
        return liftpass;
    }

    
    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isLiftpass() {
        return liftpass;
    }

    public void setLiftpass(boolean liftpass) {
        this.liftpass = liftpass;
    }

    public double getLiftprice() {
        return liftprice;
    }

    public void setLiftprice(double liftprice) {
        this.liftprice = liftprice;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getLessons() {
        return lessons;
    }

    public void setLessons(int lessons) {
        this.lessons = lessons;
    }

    public int getLessonprice() {
        return lessonprice;
    }

    public void setLessonprice(int lessonprice) {
        this.lessonprice = lessonprice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getSkiiLevel() {
        return skiiLevel;
    }

    public void setSkiiLevel(String skiiLevel) {
        this.skiiLevel = skiiLevel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(ArrayList<Customer> customers) {
        TravelPackage.customers = customers;
    }

    public static ArrayList<Accommodation> getAccommodations() {
        return accommodations;
    }

    public static void setAccommodations(ArrayList<Accommodation> accommodations) {
        TravelPackage.accommodations = accommodations;
    }

    @Override
    public String toString() {
        String hasLiftPassString = liftpass ? "Yes" : "No";
        String liftPassInfo = liftpass ? "Lift Pass Type: " + liftType + "\nLift Pass Price: $" + liftprice + "\n" : "";
        String lessonInfo = lessons > 0 ? "Lesson Type: " + lessonType + "\nLesson Duration: " + lessons + " hours\nLesson Price: $" + lessonprice + "\n" : "";
        return "Customer ID: " + custID + "\nCustomer Name: " + name + "\nPackage ID: " + packageID
                + "\nAmount of days: " + days + "\nStart Date: " + startdate
                + "\nAccommodation: " + type + "\nHas Lift Pass: " + hasLiftPassString
                + "\n\n" + liftPassInfo + lessonInfo
                + "Total: $" + total;
    }
}