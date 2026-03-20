package Projectsclass;

public class Appointment {
	
	    private int     appointmentId;
	    private Patient patient;
	    private Doctor  doctor;
	    private String  timeSlot;
	    private String  status;   // "Scheduled" | "Completed" | "Cancelled"

	    public Appointment(int appointmentId, Patient patient, Doctor doctor)
	            throws DoctorNotAvailableException {
	        this.appointmentId = appointmentId;
	        this.patient       = patient;
	        this.doctor        = doctor;
	        this.timeSlot      = doctor.bookSlot();   // throws if no slot available
	        this.status        = "Scheduled";

	        System.out.println("  Appointment #" + appointmentId + " SCHEDULED -> "
	            + patient.getName() + " with Dr. " + doctor.getName()
	            + " at [" + timeSlot + "]");
	    }

	    public void completeAppointment() {
	        this.status = "Completed";
	        doctor.freeSlot(timeSlot);
	        System.out.println("  Appointment #" + appointmentId + " marked as COMPLETED.");
	    }

	    public void cancelAppointment() {
	        this.status = "Cancelled";
	        doctor.freeSlot(timeSlot);
	        System.out.println("  Appointment #" + appointmentId + " CANCELLED.");
	    }

	    public void displayAppointment() {
	        System.out.println("-----------------------------");
	        System.out.println("  Appointment ID : " + appointmentId);
	        System.out.println("  Patient        : " + patient.getName() + " (ID: " + patient.getId() + ")");
	        System.out.println("  Doctor         : Dr. " + doctor.getName() + " | " + doctor.getSpecialization());
	        System.out.println("  Time Slot      : " + timeSlot);
	        System.out.println("  Status         : " + status);
	        System.out.println("-----------------------------");
	    }

	    // Getters
	    public int     getAppointmentId() { return appointmentId; }
	    public Patient getPatient()       { return patient; }
	    public Doctor  getDoctor()        { return doctor; }
	    public String  getStatus()        { return status; }
	    public String  getTimeSlot()      { return timeSlot; }
	
}
