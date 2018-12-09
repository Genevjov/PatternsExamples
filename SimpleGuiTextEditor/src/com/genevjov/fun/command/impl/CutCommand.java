package com.genevjov.fun.command.impl;

import com.genevjov.fun.clipboard.IClipboard;
import com.genevjov.fun.command.AbstractCommand;

import javax.swing.*;

public class CutCommand extends AbstractCommand {

    @Override
    public void executeCommand(IClipboard clipboard, JTextArea container) {
        clipboard.saveToClipboard(container.getText());
        container.setText("");
    }
}
