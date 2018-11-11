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
    public void sameValueSameDevis()  throws UnexistingCurrencyException {
        f12EUR=mf.createMoney(14, "EUR");
        f14EUR=mf.createMoney(14, "EUR");
        assertTrue(f12EUR.equals(f14EUR));
    }
}
