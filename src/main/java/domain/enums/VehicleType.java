package domain.enums;

public enum VehicleType {
    CAR(100),
    BIKE(80),
    SCOTTY_SCOOTER(50),
    ELECTRIC_CAR(60),
    ELECTRIC_SCOOTER(40),
    BICYCLE(20),
    DISABLED_VEHICLE(30);

    public final Integer price;

    VehicleType(Integer price) {
        this.price = price;
    }
}
