package com.genevjov.fun.chain.impl;

import com.genevjov.fun.chain.AbstractChainLink;

import java.io.File;

public class FileExtensionChainLink extends AbstractChainLink {

    private String requiredExtension;

    public FileExtensionChainLink(String requiredExtension) {
        this.requiredExtension = requiredExtension;
    }

    @Override
    public boolean isValid(File file) {
        String filename = file.getName();
        return filename.substring(filename.lastIndexOf(".") + 1).equals(requiredExtension);
    }
}
