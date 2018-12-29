package com.genevjov.fun.chain.impl;

import com.genevjov.fun.chain.AbstractChainLink;

import java.io.File;
import java.nio.file.Files;

public class FileSizeChainLink extends AbstractChainLink {

    private long requiredFileSize;

    public FileSizeChainLink(long requiredeFileSize) {
        this.requiredFileSize = requiredeFileSize;
    }

    @Override
    protected boolean isValid(File file) {
        return requiredFileSize == file.length();
    }
}
