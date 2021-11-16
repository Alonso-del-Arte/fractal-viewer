/*
 * Copyright (C) 2021 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple 
 * Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package fileops;

import java.io.File;

import org.testng.annotations.Test;

/**
 * Tests of the PNGFileFilter class.
 * @author Alonso del Arte
 */
public class PNGFileFilterNGTest {
    
    /**
     * Test of the accept function, of the PNGFileFilter class. The filter 
     * should accept files with the *.png file extension.
     */
    @Test
    public void testAccept() {
        System.out.println("accept");
        File file = new File("image.png");
        PNGFileFilter filter = new PNGFileFilter();
        String msg = "Filter should accept " + file.getName();
        assert filter.accept(file) : msg;
    }

    /**
     * Another test of the accept function, of the PNGFileFilter class. The 
     * filter should reject files that are not PNG files, like JPEG files, 
     * Microsoft Word files, plain text files, Java source files, etc.
     */
    @Test
    public void testReject() {
        String jpegFilename = "image.jpeg";
        String wordFilename = "essay.docx";
        String textFilename = "essay.txt";
        String javaFilename = "PNGFileFilter.java";
        File jpegFile = new File(jpegFilename);
        File wordFile = new File(wordFilename);
        File textFile = new File(textFilename);
        File javaFile = new File(javaFilename);
        PNGFileFilter filter = new PNGFileFilter();
        String msgPart = "Filter should reject ";
        assert !filter.accept(jpegFile) : msgPart + jpegFilename;
        assert !filter.accept(wordFile) : msgPart + wordFilename;
        assert !filter.accept(textFile) : msgPart + textFilename;
        assert !filter.accept(javaFile) : msgPart + javaFilename;
    }

    /**
     * Another test of the accept function, of the PNGFileFilter class. The 
     * filter should accept files with the *.PNG file extension.
     */
    @Test
    public void testAcceptUpperCaseExtension() {
        File file = new File("image.PNG");
        PNGFileFilter filter = new PNGFileFilter();
        String msg = "Filter should accept " + file.getName();
        assert filter.accept(file) : msg;
    }

    /**
     * Another test of the accept function, of the PNGFileFilter class. The 
     * filter should accept directories (folders).
     */
    @Test
    public void testAcceptDirectory() {
        String homeDirPath = System.getProperty("user.home");
        File dir = new File(homeDirPath);
        String preMsg = dir.getAbsolutePath() + " should be a directory";
        assert dir.isDirectory() : preMsg;
        PNGFileFilter filter = new PNGFileFilter();
        String msg = "Filter should accept " + dir.getName() 
                + File.separatorChar;
        assert filter.accept(dir) : msg;
    }

    /**
     * Test of the getDescription function, of the PNGFileFilter class. The 
     * description provided to JFileChooser should include the file extension 
     * *.png or *.PNG.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        PNGFileFilter filter = new PNGFileFilter();
        String description = filter.getDescription();
        String formatName = "Portable Network Graphics";
        String msg = "Filter description should include \"" + formatName + "\"";
        assert description.contains(formatName) : msg;
        assert description.toLowerCase().contains(".png") 
                : "Description contains file extension *.png";
    }
    
}
