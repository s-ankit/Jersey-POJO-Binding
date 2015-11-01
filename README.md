# RestSampleWithPojo
This Repository is here to demonstrate the mapping of Pojo with Rest Service

#Note
This demonstration is to show step by step integration of Restful API with Jersey framework and also how it can be configured easily with POJO

#Scenario
A post request with username and password in JSON format from browser side trying to access a post Restful API which consumes Application/Json type

#To Acheive
Solve 415 Media Type Not Supported error thrown by Jersey Framework.
##Important Steps:-
###Step 1:
```
Add Jersy Dependency to your Project in pom.xml as below:
<?xml version="1.0" encoding="UTF-8"?>
<dependencies>
       		<!-- Minimal Dependencies Required for making a Rest Service -->
            	<dependency>
			<groupId>javax.ws.rs</groupId>
			<artifactId>javax.ws.rs-api</artifactId>
			<version>2.0.1</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.glassfish.jersey.containers</groupId>
				<artifactId>jersey-container-servlet</artifactId>
				<version>2.22.1</version>
				<scope>provided</scope>
		</dependency>
		<!-- Minimal Dependencies Required for making a Rest Service -->
		<!-- Below Mentioned Dependency is added for POJO binding support -->
		<dependency>
				<groupId>org.glassfish.jersey.media</groupId>
				<artifactId>jersey-media-json-jackson</artifactId>
				<version>2.22.1</version>
		</dependency>
</dependencies>
```
###Step 2:
```
Remember that only adding dependency to your project in maven will result in class not found exception when you start the local
tomcat server. To solve this, Copy all the jars included in maven dependencies to WEB-INF/lib folder.(You can Skip 
jersey-media-json-jackson jars). Jars added by first two depencies must be there in lib folder.
```
###Step 3:
```
Now you can design your API using POJO like this:
        
        @Path("/login")
 	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	  public Response testHeader(UserBean userdata)
	  {
			String username=userdata.getUserName();
			String password=userdata.getPassword();
			return Response.status(200).entity("Success").build();
	  }
	 
Where UserBean is just a POJO with getter and setter of two variables named username and password.
From browser you can send a post request with username,password value in JSON format like:
  	
	{"username":"ankit","password":"srivastava"}
	  			
IMPORTANT: your variable name in POJO and in Json Key must be same(case Sensetive)
```	  			
