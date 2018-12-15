test("Alert_OPERATION_with_Sinon", function(assert)
    {
        var fixture="";
        fixture+=("<div id='res'></div>");



        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;

        var c=new calc();
        c.message="Result ...";


        var r = sinon.stub(window, "alert", function(msg) { return false; } );
        c.displayResult(document.getElementById('res'));
        ok(r.calledOnce);
        r.restore();
    }
);