# Project Setup Environment Softwares
1. Tomcat 9.x
2. MariaDB-10.1.37
3. Java Development Kit-1.8 / Java Runtime Environment-1.8

# Project Deployment
1. Copy the build *.war file from the "target" directory into the "webapp" directory inside tomcat home directory.
i.e. "app_dir/target/mvc.war" to "Tomcat_Home/webapp/"
2. Execute sql scripts from "DatabaseScripts" directory. 
3. Start the tomcat by executing "startup.sh" located into the "bin" directory inside tomcat home directory.
i.e. "Tomcat_Home/bin/startup.sh"
4. Browse the project into any browser. url ex. "localhost:8080/mvc/"
