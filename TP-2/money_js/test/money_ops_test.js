QUnit.module("moneyOps", {
//	setup:function(assert){alert("setup moneyOps individual test");},
//	teardown:function(assert){alert("teardown moneyOps individual test");}
});

QUnit.test("test simple add", function(assert)
{
	assert.expect(2);

	var m1=new money(1,"EUR");
  var m2=new money(2,"EUR");
  var m3=new money(3,"EUR");

	assert.ok(m3.equals(MoneyOps.add(m1,m2)),"3e = 1e+2e");
	assert.deepEqual(m3,MoneyOps.add(m1,m2),"3e = 1e+2e deepEqual");
}
);


QUnit.test("test multi devise add", function(assert)
{
	var m1=new money(1,"EUR");
  var m2=new money(2,"CHF");
	assert.throws(function(assert) {var m3=MoneyOps.add(m1,m2)}, DevisesIncompatibleExc, "Devises Incompatibles");
}
);


QUnit.test("test simple soustraction", function(assert)
    {
        assert.expect(2);
        var m1=new money(1,"EUR");
        var m2=new money(2,"EUR");
        var m3=new money(3,"EUR");

        assert.ok(m1.equals(MoneyOps.sub(m3,m2)),"1e = 3e+2e");
        assert.deepEqual(m1,MoneyOps.sub(m3,m2),"1e = 3e+2e deepEqual");
    }
);

QUnit.test("test simple soustraction v1 < v2", function(assert)
    {
        var m2=new money(3,"EUR");
        var m3=new money(2,"EUR");
        assert.throws(function(assert) {var m1=MoneyOps.sub(m3,m2)}, SoustractionValueExc, "Make sure that v1 > v2 : ");
    }
);

QUnit.test("test simple soustraction diff currency", function(assert)
    {
        var m2=new money(3,"EUR");
        var m3=new money(2,"EU");
        assert.throws(function(assert) {var m1=MoneyOps.sub(m3,m2)}, DevisesIncompatibleExc, "Devises Incompatibles");

    }
);