import java.util.ArrayList;

public class BankStatement {
    private int accountLength;
    private int[] transactionID={1000};
    private ArrayList<BankStatementByYear> statement = new ArrayList<BankStatementByYear>();

    public BankStatement(ArrayList<BankStatementByYear> statement) {
        this.statement=statement;
    }

    public void printStatement(String filePath,String userID){
        for(int i=0;i<statement.size();i++){
            statement.get(i).printStatement(filePath,userID,transactionID);
        }
    }


public BankStatement(Preference preference,Budget budget,int accountlength){
        this.accountLength=accountlength;
        for(int i=0;i<accountlength;i++){
    statement.add(new BankStatementByYear(preference,budget,(2018-i)));
    }




}


}
