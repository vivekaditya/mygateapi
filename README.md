# MyGateAPI
MyGate API for Backend Challenge

## Deliverables
1) Host code on GitHub (This is the repo)
2) Host product on EC2 ([Link to server](http://18.221.31.107:8090/swagger-ui.html))
3) Your code should stand alone include a good readme / any libraries or dependencies should be codified into configuration and / or be built up using scripts that you provide. (This is a docker based deployment, so its totally standalone)
4) Please list out any assumptions you have made (See the assumptions sections)
						
## Backend Challenge
Given the data about Food Trucks in San Francisco : here (https://data.sfgov.org/d/rqzj-sfat). You will build an API that allows the following operations on this data set
						
1) Search by name of applicant (GET /mygateapi/v1/foodTruck/search achieves this)
2) Search by expiration date, to find whose permits have expired (GET /mygateapi/v1/foodTruck/search achieves this)
3) Search by street name (GET /mygateapi/v1/foodTruck/search achieves this)
4) Add/Delete new food truck entry to the data set ( POST /mygateapi/v1/foodTruck/ & DELETE /mygateapi/v1/foodTruck/{id} achieves this)
5) Auto expiry of licenses (Achieved by Scheduling Tasks in Spring)
6) Given one or multiple locations, predict which truck will be	 the best one to assign the job( POST /mygateapi/v1/foodTruck/search achieves this)

## Requirements
The code just needs docker to run it.
