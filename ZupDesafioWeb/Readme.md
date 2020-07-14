# Automação Web ZUP Desafio  
- Utilizado o site do submarino para realizar um teste de ponta a ponta de busca e seleção de produto até o carrinho de compras 
- Ao final do teste é validado se o produto que foi para o carrinho é o mesmo que esperavamos  
- Utilizado um try catch para tratar a exceção de erro  
- Projeto utilizando o padrão PageObjects
- Foi utilizando um Data Driven JSON para massa de dados utilizada no teste.
  
Modo de execução do teste :
 
Com o Docker na maquina;

Abrir o Windows Powershell(para windows) ou o prompt do linux na pasta do projeto;
Executar o comando : 'docker-compose -f docker-compose.yml up';  
Em um novo PowerShell ou Prompt execute:  'docker-compose scale chrome=5';
Após isso bassa acessar o projeto por uma IDE (Eclipse,Netbeans ou IntelliJ);
Acessar o caminho src/cases/TestCase01.java e executar como JUnit Test;
Feito execução é gerar um relatorio de teste utilizando o framework extentreports na pasta Reports;

