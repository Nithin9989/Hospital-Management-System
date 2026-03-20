package Projectsclass;

public class Main {

	    public static void main(String[] args) {

	        HospitalManagementSystem hms = new HospitalManagementSystem();

	        System.out.println("============================================");
	        System.out.println("       HOSPITAL MANAGEMENT SYSTEM          ");
	        System.out.println("============================================\n");

	        // ----------------------------------------------------------------
	        // 1. ADD DOCTORS
	        // ----------------------------------------------------------------
	        System.out.println("--- Registering Doctors ---");

	        Doctor doc1 = new Doctor(101, "Anjali Sharma", 45, "9876543210", "Cardiologist");
	        Doctor doc2 = new Doctor(102, "Ravi Kumar",    38, "9876543211", "Orthopedic");
	        Doctor doc3 = new Doctor(103, "Priya Nair",    50, "9876543212", "Neurologist");

	        doc1.addScheduleSlot("Mon 10:00 AM");
	        doc1.addScheduleSlot("Mon 11:00 AM");
	        doc1.addScheduleSlot("Tue 02:00 PM");

	        doc2.addScheduleSlot("Wed 09:00 AM");
	        doc2.addScheduleSlot("Wed 10:00 AM");

	        doc3.addScheduleSlot("Thu 03:00 PM");   // Only ONE slot

	        hms.addDoctor(doc1);
	        hms.addDoctor(doc2);
	        hms.addDoctor(doc3);

	        // ----------------------------------------------------------------
	        // 2. REGISTER PATIENTS
	        // ----------------------------------------------------------------
	        System.out.println("\n--- Registering Patients ---");
	        try {
	            hms.registerPatient(new Patient(1, "Rahul Verma",  30, "9000001111", "O+"));
	            hms.registerPatient(new Patient(2, "Sneha Reddy",  25, "9000002222", "A+"));
	            hms.registerPatient(new Patient(3, "Kiran Patel",  45, "9000003333", "B-"));

	            // --- Test: DuplicatePatientException ---
	            System.out.println("\n--- [TEST] DuplicatePatientException ---");
	            hms.registerPatient(new Patient(1, "Duplicate User", 22, "0000000000", "AB+"));

	        } catch (DuplicatePatientException e) {
	            System.out.println("  CAUGHT DuplicatePatientException: " + e.getMessage());
	        }

	        // ----------------------------------------------------------------
	        // 3. DISPLAY DOCTOR SCHEDULES
	        // ----------------------------------------------------------------
	        System.out.println("\n--- Initial Doctor Schedules ---");
	        doc1.displaySchedule();
	        doc2.displaySchedule();
	        doc3.displaySchedule();

	        // ----------------------------------------------------------------
	        // 4. SCHEDULE APPOINTMENTS
	        // ----------------------------------------------------------------
	        System.out.println("\n--- Scheduling Appointments ---");
	        try {
	            hms.scheduleAppointment(1, 101);   // Rahul  -> Dr. Anjali (slot 1)
	            hms.scheduleAppointment(2, 101);   // Sneha  -> Dr. Anjali (slot 2)
	            hms.scheduleAppointment(3, 102);   // Kiran  -> Dr. Ravi   (slot 1)
	            hms.scheduleAppointment(1, 103);   // Rahul  -> Dr. Priya  (only slot)
	        } catch (DoctorNotAvailableException e) {
	            System.out.println("  CAUGHT DoctorNotAvailableException: " + e.getMessage());
	        }

	        // --- Test: DoctorNotAvailableException (Dr. Priya's slot already taken) ---
	        System.out.println("\n--- [TEST] DoctorNotAvailableException ---");
	        try {
	            hms.scheduleAppointment(2, 103);   // No slots left for Dr. Priya
	        } catch (DoctorNotAvailableException e) {
	            System.out.println("  CAUGHT DoctorNotAvailableException: " + e.getMessage());
	        }

	        // ----------------------------------------------------------------
	        // 5. ADD MEDICAL RECORDS
	        // ----------------------------------------------------------------
	        System.out.println("\n--- Adding Medical Records ---");
	        Patient rahul = hms.findPatientById(1);
	        Patient sneha = hms.findPatientById(2);

	        try {
	            rahul.addMedicalRecord(new MedicalRecord(
	                1001, "Hypertension", "Medication + Diet Control", "Amlodipine 5mg", "2024-01-15"));
	            rahul.addMedicalRecord(new MedicalRecord(
	                1002, "Chest Pain",   "ECG + Rest",                "Nitroglycerin",  "2024-03-10"));
	            sneha.addMedicalRecord(new MedicalRecord(
	                1003, "Seasonal Allergy", "Antihistamines",        "Cetirizine 10mg","2024-05-20"));

	            // --- Test: InvalidMedicalRecordException (empty diagnosis) ---
	            System.out.println("\n--- [TEST] InvalidMedicalRecordException ---");
	            rahul.addMedicalRecord(new MedicalRecord(
	                9999, "", "Some treatment", "None", "2024-06-01"));

	        } catch (InvalidMedicalRecordException e) {
	            System.out.println("  CAUGHT InvalidMedicalRecordException: " + e.getMessage());
	        }

	        // ----------------------------------------------------------------
	        // 6. DISPLAY ALL RECORDS
	        // ----------------------------------------------------------------
	        hms.displayAllDoctors();
	        hms.displayAllPatients();
	        hms.displayAllAppointments();

	        // ----------------------------------------------------------------
	        // 7. TREATMENT HISTORY
	        // ----------------------------------------------------------------
	        System.out.println("\n--- Treatment History ---");
	        rahul.displayTreatmentHistory();
	        sneha.displayTreatmentHistory();

	        // ----------------------------------------------------------------
	        // 8. COMPLETE & CANCEL APPOINTMENTS
	        // ----------------------------------------------------------------
	        System.out.println("\n--- Updating Appointment Statuses ---");
	        Appointment a1 = hms.findAppointmentById(1);
	        Appointment a2 = hms.findAppointmentById(2);
	        if (a1 != null) a1.completeAppointment();
	        if (a2 != null) a2.cancelAppointment();

	        // ----------------------------------------------------------------
	        // 9. UPDATED SCHEDULE
	        // ----------------------------------------------------------------
	        System.out.println("\n--- Updated Schedule for Dr. Anjali ---");
	        doc1.displaySchedule();

	        System.out.println("\n============================================");
	        System.out.println("           SIMULATION COMPLETE             ");
	        System.out.println("============================================");
	    }
	
}
