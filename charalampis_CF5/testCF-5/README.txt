
	| testCF-5 |


It is supposed to be an application designed for students and teachers to manage lectures, courses, and other educational activities.
It has a public page to browse and it has user-specific access.
It has a registration form for a new user nad a login form that partially works.
-----------------------------------------------------------------------------------------------------------------------------------


| Prerequisites |

- Java JDK 17 or higher
- MySQL 8.4.0 or higher
- Maven 3.9.6 or higher
-----------------------------------------------------------------------------------------------------------------------------------


Setup Instructions

| Database Setup |

1. Ensure MySQL is installed and running.
2. Open MySQL Workbench and create a database named `testdb5`:
	CREATE DATABASE testdb5;
	USE testdb5;
3. Run the provided SQL script to set up the database schema and initial data:
   mysql -u root -p testdb5 < src/main/resources/database/queryTestDB5.sql
   - Username: root
   - Password: root
	* in my application.properties file, I use my password: m3Adm!n#itsme
-----------------------------------------------------------------------------------------------------------------------------------


| Running the Project |

1. Ensure the MySQL server is running. You can verify this using Task Manager (Windows) or Activity Monitor (Mac).
2. Open a terminal/command prompt.
3. Navigate to the directory containing the JAR file:
   cd path/to/target/directory
4. Run the JAR file using the following command:
   java -jar testCF-5.jar
5. Open a browser and navigate to http://localhost:8080 to see the application running.
(hopefully)
-----------------------------------------------------------------------------------------------------------------------------------


| Additional Notes |

- Ensure MySQL server is running before starting the application.
- The application runs on port 8080 by default.
- If you encounter any issues, check the application logs for more details.
- The project did not achieve the desired functionality.
- Refer to the code and comments for more information on potential improvements and known issues.
- The only users that work are:
	anakin - password: 123
	obiwan - password: 1234
	palpatine - password: 12345
- I have no idea what the project does on Mac.

-----------------------------------------------------------------------------------------------------------------------------------