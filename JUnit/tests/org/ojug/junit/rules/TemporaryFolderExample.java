package org.ojug.junit.rules;

import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TemporaryFolderExample {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void useTempFolder() throws Exception {
        File tempFile = this.folder.newFile();
        System.out.println("tempFile: " + tempFile.getAbsolutePath());

        File namedTempFile = this.folder.newFile("file-in-temp-folder");
        System.out.println("namedTempFile: " + namedTempFile.getAbsolutePath());

        File tempFolder = this.folder.newFolder();
        System.out.println("tempFolder: " + tempFolder.getAbsolutePath());

        File namedTempFolder = this.folder.newFolder("path", "to", "named", "folder");
        System.out.println("namedTempFolder: " + namedTempFolder.getAbsolutePath());

    }

}
