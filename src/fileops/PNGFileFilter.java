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
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package fileops;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * File filter for selecting Portable Network Graphics (PNG) files in a 
 * <code>JFileChooser</code> dialog box. The file type is determined by the file 
 * extension, and not by any criterion that might be specific to a given 
 * operating system.
 * @author Alonso del Arte
 */
public class PNGFileFilter extends FileFilter {
    
    /**
     * Determines whether this filter should accept a particular file or 
     * directory. A file chooser using this filter should then display files and 
     * directories for which this function returns true and omit those for which 
     * this function returns false. However, the file chooser may choose to omit 
     * hidden files or hidden directories even if this filter indicates they 
     * should be displayed. Consult the file chooser documentation.
     * @param file The file to check for acceptance. May be a directory. 
     * Examples: image.png, logo.PNG, photo.jpg, Users/Public/, resume.docx.
     * @return True if the filename ends with ".png", without regards for case, 
     * or if <code>file</code> is actually a directory. False in any other case. 
     * For the examples given above, this function would return true for 
     * image.png, logo.PNG and Users/Public/. It would return false for 
     * photo.jpg and resume.docx.
     */
    @Override
    public boolean accept(File file) {
        return file.getName().toLowerCase().endsWith(".png") 
                || file.isDirectory();
    }
    
    /**
     * The description of this filter. The description will be displayed by the 
     * file chooser dialog, but the exact manner of display will depend on the 
     * operating system.
     * @return The description "Portable Network Graphics images (*.png)".
     */
    @Override
    public String getDescription() {
        return "Portable Network Graphics images (*.png)";
    }
    
}
