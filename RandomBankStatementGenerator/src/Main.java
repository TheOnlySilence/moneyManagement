import java.math.BigDecimal;
import java.util.Random;
import java.io.*;

public class Main {


    private static void generatePersonalData(int i,String folder_path) {


        Random random = new Random();
        User user=new User();
        //------------------------------------------
        boolean type=random.nextBoolean();
        user.setType(type);
        //------------------------------------------
        int accountLength=random.nextInt(10)+1;
        user.setAccountLength(accountLength);
        //------------------------------------------
        Double income;
        if(type){
        income=random.nextDouble()*50000+30000;
        }
        else{
        income=random.nextDouble()*30000+40000;
        }

        String income_S=String.format("%.2f",income);
        BigDecimal income_BD=new BigDecimal(income_S);
        user.setTotalIncome(income_BD);
        //------------------------------------------
        Budget budget=new Budget(income_BD,type);
        user.setBudget(budget);
        //------------------------------------------
        user.setPreference(new Preference());
        //------------------------------------------
        String user_ID=String.format("%04d",i);
        user.setUser_ID(user_ID);
        //------------------------------------------
        Preference preference= new Preference();
        user.setPreference(preference);
        //-----------------------------------------
        String filePath_data;
        filePath_data=folder_path+"/"+user_ID+".csv";
        String filePath_information;
        filePath_information=user_ID+".csv";
        //----DEBUG_INFORMATION---------------------
        System.out.println(user.getPreference().toString());
        System.out.println("Income:");
        System.out.println(income_S);
        System.out.println("TotalBudget:");
        System.out.println(user.getBudget().getTotalBudget());
        System.out.println("Food:");
        System.out.println(user.getBudget().getFood());
        System.out.println("Housing:");
        System.out.println(user.getBudget().getHousing());
        System.out.println("Apparel:");
        System.out.println(user.getBudget().getApparel());
        System.out.println("Transportation:");
        System.out.println(user.getBudget().getTransportations());
        System.out.println("Healthcare:");
        System.out.println(user.getBudget().getHealthcare());
        System.out.println("Entertainment:");
        System.out.println(user.getBudget().getEntertainment());
        System.out.println("Personal:");
        System.out.println(user.getBudget().getPersonal());
        System.out.println("Education:");
        System.out.println(user.getBudget().getEducation());
        System.out.println("Insurance:");
        System.out.println(user.getBudget().getInsurance());
        System.out.println("Saving:");
        System.out.println(user.getBudget().getSaving());
        System.out.println("RemainBudget:");
        System.out.println(user.getBudget().getRemainBudget());
        System.out.println("-------------------------------------");
        System.out.println("TotalBudget:");
        System.out.println(user.getBudget().getTotalBudget());
        System.out.println("-------------------------------------");
        //----DEBUG_INFORMATION-----------------------------------
        user.generateBankStatment();
        user.getBankStatement().printStatement(filePath_information,user.getUser_ID());


    }



    public static void main(String[] args){

        for(int i=0;i<15;i++){
            System.out.println("//------------------------------------------");
            String Folder_path=".\\userdata.csv";
            generatePersonalData(i,Folder_path);

            System.out.println("//------------------------------------------");
            //here is a test
            //here is another test
            //test
        }

    }


}