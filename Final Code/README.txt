README:

The application is deployed in Scala IDE ( SDK 4.7 ). Scala swing package is added to the IDE to develop an application. 
scala-SDK-4.7.0-vfinal-2.12-win32.win32.x86_64 : Scala IDE Eclipse for Windows 
scala-swing.jar : Jar file for using scala swing 

Please refer  http://mund-consulting.com/Blog/using-scala-ide-with-sparkletzeppelin-on-windows/ on getting started with scala IDE
( please follow the set scala installation step described in the link above to remove errors )


Data : data1.txt  ( http://www.icpsr.umich.edu/icpsrweb/NAHDAP/studies/34792 ) : DS1 - Student survey  
This data is a survey response conducted by HBSC ( Health Behavior in School-aged children 2009-2010 ). 
Tab separated file. 
1. This file will be appended with a new column if the scala IDE/Dumbo in normal is used
2. A new file with an extra column will be created if dumbo WITH PCA is used. 

Code : 

RUNNING IN SCALA IDE : 

a. Project.scala : 
This file contains the main source code for running the application. 	
The file contains the method : scObject() that loads the data, data1.txt to an RDD. When running the application, please provide the exact path of the file (data1.txt) in this method.
The application displays a form with certain questions. 
The application shows 4 other buttons: 
1. Submit : The submit button triggers logistic regression and then displays an appropriate answer as a display box.
2. Get Gender Statistics : displays the Bullyingender.png file. Please fill the appropriate path of the png file in method Bullyingender()
3. Get Female Statistics : displays the Nutrientfemale.png file. Please fill the appropriate path of the png file in method showFemaleStat()
4. Get Male Statistics   : displays the Nutrientmale.png file. Please fill the appropriate path of the png file in method showMaleStat()	


b. StatisticsCode : 
The 3 charts were derived from the statistics that were gathered by the code in StatisticsCode.txt file. The data used in the code is derived from scObject() method in Project.scala file


RUNNING IN DUMBO :

The above code can also be deployed in the NYU cluster, Dumbo. Dumbo is a part of the HPC cluster in NYU. 

1. Dumbo1 : 
Contains code to profile data and extract bully statistics. 
This code also contains experimental data that was carried out on the bully statistics. PCA was used to perform some analysis. However, PCA analysis did not return as good results as the code used in Project.scala
Experimental Analysis:
	a. Extract bully statistics. 
	   Run PCA 
	   Calculate standard deviation for the derived PCA values.
	   Determine if each record is 1 or 0 based on its PCA value and standard deviation
	b. Label each record as 1 if 1 or more of the bully responses is 1 else 0

	
2. Dumbo2 : 
Contains code to extract features and the label for each record to run logistic regression
The data used is new_data.txt from the previous step if used PCA or Pdata1 RDD if did not use PCA
Provides the accuracy of the logistic regression 

3. StatisticsCode.txt file to retrieve statistics. 
Contains Univariate statistics and the code to derive the statistics. 

4. Dumbo3 : 
Contains code that tests the logistic regression model.

Profile.scala :
Failed attempt to find an association between bully statistics and nutrient intake.
Datasets file : 
	a. bully.txt
	b.FV.txt

Application snapshots :
1. Gender Statistics - Get Gender Statistics output : Get Gender statistics Button output
2. Female Statistics - Get Female Statistics output : Get Female Statistics Button output
3. Male Statistics - Get Male Statistics output : Get Male Statistics Button output
4. HomePage : Starting page of the application displaying a form
5. Form output - Submit button : Submit Button output 

