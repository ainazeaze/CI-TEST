package fil.coo;

import static org.junit.Assert.*;

import org.junit.*;


public class BankTest {
    private Bank bankTest;
    @Before
    public void newBank(){
        this.bankTest = new Bank("BanqueName");
    }

    @Test
    public void CompteVideTest(){
        assertTrue(this.bankTest.getComptes() ==2);
    }

    @Test
    public void AjoutCompteBank(){
        this.bankTest.openAccount("nom");
        assertTrue(this.bankTest.getComptes() == 1);
        this.bankTest.openCompteEpargne("nom1");
        assertTrue(this.bankTest.getComptes() == 2);
    }

    @Test
    public void CrediterCompteTest() throws Exception{
        this.bankTest.openAccount("nom");
        this.bankTest.openCompteEpargne("nom2");
        Account compte = this.bankTest.getAccount(0);
        double credit = compte.getCredit();
        compte.crediter(100);

        assertTrue(compte.getCredit() == credit + 100);
        Account compteEpargne = this.bankTest.getAccount(1);
        double EpargneCredit = compteEpargne.getCredit();
        compteEpargne.crediter(100);
        assertTrue(compteEpargne.getCredit() == EpargneCredit + 100);
    }

    @Test
    public void DebiterCompteTest() throws Exception{
        this.bankTest.openAccount("nom");
        this.bankTest.openCompteEpargne("nom2");
        Account compte = this.bankTest.getAccount(0);
        double debit = compte.getDebit();
        compte.debiter(100);
        assertTrue(compte.getDebit() == debit + 100);

        Account compteEpargne = this.bankTest.getAccount(1);
        double EpargneDebit = compteEpargne.getDebit();
        compteEpargne.crediter(100);
        compteEpargne.debiter(100);
        assertTrue(compteEpargne.getDebit() == EpargneDebit + 100);
    }

    @Test(expected = Exception.class)
    public void OpenAccountNoExist() throws Exception{
        Account account = this.bankTest.getAccount(0);
    }

    @Test
    public void virementTestCompte() throws Exception{
        this.bankTest.openAccount("nom");
        this.bankTest.openCompteEpargne("nom2");
        Account compte = this.bankTest.getAccount(0);
        compte.crediter(300);
        Account compteEpargne = this.bankTest.getAccount(1);

        this.bankTest.virement(0, 1, 200);
        assertTrue(compte.getSolde() == 100);
        assertTrue(compteEpargne.getSolde() == 200); 

    }
    @Test(expected = Exception.class)
    public void virementTestCompteEpargneError() throws Exception{
        this.bankTest.openAccount("nom");
        this.bankTest.openCompteEpargne("nom2");

        Account compte = this.bankTest.getAccount(0);
    
        Account compteEpargne = this.bankTest.getAccount(1);
        compteEpargne.crediter(100);

        this.bankTest.virement(1, 0, 200);

    }
    @Test(expected = Exception.class)
    public void virementTestCompteInexitant() throws Exception{
        this.bankTest.openAccount("nom");
        Account compte = this.bankTest.getAccount(0);
        compte.crediter(300);

        this.bankTest.virement(0, 1, 200);

    }

}
