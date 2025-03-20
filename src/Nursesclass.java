
import java.io.*;
import java.util.Scanner;

public class Nursesclass {

    private String Firstname;
    private String Lastname;
    private int NID;
    private int Age;
    private String Martial;

    private String Blood;
    private String Gender;
    private int Salary;
    private String Email;
    private String Phone;
    private String Address;
    private int Day;
    private int Month;
    private int Year;
    private static String NursesFileLocation = "data\\DoctorFile.txt";

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
        }

    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        if (Year > 0) {
            this.Year = Year;
        }

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

    public int getNID() {
        return NID;
    }

    public void setNID(int NID) {
        this.NID = NID;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        if (Age >= 1) {
            this.Age = Age;
        }

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
            FileOutputStream stdFile = new FileOutputStream(NursesFileLocation, true);
            PrintWriter pW = new PrintWriter(stdFile);
            pW.println(this.getNID() + "\t" + this.getFirstname() + "\t" + this.getLastname() + "\t" + this.getAge() + "\t" + this.getMartial() + "\t" + this.getMonth() + "\t" + this.getDay() + "\t" + this.getYear() + "\t" + this.getBlood() + "\t" + this.getGender() + "\t" + this.getSalary() + "\t" + this.getEmail() + "\t" + this.getPhone() + "\t" + this.getAddress());
            pW.close();
        } catch (Exception Exp) {
            System.out.println("file operation Error!");
            Exp.printStackTrace();
            state = false;
        }

        return state;
    }

    public static boolean NursesExist(int search) {
        boolean state = false;
        File thisStdFile = new File(NursesFileLocation);
        try {
            Scanner input = new Scanner(thisStdFile);
            int NursesID = input.nextInt();
            while (NursesID != -1) {
                String firstname = input.next();
                String lastname = input.next();

                int age = input.nextInt();
                String martial = input.next();
                int day = input.nextInt();
                int month = input.nextInt();
                int year = input.nextInt();
                String blood = input.next();
                String gender = input.next();
                int salary = input.nextInt();
                String email = input.next();
                String phone = input.next();
                String address = input.next();
                if (NursesID == search) {
                    state = true;
                    break;
                }
                NursesID = input.nextInt();
            }
            input.close();
        } catch (Exception exp) {
            System.out.println("Error in Writing into File");
            exp.printStackTrace();
        }

        return state;
    }
//////
////

    public static String getInfoDelete(int search) {
        int NursesID;
        String firstname;
        String lastname;

        int age;
        String martial;
        int day;
        int month;
        int year;
        String blood;
        String gender;
        int salary;
        String email;
        String phone;
        String address;
        String info = "";

        File thisStdFile = new File(NursesFileLocation);

        try {
            Scanner input = new Scanner(thisStdFile);
            NursesID = input.nextInt();
            while (NursesID != -1) {
                firstname = input.next();
                lastname = input.next();

                age = input.nextInt();
                martial = input.next();
                month = input.nextInt();
                day = input.nextInt();

                year = input.nextInt();
                blood = input.next();
                gender = input.next();
                salary = input.nextInt();
                email = input.next();
                phone = input.next();
                address = input.next();

                if (NursesID == search) {
                    info = NursesID + "\t" + firstname + "\t" + lastname + "\t" + age + "\t" + martial + "\t" + month + "\t" + day + "\t" + year + "\t" + blood + "\t" + gender + "\t" + salary + "\t" + email + "\t" + phone + "\t" + address;
                    break;
                }
                NursesID = input.nextInt();
            }
            input.close();
        } catch (Exception exp) {
            System.out.println("Error in Writing into File");
            exp.printStackTrace();
        }

        return info;
    }

    public static void removeLineFromFile(String lineToRemove) {
        try {
            File inFile = new File(NursesFileLocation);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(NursesFileLocation));
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
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Nursesclass getNursesDataByID(int search) {
        Nursesclass stdn = new Nursesclass();
        File thisStdFile = new File(NursesFileLocation);
        try {
            Scanner input = new Scanner(thisStdFile);
            int NursesID = input.nextInt();
            while (NursesID != -1) {
                String firstname = input.next();
                String lastname = input.next();

                int age = input.nextInt();
                String martial = input.next();
                int month = input.nextInt();
                int day = input.nextInt();

                int year = input.nextInt();
                String blood = input.next();
                String gender = input.next();
                int salary = input.nextInt();
                String email = input.next();
                String phone = input.next();
                String address = input.next();

                if (NursesID == search) {
                    stdn.setNID(NursesID);
                    stdn.setFirstname(firstname);
                    stdn.setLastname(lastname);
                    stdn.setAge(age);
                    stdn.setMartial(martial);
                    stdn.setMonth(month);
                    stdn.setDay(day);

                    stdn.setYear(year);
                    stdn.setBlood(blood);
                    stdn.setGender(gender);
                    stdn.setSalary(salary);
                    stdn.setEmail(email);
                    stdn.setPhone(phone);
                    stdn.setAddress(address);

                    break;
                }
                NursesID = input.nextInt();
            }
            input.close();
        } catch (Exception exp) {
            System.out.println("Error in Writing into File");
            exp.printStackTrace();
        }

        return stdn;
    }

}
