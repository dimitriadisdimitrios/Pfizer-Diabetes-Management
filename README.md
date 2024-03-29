Sacchon Diabetes Management App Instructors

1.	We create a Database with the name Sacchon in Microsoft SQL server Management Studio.


2.	We run the IntellJ IDEA the BackEnd Folder, where in persistence file put the verb create.
 
3.	Next we will Open The Visual Studio Code (FrontEnd) folder and in terminal we will run to commands:

	npm install (modules Download)
	ng serve –o (Open the program to Browser)

4.	Then we will view the table which are created to Database when we run the IntellJ:

	Consultation
	Measurement
	PatientDoctorAssociation
	Users


5.	Next will view EndPoints in POSTMAN

v0.9.82 
About users____________________________________________________________________

@Get     http://localhost:9000/sacchon/users 
It returns all users

@Post    http://localhost:9000/sacchon/users   
You send email and passwordand returns a jpson {"role": "ROLE_DOCTOR","unreadConsultations": 0 }. If is Ν/Α it is exception the data are not valid.
    {
    "userEmail":"giannhs@hotmail.com",   (it must be valid)
    "userPassword": "123456"  (6chars)
    }

@Put    http://localhost:9000/sacchon/users   
Add new User to database (Register)
    {
    "first_name": "Giannhs",
    "last_name": "Papa",
    "email": " giannhs@hotmail.com ",   (Unique)
    "password": "123456",
    "accountType": 2,  (0:NA, 1 ADMIN, 2 is Doctor when Admin accept him,  3 Patient ,4 doctor register pedding)
    "amka": 12321263,  (Unique)
    "mobile_phone_number": 6986867684,
    "address": "Ipiroy",
    "gender": 2 (0: NA, 1: Male, 2 Female)
    }
About check servers works___________________________________________________________
@Get    http://localhost:9000/sacchon/ping   
It returns a msg that server works

About measurements________________________________________________________________

@Get @Auth(EMAIL && PASSWORD)  http://localhost:9000/sacchon/measurements?measurementID=2
It return specific measurement without body, only url attribute ?measurementID=

+++++++++++++++++++++++++++++++++++++++++++++

@Post @Auth(EMAIL && PASSWORD)  http://localhost:9000/sacchon/measurements    
Add new measurement
{
    "user": 3,
    "bloodGlucoseLevel": 10,
    "carbIntake": 1000
}

+++++++++++++++++++++++++++++++++++++++++++++

@Put @Auth(EMAIL && PASSWORD)  http://localhost:9000/sacchon/measurements    
It updates the fields in the body. For this we use and the get and put to measurements. With update is sends and id number which concurrently save to database.


{
    "measurementID": 3,
    "bloodGlucoseLevel": 10,
    "carbIntake": 1000,
    "measurementDate": "2012-04-30T02:15:12.356Z"
}

+++++++++++++++++++++++++++++++++++++++++++++

@Delete @Auth(EMAIL && PASSWORD)  http://localhost:9000/sacchon/measurements?measurementID=3    
Without body, Only measurementID= as url attribute. It DELETES the measurement with this id.

+++++++++++++++++++++++++++++++++++++++++++++

@Patch @Auth(EMAIL && PASSWORD)  http://localhost:9000/sacchon/measurements   

It brings the measurements based on the input sent by the user (to turn all the measurements){
    "amka": 1,
    "startAt": "2020-08-30T02:15:12.356Z",
    "endAt": "2020-10-30T02:15:12.356Z"
}




About profile_______________________________________________________________________

@Get @Auth(EMAIL && PASSWORD)  http://localhost:9000/sacchon/profile   

Returns all user fields
+++++++++++++++++++++++++++++++++++++++++++++

@Put @Auth(EMAIL && PASSWORD)  http://localhost:9000/sacchon/profile   

Refreshes all the fields we pass in the body
{
	"first_name": "Dimitrhs",
	"last_name": "giannakopoulos",
	"email": "Dim@gmail.com",
	"password": "123123",
	"amka": 123,
	"mobile_phone_number": "Dim",
	"phone_number":"Dim",
	"address": "Dim",
	"gender": 1
}

+++++++++++++++++++++++++++++++++++++++++++++

@Delete @Auth(EMAIL && PASSWORD)  http://localhost:9000/sacchon/users/interacts

Deletes the specific user.  And it frees him from the rest of the tables.
About Patients_____________________________________________________________________

@Get  @Auth(EMAIL && PASSWORD)  http://localhost:9000/sacchon/patient    
Returns all patients

+++++++++++++++++++++++++++++++++++++++++++++

@Post @Auth(EMAIL && PASSWORD)  http://localhost:9000/sacchon/patient    
Returns all measurements of the user who called it (I get the email from auth). Body attr are not mandatory if added simply limit the results.
If userID is included then it does NOT take the measurements of the user who called it but the measurements of the user with the Specific ID
{
    "userID": 3,
    "startAt": "2020-08-30T02:15:12.356Z",
    "endAt": "2020-10-30T02:15:12.356Z"
}

About Doctors______________________________________________________________________

@Get @Auth(EMAIL && PASSWORD)  http://localhost:9000/sacchon/doctors   

Returns all online doctors





About Searching users_______________________________________________________________

