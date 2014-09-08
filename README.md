DemandSpike
===========
Load Testing Framework for Distributed Applications built on Top of Yarn

##DemandSpike Command##

To run demandspike 


eg: demandspike run --target http://127.0.0.1:7080 --method POST --protocol HTTP --time 300

eg: demandspike run --target http://www.google.com --method GET --protocol HTTP




#Build And Develop#

##Build With Gradle##

1. cd Sparkngin
2. gradle clean build install

##Eclipse##

To generate the eclipse configuration

1. cd path/DemandSpike
2. gradle eclipse

To import the project into the  eclipse

1. Choose File > Import
2. Choose General > Existing Projects into Workspace
3. Check Select root directory and browse to path/DemandSpike
4. Select all the projects then click Finish

#Run DemandSpike job
Build the release
```
gradle clean build install release
```
Start demandSpike job
```
cd build/release/DemandSpike/bin
#To launch the server
./server.sh 
#Ping to check the server status
./shell.sh -c server ping 
#To launch the batch script tets
./shell.sh -f  hello-demandspike.csh
```
