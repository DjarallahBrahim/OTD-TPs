QUnit.module("Planning", {
});

QUnit.test("test Pannel creation", function(assert)
{
  var creneau = {
      "jour": "07",
      "debut": "10:45",
      "specialite": "TIIR",
      "etudiant": "Pierre Caruyer",
      "titre": "Centralisation des backups",
      "societe": "Jump Technology",
      "tuteur": "Iguchi",
      "encadrant": "Cottin",
      "resume": "Centralisation de la gestion des backups internes de JUMP.\\nDans ces backups sont compris : \\n•\\tBase de données (Oracle / MySQL)\\n•\\tBinaires de l’application\\n•\\tVMs HyperV\\n\\nDevront être centralisées les données de date, localisation, profondeur, contenu de ces backups en fonction de leurs nature. \\nUn système de visualisation Web de ces données sera également développé.\\nCette centralisation permettra d’afficher mais aussi de piloter l’ensemble des backups de l’entreprise.\\n\\nCe projet fera appel à des connaissances techniques avancées en SI, Java et Node.JS, demandera des notions importantes en SQL et architecture de solution intégrée."
  };

  var div = document.getElementById("qunit-fixture");
  var panel = new PanelCreneau(div,creneau);

  assert.equal(panel.baliseMere,div,"baliseMere correcte");
  assert.equal(panel.creneau,creneau,"creneau correcte");


  var div = document.createElement("div");
  div.setAttribute("class" ,"panel-heading");
  assert.propEqual(panel.panelHeading,div,"panel-heading created");

  div = document.createElement("div");
  div.setAttribute("class" ,"panel-body");
  assert.propEqual(panel.panelHeading,div,"panel-body created");

  div = document.createElement("div");
  div.setAttribute("class" ,"panel-footer");
  assert.propEqual(panel.panelFooter,div,"panel-footer created");


  assert.equal(panel.panelHeading.innerHTML,"10:45","panel-heading === 10:45");
  assert.equal(panel.panelBody.innerHTML,"Pierre Caruyer<br>Jump Technology<br>Iguchi<br>","panel-body == Pierre Caruyer<br>Jump Technology<br>Iguchi<br>");
  assert.equal(panel.panelFooter.innerHTML,"M5 - A2 / TIIR","panel-heading == M5 - A2 / TIIR");


});
