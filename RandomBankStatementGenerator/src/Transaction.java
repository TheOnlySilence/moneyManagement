import java.math.BigDecimal;

public class Transaction {
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

    public String toString() {
        return (transactionID+","+year+"-"+month+"-"+day+","+time+","+category+","+companyName+","+amount_s+","+location+","+paymentMethod);
    }
}
