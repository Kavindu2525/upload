
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Healthapp {


    public static void run() {

        Scanner input = new Scanner(System.in);


        int userType = 0;
        while (userType != 3) {
            System.out.println("If you are a hospital administrator, please press 1.");
            System.out.println("If you are a patient, please press 2.");
            System.out.println("To exit, press 3.");
            userType = input.nextInt();

            if (userType == 1) {
                hospitalAdministrator();
            } else if (userType == 2) {
                patient();
            } else if (userType == 3) {
                System.out.println("Exit");
            } else {
                System.out.println("Invalid Input");
            }
        }
    }


    public static void hospitalAdministrator() {
        int userObject = 0;
        while (userObject != 3) {
            System.out.println("Press 1 to add a doctor, press 2 to add a doctor availability, and press 3 to exit");
            Scanner input = new Scanner(System.in);
            userObject = input.nextInt();
            if (userObject == 1) {
                Contoller.addDoctor();


            } else if (userObject == 2) {
                Contoller.availabilityDoctor();


            } else if (userObject == 3) {
                System.out.println("Exit");
            } else {
                System.out.println("Invalid Number");
            }
        }
    }

    public static void patient() {
        int userObject = 0;
        while (userObject != 5) {
            System.out.println("Press 1 to view doctors, press 2 to book an appointment, press 3 to view a selected doctor's booking, press 4 to register patient, and press 5 to exit");
            Scanner input = new Scanner(System.in);
            userObject = input.nextInt();
            if (userObject == 1) {
                Contoller.viewDoctors();

            } else if (userObject == 2) {
                Contoller.appointment();
            } else if (userObject == 3) {
                Contoller.ViewSelectedDoctorsBookings();
            } else if (userObject == 4) {
                Contoller.registerPatient();
            } else if (userObject == 5) {
                System.out.println("Exit");
            } else {
                System.out.println("Invalid Number");
            }
        }
    }

    public static void main(String[] args) {

            Doctor sampleDoc = new Doctor(223, "Saman Kumara", "22.05.1987", "Gynocologist", "077-333-9900");
            Patient samplePatient = new Patient("T-12", "Alice Johnson", "555-123-4567");
            Contoller.allDoctors.add(sampleDoc);
            Contoller.allPatient.add(samplePatient);

            /*Doctor D1 = new Doctor(225, "Kavindu", "October 26th", "NeruoPhysician", "0714587892");
            Patient P1 = new Patient("dilum", "April 1", "02587964", "T-0034");
            System.out.println("D1:");
            System.out.println(D1.isPhysician());
            System.out.println("P1:");
            System.out.println(P1.getPatientType());*/
            run();
        }
    }



 