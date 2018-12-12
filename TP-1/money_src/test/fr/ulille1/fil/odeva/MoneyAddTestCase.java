package fr.ulille1.fil.odeva;

import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;
/*
 * Unit test for simple App.
 */
public class MoneyAddTestCase
{
    private Money f12EUR,  f14EUR;
    private MoneyFactory mf;
    
    @Before
    public void init() throws UnexistingCurrencyException
    {
      mf=MoneyFactory.getDefaultFactory();
      f12EUR=mf.createMoney(12, "EUR");
      f14EUR=mf.createMoney(14, "EUR");
    }

    /**
     * simpleAdd
     */
    @Test
    public void simpleAdd() throws UnexistingCurrencyException
    {
        Money expected=mf.createMoney(26, "EUR");
        Money result=MoneyOps.simpleAdd(f12EUR,f14EUR);
        //assertEquals(expected.,result);
        boolean res = expected.equals(result);
        assertTrue(res);
    }

    /**
     * simple Add With IncompatibleCurrencyException
     */
    @Test(expected = IncompatibleCurrencyException.class)
    public void simpleAddwithDiffCur() throws UnexistingCurrencyException {
        Money expected = mf.createMoney(26, "DZ");
        Money result = MoneyOps.simpleAdd(f12EUR, expected);
    }

    /**
     * simple Add With UnexistingCurrencyException
     */
    @Test(expected = UnexistingCurrencyException.class)
    public void simpleAddWithUnexistingCurrencyExceptionExpected() throws UnexistingCurrencyException, ValueException {
        Money m3 =mf.createMoney(26, "XX");
        Money result=MoneyOps.simpleAdd(f12EUR,m3);
    }

}
