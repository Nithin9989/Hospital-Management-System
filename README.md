🏥 Hospital Management System

A console-based Hospital Management System built in Java, demonstrating core OOP design principles — abstract classes, inheritance, object association, and array-based storage. Implements custom exceptions for real-world edge cases like invalid records, duplicate entries, and doctor unavailability.


📌 Table of Contents

About the Project
Features
OOP Concepts Used
Project Structure
Custom Exceptions
Sample Output



📖 About the Project
This project simulates a real-world Hospital Management System using Core Java. It covers the complete lifecycle of hospital operations — registering patients, managing doctor schedules, booking appointments, and maintaining medical records — all through a clean OOP architecture.
Built as part of learning Object-Oriented Programming in Java, this project applies abstract classes, inheritance, object associations, array-based data structures, and custom exception handling.

✅ Features

👤 Register and manage Patients and Doctors
📅 Book and track Appointments
📋 Store and retrieve Medical Records
🔒 Handle invalid operations with Custom Exceptions
🗂️ Array-based storage for patient records, doctor schedules, and treatment history


🧠 OOP Concepts Used
Concept                    Implementation
Abstract Class          Person — abstract base with common fields and abstract methods
Inheritance             Patient and Doctor extend Person
Association             Doctor and Patient linked through Appointment object
Encapsulation           Private fields with getters/setters in all classes
Arrays                  Patient records, doctor schedules, and treatment history
Exception Handling      Custom checked exceptions for domain-specific errors

🗂️ Project Structure
HospitalManagementSystem/
│
├── src/
│   ├── Person.java
│   ├── Patient.java
│   ├── Doctor.java
│   ├── Appointment.java
│   ├── MedicalRecord.java
│   │
│   ├── exceptions/
│   │   ├── DoctorNotAvailableException.java
│   │   ├── DuplicatePatientException.java
│   │   └── InvalidMedicalRecordException.java
│   │
│   └── Main.java
│
└── README.md

⚠️ Custom Exceptions
Exception                           Triggered When
DoctorNotAvailableException         Booking an appointment with a doctor who has no free slots
DuplicatePatientException           Registering a patient with an already existing 
IDInvalidMedicalRecordException     Adding a record with missing or null required fields



