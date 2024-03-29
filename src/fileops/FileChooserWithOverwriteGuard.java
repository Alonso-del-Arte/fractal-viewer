/*
 * Copyright (C) 2022 Alonso del Arte
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

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Just a simple tweak on <code>JFileChooser</code> so that it asks before 
 * overwriting an existing file. This is done simply by overriding 
 * <code>JFileChooser.approveSelection()</code>.
 * <p>I believe that this file chooser will display files and directories marked 
 * as hidden by the operating system, but I don't know that for certain. Consult 
 * the <code>JFileChooser</code> documentation if you have any specific 
 * requirements regarding hidden items.</p>
 * @author Alonso del Arte
 */
public class FileChooserWithOverwriteGuard extends JFileChooser {
    
    private static final long serialVersionUID = 4552602532748197888L;

    private static final String QUESTION 
            = "Do you want to overwrite the existing file?";
    
    int getConfirmationResponse() {
        return JOptionPane.showConfirmDialog(this, QUESTION, 
                this.getSelectedFile().getName() + " already exists", 
                JOptionPane.YES_NO_CANCEL_OPTION);
    }
    
    @Override
    public void approveSelection() {
        File file = this.getSelectedFile();
        if (file.exists()) {
            int response = this.getConfirmationResponse();
            switch (response) {
                case JOptionPane.YES_OPTION:
                    super.approveSelection();
                case JOptionPane.NO_OPTION:
                    return;
                default:
                    this.cancelSelection();
            }
        } else {
            super.approveSelection();
        }
    }
    
}
