To build:
    
    1. Run "mvn clean install" from the root directory 

To run:

    1. Start up docker
    2. run "docker-compose up -d" from Sector/src/main/java/org/example/sector
        This starts up the mongo-db container
    3. You can check the database is running with "docker ps"
    4. From the root directory run "mvn spring-boot:run"
    5. Test the app is running with: 
            curl http://localhost:8080/api/date
        This should return a date String in Imperial format.
