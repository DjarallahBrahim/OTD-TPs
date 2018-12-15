test("Alert_OPERATION_without_sinon", function(assert)
    {
        var fixture="";
        fixture+=("<div id='res'></div>");



        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;

        var c=new calc();
        c.message="Result ...";
        var old_alert=window.alert;
        window.alert = function (){
            document.getElementById("res").innerText="Alert"
        };

        c.displayResult(document.getElementById('res'));
        equal(document.getElementById("res").innerText,"Alert");
        window.alert=old_alert;
    }
);