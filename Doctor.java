import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class  Doctor extends Person {
    private final int DoctorId;
    private String birthday;

    private String specialization;

    private HashMap<Date,ArrayList<Appointment>> allAppointment = new HashMap<>();


private ArrayList<Date>availability;
    public Doctor(int DoctorId , String name , String birthday, String specialization,String contactNumber){
        super(name,contactNumber);
        this.DoctorId = DoctorId;
        this.birthday = birthday;
        this.specialization = specialization;
        availability= new ArrayList<>();

    }

    public boolean isPhysician(){
        return this.specialization.endsWith("Physician");
    }

    public  void setAvailability(Date availabilityDate){
       this.availability.add(availabilityDate);
    }

    public void setAppointment(Appointment appointment,Date date){
        ArrayList<Appointment>currentAppointments = this.allAppointment.get(date);
        if (currentAppointments==null){
            ArrayList<Appointment>tempAppointment = new ArrayList<>();
            tempAppointment.add(appointment);
            this.allAppointment.put(date,tempAppointment);
        }
        else {
            currentAppointments.add(appointment);
            this.allAppointment.put(date,currentAppointments);
        }





    }
    public ArrayList<Date>getAvailability(){
        return availability;

    }
    public HashMap<Date,ArrayList<Appointment>>getAllAppointment(){
        return allAppointment;
    }
    public int getDoctorId(){
        return DoctorId;
    }
    public String getBirthday(){
        return birthday;

    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public String getSpecialization(){
        return specialization;
    }
public void setSpecialization(String specialization){
        this.specialization = specialization;
}

    public void setDoctorAvailability(Date availability) {
        this.availability.add(availability);
    }

    public ArrayList<Date> getAvailabilities(){
        return this.availability;
    }

    public int getTimeForBooking(Date date){
        ArrayList<Appointment> existingAppointments = this.allAppointment.get(date);
        int NUMBER_OF_SLOTS = 5;
        if (existingAppointments == null){
            return NUMBER_OF_SLOTS;
        } else if (existingAppointments.size() == 5) {
            return -1;
        }
        return NUMBER_OF_SLOTS + existingAppointments.size();
    }



    public void setAppointments(Appointment appointment, Date date){
        ArrayList<Appointment> currentAppointments = this.allAppointment.get(date);
        if (currentAppointments == null){
            ArrayList<Appointment> tempArraylist = new ArrayList<>();
            tempArraylist.add(appointment);
            this.allAppointment.put(date, tempArraylist);
        } else {
            currentAppointments.add(appointment);
            this.allAppointment.put(date, currentAppointments);
        }
        System.out.println("Appointment added successfully.\n");
    }


}
