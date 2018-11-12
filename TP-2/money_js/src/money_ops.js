var MoneyOps=function (){
}

MoneyOps.add = function(m1,m2){
	if(m1.getCurrency().toUpperCase() !== m2.getCurrency().toUpperCase())
		throw new DevisesIncompatibleExc(m1.getCurrency().toUpperCase() , m2.getCurrency().toUpperCase());

	return new money(m1.getValue()+m2.getValue(),m1.getCurrency());
};

MoneyOps.sub = function(m1,m2){
    if(m1.getCurrency().toUpperCase() !== m2.getCurrency().toUpperCase())
        throw new DevisesIncompatibleExc(m1.getCurrency().toUpperCase() , m2.getCurrency().toUpperCase());

    if(m1.getValue() < m2.getValue())
        throw new SoustractionValueExc(m1.getValue() , m2.getValue());

    return new money(m1.getValue()-m2.getValue(),m1.getCurrency());
};
