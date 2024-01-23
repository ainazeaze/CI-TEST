package fil.coo;
import java.util.ArrayList;

public class CompteEpargne extends Account {
    private ArrayList<Double> credit = new ArrayList<>();
    private ArrayList<Double> debit  = new ArrayList<>();
    private String name;
    private double interet = 1.1;

    public CompteEpargne(String name){
        super(name);
    }
    
    public double getInteret(){
        return this.interet;
    }
    public int getCreditTaille(){
        return this.credit.size();
    }
    
    public int getDebitTaille(){
        return this.debit.size();
    }

    public double getSolde(){
        return this.getCredit();
    }

    public double getCredit(){
        double res = 0;
        for(int i = 0 ; i< this.credit.size(); i++){
            res += this.credit.get(i);
        }
        return res;
    }

    public double getDebit(){
        double res = 0;
        for(int i = 0 ; i< this.debit.size(); i++){
            res += this.debit.get(i);
        }
        return res;
    }

    public void crediter(double creditAdd){
        if(this.credit.size()==3){
            ArrayList<Double> newCredit = new ArrayList<>();
            newCredit.add(this.getCredit());
            newCredit.add(creditAdd);
            this.credit = newCredit;
        }else{
            this.credit.add(creditAdd);
        }

    }

    public void debiter(double debitAdd) throws Exception{
        if(this.getSolde() - debitAdd >= 0){
            if(this.debit.size()==3){
                ArrayList<Double> newDebit = new ArrayList<>();
                newDebit.add(this.getDebit());
                newDebit.add(debitAdd);
                this.debit = newDebit;
            }else{
                this.debit.add(debitAdd);
            }
        }else{
            throw new Exception("Debit impossible");
        }
    }
    public void addInteret(){
        ArrayList<Double> newCredit = new ArrayList<Double>();
        for(int i = 0; i<this.credit.size(); i++){
            newCredit.add(this.credit.get(i)*this.interet);
        }
        this.credit = newCredit;
    }
     
}


