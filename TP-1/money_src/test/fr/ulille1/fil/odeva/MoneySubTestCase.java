package fr.ulille1.fil.odeva;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MoneySubTestCase {

    private Money f12EUR, f14EUR;
    private MoneyFactory mf;

    @Before
    public void init() throws UnexistingCurrencyException {
        mf = MoneyFactory.getDefaultFactory();
        f12EUR = mf.createMoney(12, "EUR");
        f14EUR = mf.createMoney(14, "EUR");
    }

    /**
     * simpleSub
     */
    @Test
    public void simpleSub() throws ValueException, UnexistingCurrencyException {
        Money expected = mf.createMoney(26, "EUR");
        Money result = MoneyOps.simpleSub(f14EUR, f12EUR);
        boolean res = expected.equals(result);
        assertTrue(res);
    }

    /**
     * simple Sub With IncompatibleCurrencyException
     */
    @Test(expected = IncompatibleCurrencyException.class)
    public void simpleSubbWithDiffCur() throws ValueException, UnexistingCurrencyException {
        Money expected = mf.createMoney(26, "DZ");
        Money result = MoneyOps.simpleSub(f12EUR, expected);
    }

    /**
     * simple Sub With ValueException
     */
    @Test(expected = ValueException.class)
    public void simpleSubbWithNegativeResult() throws ValueException, UnexistingCurrencyException {
        Money expected = mf.createMoney(26, "DZ");
        Money result = MoneyOps.simpleSub(f12EUR, f14EUR);
    }

    /**
     * simple Sub With UnexistingCurrencyException
     */
    @Test(expected = UnexistingCurrencyException.class)
    public void simpleSubWithUnexistingCurrencyExceptionExpected() throws UnexistingCurrencyException, ValueException {
        Money m3 =mf.createMoney(26, "XX");
        Money result=MoneyOps.simpleSub(f12EUR,m3);
    }
}
