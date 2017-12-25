package ua.nure.garmash.Practice6;

public class Part3 {
    static Car parking[] = new Car[10];

    public static void main(String[] args) {
        System.out.println("Empty parking place=================================");
        Parking.showParkingPlace();
        System.out.println("Park 2 cars (starting from 0 place) ==================");
        Parking.parkACar(0);
        Parking.parkACar(0);
        Parking.showParkingPlace();
        System.out.println("Park 5 cars (starting from 5th place)================");
        Parking.parkACar(5);
        Parking.parkACar(5);
        Parking.showParkingPlace();
        Parking.leaveParkingPlace(5);
        Parking.showParkingPlace();
        Parking.parkACar(6);
        Parking.showParkingPlace();


    }
    private static class Parking {

        public static void parkACar(int k) {
            Car car = new Car();
            for (int i =k; i<parking.length; i++) {
                if(parking[i]==null){
                    parking[i] = car;
                    return;
                }
            }
        }
        public static void leaveParkingPlace (int i) {
            if (parking[i]==null) {
                System.out.println( "there is no car at parking place # " + i);
            }
            parking[i]=null;
            System.out.println("the car has successfully left parking place # " + i);
        }

        public static String showParkingPlace (){

            for (int i=0; i<parking.length; i++){
                if(parking[i]!=null){
                    System.out.print("[Car"+i+"] ");
                } else
                System.out.print("["+i+ "] ");
            }
            System.out.println("\n");
            return "";
        }
    }

    private static class Car {

    }
}
