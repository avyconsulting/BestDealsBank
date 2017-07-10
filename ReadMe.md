# BestDeals Bank

Interview test implementation
Java implementation of BestDeals Bank Interview test task. Guice and Jersey are used to implement the REST Endpoints/Resources.

## Installation

mvn clean install

## Usage

Calculate - [Type] simple/compound

[POST]
<br/>
http://localhost:7080/calculator-services/services/calculator?type=simple
<br/>
Input Json:
{
  "principle": 2000,
  "noOfYears": 5,
  "rate": 3
}

<br/>
[PUT]
<br/>
http://localhost:7080/calculator-services/services/deal/clients/1
<br/>
[
   {
 	"principle": 2000,
 	"noOfYears": 5,
 	"rate": 3
   },
   {
     "principle": 32000,
     "noOfYears": 35,
     "rate": 3
   }  
 ]
<br/>

[GET]
<br/>
http://localhost:7080/calculator-services/services/deal/clients/1

## Contributing

## History

TODO: Write history

## Credits

TODO: Write credits

## License
