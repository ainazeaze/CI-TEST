package fil.coo;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class Account 
{
    private ArrayList<Double> credit = new ArrayList<>();
    private ArrayList<Double> debit  = new ArrayList<>();
    private String name;

    public Account(String name)
    {
        this.name = name;
    }

    public double getCreditListe(int i){
        return this.credit.get(i);
    }

    public Double getDebitListe(int i){
        return this.debit.get(i);
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
    public double getSolde(){
        return this.getCredit() - this.getDebit();
    }

    public void crediter(double creditAdd) throws Exception{
        if(creditAdd <= 0)
        {
            throw new Exception("Montant négatif ou nul");
        }else if(creditAdd > 100000){
            throw new Exception("Le blanchissement c'est pas bien");
        }
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
        if(debitAdd <= 0)
        {
            throw new Exception("Montant négatif ou nul");
        }else if(debitAdd > 100000){
            throw new Exception("Le blanchissement c'est pas bien");
        }
        if(this.debit.size()==3){
            ArrayList<Double> newDebit = new ArrayList<>();
            newDebit.add(this.getDebit());
            newDebit.add(debitAdd);
            this.debit = newDebit;
        }else{
            this.debit.add(debitAdd);
        }
    }
}
