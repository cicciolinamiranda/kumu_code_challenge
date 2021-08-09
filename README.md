# Kumu Code Challenge

## Using Java ,MVVM, Retrofit, Android Room

## Example’s Feature:
* Load data from server Using Retrofit2.
* Use Livedata with Room.

<img src="https://github.com/cicciolinamiranda/kumu_code_challenge/blob/master/device-2021-08-09-203059.png" height="450px" width="250px">
<img src="https://github.com/cicciolinamiranda/kumu_code_challenge/blob/master/device-2021-08-09-203116.png" height="450px" width="250px">

***
## Technology Stack
* Java
* Android

DB
* Offline Storage Using Room


Architectural Pattern
* Model-View-ViewModel

Why MVVM?
*  Easy to build up and to maintain. Cleanly separates the user interface from the application logic. 

Libraries
* Room - The code is simpler with the use of annotations and you don't to create your custom SQL Lite class for your device database. Easier to maintain since the sql query can be declared on its @Query annotation. It will already provide the interface implementation for your DAO methods.

* Retrofit - Easier to develop and to maintain. It supports http logging, serialization and deserialization of responses and able to provide synchronous and asynchronous calls.

## Folder Structure
### Under `src/main`
* `java` contains Java source codes
* `res` contains all images, xmls and drawables

### Under `src/main/java`

* `com.example.kumu.data` contains classes that interact or represent the data layer.
    * `db` - domain data models for the ORM. (i.e. classes that represent the DB tables).
    * `repository` - classes that abstract the DAO as repositories. These classes represent results as collections of entities. Hence the name 'repository'.
    * `dto` - data transfer objects that carries data between processes.
    * `exception` - custom global Exception class that is being use by the app.

* `com.example.kumu.api` contains the classes that will be use for API calls.

* `com.example.kumu.util` contains utility classes for that application (e.g. mapping domain models to resources).

* `com.example.kumu.viewmodel` contains the viewmodels which is the mediator from the view to the business logic.

* `com.example.kumu.view` contains View controller classes for activities, adapters and the like.


