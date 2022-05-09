# qc-demo

1. create a clean maria-db schema 'nation'
2. adjust connection properties in application.properties file.
3. run project
4. http://localhost:8080

the rest end points are: 
#for screen 1
http://localhost:8080/api/countries?page=1&size=5&sorted=true

#for task 1
http://localhost:8080/api/languages/{countryId}

#for screen 3
http://localhost:8080/api/countries/stats
post request body example:
{
    "regionName":"Caribbean",
    "yearFrom":1990,
    "yearTo":2000,
    "page":1,
    "size":10
}

#for screen 3
http://localhost:8080/api/regions

#for screen 2
http://localhost:8080/api/countries/gdpperpopulation
