package service;

import entities.abstracts.IBusiness;
import entities.abstracts.Plane;

public class TicketService {


    public void takeTicketForPassenger(Plane plane, int countPerson){

        int takeTicketFare = plane.takeTicket(countPerson);
        if(takeTicketFare == -1){
            System.out.println("Yeterli Yer Bulunmamaktadir");
            return;
        }
        System.out.println("Total fare: " + takeTicketFare);


    }

    public void takeBusinessTicketForPassenger(IBusiness plane  , int countPerson){
        int ticketFare = plane.takeBusinessTicket(countPerson);
        if(ticketFare == -1){
            System.out.println("Yeterli Yer Bulunmamaktadir");
            return;
        }
        System.out.println("Total fare: " + ticketFare);
    }


}
