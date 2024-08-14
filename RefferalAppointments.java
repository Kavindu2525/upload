import java.util.Date;

public class RefferalAppointments extends Appointment  {

   private Doctor refferalDoctor;
    private String notes;
    private String refferalDoctorNotes;


    public RefferalAppointments(Doctor doctor, Doctor refferalDoctor, Patient patient,  Date date, String time,String note) {
        super(doctor,patient,date,time);
        this.notes=note;
        this.refferalDoctorNotes="";
        this.refferalDoctor=refferalDoctor;


    }
    public Doctor getRefferalDoctor(){
        return refferalDoctor;
    }

    public void setRefferalDoctor(Doctor refferalDoctor){
        this.refferalDoctor=refferalDoctor;
    }
    public String getNote(){
        return this.notes;
    }
    public void setNote(String note){
        this.notes=note;
    }

    public void setRefferalDoctorNotes(String[] notesArray){
        String Note = "";
        for (String note : notesArray){
            Note = note + " ";
        }
        this.refferalDoctorNotes = Note;
    }

    public String setRefferalDoctorNotes(String refferalDoctorNotes){
        return this.refferalDoctorNotes;
    }


}
