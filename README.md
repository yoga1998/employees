# employees
Requirements : Eclipse IDE, java 8, Apache maven, Mysql workbench with employees database, Postman (for testing)

1. Download this project and unzip and stored in particular directory
2. Then import this project in eclipse-workspace , by click File -> Import
3. In the import dialog box, select maven folder-> Exisiting Maven project and click next
4. Now, select the unzipped project by browsing it and click finish
5. Now the project is build in workspace
6. After the completion of project build, it can be tested by running the project
7. For run the project, go to main class , just right-click inside it, click Run as -> java application or click Run as button in toolbar and select as java application
8. Now our code gets executed in the console tab and ends with port number (like 1010) which set in server port in code
9. Then tested apis' in postman. for eg : get call api tested by giving URL as http://localhost:1010/api/employee/get-employees
10. Similarly remaining apis' get tested
 
CRUD in employee details :

I) get call url - /api/employee/get-employees
II) post call url - /api/employee/save-employee
III) put call url - /api/employee/update-employee/{id}?empNo=10010
IV) delete call url - /api/employee/delete-employee/{id}?empNo=10011
