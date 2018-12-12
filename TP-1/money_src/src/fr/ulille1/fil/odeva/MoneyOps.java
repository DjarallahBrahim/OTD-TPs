/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.ulille1.fil.odeva;

/**
 *
 * @author marius
 */
public class MoneyOps {
  private static MoneyFactory mf = MoneyFactory.getDefaultFactory();

  /**
   * Add moneys having the same currency
  */
  public static Money simpleAdd(Money m1, Money m2) throws UnexistingCurrencyException {
    if(!m1.getCurrency().equals(m2.getCurrency()))
      throw new IncompatibleCurrencyException(m1.getCurrency(),m2.getCurrency());

    Money m=mf.createMoney(m1.getValue()+m2.getValue(),m1.getCurrency());
    return m;
  }

  /**
   * Add moneys having the dif currency
   */
  public static Money simpleSub(Money m1, Money m2) throws IncompatibleCurrencyException, ValueException, UnexistingCurrencyException {
    if(!m1.getCurrency().equals(m2.getCurrency()))
      throw new IncompatibleCurrencyException(m1.getCurrency(),m2.getCurrency());

    if(m1.getValue() < (m2.getValue()))
      throw new ValueException(m1.getValue(),m2.getValue());

    Money m=mf.createMoney(m1.getValue()+m2.getValue(),m1.getCurrency());
    return m;
  }
}
