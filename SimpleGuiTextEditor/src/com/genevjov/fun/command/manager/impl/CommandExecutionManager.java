package com.genevjov.fun.command.manager.impl;

import com.genevjov.fun.clipboard.IClipboard;
import com.genevjov.fun.command.AbstractCommand;
import com.genevjov.fun.command.impl.CopyCommand;
import com.genevjov.fun.command.impl.CutCommand;
import com.genevjov.fun.command.impl.PasteCommand;
import com.genevjov.fun.command.impl.SaveCommand;
import com.genevjov.fun.command.manager.CommandManager;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

import static com.genevjov.fun.constants.Commands.*;

public class CommandExecutionManager implements CommandManager {

    private Map<String, AbstractCommand> commandContainer;

    public CommandExecutionManager() {
        initCommandContainer();
    }

    @Override
    public void executeCommand(String command, JTextArea container, IClipboard clipboard) {
        commandContainer.get(command).executeCommand(clipboard, container);
    }

    private void initCommandContainer() {
        commandContainer = new HashMap<>();
        commandContainer.put(COPY_COMMAND, new CopyCommand());
        commandContainer.put(PASTE_COMMAND, new PasteCommand());
        commandContainer.put(CUT_COMMAND, new CutCommand());
        commandContainer.put(SAVE_COMMAND, new SaveCommand());
    }
}
