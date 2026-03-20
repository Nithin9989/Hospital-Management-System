package Projectsclass;
import java.util.Arrays;

public class Patient extends Person {
	
	    private String bloodGroup;
	    private MedicalRecord[] treatmentHistory;
	    private int recordCount;
	    private static final int MAX_RECORDS = 50;

	    public Patient(int id, String name, int age, String phone, String bloodGroup) {
	        super(id, name, age, phone);
	        this.bloodGroup      = bloodGroup;
	        this.treatmentHistory = new MedicalRecord[MAX_RECORDS];
	        this.recordCount     = 0;
	    }

	    @Override
	    public String getRole() { return "Patient"; }

	    @Override
	    public void displayInfo() {
	        System.out.println("-----------------------------");
	        System.out.println("  Patient ID  : " + id);
	        System.out.println("  Name        : " + name);
	        System.out.println("  Age         : " + age);
	        System.out.println("  Phone       : " + phone);
	        System.out.println("  Blood Group : " + bloodGroup);
	        System.out.println("  Records     : " + recordCount);
	        System.out.println("-----------------------------");
	    }

	    public void addMedicalRecord(MedicalRecord record) throws InvalidMedicalRecordException {
	        if (recordCount >= MAX_RECORDS) {
	            throw new InvalidMedicalRecordException("Cannot add more records. Maximum limit reached.");
	        }
	        // Check for duplicate record ID
	        for (int i = 0; i < recordCount; i++) {
	            if (treatmentHistory[i].getRecordId() == record.getRecordId()) {
	                throw new InvalidMedicalRecordException(
	                    "Record with ID " + record.getRecordId() + " already exists.");
	            }
	        }
	        treatmentHistory[recordCount++] = record;
	        System.out.println("  Medical record added for patient: " + name);
	    }

	    public void displayTreatmentHistory() {
	        System.out.println("Treatment History for " + name + " (ID: " + id + "):");
	        if (recordCount == 0) {
	            System.out.println("  No records found.");
	            return;
	        }
	        for (int i = 0; i < recordCount; i++) {
	            System.out.println(treatmentHistory[i]);
	        }
	    }

	    // Getters
	    public MedicalRecord[] getTreatmentHistory() { return Arrays.copyOf(treatmentHistory, recordCount); }
	    public String getBloodGroup()                { return bloodGroup; }
	}

