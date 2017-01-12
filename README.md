#### TECHNICAL TASK:

Develop Java RESTful API that returns in geojson format a list of weather stations 

	including station id, name, geo location and current weather observations like:
	wind speed, 
	temperature within a given rectangular  geo coordinates. 
	
	
	
#### Run info

Execute like typical Spring Boot application -> by running `GeoApiDataApplication.main()`

after the application will be up you can access following url:

    http://localhost:8081/stations
    
Also, some predefined data is saved to H2 in memory DD, thus you can access, for example:

    http://localhost:8081/stations/huston
    
With Postman application you can check main operation: POST, DELETE, UPDATE.

For POST you can use `request_example.json` example which is located under 'resource' folder.