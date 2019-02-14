import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Random;

public class Budget {
    public final static String FOOD_MINIMUM_E="4380";
    public final static String HOUSING_MINIMUM_E="12000";
    public final static String APPAREL_MINIMUM_E="1500";
    public final static String TRANSPORTATION_MINIMUM_E="6000";
    public final static String HEALTHCARE_MINIMUM_E="1000";
    public final static String ENTERTAINMENT_MINIMUM_E="1000";
    public final static String PERSONAL_MINIMUM_E="1000";
    public final static String EDUCATION_MINIMUM_E="0";
    public final static String INSURANCE_MINIMUM_E="1500";
    public final static String SAVING_MINIMUM_E="1000";
    //MINIMUM total:30000
    //---------------------------------------------------------------
    public final static String FOOD_MINIMUM_S="4380";
    public final static String HOUSING_MINIMUM_S="4800";
    public final static String PERSONAL_MINIMUM_S="1000";
    public final static String APPAREL_MINIMUM_S="1000";
    public final static String TRANSPORTATION_MINIMUM_S="1200";
    public final static String EDUCATION_MINIMUM_S="22000";
    public final static String INSURANCE_MINIMUM_S="3000";
    public final static String SAVING_MINIMUM_S="0";
    public final static String ENTERTAINMENT_MINIMUM_S="1000";
    public final static String HEALTHCARE_MINIMUM_S="1000";
    //MINIMUM total:40000
    //---------------------------------------------------------------

    private BigDecimal totalBudget;
    private BigDecimal food;
    private BigDecimal housing;
    private BigDecimal apparel;
    private BigDecimal transportations;
    private BigDecimal healthcare;
    private BigDecimal entertainment;
    private BigDecimal personal;
    private BigDecimal education;
    private BigDecimal insurance;
    private BigDecimal saving;
    private BigDecimal remainBudget;
    private BigDecimal housingPerMonth;
    private BigDecimal transportationPerMonth;
    private BigDecimal personalPerMonth;


    public void remainBudgetDistribution(){
        Random random = new Random();
        BigDecimal minimumUnit=totalBudget.divide(new BigDecimal("100000"),3, RoundingMode.DOWN);
        //System.out.println("minimumUnit:");
        //System.out.println(minimumUnit);
        int remainingShare= remainBudget.divide(minimumUnit,2,RoundingMode.DOWN).intValue();
        //System.out.println("Remaining Budget:");
        //System.out.println(remainBudget);
        //System.out.println("Remaining Share:");
        //System.out.println(remainingShare);
        for(int i=0;i<remainingShare;i++){
            double result =random.nextDouble()*10;
            if(result<1){
                food=food.add(minimumUnit);
                remainBudget=remainBudget.subtract(minimumUnit);
            }
            else if(result<2){
                housing=housing.add(minimumUnit);
                remainBudget=remainBudget.subtract(minimumUnit);
            }
            else if(result<3){
                apparel=apparel.add(minimumUnit);
                remainBudget=remainBudget.subtract(minimumUnit);
            }
            else if(result<4){
                transportations=transportations.add(minimumUnit);
                remainBudget=remainBudget.subtract(minimumUnit);
            }
            else if(result<5){
                healthcare=healthcare.add(minimumUnit);
                remainBudget=remainBudget.subtract(minimumUnit);
            }
            else if(result<6){
                entertainment=entertainment.add(minimumUnit);
                remainBudget=remainBudget.subtract(minimumUnit);
            }
            else if(result<7){
                personal=personal.add(minimumUnit);
                remainBudget=remainBudget.subtract(minimumUnit);
            }
            else if(result<8){
                education=education.add(minimumUnit);
                remainBudget=remainBudget.subtract(minimumUnit);
            }
            else if(result<9){
                insurance=insurance.add(minimumUnit);
                remainBudget=remainBudget.subtract(minimumUnit);
            }
            else{
                saving=saving.add(minimumUnit);
                remainBudget=remainBudget.subtract(minimumUnit);
            }
        }

    }

