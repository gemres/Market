# Market
1) To Run the application from terminal, go to project folder and then go to target folder 
 And then under target execute the below command :
 
 java -cp Market-0.0.1-SNAPSHOT.jar com.simulation.shopping.Market.App
 
 And for the current project; you will see the below screen :
 
Sub Total = 12.58
Beans 3 for 2 = 1.00
Coke 2 for £1 = 2.00
Total Savings = 3.00
Total To Pay = 9.58

2) Visitor Design pattern is used
3) Under the test package, 11 test cases are created with JUNIT and Mock 
4) In the App.java class the orange, coke and bean objects are created with price and quantity/weight info and the "sub total" amount (the total amount before discount)
and the discount amounts of bean and coke and the "total savings" (total discount amount) and finally the "total to pay" amount are calculated.
And all these info are printed to the console
5) As it is not requested there is no implementation about printing or composing a bill
6) As it is not requested the shopping items (bean, coke and orange) are not retrieved from the user, they are hardcoded in the App class, just for test purposes.
7) The calculation of discount amount is implemented according to the receipt example.
8) Currently application supports only coke, bean and orange but new products can be added easily.
