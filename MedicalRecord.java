package Projectsclass;

public class MedicalRecord {
	
	    private int recordId;
	    private String diagnosis;
	    private String treatment;
	    private String prescription;
	    private String date;

	    public MedicalRecord(int recordId, String diagnosis, String treatment,
	                         String prescription, String date)
	            throws InvalidMedicalRecordException {

	        if (diagnosis == null || diagnosis.trim().isEmpty()) {
	            throw new InvalidMedicalRecordException("Diagnosis cannot be empty.");
	        }
	        if (date == null || date.trim().isEmpty()) {
	            throw new InvalidMedicalRecordException("Date cannot be empty.");
	        }

	        this.recordId    = recordId;
	        this.diagnosis   = diagnosis;
	        this.treatment   = treatment;
	        this.prescription = prescription;
	        this.date        = date;
	    }

	    // Getters
	    public int    getRecordId()     { return recordId; }
	    public String getDiagnosis()    { return diagnosis; }
	    public String getTreatment()    { return treatment; }
	    public String getPrescription() { return prescription; }
	    public String getDate()         { return date; }

	    @Override
	    public String toString() {
	        return String.format(
	            "  [Record #%d | Date: %s]\n    Diagnosis   : %s\n    Treatment   : %s\n    Prescription: %s",
	            recordId, date, diagnosis, treatment, prescription
	        );
	    }

}
