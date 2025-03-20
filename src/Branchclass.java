
import java.io.*;
import java.util.Scanner;

public class Branchclass {

    private int BranchNo;
    private String Address;
    private String Country;
    private String PhoneNo;
    private String Email;
    private static String BranchFileLocation = "data\\DoctorFile.txt";

    public int getBranchNo() {
        return BranchNo;
    }

    public void setBranchNo(int branchNo) {
        BranchNo = branchNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public boolean AddObjectToFile() {
        boolean state = true;
        try {
            FileOutputStream thisStdBFile = new FileOutputStream(BranchFileLocation, true);
            PrintWriter pW = new PrintWriter(thisStdBFile);
            pW.println(this.getBranchNo() + "\t" + this.getAddress() + "\t" + this.getCountry() + "\t" + this.getPhoneNo() + "\t" + this.getEmail());
            pW.close();
        } catch (Exception Exp) {
            System.out.println("file operation Error!");
            state = false;
        }

        return state;
    }

    public static boolean branchExist(int search) {
        boolean state = false;
        File thisStdBFile = new File(BranchFileLocation);
        try {
            Scanner input = new Scanner(thisStdBFile);
            int branchNo = input.nextInt();
            while (branchNo != -1) {

                String address = input.next();
                String country = input.next();
                String phoneNo = input.next();
                String email = input.next();

                if (branchNo == search) {
                    state = true;
                    break;
                }
                branchNo = input.nextInt();
            }
            input.close();
        } catch (Exception exp) {
            System.out.println("Error in Writing into File");
        }

        return state;
    }

    //////
////
    public static String getInfoDelete(int search) {
        int branchNo;
        String address;
        String country;
        String phoneNo;

        String email;
        String info = "";

        File thisStdBFile = new File(BranchFileLocation);

        try {
            Scanner input = new Scanner(thisStdBFile);
            branchNo = input.nextInt();
            while (branchNo != -1) {
                address = input.next();
                country = input.next();
                phoneNo = input.next();

                email = input.next();
                if (branchNo == search) {
                    info = branchNo + "\t" + address + "\t" + country + "\t" + phoneNo + "\t" + email;
                    break;
                }
                branchNo = input.nextInt();
            }
            input.close();
        } catch (Exception exp) {
            System.out.println("Error in Writing into File");
        }

        return info;
    }

    public static void removeLineFromFile(String lineToRemove) {
        try {
            File inFile = new File(BranchFileLocation);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(BranchFileLocation));
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

    public static Branchclass getBranchDataByID(int search) {
        Branchclass stdB = new Branchclass();
        File thisStdFile = new File(BranchFileLocation);
        try {
            Scanner input = new Scanner(thisStdFile);
            int branchNo = input.nextInt();
            while (branchNo != -1) {
                String address = input.next();
                String country = input.next();
                String phoneNo = input.next();
                String email = input.next();

                if (branchNo == search) {
                    stdB.setBranchNo(branchNo);
                    stdB.setAddress(address);
                    stdB.setCountry(country);
                    stdB.setPhoneNo(phoneNo);
                    stdB.setEmail(email);

                    break;
                }
                branchNo = input.nextInt();
            }
            input.close();
        } catch (Exception exp) {
            System.out.println("Error in Writing into File");
        }

        return stdB;
    }

}
