# lambda-rest-api
Rest API using Lambda and API Gateway

## Assignment:
1.	Build REST API by leveraging the serverless architecture. API should perform CRUD operation on the Employee entity using Lambda and Api Gateway. 

2.	Employee Entity Attributes:
a.	First Name
b.	Last Name
c.	Aadhar Number (This is unique)
d.	Age
e.	Salary
f.	Department

3.	Build Lambda which perform the business operation (CRUD) and integrate this Lambda with REST API in API Gateway. Leverage following AWS Services (all falls under free tier)
a.	Lambda
b.	S3
c.	API Gateway
d.	Data inserted into RDS Create REST API which performs CRUD operation on Employee Entity

4.	REST API should talk to Lambda backend 
a.	Create:
i.	Use Http Post method to insert new record. Aadhar number should be unique. 
ii.	When you insert record with Http POST and if record already exists (same Aadhar number provided) then you should respond Http Response code '409 Conflict' or you can update the existing record in the DB
iii.	Aadhar number is unique in DB

b.	Read
i.	Use Http Get Method and retrieve request based on the provided Aadhar number
ii.	User Aadhar number query parameter to retrieve the record
c.	Update
i.	Use Http Put method to update existing record in DB
ii.	If Http Put method is called, update the existing record based on Aadhar Number

d.	Delete
i.	Use Http Get Method to Http Delete method  to delete the existing record based on Aadhar Number.

5.	Steps
a.	Create Lambda which receives the Employee Entity,(passed from API ) 
b.	Perform Create or delete or update or read operation in lambda by interfacing with RDS in backend. If you wish you can use Dynamo DB also.
c.	Please use PostMan or any of the API testing tool to test the API 
