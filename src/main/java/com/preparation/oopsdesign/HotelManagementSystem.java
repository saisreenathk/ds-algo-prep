package com.preparation.oopsdesign;

import java.util.Date;
import java.util.List;
//https://www.youtube.com/watch?v=Hb6WePtPQhg&list=PL12BCqE-Lp650Cg6FZW7SoZwN8Rw1WJI7&index=3&ab_channel=SoumyajitBhattacharyay
public class HotelManagementSystem {
}

class Hotel {

    String Name;
    Integer id;
    Location hotelLocation;
    List<Room> roomList;

}

class Location {

    Double longitude;
    Double latitude;
}

class Room {

    String roomNumber;
    RoomStyle roomStyle;
    RoomStatus roomStatus;
    Double bookingPrice;
    List<RoomKey> roomKeys;
    List<HouseKeepingLog> houseKeepingLogs;

}

enum RoomStyle {

    STANDARD, DELUX, FAMILY_SUITE;
}

enum RoomStatus {

    AVAILABLE, RESERVED, NOT_AVAILBLE, OCCUPIED, SERVICE_IN_PROGRESS;
}

class RoomKey {

    String keyId;
    String barCode;
    Date issuedAt;
    Boolean isActive;
    Boolean isMaster;

    public void assignRoom(Room room) {
    }

    ;

}

class HouseKeepingLog {
    String description;
    Date startDate;
    int duration;
    HouseKeeper houskeeper;

    public void addRoom(Room room) {
    }

    ;
}

abstract class Person {

    String name;
    Account accountDetail;
    String phone;
}

class Account {

    String username;
    String password;

    AccountStatus accountStatus;

}

enum AccountStatus {

    ACTIVE, CLOSED, BLOCKED;
}

class HouseKeeper extends Person {

    public List<Room> getRoomsServiced(Date date) {
        return null;
    };
}

class Guest extends Person {

    Search searchObj;
    Booking bookingObj;

    public List<RoomBooking> getAllRoomBookings() {
    return null;
    }

    public RoomBooking createBooking() {
    return null;}

    public RoomBooking cancelBooking(int bookingId) {
    return null;}
}

class Receptionist extends Person {

    Search searchObj;
    Booking bookingObj;

    public void checkInGuest(Guest guest, RoomBooking bookingInfo) {
    }

    ;

    public void checkOutGuest(Guest guest, RoomBooking bookingInfo) {
    }

    ;

}

class admin extends Person {

    public void addRomm(Room roomDetail) {
    }

    public Room deleteRoom(String roomId) {
    return null;}

    public void editRoom(Room roomDetail) {
    }
}

class Search {

    public List<Room> searchRoom(RoomStyle roomStyle, Date startDate, int duration) {
    return null;}

}

class RoomBooking {

    String bookingId;
    Date startDate;
    int durationInDays;
    BookingStatus bookingStatus;
    List<Guest> guestList;
    List<Room> roomInfo;
    BaseRoomCharge totalRoomCharges;
}

class BookingStatus{

}


/**
 * Decorator pattern is used to decorate the prices here.
 **/

interface BaseRoomCharge {

    public Double getCost();

    void setCost(double v);
}

class RoomCharge implements BaseRoomCharge {


    double cost;

    @Override
    public Double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

class RoomServiceCharge implements BaseRoomCharge {

    double cost;
    BaseRoomCharge baseRoomCharge;

    public Double getCost() {
        baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
        return baseRoomCharge.getCost();
    }

    @Override
    public void setCost(double v) {

    }
}

class InRoomPurchaseCharges implements BaseRoomCharge {

    double cost;
    BaseRoomCharge baseRoomCharge;

    public Double getCost() {
        baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
        return baseRoomCharge.getCost();
    }

    @Override
    public void setCost(double v) {

    }
}

class Booking {

    public RoomBooking createBooking(Guest guestInfo) {
    return  null;}

    public RoomBooking cancelBooking(int bookingId) {
    return null;}

}
