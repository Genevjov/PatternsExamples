package com.genevjov.fun.command.impl;

import com.genevjov.fun.clipboard.IClipboard;
import com.genevjov.fun.command.AbstractCommand;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand extends AbstractCommand {

    // Lol hardcode. It made for run this app from box.
    private static final String DEFAULT_PATH_TO_SAVE_FILE = "D:/savedDoc.txt";

    @Override
    public void executeCommand(IClipboard clipboard, JTextArea container) {
        File fileToSave = new File(DEFAULT_PATH_TO_SAVE_FILE);
        try (FileWriter fileWriter = new FileWriter(fileToSave)) {
            fileWriter.write(container.getText());
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println("SOMETHING WENT WRONG: ".concat(e.getMessage()));
        }
    }
}