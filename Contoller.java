import java.util.*;

public class Contoller {
    public static ArrayList<Doctor> allDoctors = new ArrayList<>();
    public static ArrayList<Patient> allPatient = new ArrayList<>();
    public static int NUMBER_OF_SLOTS = 5;

    public static void addDoctor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Enter your birthday");
        String birthday = sc.nextLine();
        System.out.println("Enter your specialization");
        String specialization = sc.nextLine();
        System.out.println("Enter your contact");
        String contact = sc.nextLine();

        Random random = new Random();
        Doctor tempDoctor = new Doctor(random.nextInt(), name, birthday, specialization, contact);
        allDoctors.add(tempDoctor);
    }

    public static void availabilityDoctor() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Doctor ID");
        int ID = scanner.nextInt();
        Doctor SelectedDoctor = null;
        for (Doctor doc : allDoctors) {
            if (doc.getDoctorId() == ID) {
                SelectedDoctor = doc;
            }
        }
        if (SelectedDoctor == null) {
            System.out.println("No Doctor Found");
            return;
        }
        System.out.println("Enter the Day you want to add Availability:");
        int day = scanner.nextInt();
        System.out.println("Enter the Month you want to add Availability:");
        int month = scanner.nextInt();
        System.out.println("Enter the Year you want to add Availability:");
        int year = scanner.nextInt();

        Date bookingdate = new Date(year, month, day);
        SelectedDoctor.setAvailability(bookingdate);

    }

    public static void viewDoctors() {

        for (Doctor doc : allDoctors) {
            System.out.println(doc.getName() + "has a specialization of  " + doc.getSpecialization() + " has a ID " + doc.getDoctorId() + " has a availability" + doc.getAvailability().toString());

        }
    }

    public static void registerPatient() {

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter patient Name");
        String name = sc1.next();
        System.out.println("Enter patient birthday");
        String birthday = sc1.next();
        System.out.println("Enter patient contact number ");
        String contactNumber = sc1.next();
        System.out.println("Enter patient ID");
        String ID = sc1.next();

        Patient patient = new Patient(name, contactNumber, ID);
        allPatient.add(patient);

    }

    public static void appointment() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Doctor's ID you want to make appointment");
        int ID = scanner.nextInt();
        System.out.println("Enter patient ID");
        String id = scanner.next();

        System.out.println("Enter the Day you want to add Appointment:");
        int day = scanner.nextInt();
        System.out.println("Enter the Month you want to add Appointment:");
        int month = scanner.nextInt();
        System.out.println("Enter the Year you want to add Appointment:");
        int year = scanner.nextInt();

        Patient selectedPatient = getPatient(id);
        Doctor selectedDoctor = getDoctor(ID);
        if (selectedDoctor == null || selectedPatient == null) {
            System.out.println("Invalid Doc ID or Patient id");
            return;
        }
        Date appointmentDate = new Date(year, month, day);


        Boolean isAvailable = checkAvailabilaty(selectedDoctor, appointmentDate);
        if (isAvailable) {
            String appTime = getTimeForBooking(selectedDoctor, appointmentDate);
            if (appTime != null) {
                GeneralAppointments appointment = new GeneralAppointments(selectedDoctor, selectedPatient, appointmentDate, "", "");
                selectedDoctor.setAppointment(appointment, appointmentDate);
                System.out.println(selectedDoctor.getAllAppointment().toString());

            } else {
                System.out.println("All the slots are filled");
            }
              scanner = new Scanner(System.in);
            System.out.print("Press G for General R for Referral");
            String appointmentType = scanner.nextLine();

            if (Objects.equals(appointmentType, "G")) {
                GeneralAppointments appointment = new GeneralAppointments(selectedDoctor, selectedPatient, appointmentDate, "", "");
                selectedDoctor.setAppointments((Appointment) appointment, appointmentDate);


            } else if (Objects.equals(appointmentType, "R")) {

                System.out.print("Enter Referral Doctors ID: ");
                int refferalDoctorById = scanner.nextInt();
                System.out.println("Enter Referral Doctors notes: ");
                String refferalDoctorNotes = scanner.next();

                Doctor refferalDoctor = getDoctor(refferalDoctorById);
                if (refferalDoctor != null) {
                    RefferalAppointments appointments = new RefferalAppointments(selectedDoctor, refferalDoctor, selectedPatient, appointmentDate, "", "");
                    appointments.setRefferalDoctorNotes(refferalDoctorNotes);
                    ;

                    selectedDoctor.setAppointment(appointments, appointmentDate);

                }


            } else {
                System.out.println("Invalid ID! No doctor found.");
                return;
            }
            System.out.println();


        } else {
            System.out.println("Doctor is not available on the selected Date");

        }
    }


    private static String getTimeForBooking(Doctor selectedDoctor, Date dateOfBooking) {
        for (Map.Entry<Date, ArrayList<Appointment>> appointment : selectedDoctor.getAllAppointment().entrySet()) {
            if (appointment.getKey().equals(dateOfBooking)) {
                int numbersOfSlots = appointment.getValue().size();
                if (numbersOfSlots > NUMBER_OF_SLOTS - 1) {
                    return null;
                }
                System.out.println("We can make a booking");
                int time = 17 + appointment.getValue().size();
                return time + " :00";
            }
        }
        return "17:00";
    }

    public static Boolean checkAvailabilaty(Doctor selectedDoctor, Date dateOfBooking) {
        for (Date day : selectedDoctor.getAvailability()) {
            if (day.equals(dateOfBooking)) {
                return true;
            }
        }
        return false;
    }


    public static Patient getPatient(String id) {
        for (Patient patient : allPatient) {
            if (patient.getPatientId().equals(id)) {
                return patient;
            }
        }
        return null;
    }

    public static Doctor getDoctor(int ID) {
        for (Doctor doctor : allDoctors) {
            if (doctor.getDoctorId() == ID) {
                return doctor;

            }
        }
        System.out.println("NO Doctor Found");
        return null;
    }

    public static void ViewSelectedDoctorsBookings() {
         Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Doctors ID you want to view appointment: ");
        int DoctorId = scanner.nextInt();
        //scanner.nextLine();

        Doctor selectedDoc = getDoctor(DoctorId);
        if (selectedDoc != null) {
            int i = 1;
            for (Map.Entry<Date, ArrayList<Appointment>> date : selectedDoc.getAllAppointment().entrySet()) {
                System.out.println(i + ". Appointments on " + date.getKey() + ": ");
                for (Appointment appointments : date.getValue()) {
                    System.out.printf("""
                                    - Patient ID:
                                    - Patient Name:
                                    - Appointment Time:
                                                                 
                                    """
                            , appointments.getPatient().getPatientId() , appointments.getPatient().getName() , appointments.getTime());

                }
                i++;

            }
            return;
        }
        System.out.println("Invalid Doctor ID! Doctor does not exist.");


    }
}
