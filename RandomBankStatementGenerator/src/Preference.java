import java.util.Random;

public class Preference {

    private int birthMonth;
    private int birthDate;
    private int age;
    private boolean gender;
    private double averageMealsPerDay;
    private int timesToBuyCloth;
    private int dayToPayHousing;
    private int dayToPayTransportations;
    private int dayToPayInsurance;
    private int dayToPayApparel;
    private double dateToPayHealthcare;

    //TODO

    public Preference(){
        Random random = new Random();
        //---------------------------------------------------------------
        this.birthMonth=random.nextInt(12)+1;
        int MAX_DAY;
        if(this.birthMonth==1||this.birthMonth==3||this.birthMonth==5||this.birthMonth==7
                ||this.birthMonth==8||this.birthMonth==10||this.birthMonth==12){
            MAX_DAY=31;
        }else if (this.birthMonth==2){
            MAX_DAY=28;
        }else{
            MAX_DAY=30;
        }
        //---------------------------------------------------------------
        this.birthDate=random.nextInt(MAX_DAY)+1;
        //---------------------------------------------------------------
        this.age=random.nextInt(40)+20;
        //---------------------------------------------------------------
        this.gender=random.nextBoolean();
        //---------------------------------------------------------------
        this.averageMealsPerDay=random.nextDouble()+2;
        String AMPD_S=String.format("%.2f",averageMealsPerDay);
        this.averageMealsPerDay=Double.parseDouble(AMPD_S);
        //---------------------------------------------------------------
        this.timesToBuyCloth=random.nextInt(12)+1;
        //---------------------------------------------------------------
        this.dayToPayHousing=random.nextInt(28)+1;
        this.dayToPayInsurance=random.nextInt(28)+1;
        this.dayToPayTransportations=random.nextInt(28)+1;
        this.dayToPayApparel=random.nextInt(28)+1;
        this.dateToPayHealthcare=random.nextInt(12)+1+(random.nextInt(28)+1)/100;
        //---------------------------------------------------------------

    }


    public String toString(){
        return ("BirthMonth:"+birthMonth+"\n"+"BirthDate:"+birthDate+"\n"+"Age:"+age+"\n"+"Gender:"+gender+"\n"
                +"AverageMealsPerDay:"+averageMealsPerDay+"\n"+"TimesToBuyCloth:"+timesToBuyCloth+"\n"+"DayToPayHousing"+dayToPayHousing+"\n"+"DayToPayInsurance"+dayToPayInsurance);

    }

    public double getDateToPayHealthcare() {
        return dateToPayHealthcare;
    }

    public void setDateToPayHealthcare(double dateToPayHealthcare) {
        this.dateToPayHealthcare = dateToPayHealthcare;
    }

    public int getAge() {
        return age;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getDayToPayApparel() {
        return dayToPayApparel;
    }

    public boolean isGender() {
        return gender;
    }

    public double getAverageMealsPerDay() {
        return averageMealsPerDay;
    }

    public int getDayToPayHousing() {
        return dayToPayHousing;
    }

    public int getDayToPayInsurance() {
        return dayToPayInsurance;
    }

    public int getDayToPayTransportations() {
        return dayToPayTransportations;
    }

    public int getTimesToBuyCloth() {
        return timesToBuyCloth;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAverageMealsPerDay(double averageMealsPerDay) {
        this.averageMealsPerDay = averageMealsPerDay;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public void setDayToPayApparel(int dayToPayApparel) {
        this.dayToPayApparel = dayToPayApparel;
    }

    public void setDayToPayHousing(int dayToPayHousing) {
        this.dayToPayHousing = dayToPayHousing;
    }

    public void setDayToPayInsurance(int dayToPayInsurance) {
        this.dayToPayInsurance = dayToPayInsurance;
    }

    public void setDayToPayTransportations(int dayToPayTransportations) {
        this.dayToPayTransportations = dayToPayTransportations;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setTimesToBuyCloth(int timesToBuyCloth) {
        this.timesToBuyCloth = timesToBuyCloth;
    }
}