    public Budget(BigDecimal totalBudget,Boolean type){
        this.totalBudget=totalBudget;
        if (type==true){
            this.food=new BigDecimal(FOOD_MINIMUM_E);
            this.housing=new BigDecimal(HOUSING_MINIMUM_E);
            this.apparel=new BigDecimal(APPAREL_MINIMUM_E);
            this.transportations=new BigDecimal(TRANSPORTATION_MINIMUM_E);
            this.healthcare=new BigDecimal(HEALTHCARE_MINIMUM_E);
            this.entertainment=new BigDecimal(ENTERTAINMENT_MINIMUM_E);
            this.personal=new BigDecimal(PERSONAL_MINIMUM_E);
            this.education=new BigDecimal(EDUCATION_MINIMUM_E);
            this.insurance=new BigDecimal(INSURANCE_MINIMUM_E);
            this.saving=new BigDecimal(SAVING_MINIMUM_E);

        }else{
            this.food=new BigDecimal(FOOD_MINIMUM_S);
            this.housing=new BigDecimal(HOUSING_MINIMUM_S);
            this.apparel=new BigDecimal(APPAREL_MINIMUM_S);
            this.transportations=new BigDecimal(TRANSPORTATION_MINIMUM_S);
            this.healthcare=new BigDecimal(HEALTHCARE_MINIMUM_S);
            this.entertainment=new BigDecimal(ENTERTAINMENT_MINIMUM_S);
            this.personal=new BigDecimal(PERSONAL_MINIMUM_S);
            this.education=new BigDecimal(EDUCATION_MINIMUM_S);
            this.insurance=new BigDecimal(INSURANCE_MINIMUM_S);
            this.saving=new BigDecimal(SAVING_MINIMUM_S);
        }
        this.remainBudget=totalBudget;
        this.remainBudget=remainBudget.subtract(food);
        this.remainBudget=remainBudget.subtract(housing);
        this.remainBudget=remainBudget.subtract(apparel);
        this.remainBudget=remainBudget.subtract(transportations);
        this.remainBudget=remainBudget.subtract(healthcare);
        this.remainBudget=remainBudget.subtract(entertainment);
        this.remainBudget=remainBudget.subtract(personal);
        this.remainBudget=remainBudget.subtract(education);
        this.remainBudget=remainBudget.subtract(insurance).subtract(saving);
        this.remainBudgetDistribution();
        this.housingPerMonth=housing.divide(new BigDecimal("12"),2, RoundingMode.DOWN);
        this.transportationPerMonth=housing.divide(new BigDecimal("12"),2, RoundingMode.DOWN);
        this.personalPerMonth=personal.divide(new BigDecimal("12"),2,RoundingMode.DOWN);
    }

    public void generatePersonalReport(String filePath){
        //TODO




    }



    public void setTotalBudget(BigDecimal totalBudget) {
        this.totalBudget = totalBudget;
    }

    public void setFood(BigDecimal food) {
        this.food = food;
    }

    public void setHousing(BigDecimal housing) {
        this.housing = housing;
    }

    public void setApparel(BigDecimal apparel) {
        this.apparel = apparel;
    }

    public void setTransportations(BigDecimal transportations) {
        this.transportations = transportations;
    }

    public void setHealthcare(BigDecimal healthcare) {
        this.healthcare = healthcare;
    }

    public void setEntertainment(BigDecimal entertainment) {
        this.entertainment = entertainment;
    }

    public void setPersonal(BigDecimal personal) {
        this.personal = personal;
    }

    public void setEducation(BigDecimal education) {
        this.education = education;
    }

    public void setInsurance(BigDecimal insurance) {
        this.insurance = insurance;
    }

    public void setSaving(BigDecimal saving) {
        this.saving = saving;
    }

    public void setRemainBudget(BigDecimal remainBudget) {
        this.remainBudget = remainBudget;
    }

    public BigDecimal getTotalBudget() {
        return totalBudget;
    }

    public BigDecimal getFood() {
        return food;
    }

    public BigDecimal getApparel() {
        return apparel;
    }

    public BigDecimal getEducation() {
        return education;
    }

    public BigDecimal getEntertainment() {
        return entertainment;
    }

    public BigDecimal getHealthcare() {
        return healthcare;
    }

    public BigDecimal getInsurance() {
        return insurance;
    }

    public BigDecimal getPersonal() {
        return personal;
    }

    public BigDecimal getSaving() {
        return saving;
    }

    public BigDecimal getTransportations() {
        return transportations;
    }

    public BigDecimal getHousing() {
        return housing;
    }

    public BigDecimal getRemainBudget() {
        return remainBudget;
    }
}
