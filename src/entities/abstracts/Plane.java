package entities.abstracts;

public abstract class Plane {

    protected int passengerCount = 0;
    private int capacity;
    protected int fare;

    public Plane(int capacity, int fare) {
        this.capacity = capacity;
        this.fare = fare;
    }

    public int takeTicket(int countPerson){
        if (!this.isCapacity(countPerson)){
            return -1;
        }

        int ticketFare = countPerson * fare;
        increasePassengerCount(countPerson);

        return ticketFare;
    }

    public boolean isCapacity(int passengerCount){

        return capacity >= this.passengerCount + passengerCount;
    }

    public void increasePassengerCount(int countPerson){
        this.passengerCount += countPerson;
    }


    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }
}
