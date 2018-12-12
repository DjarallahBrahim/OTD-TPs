package fr.ulille1.fil.odeva;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MoneyEqualsTestCase{
    private Money f12EUR,  f14EUR;
    private MoneyFactory mf;

    @Before
    public void init()
    {
        mf=MoneyFactory.getDefaultFactory();

    }

    /**
     * Equals
     */
    @Test
    public void sameValueSameDevise()  throws UnexistingCurrencyException {
        f12EUR=mf.createMoney(14, "EUR");
        f14EUR=mf.createMoney(14, "EUR");
        assertTrue(f12EUR.equals(f14EUR));
    }

    @Test
    public void SameValueSameDevise() throws UnexistingCurrencyException
    {
        Money f12EUR = mf.createMoney(12, "EUR");
        Money f_12EUR = mf.createMoney(12, "EUR");

        assertTrue(f12EUR.equals(f_12EUR));
    }

    @Test
    public void DiffValueDiffDevise() throws UnexistingCurrencyException
    {
        Money f12EUR = mf.createMoney(12, "EUR");
        Money f14CHF = mf.createMoney(14, "CHF");

        assertTrue(!f12EUR.equals(f14CHF));
    }

    @Test
    public void DiffValueSameDevise() throws UnexistingCurrencyException
    {
        Money f12EUR = mf.createMoney(12, "EUR");
        Money f14EUR = mf.createMoney(14, "EUR");

        assertTrue(!f12EUR.equals(f14EUR));
    }

    @Test
    public void SameValueDiffDevise() throws UnexistingCurrencyException
    {
        Money f12EUR = mf.createMoney(12, "EUR");
        Money f12CHF = mf.createMoney(12, "CHF");

        assertTrue(!f12EUR.equals(f12CHF));
    }
}
