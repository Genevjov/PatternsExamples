package com.genevjov.fun.command.impl;

import com.genevjov.fun.clipboard.IClipboard;
import com.genevjov.fun.command.AbstractCommand;

import javax.swing.*;

public class PasteCommand extends AbstractCommand {

    @Override
    public void executeCommand(IClipboard clipboard, JTextArea container) {
        container.setText(clipboard.getFromClipboard());
    }
}
