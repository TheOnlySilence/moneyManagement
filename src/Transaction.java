import java.lang.reflect.Array;
import java.math.BigDecimal;

public class Transaction {
    private int userID;
    private int transactionID;
    private int year;
    private int month;
    private int day;
    private String time;
    private String category;
    private BigDecimal amount;
    private String companyName;
    private String location;
    private String paymentMethod;
    private String amount_s;


    public Transaction(int year,int month, int day, String time, String category, String companyName,BigDecimal amount, String location, String paymentMethod){
        this.year=year;
        this.month=month;
        this.day=day;
        this.time=time;
        this.category=category;
        this.companyName=companyName;
        this.location=location;
        this.paymentMethod=paymentMethod;
        this.amount_s=amount.toString();
    }

    public int getUserID() {
        return userID;
    }

    public String getAmount_s() {
        return amount_s;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public void setAmount_s(String amount_s) {
        this.amount_s = amount_s;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getCategory() {
        return category;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String toString_forPrint(String userID, int[]transactionID) {
        int categoryID=0;
        int companyID=0;
        int paymentType=0;
        if(this.paymentMethod.equals("CHIP"))
            paymentType=0;
        else
            paymentType=1;
        if(this.category.equals("Education"))
            categoryID=0;
        if(this.category.equals("HealthCarfe"))
            categoryID=1;
        if(this.category.equals("Apparel"))
            categoryID=2;
        if(this.category.equals("Transportation"))
            categoryID=3;
        if(this.category.equals("Entertainment"))
            categoryID=4;
        if(this.category.equals("Insurance"))
            categoryID=5;
        if(this.category.equals("Housing"))
            categoryID=6;
        if(this.category.equals("Groceries"))
            categoryID=7;
        if(this.category.equals("FOOD"))
            categoryID=8;
        if(this.companyName.equals("PennState"))
            companyID=0;
        if(this.companyName.equals("DoNotWantYouDie.INC"))
            companyID=1;
        if(this.companyName.equals("NotUniform.INC"))
            companyID=2;
        if(this.companyName.equals("NotSellingJets.INC"))
            companyID=3;
        if(this.companyName.equals("NotFunAtAll.INC"))
            companyID=4;
        if(this.companyName.equals("HopeYouAreFine.INC"))
            companyID=5;
        if(this.companyName.equals("ParadiseIsland.INC"))
            companyID=6;
        if(this.companyName.equals("SupremeMarket"))
            companyID=7;
        if(this.companyName.equals("RESTAURANT_A"))
            companyID=8;
        if(this.companyName.equals("RESTAURANT_B"))
            companyID=9;
        if(this.companyName.equals("RESTAURANT_C"))
            companyID=10;
        return (Array.getInt(transactionID,0)+","+userID+","+amount_s+","+categoryID+","+year+"-"+month+"-"+day+","+time+","+companyID+","+paymentType);
    }
}
