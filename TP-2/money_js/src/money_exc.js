function DevisesIncompatibleExc(_d1,_d2) {
	this.d1=_d1; this.d2=_d2;
	
}

DevisesIncompatibleExc.prototype.toString=function (){
		return "Devises incompatibles : "+this.d1+" vs "+this.d2;
};

function SoustractionValueExc(_d1,_d2) {
    this.d1=_d1; this.d2=_d2;

}

SoustractionValueExc.prototype.toString=function (){
    return "Make sure that v1 > v2 : "+ this.d1+" - "+this.d2;
};
