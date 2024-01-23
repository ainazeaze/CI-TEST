package fil.coo;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();
    private String name;

    public Bank(String name){
        this.name = name;
    }

    public int getComptes(){
        return this.accounts.size();
    }

    public void openAccount(String name){
        this.accounts.add(new Account(name));
    }
    public void openCompteEpargne(String name){
        this.accounts.add(new CompteEpargne(name));
    }
    public Account getAccount(int i) throws Exception{
        if (this.accounts.size() >= i){
            return this.accounts.get(i);
        }else{
            throw new Exception("Le compte n'existe pas");
        }
    }

    public void virement(int src, int dest, int val) throws Exception{
        Account acc1;
        Account acc2 ;
        try
        {
            acc1 = this.getAccount(src);
            acc2 = this.getAccount(dest);
        }catch(Exception ex){
            throw new Exception("Compte non existant");
        }
        try{
            acc1.debiter(val);
        }catch(Exception ex){
            throw new Exception("Compte epargne debit negatif");
        }
        acc2.crediter(val);
        this.accounts.set(src, acc1);
        this.accounts.set(dest, acc2);
    }
}
