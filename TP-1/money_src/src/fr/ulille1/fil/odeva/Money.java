package  fr.ulille1.fil.odeva;


public class Money {
	private int value;
	private String currency;
	

	Money(int value, String currency)
	{
		this.value=value;
		this.currency=currency;
	}

	public int getValue()
	{
		return this.value;
	}

	public String getCurrency()
	{
		return this.currency;
	}

	@Override
    public String toString() {
     	return this.getValue()+" ("+this.getCurrency()+")";
    }

    //Step 1
    public boolean equals_v1(Object object){
		return true;
	}
	//Same Value Dif Currency
	public boolean equals_v2(Object object){
		Money second = (Money) object;

		if (this.value == second.value &&
				!this.currency.equals(second.currency))
			return false;
		return true;
	}

	//Dif Value same Currency
	public boolean equals_v3(Object object){
		Money second = (Money) object;

		if (this.value != second.value &&
				this.currency.equals(second.currency))
			return false;
		return true;
	}

	//Dif Value Dif Currency
	public boolean equals_v4(Object object){
		Money second = (Money) object;

		if (this.value != second.value &&
				!this.currency.equals(second.currency))
			return false;
		return true;
	}

	//Null object
	public boolean equals_v5(Object object){

		if (object == null)
			return false;
		return true;
	}

	//Def class
	public boolean equals_v6(Object object){

		if (getClass() != object.getClass())
			return false;
		return true;
	}

	//All in one
	@Override
	public boolean equals(Object object){
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;
		Money seconde = (Money) object;
		if (null == getCurrency() && seconde.getCurrency() != null) {
			return false;
		} else if (!this.getCurrency().toUpperCase().equals(seconde.getCurrency().toUpperCase()))
			return false;
		if (seconde.getValue() != this.getValue())
			return false;
		return true;
	}


@Override
  public int hashCode() {
    /* i Overrided it just for sonarqube   */
		return 1;
}
}
