package com.genevjov.fun.clipboard;

public interface IClipboard {

    void saveToClipboard(String dataToStore);

    void clearClipboard();

    String getFromClipboard();
}
