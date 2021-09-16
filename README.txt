JAVA_Hometask by Agris Klimkans, 05.09.2021.

The task has been accomplished using JDK (v16) and Eclipse IDE v2021-06.

Prerequisites:
JDK
JSTL
Apache Tomcat (v9).

*** Follow the below steps to install binaries ***
	
	Copy the JAVA_Hometask.war file to the Tomcat webapps folder.
	Tomcat should auto deploy it. If it does not, extract the file manually.
	In a web browser open http://<tomcat_host>:<tomcat_port>/JAVA_Hometask
	The web page offers to check either a single IBAN or a list.
	To check IBAN list, create a text file where each line contains ONE IBAN. For example:
	BE71 0961 2345 6769
	BR15 0000 0000 0000 1093 2840 814 P2
	CR99 0000 0000 0000 8888 88
	FR76 3000 6000 0112 3456 7890 189
	DE91 1000 0000 0123 4567 89
	GR96 0810 0010 0000 0123 4567 890
	MU43 BOMM 0101 1234 5678 9101 000 MUR
	
	Due to browser security restrictions the file should be stored in the webapps/JAVA_Hometask folder.


*** Follow the below steps to copy the Eclipse project to your workstation ***

    Extract the project folder to the destination system
    Create Eclipse workspace
    Select File -> Import
    Select General -> Existing project into workspace
    Select the project folder (under selected root folder)
    Say 'Finish'
    Classpath for jstl-1.2.jar can be modified in Eclipse project properties, Java build path.


