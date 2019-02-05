
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;

public class BankStatementByDay {
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    int numberOfTransactions;
    BigDecimal remainingBudgetForMeal;

    public BankStatementByDay(Preference preference,Budget budget,int date,int month,int year,Flags flags){
        date=date+1;
        numberOfTransactions=0;
        java.lang.String time;
        remainingBudgetForMeal=budget.getFood().divide(new BigDecimal("365"),2,RoundingMode.DOWN);
        for(int i=0;i<24;i++){
            time=i+":00";
        if(i==0 && flags.isPayEducation()){
            BigDecimal amount=budget.getEducation().divide(new BigDecimal(2),2, RoundingMode.DOWN);
            transactions.add(new Transaction(year,month,date,time,"Education",
                    "PennState",amount,"StateCollege","ONLINE"));
            numberOfTransactions++;
        }
        if(i==0&&flags.isPayHealthcare()){
            transactions.add(new Transaction(year,month,date,time,"HealthCare",
                    "DoNotWantYouDie.INC", budget.getHealthcare(),"StateCollege",
                    "ONLINE"));
            numberOfTransactions++;
        }
        if(i==19&&flags.isPayApparel()){
            transactions.add(new Transaction(year,month,date,time,"Apparel",
                    "NotUniform.INC",budget.getApparel().divide(new BigDecimal("12"),2,RoundingMode.DOWN),
                    "StateCollege","CHIP"));
            numberOfTransactions++;
        }
        if(i==0&&flags.isPayTransportation()){
            transactions.add(new Transaction(year,month,date,time,"Transportation",
                    "NotSellingJets.INC",budget.getTransportations().divide(new BigDecimal("12"),2,RoundingMode.DOWN),
                    "StateCollege","ONLINE"));
            numberOfTransactions++;
        }
        if(i==21&&flags.isPayEntertainment()){
            transactions.add(new Transaction(year,month,date,time,"Entertainment",
                    "NotFunAtAll.INC",budget.getEntertainment().divide(new BigDecimal("12"),2,RoundingMode.DOWN).divide(new BigDecimal("6"),2,RoundingMode.DOWN)
                    ,"StateCollege","CHIP"));
            numberOfTransactions++;
        }
        if(i==0&&flags.isPayInsurance()){
            transactions.add(new Transaction(year,month,date,time,"Insurance",
                    "HopeYouAreFine.INC",budget.getInsurance().divide(new BigDecimal("12"),2,RoundingMode.DOWN),
                    "StateCollege","ONLINE"));
            numberOfTransactions++;

        }
        if(i==0&&flags.isPayHousing()){
            transactions.add(new Transaction(year,month,date,time,"Housing",
                    "ParadiseIsland.INC",budget.getHousing().divide(new BigDecimal("12"),2,RoundingMode.DOWN),
                    "StateCollege","ONLINE"));
            numberOfTransactions++;
        }
        if(i==18&&flags.isPayPersonal()){
            transactions.add(new Transaction(year,month,date,time,"Groceries",
                    "SupremeMarket",budget.getPersonal().divide(new BigDecimal("120"),2,RoundingMode.DOWN)
                    ,"StateCollege","CHIP"));
            numberOfTransactions++;

        }
        if(i==8){//Breakfast
            Random random = new Random();
            double ratioForBreakfast=(random.nextDouble()*2+1)*10;
            String ratioForBreakfast_S=String.format("%.2f",ratioForBreakfast);
            String companyName;

            BigDecimal budgetForBreakfast=remainingBudgetForMeal.divide(new BigDecimal("100"),2,RoundingMode.DOWN).multiply(new BigDecimal(ratioForBreakfast_S));
            double actualSpendRatio=(random.nextDouble()*20+80);
            String actualSpendRatio_S=String.format("%.2f",actualSpendRatio);
            BigDecimal actualSpendMoney=budgetForBreakfast.multiply(new BigDecimal(actualSpendRatio_S)).divide(new BigDecimal("100"),2,RoundingMode.DOWN);

            if(actualSpendMoney.compareTo(new BigDecimal("10"))<1){
                companyName="RESTAURANT_A";
            }else if(actualSpendMoney.compareTo(new BigDecimal("20"))<1){
                companyName="RESTAURANT_B";
            }else{
                companyName="RESTAURANT_C";
            }
            remainingBudgetForMeal=remainingBudgetForMeal.subtract(actualSpendMoney);
            transactions.add(new Transaction(year,month,date,time,"FOOD",
                    companyName,actualSpendMoney,"StateCollege","CHIP"));
            numberOfTransactions++;

        }
            if(i==12){//LUNCH
                Random random = new Random();
                double ratioForLunch=(random.nextDouble()*30+30);
                String ratioForLunch_S=String.format("%.2f",ratioForLunch);
                String companyName;

                BigDecimal budgetForLunch=remainingBudgetForMeal.divide(new BigDecimal("100"),2,RoundingMode.DOWN).multiply(new BigDecimal(ratioForLunch_S));
                double actualSpendRatio=(random.nextDouble()*20+80);
                String actualSpendRatio_S=String.format("%.2f",actualSpendRatio);
                BigDecimal actualSpendMoney=budgetForLunch.multiply(new BigDecimal(actualSpendRatio_S)).divide(new BigDecimal("100"),2,RoundingMode.DOWN);

                if(actualSpendMoney.compareTo(new BigDecimal("10"))<1){
                    companyName="RESTAURANT_A";
                }else if(actualSpendMoney.compareTo(new BigDecimal("20"))<1){
                    companyName="RESTAURANT_B";
                }else{
                    companyName="RESTAURANT_C";
                }
                remainingBudgetForMeal=remainingBudgetForMeal.subtract(actualSpendMoney);
                transactions.add(new Transaction(year,month,date,time,"FOOD",
                        companyName,actualSpendMoney,"StateCollege","CHIP"));
                numberOfTransactions++;

            }
            if(i==17){//DINNER
                String companyName;
                if(remainingBudgetForMeal.compareTo(new BigDecimal("10"))<1){
                    companyName="RESTAURANT_A";
                }else if(remainingBudgetForMeal.compareTo(new BigDecimal("20"))<1){
                    companyName="RESTAURANT_B";
                }else{
                    companyName="RESTAURANT_C";
                }
                transactions.add(new Transaction(year,month,date,time,"FOOD",
                        companyName,remainingBudgetForMeal,"StateCollege","CHIP"));
                numberOfTransactions++;

            }

    }




    }




    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }



    public void printTransactions(java.lang.String filePath,String userID){
        for(int i=0;i<transactions.size();i++){
            System.out.println(transactions.get(i).toString());

                    try {
                        this.Output_transactions(userID);
                    }
                    catch (Exception e) {
                        System.out.println(e);

        }


        }

        //todo
    }




    public void Output_transactions(String userID) throws IOException
    {
        for(int i=0;i<transactions.size();i++){

        String str = transactions.get(i).toString();
        String location =userID+".csv";
        FileWriter fs = null;
        try {
            fs = new FileWriter(location,true);
            fs.write(str + "\n");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            fs.close();
        }
        //todo
    }


    }
}