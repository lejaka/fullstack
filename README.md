# Full stack development assessment
A blank/template project to pull and push assessment

## The following are prerequisites for taking the assessment:
 - Internet connection
 - Access to GitLab.com; LoL - you already have if you see this :-)
 - Own PC/Laptop
 - Java openJDK/oracleJDK and supported IDE
 - Gradle/Maven Build tool
 - Estimate 2 - 24 hours

## Update this file :
Document all information and instructions as part of this readme file of the project, for someone else to test and make use of your application. Also includes login credentials to use for testing.


# How to test
## Troubleshoot (Backend)
- Please make sure you create a database named pineapple before starting the backend application.
- Start MySQL on your PC
- Run the backend application
- Use Postman to run tests as shown below:

Please note, I did not implement the frontend, therefore the app can be tested via Postman  
## Get All Users
### Method
GET
### URL
http://localhost:8080/users


## Get Users By Email
### Method
POST
### URL
http://localhost:8080/users/user?email=lejaka@gmail.com


## Add User
### Method
POST
### URL
http://localhost:8080/users/add
### Body
```
{
    "email": "lejaka@mama.com",
    "iud" : "1",
    "displayName": "Lejaka",
    "photoURL": "https://saasta.ac.za/getsetgo/issues/201611/images/articles/saasta_two_times/2.jpg"
}

```


## Update User
### Method
PUT
### URL
http://localhost:8080/users/add
### Body
```
{	  "user_id": 1,
    "email": "lejaka@gmail.com",
    "iud" : "1",
    "displayName": "Lejaka",
    "photoURL": "https://saasta.ac.za/2.jpg"
}
```

## Login
using email and displayName (acting as password)
### Method
POST
### URL
http://localhost:8080/users/login
### Body
```
{
  "email": "nkosi@mama.com",
  "displayName": "NATHI"
}
```

## Delete User By Email
### Method
DELETE
### URL
http://localhost:8080/users/delete/itu@mama.com


## Get All Triangles
### Method
GET
### URL
http://localhost:8080/shapes


## Get Triangle By Name
### Method
POST
### URL
http://localhost:8080/shapes/byName?nameOfShape=initial


## Get Triangles By Symbol
### Method
POST
### URL
http://localhost:8080/shapes/bySymbol?symbolToPrint=*


## Add Triangle
### Method
POST
### URL
http://localhost:8080/shapes/add
### Body
```
{        
  "user_id": 1,
	"rowsToPrint": 12,
	"symbolToPrint": "+",
	"nameOfShape":"plus12"
}

```

## Update Triangle
### Method
PUT
### URL
http://localhost:8080/shapes/add
### Body
```
{
  "user_id": 1,
	"triangleId": 1,
	"rowsToPrint": 6,
	"symbolToPrint": "*",
	"nameOfShape":"initial"
}
```

## Delete Triangle By nameOfShape
### Method
DELETE
### URL
http://localhost:8080/shapes/delete/plus12


# How to test
## Troubleshoot  Frontend
- Please make sure you have node and angular installed.
- cd into the application directory
- Run the command "npm install"
- Run the application (using "ng serve -o" command)
- This section is incomplete

## Home page
### URL
http://localhost:4200/home

## Login (Same page as Home, click a button to login)
### URL
http://localhost:4200/home
### credentials
username: nkosi@mama.com
password: nathi

## Apply (Main page for functionality: Still needs some work)
### URL
http://localhost:4200/apply
