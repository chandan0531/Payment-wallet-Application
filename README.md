
# Online Payment wallet Application REST-API

Our team has created REST API Application for online payment wallet apllication which can be used by bank's customers for different services like create bank account, login and SignUp to account, create wallet from bank account, add money to wallet, Billpayment from wallet, get transaction details from wallet etc. Also user can delete the account.



## Collaborators (Masai school's Student)
 - [Chandan Kumar Sharma](https://github.com/chandan0531)
 - [Gaurav Jaiswal](https://github.com/Aryan-2-2)
 - [Shubham Kumar](https://github.com/alluShubham)
- [Suresh Jungade](https://github.com/sureshjungade)
- [Vamsi Krishna](https://github.com/Vamsi4612)

## REST API Use for below functions
- User can Login and Signup.
- Create Bank account and wallet.
- Adding money to wallet.
- Any Bill payments from wallet.
- User can see transactions details from wallet.
- Delete Bank account.

## Tech Stack
- Java
- Hibernate
- Spring Framework
- Spring Boot with JPA
- MySQL
- Maven
- Swagger UI

## ER Diagram
Following ER diagram indicates the database tables and thier interaction which we are using.
![Untitled Workspace](https://user-images.githubusercontent.com/101566029/185031322-cca7cf0e-652d-4a75-8ca5-062b8d21614a.jpg)



## Modals
- Login 
- Bank Account
- Customer
- Wallet
- Bill Payment
- Cashback
- Transactions
- Beneficiary



## MySql database details

Install and connect with database

```bash
#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/walletdb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=12345
```
## Running Tests
Run the following command on swagger UI
![swagger](https://user-images.githubusercontent.com/101566029/185036837-17caf0e0-94c6-4280-8719-20d52e2570c3.png)

## API Functionality are-
- #### User features
1.  User can login and SignUp.

- #### Bank Account features
1.  User can create the bank account.
2.  User can get the account details.
3.  User can delete the account details.

- #### Customer features
1.  Customer can save the details with bank.
2.  Customer can update the details with bank.

- #### Wallet features
1.  User can seen the wallet balance.
2.  User can add the money to the wallet.
3.  User can transfer the money from wallet.

- #### Bill payment features
1.  User can pay any bill from wallet.
2.  User can get all bills details.

- #### Cashback features
1.  User can get the cashback whenwvr they pay the bills.

- #### Transaction features
1.  User can seen the transaction details with date wise.
2.  User can see the transaction details with wallet user.
3. User can see all the transaction details.

## Possible Next Steps/Things to improve:
- Need to improve the Beneficiary like connection with wallet.
- User can get the transaction details like from date - to date.
