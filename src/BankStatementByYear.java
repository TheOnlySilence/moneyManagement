import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankStatementByYear {
    private BankStatementByMonth[] statement= new BankStatementByMonth[12];




    public BankStatementByYear(Preference preference,Budget budget,int year){
        BankStatementByMonth month1=new BankStatementByMonth(31,preference,budget,1,year);
        BankStatementByMonth month2=new BankStatementByMonth(28,preference,budget,2,year);
        BankStatementByMonth month3=new BankStatementByMonth(31,preference,budget,3,year);
        BankStatementByMonth month4=new BankStatementByMonth(30,preference,budget,4,year);
        BankStatementByMonth month5=new BankStatementByMonth(31,preference,budget,5,year);
        BankStatementByMonth month6=new BankStatementByMonth(30,preference,budget,6,year);
        BankStatementByMonth month7=new BankStatementByMonth(31,preference,budget,7,year);
        BankStatementByMonth month8=new BankStatementByMonth(31,preference,budget,8,year);
        BankStatementByMonth month9=new BankStatementByMonth(30,preference,budget,9,year);
        BankStatementByMonth month10=new BankStatementByMonth(31,preference,budget,10,year);
        BankStatementByMonth month11=new BankStatementByMonth(30,preference,budget,11,year);
        BankStatementByMonth month12=new BankStatementByMonth(31,preference,budget,12,year);
        statement[0]= month1;
        statement[1]= month2;
        statement[2]= month3;
        statement[3]= month4;
        statement[4]= month5;
        statement[5]= month6;
        statement[6]= month7;
        statement[7]= month8;
        statement[8]= month9;
        statement[9]= month10;
        statement[10]= month11;
        statement[11]= month12;

    }
    public void printStatement(String filePath,String userID,int[] transactionID){
        for(int i=0;i<12;i++){
            statement[i].printStatement(filePath,userID,transactionID);

        }


    }


}
