import java.io.*;

public class FileIOExample {
    public static void main(String[] args) {
        try {
            // --- Step 1: Create a new file ---
            // Create a File object representing "example.txt"
            File file = new File("example.txt");

            // Try to create the actual file on disk
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            // --- Step 2: Read from the console using InputStreamReader and BufferedReader ---
            // InputStreamReader converts bytes from System.in to characters
            InputStreamReader isr = new InputStreamReader(System.in);

            // BufferedReader allows us to read an entire line using readLine()
            BufferedReader consoleReader = new BufferedReader(isr);

            // Prompt the user for input
            System.out.print("Enter a line to write to file: ");
            String userInput = consoleReader.readLine(); // Waits for the user to hit Enter

            // --- Step 3: Write to file using FileWriter (overwrite mode) ---
            // FileWriter writes characters directly to the file (overwrites content)
            FileWriter fw = new FileWriter(file); // Not in append mode
            fw.write("FileWriter: " + userInput + "\n"); // Write user input
            fw.close(); // Close to flush data and release resources

            // --- Step 4: Write using BufferedWriter wrapped over FileWriter (append mode) ---
            // BufferedWriter provides buffering and extra features like newLine()
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); // Append = true
            bw.write("BufferedWriter: " + userInput + "\n"); // Append user input
            bw.close(); // Always close your writers!

            // --- Step 5: Write using PrintWriter wrapped around BufferedWriter and FileWriter ---
            // PrintWriter provides print(), println(), printf() just like System.out
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true))); // Append = true
            pw.println("PrintWriter: " + userInput); // Automatically adds a newline
            pw.close(); // Close to flush everything

            // --- Step 6: Write using OutputStreamWriter (lower-level) ---
            // OutputStreamWriter converts characters to bytes and writes to OutputStream
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file, true)); // Append mode
            osw.write("OutputStreamWriter: " + userInput + "\n"); // Manually add newline
            osw.close(); // Flush and close

            // --- Step 7: Read contents of the file using FileReader ---
            // FileReader reads one character at a time from the file
            System.out.println("\n--- Contents of file (FileReader) ---");
            FileReader fr = new FileReader(file);
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch); // Cast int to char to print
            }
            fr.close(); // Close reader

            // --- Step 8: Delete the file and print its name ---
            System.out.println("\n\nAttempting to delete the file...");
            String fileName = file.getName(); // Save name before deletion
            if (file.delete()) {
                System.out.println("Deleted file: " + fileName);
            } else {
                System.out.println("Failed to delete file: " + fileName);
            }

        } catch (IOException e) {
            // Handle any input/output exceptions that may occur
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