@Post    http://localhost:9000/sacchon/users/interacts        

Looking for a specific user based on AMKA. If the "role" is added to the body, it will check whether there is a user with this AMKA, and whether the role fits
{
    "amka" : 126,
    "role" : 1
}

About Association Patient and Doctor________________________________________________

@Get @Auth(EMAIL && PASSWORD) http://localhost:9000/sacchon/associations 

Base on categoryType (url attribute) user gives, it return a list with patient/doctors that is active
null = patients with Doctor that call url
1 = patients without Doctor
2 = patients with Doctors
3 = All patients that are also active

+++++++++++++++++++++++++++++++++++++++++++++

@Put @Auth(EMAIL && PASSWORD) http://localhost:9000/sacchon/associations   

UPDATE the existing registration. The patiend is the patient's id and is mandatory The doctor is again the doctor's id but it is mandatory. !!! SOS !!! the id that is entered must have correct roll, because I check if the doctor or the patient, before registration and if it is not correct I throw a exception.
									
{
    "patient": 2,
    "doctor": 1,
    "isActive": true
}

+++++++++++++++++++++++++++++++++++++++++++++

@Post @Auth(EMAIL && PASSWORD) http://localhost:9000/sacchon/associations   

Registers the existing registration. The patiend is the patient's id and is subordinate. The doctor is the doctor's id but it is NOT mandatory. !!! SOS !!! the id that is entered must have a correct role because I check if the doctor is a patient before the registration and if it is not correct I throw an exception.										
{
    "patient": 2,
    "doctor": 1
}

About Doctor Expired Session________________________________________________________

@Get @Auth(EMAIL && PASSWORD) http://localhost:9000/sacchon/expired?needDoctors=false

Returns all doctors (if? NeedDoctors = true) or patients (if? NeedDoctors = false) who have to login for more than 15 days




About Consulate___________________________________________________________________

@Get @Auth(EMAIL && PASSWORD) http://localhost:9000/sacchon/consultatio?categoryType=2&consultationID=2
Get consultation for specific users Based on ?categoryType= (url attribute)
if Add as url attribute the ?consultationID=  it will return a specific consultation with given specificic counsultation id

null = users that call url consultations
-1 = All consultations
x(id) = All consultations for x user

+++++++++++++++++++++++++++++++++++++++++++++

@Post @Auth(EMAIL && PASSWORD) http://localhost:9000/sacchon/consultation
Enter a new consult with the following information. PatientID is mandatory!
{
    "patientID": 3, 
    "registerDate": "2012-04-30T02:15:12.356Z",
    "consultationMsg": "This is the test ",
    "isRead": true
}

+++++++++++++++++++++++++++++++++++++++++++++

@Put @Auth(EMAIL && PASSWORD) http://localhost:9000/sacchon/consultation

Updates consultation with the specific consultation, with the following information. PatientID and consulationID are required !!
{
    "consultationID": 1, 
    "patientID": 3,
    "registerDate": "2012-04-30T02:15:12.356Z",
    "consultationMsg": "This is the test ",
    "isRead": true
}

+++++++++++++++++++++++++++++++++++++++++++++

@Delete @Auth(EMAIL && PASSWORD) http://localhost:9000/sacchon/consultation?consultationID=1

Without body ... Only with consulationID = as url attribute
Deletes the consulate with the specific consultationID
+++++++++++++++++++++++++++++++++++++++++++++

@Patch @Auth(EMAIL && PASSWORD) http://localhost:9000/sacchon/consultation

Returns consultations for a specific doctor for a specific period
{
    "amka": 1333,
    "startAt": "2012-04-30T02:15:12.356Z",
    "endAt": "2020-10-30T02:15:12.356Z"
}



About Average_____________________________________________________________________

@Post @Auth(EMAIL && PASSWORD) http://localhost:9000/sacchon/data

Returns the averages from the measurements depending on the fields to be entered and returns a body like the examples
{
    "amka": 5344,
    "userID": 1,
    "startAt": "2020-10-30T02:15:12.356Z",
    "endAt": "2020-11-30T02:15:12.356Z"
}

!!!!!! And the following body returns !!!!!!!!!
{
    "avgCarbIntake": 50.0,
    "avgBloodGlucoseLevel": 200.0,
    "numberOfResults": 1
}

About Pending Doctors_______________________________________________________________

@Get @Auth(EMAIL && PASSWORD) http://localhost:9000/sacchon/pending

Returns all doctors with Account Type ROLE PENDING
+++++++++++++++++++++++++++++++++++++++++++++

@Post @Auth(EMAIL && PASSWORD) http://localhost:9000/sacchon/pending

Activates (from pending account type to doctor account type) the user with the userID that was given
{
    "userID": 12
}

About Wait consultations up to 30 days_____________________________________________

@Get @Auth(EMAIL && PASSWORD) http://localhost:9000/sacchon/consultation/wait

Returns all users who need to get a consultation because more than 30 have passed as well as the days that have passed since the last consultation.
 
Example body that you return !!!!! [
    {
        "patientsId": 7,
        "daysFromLastConsultation": 85
    }
]
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	Admin user register from Database.
	Exists auth from the Front and  Back end for the users
	Front End have all validators
	When register as doctor, you should wait for admin to accept you. 

