package com.techelevator.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TransactionLog {

    private File logFile;

    private static final String DEFAULT_LOG_FILE_NAME = "VendingMachineTransactionLog.log";

    // no parameter constructor
    public TransactionLog() {
        logFile = new File(DEFAULT_LOG_FILE_NAME);
    }

    // methods (verbs of the class)
    public void write(String event, String amountSpent, String getBalance) {

        LocalDateTime timeStamp = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a");
        String formattedTimeStamp = timeStamp.format(formatter);


        String logMessage = String.format("%s, %s, $%s, $%s", formattedTimeStamp, event, amountSpent, getBalance);

        // write to logFile and append so as to not overwrite previous entries
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {

            // writer writes the entry then starts a new line
            writer.write(logMessage + "\n");

        } catch (Exception ex) {
            // ALLIGATOR
            System.out.println(ex.getMessage());
        }
    }
}
