# airports
Develop a service that continuously loads and stores a subset of METAR data for the subscribed airports, and makes that data available to clients on request

I have created two services one called SubscriptionRestController and one called AirportRestController,
in these controllers I have implemented the GET,POST and DELETE functions. 
The entities are Subscriptions and Metar with their relative repositories.
To perform the GET,POST and DELETE tests I used POSTMAN or curl like:
curl -H "Content-Type: application/json" -X POST http://localhost:8080/subscriptions/add -d "{"icaoCode":"LIMC","description":"Milano Malpensa"}"
