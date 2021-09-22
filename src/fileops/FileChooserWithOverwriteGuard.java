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

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Just a simple tweak on JFileChooser so that it asks before overwriting an 
 * existing file. This is done simply by overriding 
 * <code>JFileChooser.approveSelection()</code>.
 * @author Alonso del Arte
 */
// TODO: Write tests for this
public class FileChooserWithOverwriteGuard extends JFileChooser {
    
}
