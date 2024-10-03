# Tracker IP

The project consists of a frontend made with React and a backend made with Java and Spring Boot.

# How to use it

 1. Build API
 2. Start Client
 3. Try it out!

### API
You need to build a run a docker container.

 1. docker build -t trackerip .
 2. docker run -p 8000:8080 trackerip

### Client
You need to start the React app

 1. npm start

### API Request (Optional)
If you need to test the API, you can build the API and make a request like this:

> localhost:8080/traceip?ip=83.44.194.93

Or if you builded the docker container, you can make a request like to:

   

> localhost:8000/traceip?ip=83.44.194.93

## Improvements 

 1. First would be to change the **caching system** so that, instead of doing the caching manually, to use the Spring Cache. Due to time constraints I did not advance it.
 2. Use a **persistent database** like redis or mysql for the 4 repositories that the api has.
 3. On the front end side it needs more love. At least a **loading screen**.




