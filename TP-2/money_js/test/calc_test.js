QUnit.module("calc", {
//	setup:function(){alert("setup moneyOps individual test");},
//	teardown:function(){alert("teardown moneyOps individual test");}
});

QUnit.test("test_computeresults", function(assert)
{
        var fixture="";
        fixture+=("<form id='form0'>");
        fixture+=("<input type='text' id='v1' name='v1' value='2'/>");
        fixture+=("<input type='text' id='c1' name='c1' value='EU'/>");
        fixture+=("<input type='text' id='v2' name='v2' value='2'/>");
        fixture+=("<input type='text' id='c2' name='c2' value='EU'/>");
        fixture+=("<input type='text' id='ops' name='ops' value='ADD'/>");
        fixture+=("</form>");


        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;


        var c=new calc();
        c.computeResult(document.getElementById('form0'));
        assert.equal(c.message,"Result : 4 (EU)");
}
);


QUnit.test("test_computeresults_other", function(assert)
{
        var fixture="";
        fixture+=("<div id='res'></div>");
        fixture+=("<form id='form0'>");
        fixture+=("<input type='text' id='v1' name='v1' value='2'/>");
        fixture+=("<input type='text' id='c1' name='c1' value='EU'/>");
        fixture+=("<input type='text' id='v2' name='v2' value='2'/>");
        fixture+=("<input type='text' id='c2' name='c2' value='EU'/>");
        fixture+=("<input type='text' id='ops' name='ops' value='SUB'/>");
        fixture+=("</form>");


        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;

        var c=new calc();
        c.computeResult(document.getElementById('form0'));
        assert.equal(c.message,"Result : 0 (EU)");
}
);

QUnit.test("test_displayResult", function(assert)
{
        var fixture="";
        fixture+=("<div id='res'></div>");

        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;

        var c=new calc();
        c.message="Result : 4 (EU)";
        c.displayResult(document.getElementById('res'));
        assert.equal(document.getElementById('res').innerHTML,"Result : 4 (EU)");
}
);

QUnit.test("Devises_incompatibles_ADD", function(assert)
    {
        var fixture="";
        fixture+=("<div id='res'></div>");
        fixture+=("<form id='form0'>");
        fixture+=("<input type='text' id='v1' name='v1' value='2'/>");
        fixture+=("<input type='text' id='c1' name='c1' value='EU'/>");
        fixture+=("<input type='text' id='v2' name='v2' value='2'/>");
        fixture+=("<input type='text' id='c2' name='c2' value='DA'/>");
        fixture+=("<input type='text' id='ops' name='ops' value='ADD'/>");
        fixture+=("</form>");


        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;

        var c=new calc();
        c.computeResult(document.getElementById('form0'));
        assert.equal(c.message,"Devises incompatibles : EU vs DA");
    }
);

QUnit.test("Devises_incompatibles_SUB", function(assert)
    {
        var fixture="";
        fixture+=("<div id='res'></div>");
        fixture+=("<form id='form0'>");
        fixture+=("<input type='text' id='v1' name='v1' value='2'/>");
        fixture+=("<input type='text' id='c1' name='c1' value='EU'/>");
        fixture+=("<input type='text' id='v2' name='v2' value='2'/>");
        fixture+=("<input type='text' id='c2' name='c2' value='DA'/>");
        fixture+=("<input type='text' id='ops' name='ops' value='SUB'/>");
        fixture+=("</form>");


        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;

        var c=new calc();
        c.computeResult(document.getElementById('form0'));
        assert.equal(c.message,"Devises incompatibles : EU vs DA");
    }
);

QUnit.test("OPERATION_incompatibles_SUB", function(assert)
    {
        var fixture="";
        fixture+=("<div id='res'></div>");
        fixture+=("<form id='form0'>");
        fixture+=("<input type='text' id='v1' name='v1' value='2'/>");
        fixture+=("<input type='text' id='c1' name='c1' value='EU'/>");
        fixture+=("<input type='text' id='v2' name='v2' value='2'/>");
        fixture+=("<input type='text' id='c2' name='c2' value='DA'/>");
        fixture+=("<input type='text' id='ops' name='ops' value='MUL'/>");
        fixture+=("</form>");


        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;

        var c=new calc();
        c.computeResult(document.getElementById('form0'));
        assert.equal(c.message,"Unsupported operation MUL");
    }
);

QUnit.test("RED_STATUS_FOR_NO_OK_OPERATION", function(assert)
    {
        var fixture="";
        fixture+=("<div id='res'></div>");

        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;

        var c=new calc();
        c.message="uytr";

        console.log(document.getElementById("res"));
        c.displayResult(document.getElementById('res'));
        assert.equal(document.getElementById("res").style.color,"rgb(255, 0, 0)");
    }
);

QUnit.test("GREEN_STATUS_FOR_OK_OPERATION", function(assert)
    {
        var fixture="";
        fixture+=("<div id='res'></div>");

        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;

        var c=new calc();
        c.message="Result ...";

        console.log(document.getElementById("res"));
        c.displayResult(document.getElementById('res'));
        assert.equal(document.getElementById("res").style.color,"rgb(13, 255, 88)");
    }
);

QUnit.test("Alert_OPERATION", function(assert)
    {
        var fixture="";
        fixture+=("<div id='res'></div>");



        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;

        var c=new calc();
        c.message="Result ...";

        c.displayResult(document.getElementById('res'));

        window.alert = function (){
            document.getElementById("res").innerText="Alert"
        };
        assert.equal(document.getElementById("res"),"Alert");
    }
);