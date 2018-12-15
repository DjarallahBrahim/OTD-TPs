module("money", {
//	setup:function(assert){alert("setup money individual QUnit.test");},
//	teardown:function(assert){alert("teardown money individual QUnit.test");}
});

test("test construct money",function(assert)
{
	expect(2);
	var m=new money(1,"EUR");
	ok(m.v==1,"valeur = 1");
	equal(m.curr,"EUR","currency = EUR");
}
);

test("test accesseurs", function(assert)
{
	expect(2);
	var m=new money(1,"EUR");
	ok(m.getValue()==1,"valeur = 1");
	equal(m.getCurrency(),"EUR","currency = EUR");
}
);


test("test equals", function(assert)
{
	expect(4);
	var m1EUR=new money(1,"EUR");
	var m1eur=new money(1,"eur");
	var m1CHF=new money(1,"CHF");
	var m10eur=new money(10,"eur");

	ok(m1EUR.equals(m1EUR),"1 EUR égal à 1 EUR");
	ok(m1EUR.equals(m1eur),"1 EUR égal à 1 eur");
	ok(!m1EUR.equals(m1CHF),"1 EUR diff de 1 CHF");
	ok(!m1EUR.equals(m10eur),"1 EUR diff de 10 eur");
}
);

test("test currency", function(assert)
    {
        expect(2);
        var m=new money(1,"EUR");

        equal(m.getCurrency().length,3);

        var m2=new money(1,"EURO");

        ok(m2.getCurrency().length>3);
    }
);
