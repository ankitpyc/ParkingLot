# Parking Lot Low-Level Design

## Overview

This project is a low-level design implementation of a parking lot system. The system manages parking spaces, vehicle entry, and exit. It provides functionality to park vehicles, retrieve parked vehicles, and monitor parking space availability.

## Features

- **Parking Space Management:** Efficiently manage parking spaces for cars and other vehicles.
- **Vehicle Entry and Exit:** Facilitate the entry and exit of vehicles from the parking lot.
- **Parking Ticket System:** Issue parking tickets upon vehicle entry and handle payments for exit.

## Tech Stack

- Java
- Object-Oriented Programming (OOP) principles

## Setup

1. Clone the repository:

```bash
   git clone https://github.com/your-username/parking-lot.git
```
2. Navigate to the project directory:
```bash
cd parking-lot
```
3. Compile and run the application:
```bash
javac Main.java
java Main
```


## Parking a Vehicle:
```java
ParkingLot parkingLot = new ParkingLot(20); // Create a parking lot with 20 spaces
Vehicle car = new Car("ABC123"); // Create a car with license plate "ABC123"
ParkingTicket ticket = parkingLot.parkVehicle(car);
```
Retrieving a Parked Vehicle:
```java
Vehicle retrievedCar = parkingLot.retrieveVehicle(ticket);
```
## Example Main Program:
```java
public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(50);
        Vehicle car1 = new Car("XYZ456");
        ParkingTicket ticket1 = parkingLot.parkVehicle(car1);

        // Continue with other operations...
    }
}
```
## Contributing

Feel free to contribute to the development of this parking lot system. Open issues, submit pull requests, and share your ideas!

License

This project is licensed under the MIT License - see the LICENSE file for details.
