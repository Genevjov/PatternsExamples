package com.genevjov.fun.clipboard.impl;

import com.genevjov.fun.clipboard.IClipboard;

public class Clipboard implements IClipboard {

    private StringBuilder storedData;

    public Clipboard() {
        this.storedData = new StringBuilder();
    }

    @Override
    public void saveToClipboard(String dataToStore) {
        clearClipboard();
        storedData.append(dataToStore);
    }

    @Override
    public void clearClipboard() {
        storedData.setLength(0);
    }

    @Override
    public String getFromClipboard() {
        return storedData.toString();
    }
}