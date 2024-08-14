public class Patient extends Person{

    private final String patientId;


    public Patient(String name, String contactNumber, String patientId){
        super(name,contactNumber);
        this.patientId = patientId;

    }
    public String getPatientId(){
        return this.patientId;
    }
    public char getPatientType(){
        return this.patientId.charAt(0);
    }

}
