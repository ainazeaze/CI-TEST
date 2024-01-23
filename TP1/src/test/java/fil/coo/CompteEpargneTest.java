package fil.coo;

import static org.junit.Assert.*;

import org.junit.*;

import fil.coo.CompteEpargne;


public class CompteEpargneTest {
    private CompteEpargne compteEpargneTest;
    @Before
    public void createCompte()
    {
        this.compteEpargneTest = new CompteEpargne("compte");
    }

    @Test
    public void CreationCompteEpargneTest(){
        assertTrue(this.compteEpargneTest.getCreditTaille()== 0);
        assertTrue(this.compteEpargneTest.getDebitTaille()== 0);

    }
    
    @Test
    public void CrediterSoldeCompteEpargne(){
        this.compteEpargneTest.crediter(50);
        assertTrue(this.compteEpargneTest.getSolde() == 50);
    }

    // @Test
    // public void debiterCompteEpargneImpossible(){
    //     double debit = this.compteEpargneTest.getDebit();
    //     double value = 50;
    //     this.compteEpargneTest.debiter(value);
    //     assertTrue(this.compteEpargneTest.getDebit() == debit);
    // }


    @Test(expected = Exception.class)
    public void debiterCompteEpargneImpossibleException() throws Exception{
        this.compteEpargneTest.debiter(50);
    }
    @Test
    public void InteretAjoutTest(){
        this.compteEpargneTest.crediter(100);
        double credit = this.compteEpargneTest.getCredit();
        this.compteEpargneTest.addInteret();
        assertTrue(this.compteEpargneTest.getCredit() == credit * this.compteEpargneTest.getInteret());
    }
}






