package com.genevjov.fun;

import com.genevjov.fun.chain.AbstractChainLink;
import com.genevjov.fun.chain.impl.FileExtensionChainLink;
import com.genevjov.fun.chain.impl.FileNameChainLink;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ApplicationLauncher {

    private static final String EXTENSION = "txt";
    private static final String FILENAME = "test";
    private static final String START_PATH = "D:/";

    public static void main(String[] args) {
        AbstractChainLink searchFileChain = new FileExtensionChainLink(EXTENSION);
        searchFileChain.linkWithNextElement(new FileNameChainLink(FILENAME));
        List<File> foundFiles = extractAllFilesFromDirectory();
        validateExtractedFileList(foundFiles);
        chainFoundFiles(foundFiles, searchFileChain);
    }

    private static void chainFoundFiles(List<File> files, AbstractChainLink chain) {
        int validFiles = 0;
        for (File file : files) {
            if (chain.doChain(file)) {
                ++validFiles;
                System.out.println(file.getAbsolutePath());
            }
        }
        System.out.println("Found " + validFiles + " files.");
    }

    private static void validateExtractedFileList(List<File> files) {
        if (Objects.isNull(files) || files.size() == 0) {
            throw new RuntimeException("Any files found.");
        }
    }

    private static List<File> extractAllFilesFromDirectory() {
        File directory = new File(START_PATH);
        List<File> foundFiles = Arrays.asList(directory.listFiles());
        return foundFiles;
    }
}