## 🖥️ Sample Output
```
============================================
       HOSPITAL MANAGEMENT SYSTEM          
============================================

--- Registering Doctors ---
  Doctor added: Dr. Anjali Sharma (Cardiologist)
  Doctor added: Dr. Ravi Kumar (Orthopedic)
  Doctor added: Dr. Priya Nair (Neurologist)

--- Registering Patients ---
  Patient registered: Rahul Verma (ID: 1)
  Patient registered: Sneha Reddy (ID: 2)
  Patient registered: Kiran Patel (ID: 3)

--- [TEST] DuplicatePatientException ---
  CAUGHT DuplicatePatientException: Patient with ID 1 already exists.

--- Initial Doctor Schedules ---
Schedule for Dr. Anjali Sharma:
  Mon 10:00 AM  ->  Available
  Mon 11:00 AM  ->  Available
  Tue 02:00 PM  ->  Available
Schedule for Dr. Ravi Kumar:
  Wed 09:00 AM  ->  Available
  Wed 10:00 AM  ->  Available
Schedule for Dr. Priya Nair:
  Thu 03:00 PM  ->  Available

--- Scheduling Appointments ---
  Appointment #1 SCHEDULED -> Rahul Verma with Dr. Anjali Sharma at [Mon 10:00 AM]
  Appointment #2 SCHEDULED -> Sneha Reddy with Dr. Anjali Sharma at [Mon 11:00 AM]
  Appointment #3 SCHEDULED -> Kiran Patel with Dr. Ravi Kumar at [Wed 09:00 AM]
  Appointment #4 SCHEDULED -> Rahul Verma with Dr. Priya Nair at [Thu 03:00 PM]

--- [TEST] DoctorNotAvailableException ---
  CAUGHT DoctorNotAvailableException: Dr. Priya Nair (Neurologist) has no available slots.

--- Adding Medical Records ---
  Medical record added for patient: Rahul Verma
  Medical record added for patient: Rahul Verma
  Medical record added for patient: Sneha Reddy

--- [TEST] InvalidMedicalRecordException ---
  CAUGHT InvalidMedicalRecordException: Diagnosis cannot be empty.

===== ALL DOCTORS (3) =====
-----------------------------
  Doctor ID       : 101
  Name            : Dr. Anjali Sharma
  Age             : 45
  Phone           : 9876543210
  Specialization  : Cardiologist
  Available Slots : 1
-----------------------------
-----------------------------
  Doctor ID       : 102
  Name            : Dr. Ravi Kumar
  Age             : 38
  Phone           : 9876543211
  Specialization  : Orthopedic
  Available Slots : 1
-----------------------------
-----------------------------
  Doctor ID       : 103
  Name            : Dr. Priya Nair
  Age             : 50
  Phone           : 9876543212
  Specialization  : Neurologist
  Available Slots : 0
-----------------------------

===== ALL PATIENTS (3) =====
-----------------------------
  Patient ID  : 1
  Name        : Rahul Verma
  Age         : 30
  Phone       : 9000001111
  Blood Group : O+
  Records     : 2
-----------------------------
-----------------------------
  Patient ID  : 2
  Name        : Sneha Reddy
  Age         : 25
  Phone       : 9000002222
  Blood Group : A+
  Records     : 1
-----------------------------
-----------------------------
  Patient ID  : 3
  Name        : Kiran Patel
  Age         : 45
  Phone       : 9000003333
  Blood Group : B-
  Records     : 0
-----------------------------

===== ALL APPOINTMENTS (4) =====
-----------------------------
  Appointment ID : 1
  Patient        : Rahul Verma (ID: 1)
  Doctor         : Dr. Anjali Sharma | Cardiologist
  Time Slot      : Mon 10:00 AM
  Status         : Scheduled
-----------------------------
-----------------------------
  Appointment ID : 2
  Patient        : Sneha Reddy (ID: 2)
  Doctor         : Dr. Anjali Sharma | Cardiologist
  Time Slot      : Mon 11:00 AM
  Status         : Scheduled
-----------------------------
-----------------------------
  Appointment ID : 3
  Patient        : Kiran Patel (ID: 3)
  Doctor         : Dr. Ravi Kumar | Orthopedic
  Time Slot      : Wed 09:00 AM
  Status         : Scheduled
-----------------------------
-----------------------------
  Appointment ID : 4
  Patient        : Rahul Verma (ID: 1)
  Doctor         : Dr. Priya Nair | Neurologist
  Time Slot      : Thu 03:00 PM
  Status         : Scheduled
-----------------------------

--- Treatment History ---
Treatment History for Rahul Verma (ID: 1):
  [Record #1001 | Date: 2024-01-15]
    Diagnosis   : Hypertension
    Treatment   : Medication + Diet Control
    Prescription: Amlodipine 5mg
  [Record #1002 | Date: 2024-03-10]
    Diagnosis   : Chest Pain
    Treatment   : ECG + Rest
    Prescription: Nitroglycerin
Treatment History for Sneha Reddy (ID: 2):
  [Record #1003 | Date: 2024-05-20]
    Diagnosis   : Seasonal Allergy
    Treatment   : Antihistamines
    Prescription: Cetirizine 10mg

--- Updating Appointment Statuses ---
  Slot 'Mon 10:00 AM' is now free for Dr. Anjali Sharma
  Appointment #1 marked as COMPLETED.
  Slot 'Mon 11:00 AM' is now free for Dr. Anjali Sharma
  Appointment #2 CANCELLED.

--- Updated Schedule for Dr. Anjali ---
Schedule for Dr. Anjali Sharma:
  Mon 10:00 AM  ->  Available
  Mon 11:00 AM  ->  Available
  Tue 02:00 PM  ->  Available

============================================
           SIMULATION COMPLETE             
============================================
