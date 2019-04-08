# Crowdfunding Poller

![](https://travis-ci.com/cbroome/crowdfund-poller.svg?branch=master)

This application will poll popular open source websites nightly. It builds a selection of currently active campaigns and allows basic perusal.

The bundled frontend will load one random active campaign from a crowdfunding site. Currently Kiva, and Donors Choose are polled.  

## Components

### Backend

The backend server is written in Spring Boot. The process for polling the web services utilize Spring Batch.


### Frontend

The frontend is written in React. Gatsby is used to host it. 


## Install

THis is a Java 8 application and should not be used with a later JDK

### Database

The application expects to connect to a Postgres database. For convenience a docker script is included to quickly stand up a new instance.

To run:

`$ docker-compose -f ./docker/stack.yml up`

Set up your connection details in `src/main/java/resources/application.properties`


### Application

Build a new jar (if not provided with)

`./gradlew build`

Then run as a jar with Java 8. Later versions won't operate: 

`$ java -jar .//build/libs/crowdfund-0.0.1.jar`

This will launch the application on port 8080. As a result of the first run the database tables will get created and populated. 

### Frontend

To run the frontend you'll need to have Gatsby installed: 

`npm install -g gatsby`

Afterwards change your working directory to `frontend`. Run `npm install` to gather all required modules


## TODO

1. Remove the Gatsby default spreadsheets
1. Add schedules to poll campaigns nightly
1. Get Gatsby to parse properly
