import java.math.BigDecimal;
import java.util.Random;

public class User {
    private String user_ID;
    private boolean type;
    private BigDecimal totalIncome;
    private int accountLength;
    private Preference preference;
    private Budget budget;
    private BankStatement bankStatement;
    public User(){



    }

    public void generateBankStatment(){

    this.bankStatement=new BankStatement(preference,budget,accountLength);




    }

    public void setBankStatement(BankStatement bankStatement) {
        this.bankStatement = bankStatement;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void setAccountLength(int accountLength) {
        this.accountLength = accountLength;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public void setUser_ID(String user_ID) {this.user_ID=user_ID;}

    public BankStatement getBankStatement() {
        return bankStatement;
    }

    public String getUser_ID() {return user_ID;}

    public boolean getType(){
        return type;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public int getAccountLength() {
        return accountLength;
    }

    public Preference getPreference() {
        return preference;
    }

    public Budget getBudget(){return budget;}
}
