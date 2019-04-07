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

### Database

The application expects to connect to a Postgres database. For convenience a docker script is included to quickly stand up a new instance.

To run:

`$ docker-compose -f ./docker/stack.yml up`

Set up your connection details in `src/main/java/resources/application.properties`


### Application
