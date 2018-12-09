package com.genevjov.fun.command;

import com.genevjov.fun.clipboard.IClipboard;

import javax.swing.*;

public abstract class AbstractCommand {

    public abstract void executeCommand(IClipboard clipboard, JTextArea container);
}
