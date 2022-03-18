# DFESW12_Final_Project 

Welcome! Here is my final project from when I was on QA Academy DFESW12 cohort. A big thank you goes out to both my peers and the trainers at the QA Academy for helping me come this far with the project!  The aim was to create a fully-functional RESTful Spring Boot API, using an application back-end created in Java, a database hosted on MySQL, the use of Postman to make API calls and the use of MySQL Workbench to check whether the requested data had persisted or not. The API manages records of Animes in an anime database.

My Jira board: https://emmanuel1995.atlassian.net/jira/software/projects/DFP/boards/3/backlog

## Tests and Coverage

All tests passed  
DFESW12_Final_Project coverage: 95.1%  
src/main/java coverage: 85.9%  


![Screenshot 2022-03-18 at 07 40 52](https://user-images.githubusercontent.com/98022119/159011536-5ff842fa-2018-41f5-bd02-aa8daf77d45b.jpg)

![Screenshot 2022-03-18 at 07 40 30](https://user-images.githubusercontent.com/98022119/159011694-330c67c3-2efe-403e-9f36-126291c09d33.jpg)

## Prerequisites 

- Java 11 
- MySQL Workbench
- Postman

## Why are we doing this? 

The aim of the project was to apply all the theory that had been learnt while I was on the 9-week QA Software Development bootcamp. The objectives for the project were to:
- implement the use of Agile principles in Project Management, specifically through the use of GitHub and Jira
- consolidating knowledge of Databases through the use of MySQL and H2
- use Object Oriented Programming in the form of Java to create a new domain (Animes) and a fully-functional and tested set of CRUD methods.
- use Spring Boot to develop and run the API.
- test the developed API using JUnit and Mockito automated testing. 

## How I expected the challenge to go 

My expectations were set low as is the case with imposter syndrome, the project specification seemed intimidating but the more I persisted the more confidence I gained. I was able to go back to prior areas that I did not feel confident on and thus managed to wrap my head around them. I expected to just meet the Minimum Viable Product in the allocated time, however if I did get the time to I was keen on adding value by extending the project.

## How the project actually went 

I enjoyed working on the project while making sure to mostly figure out solutions by myself, however on the occasions where I did consult my peers and trainers I learnt a lot. When I fell behind schedule I made a sure to work on the project outside of the course hours. Initially, I faced an issue where I could not connect my Spring Boot API to MySQL due to an ‘Access denied for user ‘root’@’localhost’ (using password:YES)’ issue. Through sheer persistence I was able to figure out a solution to the issue with the use of various online resource and a lot of ‘trial & error’. Otherwise the project went well for me in the technical aspect and most of the difficulty came from writing the code. I was able to reach 85.9% coverage in the src/main/java folder which was way higher than I expected to achieve. 

## Possible improvements for future revisions of the project 

My implementation of the Feature Branch Model was overly simplified, in hindsight I would have created more branches to make more effective use of version control. If I had time for another sprint I would have included custom queries, the use of Lombok to reduce boilerplate code, DTOs, custom queries like search by genre (or animation studio/ year of release), custom exceptions and a frontend application for users to interact with. I hope accomplish the aforementioned points for improvement when I have spare time, and will include a link to that repository here once I am ready. 

## Screenshots of Postman Requests, output from the API and pesisted data in the database 

I will create 3 records via Postman request and will use these demonstrate the functionality of my Spring Boot API. 

### Creating 3 records

![Screenshot 2022-03-18 at 07 06 29](https://user-images.githubusercontent.com/98022119/159013395-d57a9e48-d10d-48e6-a649-4889d32557cf.jpg) 
![Screenshot 2022-03-18 at 07 07 06](https://user-images.githubusercontent.com/98022119/159013453-341db828-ba54-47fd-ac63-22583b6af48e.jpg)
![Screenshot 2022-03-18 at 07 10 46](https://user-images.githubusercontent.com/98022119/159013934-c6e994f0-b891-46eb-a68f-00fa30edcad4.jpg)
![Screenshot 2022-03-18 at 07 11 02](https://user-images.githubusercontent.com/98022119/159013958-c526c7a1-aaad-4c4a-92ea-b239d8455be1.jpg)
![Screenshot 2022-03-18 at 07 14 39](https://user-images.githubusercontent.com/98022119/159013991-474b71db-7716-455a-b9eb-77c06e5faa66.jpg)
![Screenshot 2022-03-18 at 07 15 00](https://user-images.githubusercontent.com/98022119/159014011-edb267d9-f27b-4099-b9f0-0ba5119c62d8.jpg) 

### Reading all the records  

![Screenshot 2022-03-18 at 07 20 36](https://user-images.githubusercontent.com/98022119/159014292-aff315f7-fa38-46c9-b0f0-f1bebdff7c25.jpg) 

### Updating an existing record 

![Screenshot 2022-03-18 at 07 25 15](https://user-images.githubusercontent.com/98022119/159014380-7924016f-3b09-4789-b0a5-585129bdb2c9.jpg)
![Screenshot 2022-03-18 at 07 26 48](https://user-images.githubusercontent.com/98022119/159014479-07a4d0bd-22a2-4336-8b68-5cbd4acf7e95.jpg) 

### Reading a record via the ID 

![Screenshot 2022-03-18 at 07 29 00](https://user-images.githubusercontent.com/98022119/159014586-3ed59424-b78a-4c74-bc15-09fb51b3a726.jpg)
![Screenshot 2022-03-18 at 07 29 25](https://user-images.githubusercontent.com/98022119/159014607-052b5dbb-fb07-4f35-8bd2-014ba38c9742.jpg) 

### Deleting a record 

![Screenshot 2022-03-18 at 07 31 33](https://user-images.githubusercontent.com/98022119/159014700-7158d17d-d6e9-4e8c-929e-56546bfec577.jpg)
![Screenshot 2022-03-18 at 07 31 50](https://user-images.githubusercontent.com/98022119/159014751-e1b6a020-ab66-4fbd-aef9-281fa775eb73.jpg) 

### Removing a record and returning a boolean 

![Screenshot 2022-03-18 at 07 34 22](https://user-images.githubusercontent.com/98022119/159014959-6bc2a012-5f6e-4b2d-9dcb-ac572207e120.jpg) 
![Screenshot 2022-03-18 at 07 34 38](https://user-images.githubusercontent.com/98022119/159014990-39f626ac-8c09-461a-a85f-dfc2419b9d29.jpg) 

## Author 

Name: Emmanuel Engelbert  
Username: EmmanuelEngelbert
