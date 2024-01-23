package fil.coo;

import static org.junit.Assert.*;

import org.junit.*;


/**
 * Unit test for simple App.
 */
public class CompteCreditDebitTest 
{
    /**
     * Rigorous Test :-)
     */
    private Account compteTest;
    @Before
    public void createCompte()
    {
        this.compteTest = new Account("Aina");
    }
    @Test
    public void CreationCompteCreditZero()
    {
        assertTrue(this.compteTest.getCredit() == 0);
    }
     @Test
    public void CreationCompteDebitZero()
    {
        assertTrue(this.compteTest.getDebit() == 0);
    }

    @Test
    public void CompteCrediterTest() throws Exception{
        double val = this.compteTest.getCredit();
        this.compteTest.crediter(100);
        assertTrue(this.compteTest.getCredit() == val + 100);
    }
    @Test
    public void CompteDebiterTest() throws Exception{
        double val = this.compteTest.getDebit();
        this.compteTest.debiter(100);
        assertTrue(this.compteTest.getDebit() == val + 100);
    }
    @Test(expected = Exception.class)
    public void CompteDebiterNegatifThrowExceptionTest() throws Exception
    {
        this.compteTest.debiter(-500);
    }
    @Test(expected = Exception.class)
    public void CompteCrediterNegatifThrowExceptionTest() throws Exception
    {
        this.compteTest.crediter(-500);
    }
    @Test
    public void CrediterSoldeTest() throws Exception{
        this.compteTest.crediter(500);
        assertTrue(this.compteTest.getSolde() == 500);

    }
    @Test
    public void DebiterSoldeTest() throws Exception{
        this.compteTest.crediter(500);
        this.compteTest.debiter(300);
        assertTrue(this.compteTest.getSolde() == 200);

    }
    @Test
    public void ReleveCrediterCompteTest() throws Exception{
        this.compteTest.crediter(50);
        assertTrue(this.compteTest.getCreditListe(0) == 50);
    
        this.compteTest.crediter(60);
        this.compteTest.crediter(70);
        this.compteTest.crediter(80);

        assertTrue(this.compteTest.getCreditListe(0) == 180);

    }
    @Test
    public void ReleveDebiterCompteTest() throws Exception{

        this.compteTest.debiter(50);
        assertTrue(this.compteTest.getDebitListe(0) == 50);
    
        this.compteTest.debiter(60);
        this.compteTest.debiter(70);
        this.compteTest.debiter(80);

        assertTrue(this.compteTest.getDebitListe(0) == 180);

    }
    @Test(expected = Exception.class)
    public void Crediter100001()throws Exception{
        this.compteTest.crediter(100001);
    }
    @Test(expected = Exception.class)
    public void Debiter100001()throws Exception{
        this.compteTest.debiter(100001);
    }
}
