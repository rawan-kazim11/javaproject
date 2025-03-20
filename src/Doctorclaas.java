
import java.io.*;
import java.util.Scanner;

public class Doctorclaas {

    private String Firstname;
    private String Lastname;
    private int DID;
    private int Age;
    private String Martial;
    private String Blood;
    private String Gender;
    private int Salary;
    private String Email;
    private String Phone;
    private String Address;
    private String Specialization;
    private int Day;
    private int Month;
    private int Year;
    private static String DoctorFileLocation = "data\\DoctorFile.txt";

    public int getDay() {
        return Day;
    }

    public void setDay(int Day) {
        if (Day >= 1 && Day <= 31) {
            this.Day = Day;
        } else {
            Day = 1;
        }
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int Month) {
        if (Month >= 1 && Month <= 12) {
            this.Month = Month;
        } else {
            Month = 1;
        }
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        if (Year > 0) {
            this.Year = Year;
        } else {
            Year = 2021;
        }
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public int getDID() {
        return DID;
    }

    public void setDID(int DID) {
        this.DID = DID;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getMartial() {
        return Martial;
    }

    public void setMartial(String Martial) {
        this.Martial = Martial;
    }

    public String getBlood() {
        return Blood;
    }

    public void setBlood(String Blood) {
        this.Blood = Blood;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public boolean AddObjectToFile() {
        boolean state = true;
        try {
            FileOutputStream stdFile = new FileOutputStream(DoctorFileLocation, true);
            PrintWriter pW = new PrintWriter(stdFile);
            pW.println(this.getDID() + "\t" + this.getFirstname() + "\t" + this.getLastname() + "\t" + this.getAge() + "\t" + this.getMartial() + "\t" + this.getMonth() + "\t" + this.getDay() + "\t" + this.getYear() + "\t" + this.getBlood() + "\t" + this.getGender() + "\t" + this.getSpecialization() + "\t" + this.getSalary() + "\t" + this.getPhone() + "\t" + this.getEmail() + "\t" + this.getAddress());
            pW.close();
        } catch (Exception Exp) {
            System.out.println("file operation Error!");
            state = false;
        }

        return state;
    }

    public static boolean DoctorExist(int search) {
        boolean state = false;
        File thisStdFile = new File(DoctorFileLocation);
        try {
            Scanner input = new Scanner(thisStdFile);
            int DoctorID = input.nextInt();
            while (DoctorID != -1) {
                String firstname = input.next();
                String lastname = input.next();

                int age = input.nextInt();
                String martial = input.next();
                int month = input.nextInt();
                int day = input.nextInt();

                int year = input.nextInt();
                String blood = input.next();
                String gender = input.next();
                String specialization = input.next();
                int salary = input.nextInt();
                String phone = input.next();
                String email = input.next();

                String address = input.next();
                if (DoctorID == search) {
                    state = true;
                    break;
                }
                DoctorID = input.nextInt();
            }
            input.close();
        } catch (Exception exp) {
            System.out.println("Error in Writing into File");
        }

        return state;
    }
//////

    public static String getInfoDelete(int search) {
        int DoctorID;
        String firstname;
        String lastname;
        int age;
        String martial;
        int month;
        int day;

        int year;
        String blood;
        String gender;
        String specialization;
        int salary;

        String phone;
        String email;
        String address;
        String info = "";

        File thisStdFile = new File(DoctorFileLocation);

        try {
            Scanner input = new Scanner(thisStdFile);
            DoctorID = input.nextInt();
            while (DoctorID != -1) {
                firstname = input.next();
                lastname = input.next();
                age = input.nextInt();
                martial = input.next();
                month = input.nextInt();
                day = input.nextInt();
                year = input.nextInt();
                blood = input.next();
                gender = input.next();
                specialization = input.next();
                salary = input.nextInt();
                phone = input.next();
                email = input.next();
                address = input.next();

                if (DoctorID == search) {
                    info = DoctorID + "\t" + firstname + "\t" + lastname + "\t" + age + "\t" + martial + "\t" + month + "\t" + day + "\t" + year + "\t" + blood + "\t" + gender + "\t" + specialization + "\t" + salary + "\t" + phone + "\t" + email + "\t" + address;
                    break;
                }
                DoctorID = input.nextInt();
            }
            input.close();
        } catch (Exception exp) {
            System.out.println("Error in Writing into File");
        }

        return info;
    }

    public static void removeLineFromFile(String lineToRemove) {
        try {
            File inFile = new File(DoctorFileLocation);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(DoctorFileLocation));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {

                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) {
                System.out.println("Could not rename file");
            }

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public static Doctorclaas getDoctorDataByID(int search) {
        Doctorclaas stdd = new Doctorclaas();
        File thisStdFile = new File(DoctorFileLocation);
        try {
            Scanner input = new Scanner(thisStdFile);
            int DoctorID = input.nextInt();
            while (DoctorID != -1) {

                String firstname = input.next();
                String lastname = input.next();
                int age = input.nextInt();
                String martial = input.next();
                int month = input.nextInt();
                int day = input.nextInt();
                int year = input.nextInt();
                String blood = input.next();
                String gender = input.next();
                String specialization = input.next();
                int salary = input.nextInt();
                String phone = input.next();

                String email = input.next();
                String address = input.next();

                if (DoctorID == search) {
                    stdd.setDID(DoctorID);
                    stdd.setFirstname(firstname);
                    stdd.setLastname(lastname);
                    stdd.setAge(age);
                    stdd.setMartial(martial);
                    stdd.setMonth(month);
                    stdd.setDay(day);
                    stdd.setYear(year);
                    stdd.setBlood(blood);
                    stdd.setGender(gender);
                    stdd.setSpecialization(specialization);
                    stdd.setSalary(salary);
                    stdd.setPhone(phone);
                    stdd.setEmail(email);

                    stdd.setAddress(address);

                    break;
                }
                DoctorID = input.nextInt();
            }
            input.close();
        } catch (Exception exp) {
            System.out.println("Error in Writing into File");
        }

        return stdd;
    }
}
