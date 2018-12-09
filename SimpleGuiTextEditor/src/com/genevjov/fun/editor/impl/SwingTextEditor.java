package com.genevjov.fun.editor.impl;

import com.genevjov.fun.clipboard.IClipboard;
import com.genevjov.fun.command.manager.CommandManager;
import com.genevjov.fun.editor.Editor;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static javax.swing.BoxLayout.Y_AXIS;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SwingTextEditor implements Editor {

    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 200;
    private IClipboard clipboard;
    private CommandManager commandManager;

    public SwingTextEditor(CommandManager commandManager, IClipboard clipboard) {
        this.commandManager = commandManager;
        this.clipboard = clipboard;
    }

    @Override
    public void renderEditorGui() {
        JFrame frame = new JFrame("Text editor");
        JPanel mainPanel = new JPanel();
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainPanel.setLayout(new BoxLayout(mainPanel, Y_AXIS));
        JTextArea textContainer = new JTextArea();
        textContainer.setLineWrap(true);
        mainPanel.add(textContainer);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        initButtonPanel(buttonPanel, textContainer, clipboard);
        mainPanel.add(buttonPanel);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initButtonPanel(JPanel buttonPanel, JTextArea textContainer, IClipboard clipboard) {
        JButton ctrlC = new JButton("Copy");
        JButton ctrlX = new JButton("Cut");
        JButton ctrlV = new JButton("Paste");
        JButton ctrlZ = new JButton("Save");
        List<JButton> buttons = Arrays.asList(ctrlC, ctrlX, ctrlV, ctrlZ);
        buttons.forEach(jButton -> jButton.setActionCommand(jButton.getText().toLowerCase()));
        buttons.forEach(jButton -> jButton.addActionListener(event ->
                commandManager.executeCommand(event.getActionCommand(), textContainer, clipboard)));
        buttonPanel.add(ctrlC);
        buttonPanel.add(ctrlX);
        buttonPanel.add(ctrlV);
        buttonPanel.add(ctrlZ);
    }
}