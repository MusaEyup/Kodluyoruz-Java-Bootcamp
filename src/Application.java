import entities.airlines.AnadoluJet;
import entities.abstracts.IAbroad;
import entities.abstracts.IBusiness;
import entities.airlines.Pegasus;
import entities.abstracts.IPackage;
import entities.abstracts.Plane;
import entities.airlines.THY;
import service.TicketService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {



        Plane thy = new THY(100, 200);

        Plane anadoluJet = new AnadoluJet(100, 200);

        Plane pegasus = new Pegasus(150, 200, 20);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hosgeldiniz.....");
        TicketService ticketService = new TicketService();
        boolean exit = false;
        do {

            showMenu();
            String next = scanner.next();

            switch (next){
                case "1":
                    System.out.print("koltuk sayısını giriniz: ");
                    String seatCount = scanner.next();
                    ticketService.takeTicketForPassenger(thy, Integer.parseInt(seatCount) );
                    break;

                case "2":
                    System.out.println(getPlaneInfo(thy));
                    break;

                case "3":
                    System.out.print("koltuk sayısını giriniz: ");
                    seatCount = scanner.next();
                    String input = "";
                    do {
                        System.out.print("Business ise \'B\'ye değilse \'E\'ye basiniz: ");
                        input = scanner.next();
                    } while (!input.equalsIgnoreCase("B") && !input.equalsIgnoreCase("E"));

                    if(input.equalsIgnoreCase("B")){
                        ticketService.takeBusinessTicketForPassenger((IBusiness) pegasus, Integer.parseInt(seatCount));
                    }else{
                        ticketService.takeTicketForPassenger(pegasus, Integer.parseInt(seatCount));
                    }
                    break;
                case "4":
                    System.out.println(getPlaneInfo(pegasus));
                    break;
                case "5":

                    break;
                case "6":
                    System.out.println(getPlaneInfo(anadoluJet));

                    break;
                case "7":
                    exit = true;
            }


        } while(!exit);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("1) THY ile uçuş yapmak istiyorsunuz");
        System.out.println("2) THY  uçuş bilgileri ");
        System.out.println("3) Pegasus ile uçuş yapmak istiyorsunuz");
        System.out.println("4) Pegasus  uçuş bilgileri");
        System.out.println("5) Anadolu Jet ile uçuş yapmak istiyorsunuz");
        System.out.println("6) Anadolu Jet uçuş bilgileri ");
        System.out.println("7) Çıkış");

    }
    private static String getPlaneInfo(Plane plane){

        StringBuilder builder = new StringBuilder();

        String[] classname = plane.getClass().getName().split("\\.");
        String airlineCompanyName = classname[classname.length-1];
        String header = airlineCompanyName + " Bilgileri: ";
        builder.append(header);
        builder.append("\nToplam koltuk sayısı: ");
        builder.append(plane.getCapacity());
        builder.append("\nDolu koltuk sayısı: ");
        builder.append(plane.getPassengerCount());
        builder.append("\nBoş koltuk sayısı: ");
        builder.append(plane.getCapacity() - plane.getPassengerCount());

        if(plane instanceof Pegasus){
            Pegasus plane1 = (Pegasus) plane;
            builder.append("\nBusiness koltuk sayısı: ");
            builder.append(plane1.getBusinessCapacity());
            builder.append("\nDolu business koltuk sayısı: ");
            builder.append(plane1.getBusinessPassengerCount());
            builder.append("\nBoş business koltuk sayısı: ");
            builder.append(plane1.getBusinessCapacity() - plane1.getBusinessPassengerCount());
        }
        if(plane instanceof IAbroad){
            IAbroad anadoluJet = (IAbroad) plane;
            builder.append("\n").append(anadoluJet.foodChoice());
        }

        if(plane instanceof IPackage){
            IPackage plane1 = (IPackage) plane;
            plane1.extraPackage();
            builder.append("\n");
            builder.append(plane1.extraPackage());
        }
        builder.append("\n");
        return builder.toString();



    }
}
