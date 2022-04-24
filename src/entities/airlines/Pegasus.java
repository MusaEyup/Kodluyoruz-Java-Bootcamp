package entities.airlines;

import entities.abstracts.IBusiness;
import entities.abstracts.Plane;

public class Pegasus extends Plane implements IBusiness {

    private int businessCapacity;
    private int businessPassengerCount = 0;
    private final int businessFare = 500;

    public Pegasus(int capacity, int fare ,int businessCount) {
        super(capacity, fare);

        this.businessCapacity = businessCount;
    }



    @Override
    public int takeBusinessTicket(int countPerson) {
        if(this.businessCapacity < countPerson || !super.isCapacity(countPerson)){
            return -1;
        }
        this.businessPassengerCount += countPerson;
        this.businessCapacity -= countPerson;
        super.passengerCount -= countPerson;

        int ticketFare = businessFare * countPerson + super.fare * countPerson;
        return ticketFare;
    }

    public int getBusinessCapacity() {
        return businessCapacity;
    }

    public void setBusinessCapacity(int businessCapacity) {
        this.businessCapacity = businessCapacity;
    }

    public int getBusinessPassengerCount() {
        return businessPassengerCount;
    }

    public void setBusinessPassengerCount(int businessPassengerCount) {
        this.businessPassengerCount = businessPassengerCount;
    }
}
