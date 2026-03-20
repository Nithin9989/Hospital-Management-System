package Projectsclass;

public class Doctor extends Person {
	
	    private String   specialization;
	    private String[] schedule;         // Array of time slot labels
	    private boolean[] slotAvailable;   // Parallel availability array
	    private static final int MAX_SLOTS = 10;
	    private int slotCount;

	    public Doctor(int id, String name, int age, String phone, String specialization) {
	        super(id, name, age, phone);
	        this.specialization = specialization;
	        this.schedule       = new String[MAX_SLOTS];
	        this.slotAvailable  = new boolean[MAX_SLOTS];
	        this.slotCount      = 0;
	    }

	    @Override
	    public String getRole() { return "Doctor"; }

	    @Override
	    public void displayInfo() {
	        System.out.println("-----------------------------");
	        System.out.println("  Doctor ID       : " + id);
	        System.out.println("  Name            : Dr. " + name);
	        System.out.println("  Age             : " + age);
	        System.out.println("  Phone           : " + phone);
	        System.out.println("  Specialization  : " + specialization);
	        System.out.println("  Available Slots : " + getAvailableSlotCount());
	        System.out.println("-----------------------------");
	    }

	    public void addScheduleSlot(String timeSlot) {
	        if (slotCount < MAX_SLOTS) {
	            schedule[slotCount]      = timeSlot;
	            slotAvailable[slotCount] = true;
	            slotCount++;
	        } else {
	            System.out.println("Schedule full for Dr. " + name);
	        }
	    }

	    // Books the first available slot and returns its label
	    public String bookSlot() throws DoctorNotAvailableException {
	        for (int i = 0; i < slotCount; i++) {
	            if (slotAvailable[i]) {
	                slotAvailable[i] = false;
	                return schedule[i];
	            }
	        }
	        throw new DoctorNotAvailableException(
	            "Dr. " + name + " (" + specialization + ") has no available slots.");
	    }

	    // Frees a previously booked slot
	    public void freeSlot(String timeSlot) {
	        for (int i = 0; i < slotCount; i++) {
	            if (schedule[i].equals(timeSlot)) {
	                slotAvailable[i] = true;
	                System.out.println("  Slot '" + timeSlot + "' is now free for Dr. " + name);
	                return;
	            }
	        }
	    }

	    public int getAvailableSlotCount() {
	        int count = 0;
	        for (int i = 0; i < slotCount; i++) {
	            if (slotAvailable[i]) count++;
	        }
	        return count;
	    }

	    public void displaySchedule() {
	        System.out.println("Schedule for Dr. " + name + ":");
	        if (slotCount == 0) { System.out.println("  No slots added."); return; }
	        for (int i = 0; i < slotCount; i++) {
	            System.out.println("  " + schedule[i] + "  ->  " + (slotAvailable[i] ? "Available" : "Booked"));
	        }
	    }

	    // Getter
	    public String getSpecialization() { return specialization; }
	
}
