TP3: Tests UI avec Selenium WebDriver

element.click();
element.submit();
Q1): Est-ce que les deux sont compatibles avec le comportement actuel de l'intérface ? 

- Non, par ce que dans notre index.htmp nous avons utilisé un inpute de type Button donc soit on utilise driver.findElement(By.xpath("//input[@type='button']"));, soit on change le type d'inpute.

Q2): Qu'en pensez-vous des implications sur l'objet WebDriverWait? contrôlant la synchronisation ? 

- Je trouve que l'utilisation de WebDriverWait n'est pas efficace avec tous les tests, solution: soit on augmente le temps, soit on essaye de trouver un intervalle pour chaque test.



