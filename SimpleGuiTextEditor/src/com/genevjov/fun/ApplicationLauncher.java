package com.genevjov.fun;

import com.genevjov.fun.clipboard.impl.Clipboard;
import com.genevjov.fun.command.manager.impl.CommandExecutionManager;
import com.genevjov.fun.editor.impl.SwingTextEditor;

public class ApplicationLauncher {
    public static void main(String[] args) {
        new SwingTextEditor(new CommandExecutionManager(),
                new Clipboard()).renderEditorGui();
    }
}
