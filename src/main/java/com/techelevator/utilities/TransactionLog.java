package com.techelevator.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TransactionLog {

    private File logFile;

    private static final String DEFAULT_LOG_FILE_NAME = "VendingMachineTransactionLog.log";

    // no parameter constructor
    public TransactionLog() {
        logFile = new File(DEFAULT_LOG_FILE_NAME);
    }

    // methods (verbs of the class)
    public void write(String event) {

        // write to logFile and append so as to not overwrite previous entries
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {

            // writer writes the entry then starts a new line
            writer.write(event + "\n");

        } catch (Exception ex) {
            // ALLIGATOR
            System.out.println(ex.getMessage());
        }
    }
}
