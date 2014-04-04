enviroCar_demo
==============

	
I am calling the track with trackid 533ecbfde4b09d7b34f80643
and since there are many measurement values included in it
for different co-ordinates, i am calling the measurement
with measurement id 533ecbfde4b09d7b34f80645

Now the approach:

I got the json which  i have attached below. The fuel consumption
was iven in l/h and the speed was given in km/h.

So i calculated the fuel consumption from this in litre/km, which 
can be done as consumtion/speed.

Then 1litre/km= 2.35214583 Miles per gallon. So follows the answer.

Also attached the screenshot.








JSON


{
   "type":"Feature",
   "geometry":{
      "type":"Point",
      "coordinates":[
         11.74033791,
         48.39654225
      ]
   },
   "properties":{
      "id":"533ecbfde4b09d7b34f80645",
      "time":"2014-04-04T15:02:51Z",
      "sensor":{
         "type":"car",
         "properties":{
            "id":"526d5f07e4b000fe05820d89",
            "model":"Golf V",
            "fuelType":"gasoline",
            "manufacturer":"Volkswagen",
            "constructionYear":2005,
            "engineDisplacement":1600
         }
      },
      "phenomenons":{
         "Rpm":{
            "value":737.0,
            "unit":"u/min"
         },
         "Calculated MAF":{
            "value":8.540597250076145,
            "unit":"g/s"
         },
         "Consumption":{
            "value":2.8074830023534787,
            "unit":"l/h"
         },
         "GPS HDOP":{
            "value":0.8,
            "unit":"precision"
         },
         "Speed":{
            "value":9.0,
            "unit":"km/h"
         },
         "GPS Speed":{
            "value":8.1,
            "unit":"km/h"
         },
         "Intake Pressure":{
            "value":79.0,
            "unit":"kPa"
         },
         "GPS Bearing":{
            "value":338.3999938964844,
            "unit":"deg"
         },
         "GPS Altitude":{
            "value":497.0,
            "unit":"m"
         },
         "CO2":{
            "value":6.597585055530675,
            "unit":"kg/h"
         },
         "GPS PDOP":{
            "value":1.1,
            "unit":"precision"
         },
         "GPS Accuracy":{
            "value":5.0,
            "unit":"%"
         },
         "Intake Temperature":{
            "value":-4.0,
            "unit":"c"
         },
         "GPS VDOP":{
            "value":0.8,
            "unit":"precision"
         }
      }
   }
}
