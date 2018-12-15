QUnit.test("Alert_OPERATION", function(assert)
    {
        var fixture="";
        fixture+=("<div id='res'></div>");



        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;

        var c=new calc();
        c.message="Result ...";


        sinon.spy(window,"confirm");

        c.displayResult(document.getElementById('res'));
        assert.ok(window.confirm.calledOnce);
        window.confirm.restore();
    }
);