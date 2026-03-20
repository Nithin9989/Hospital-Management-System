package Projectsclass;

public class HospitalManagementSystem {
	
	    private Patient[]     patients;
	    private Doctor[]      doctors;
	    private Appointment[] appointments;

	    private int patientCount;
	    private int doctorCount;
	    private int appointmentCount;

	    private static final int MAX_PATIENTS     = 100;
	    private static final int MAX_DOCTORS      = 50;
	    private static final int MAX_APPOINTMENTS = 200;

	    public HospitalManagementSystem() {
	        patients     = new Patient[MAX_PATIENTS];
	        doctors      = new Doctor[MAX_DOCTORS];
	        appointments = new Appointment[MAX_APPOINTMENTS];
	        patientCount     = 0;
	        doctorCount      = 0;
	        appointmentCount = 0;
	    }

	    // ---- Patient Operations ----

	    public void registerPatient(Patient patient) throws DuplicatePatientException {
	        for (int i = 0; i < patientCount; i++) {
	            if (patients[i].getId() == patient.getId()) {
	                throw new DuplicatePatientException(
	                    "Patient with ID " + patient.getId() + " already exists.");
	            }
	        }
	        patients[patientCount++] = patient;
	        System.out.println("  Patient registered: " + patient.getName()
	            + " (ID: " + patient.getId() + ")");
	    }

	    public Patient findPatientById(int id) {
	        for (int i = 0; i < patientCount; i++) {
	            if (patients[i].getId() == id) return patients[i];
	        }
	        return null;
	    }

	    public void displayAllPatients() {
	        System.out.println("\n===== ALL PATIENTS (" + patientCount + ") =====");
	        if (patientCount == 0) { System.out.println("  No patients registered."); return; }
	        for (int i = 0; i < patientCount; i++) patients[i].displayInfo();
	    }

	    // ---- Doctor Operations ----

	    public void addDoctor(Doctor doctor) {
	        doctors[doctorCount++] = doctor;
	        System.out.println("  Doctor added: Dr. " + doctor.getName()
	            + " (" + doctor.getSpecialization() + ")");
	    }

	    public Doctor findDoctorById(int id) {
	        for (int i = 0; i < doctorCount; i++) {
	            if (doctors[i].getId() == id) return doctors[i];
	        }
	        return null;
	    }

	    public void displayAllDoctors() {
	        System.out.println("\n===== ALL DOCTORS (" + doctorCount + ") =====");
	        if (doctorCount == 0) { System.out.println("  No doctors registered."); return; }
	        for (int i = 0; i < doctorCount; i++) doctors[i].displayInfo();
	    }

	    // ---- Appointment Operations ----

	    public Appointment scheduleAppointment(int patientId, int doctorId)
	            throws DoctorNotAvailableException {

	        Patient patient = findPatientById(patientId);
	        Doctor  doctor  = findDoctorById(doctorId);

	        if (patient == null)
	            throw new IllegalArgumentException("Patient ID " + patientId + " not found.");
	        if (doctor == null)
	            throw new IllegalArgumentException("Doctor ID " + doctorId + " not found.");

	        Appointment appt = new Appointment(appointmentCount + 1, patient, doctor);
	        appointments[appointmentCount++] = appt;
	        return appt;
	    }

	    public Appointment findAppointmentById(int id) {
	        for (int i = 0; i < appointmentCount; i++) {
	            if (appointments[i].getAppointmentId() == id) return appointments[i];
	        }
	        return null;
	    }

	    public void displayAllAppointments() {
	        System.out.println("\n===== ALL APPOINTMENTS (" + appointmentCount + ") =====");
	        if (appointmentCount == 0) { System.out.println("  No appointments found."); return; }
	        for (int i = 0; i < appointmentCount; i++) appointments[i].displayAppointment();
	    }
	
}
