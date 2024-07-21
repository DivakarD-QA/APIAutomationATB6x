package org.example.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.example.pojos.*;

public class PayloadManager {

    Faker faker = new Faker();
    Gson gson = new Gson();

    public String createBookingPayloadAsString(){
        Booking booking =new Booking();

        booking.setFirstname("Pramod");
        booking.setLastname("Stupid");
        booking.setTotalprice(213);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");


        String jsonString = gson.toJson(booking);
        return jsonString;
    }

    public String creaeBookingNegative(){
        Booking booking =new Booking();

        booking.setFirstname("Pramod");
        booking.setLastname("Stupid");
        booking.setTotalprice(213);
        booking.setDepositpaid(true);
        return "{ }";
    }

    public String fullUpdatePayloadAsString(){
        Booking booking =new Booking();

        booking.setFirstname("Naveen");
        booking.setLastname("King");
        booking.setTotalprice(213);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        return gson.toJson(booking);
    }


    public BookingResponse bookingResponseJava(String responseString){

        BookingResponse bookingResponse = gson.fromJson(responseString,BookingResponse.class);
        return bookingResponse;
    }

    public VWOResponse vwoResponseJava(String responseString){

        VWOResponse vwoResponse = gson.fromJson(responseString,VWOResponse.class);
        return vwoResponse;
    }

    public String setAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        // Ser
        String jsonPayloadString = gson.toJson(auth);
        System.out.println(" Payload set to " + jsonPayloadString);

        return jsonPayloadString;
    }

    public String getTokenFromJson(String tokenResponse){
        // Response ( JSON) ->  Object TokenResponse
        // Deserialization

        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
                return tokenResponse1.getToken();
    }

    public Booking getResponseFromJson(String getResponse){
        // Response ( JSON) ->  Object getResponse
        // Deserialization
       Booking booking = gson.fromJson(getResponse, Booking.class);
    return booking;
    }
}

