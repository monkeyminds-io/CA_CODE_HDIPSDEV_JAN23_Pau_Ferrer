# Distributed Systems CA
by Pau Ferrer

## Introduction
This project is a concept project designed and developed to be submitted as the CA of
the module Distributed Systems of a Higher Diploma Level 8 in Computer Science in
Software Development.

The purpose of this project is to design and build a smart health application using
gRPC and jmDNS to develop a client-server application in a local environment.

## Service Definitions
### 1. Auth Service
The Auth Service is responsible for registering and logging in users. Uses a CSV file
to persist data as a DataBase. It has a proto file and its corresponding Server and Client
files / classes.

The methods implemented in this service are:
* register() => Simple RPC
  * REQUEST (First Name, Last Name, Email, Password and Role)
  * RESPONSE (Newly created User)
* login() => Simple RPC
  * REQUEST (Email and Password)
  * RESPONSE (The found User matching credentials)

 ### 2. Booking Service
The Booking Service is responsible for managing appointments and performing CRUD actions.
It uses a CSV file to persist and store data as a DataBase. And it has a proto file and\
its corresponding Server files / classes.

The methods implemented for this service are:
* create() => Simple RPC
  * REQUEST (Patient ID, Doctor ID, Date-Time)
  * RESPONSE (Newly created Appointment)
* get() => Simple RPC
  * REQUEST (ID)
  * RESPONSE (Appointment matching ID)
* update() => Simple RPC
  * REQUEST (Patient ID, Doctor ID, Dat-Time)
  * RESPONSE (Updated Appointment)
* cancel() => Simple RPC
  * REQUEST (ID)
  * RESPONSE (Deleted Appointment)
* shiftList() => Bidirectional streaming RPC
  * REQUEST (Stream of Doctor IDs)
  * RESPONSE (Stream of Appointments for each Doctor)

### 3. Prescriptions Service
The Prescriptions Service is responsible for managing prescriptions. It performs actions
for create and view all prescriptions. USes a CSV file as a DataBase in order to persist
and store data. And it has a proto file and its corresponding Server files / classes.

The methods implemented are:
* create() => Simple RPC
  * REQUEST (Patient ID, Doctor Id, Expiry)
  * RESPONSE (Newly created Prescription)
* addDrug() => Simple RPC
  * REQUEST (Drug Name, Doses, Comments)
  * RESPONSE (Newly created Drug)
* viewAll() => Server-side streaming RPC
  * REQUEST (Empty)
  * RESPONSE (Stream of Prescriptions)
