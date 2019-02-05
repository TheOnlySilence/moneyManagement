import java.util.ArrayList;

public class BankStatementByMonth {
    private int numberOfDays;
    private ArrayList<BankStatementByDay> bankstatementByDay = new ArrayList<BankStatementByDay>();

    public BankStatementByMonth(int numberOfDays,Preference preference,Budget budget,int month,int year)
    {
        this.numberOfDays=numberOfDays;
        for (int i=0; i != numberOfDays;++i){
            Flags flags=new Flags();
            double date=month+i/100;

                if(i==preference.getDayToPayApparel()){
                    flags.setPayApparel(true);
                }
                if(i==preference.getDayToPayHousing()){
                    flags.setPayHousing(true);

                }
                if(i==preference.getDayToPayInsurance()){
                    flags.setPayInsurance(true);
                }
                if(i==preference.getDayToPayTransportations()){
                    flags.setPayTransportation(true);
                }
                if(date==preference.getDateToPayHealthcare()){
                    flags.setPayHealthcare(true);
                }
                if(date==9.01||date==1.10){
                    flags.setPayEducation(true);
                }
                if(i%5==0){
                    flags.setPayEntertainment(true);
                }
                if(i%3==0){
                    flags.setPayPersonal(true);
                }
                bankstatementByDay.add(new BankStatementByDay(preference,budget,i,month,year,flags));

        }
    }


    public void printStatement(String filePath,String userID){
    for (int i=0;i<bankstatementByDay.size();i++){
        bankstatementByDay.get(i).printTransactions(filePath,userID);
    }


    }



}
