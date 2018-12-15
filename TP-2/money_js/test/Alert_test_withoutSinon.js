QUnit.module("calc", {
//	setup:function(){alert("setup moneyOps individual test");},
//	teardown:function(){alert("teardown moneyOps individual test");}
});




QUnit.test("Alert_OPERATION", function(assert)
    {
        var fixture="";
        fixture+=("<div id='res'></div>");



        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;

        var c=new calc();
        c.message="Result ...";
        var old_confirm=window.confirm;
        window.confirm = function (){
            document.getElementById("res").innerText="Alert"
        };

        c.displayResult(document.getElementById('res'));
        assert.equal(document.getElementById("res").innerText,"Alert");
        window.confirm = old_confirm;
    }
);