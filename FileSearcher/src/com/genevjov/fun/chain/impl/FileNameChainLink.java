package com.genevjov.fun.chain.impl;

import com.genevjov.fun.chain.AbstractChainLink;

import java.io.File;

public class FileNameChainLink extends AbstractChainLink {

    private String requiredFileName;

    public FileNameChainLink(String requiredFileName) {
        this.requiredFileName = requiredFileName;
    }

    @Override
    protected boolean isValid(File file) {
        String filenameWithoutExtension = file.getName().substring(0, file.getName().lastIndexOf("."));
        return requiredFileName.equals(filenameWithoutExtension);
    }
}
