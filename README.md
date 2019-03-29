# Crowdfunding Poller

This application will poll popular open source websites nightly. It builds a selection of currently active campaigns and


## Install

The application expects to connect to a Postgres database. For convenience a docker script is included to quickly stand up a new instance.

To run:

`$ docker-compose -f ./docker/stack.yml up`

Set up your connection details in `src/main/java/resources/application.properties`