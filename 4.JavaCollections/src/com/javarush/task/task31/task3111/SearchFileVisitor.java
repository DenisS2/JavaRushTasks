/*package com.javarush.task.task31.task3111;


import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private int isPartOfName = 0;
    private int isPartOfContent = 0;
    private int isMinSize = 0;
    private int isMaxSize = 0;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        long fileSize = Files.size(file);
        String buff = new String(Files.readAllBytes(file));

        if (attrs.isRegularFile()) {

            if (!partOfName.equals(null)) {
                if (file.getFileName().toString().contains(partOfName)) {
                    //foundFiles.add(file);
                    isPartOfName = 2;
                }
            }

            if (!partOfContent.equals(null)) {
                if (buff.contains(partOfContent)) {
                    //foundFiles.add(file);
                    isPartOfContent = 2;
                }
            }

            if (maxSize != 0) {
                if (fileSize < maxSize) {
                    //foundFiles.add(file);
                    isMaxSize = 2;
                }
            }

            if (minSize != 0) {
                if (fileSize > minSize) {
                    //foundFiles.add(file);
                    isMinSize = 2;
                }
            }

            if (isPartOfName != 1 && isPartOfContent != 1 && isMaxSize != 1 && isMinSize != 1)
                foundFiles.add(file);
        }

            return super.visitFile(file, attrs);

    }


    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public String getPartOfName() {

        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        isPartOfName = 1;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        isPartOfContent = 1;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        isMinSize = 1;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        isMaxSize = 1;
    }
}
*/
package com.javarush.task.task31.task3111;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private List<Path> foundFiles = new ArrayList<>();
    private String partOfName;
    private String partOfContent;

    boolean minSizeCheck;
    boolean maxSizeCheck;
    boolean partOfNameCheck;
    boolean partOfContentCheck;
    private int minSize;
    private int maxSize;


    public SearchFileVisitor() {
        this.partOfName = null;
        this.partOfContent = null;
        this.minSize = 0;
        this.maxSize = 0;

        this.minSizeCheck = false;
        this.maxSizeCheck = false;
        this.partOfNameCheck = false;
        this.partOfContentCheck = false;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        this.minSizeCheck = true;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        this.maxSizeCheck = true;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        this.partOfNameCheck = true;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        this.partOfContentCheck = true;
    }

    public List<Path> getFoundFiles() {
        return this.foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (!attrs.isRegularFile()) return CONTINUE;

        if (partOfNameCheck && file.getFileName().toString().indexOf(this.partOfName) == -1)
            return CONTINUE;

        if (minSizeCheck && attrs.size() < minSize)
            return CONTINUE;

        if (maxSizeCheck && attrs.size() > maxSize)
            return CONTINUE;

        if (partOfContentCheck && new String(Files.readAllBytes(file)).indexOf(partOfContent) == -1)
            return CONTINUE;

        foundFiles.add(file);

        return CONTINUE;
    }
}