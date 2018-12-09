package com.genevjov.fun.command.manager;

import com.genevjov.fun.clipboard.IClipboard;

import javax.swing.*;

public interface CommandManager {

    void executeCommand(String command, JTextArea containerValue, IClipboard clipboard);
}
