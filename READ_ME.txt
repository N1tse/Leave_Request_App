Technologies Used: 
-Spring MVC
-Maven
-Jdbc

Database:
-MySql

Front_End:
-HTML
-CSS
   BootStrap
-JavaScript
   JQuery

Easy to Deploy with Maven.
Open Project with any IDE and let Maven Download the needed dependencies.

The Project has two main roles,ADMIN and User
You can login with any of that roles
ADMIN credentials:
	username:admin
	password:admin
USER credentials:
	username:user
	password:user

Their is a Register function but by default the new account's Role will be USER, but ADMIN have the ability to make anyone ADMIN.

USER can:
	-Register/Login/Logout
	-See Last Leave Request
	-Leave A New Leave Request with Dates

ADMIN can:
	-Login/Logout
	-See All Users
	-See all User's Profile with all Their Info
	-Update a User's Role to ADMIN
	-Search A User By Username
	-Search to see who is gonna be absent between two Dates
	-Search Leave Request By Committed Date