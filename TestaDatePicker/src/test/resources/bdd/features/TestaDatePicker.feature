Feature: Testa Date Picker

@usrum
Scenario Outline: 
	Given acesso ao site "<url>"
	When seleciono a data "<data>"
 

Examples:
   | url                                      |data           |
   | http://demoqa.com/datepicker/            |24 of February | 


