//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.EOFException;

 class Lab11Prob01 {

    public static void main(String[] args) {
        // Input and Output file paths
        String inputFile = "person.dat";
        String outputFile = "people-copy.dat";

        try {
            // Initialize input stream to read binary data
            FileInputStream fileInput = new FileInputStream(inputFile);
            DataInputStream dataInput = new DataInputStream(fileInput);

            // Initialize output stream to write binary data
            FileOutputStream fileOutput = new FileOutputStream(outputFile);
            DataOutputStream dataOutput = new DataOutputStream(fileOutput);

            // Read the data from the binary file and print to console
            while (true) {
                try {
                    int age = dataInput.readInt();  // Read age (int)
                    String firstName = dataInput.readUTF();  // Read first name (UTF-8 string)
                    String lastName = dataInput.readUTF();   // Read last name (UTF-8 string)
                    String address = dataInput.readUTF();   // Read address (UTF-8 string)
                    int zipCode = dataInput.readInt();  // Read zip code (int)
                    double salary = dataInput.readDouble(); // Read salary (double)

                    // Print data to the console
                    System.out.println("Age: " + age);
                    System.out.println("Name: " + firstName + " " + lastName);
                    System.out.println("Address: " + address);
                    System.out.println("Zip Code: " + zipCode);
                    System.out.println("Salary: " + salary);
                    System.out.println("----------------------------------");

                    // Write the same data to the new binary file
                    dataOutput.writeInt(age);
                    dataOutput.writeUTF(firstName);
                    dataOutput.writeUTF(lastName);
                    dataOutput.writeUTF(address);
                    dataOutput.writeInt(zipCode);
                    dataOutput.writeDouble(salary);

                } catch (EOFException e) {
                    // End of file reached, break out of the loop
                    break;
                }
            }

            // Close streams
            dataInput.close();
            fileInput.close();
            dataOutput.close();
            fileOutput.close();

            System.out.println("Data copied successfully to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

