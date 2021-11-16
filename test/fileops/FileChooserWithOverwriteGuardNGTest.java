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
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import static org.testng.Assert.*;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Tests of the FileChooserWithOverwriteGuard class.
 * @author Alonso del Arte
 */
public class FileChooserWithOverwriteGuardNGTest {
    
    private File TEST_FILE;
    
    @BeforeSuite
    public void setUpClass() {
        // TODO: Create example existing file
    }
    
    @Test
    public void testApproveSelection() {
        System.out.println("approveSelection");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @AfterSuite
    public void tearDownClass() {
        // TODO: Delete example existing file
    }
    
    /**
     * Extends {@link FileChooserWithOverwriteGuard} so that the confirmation 
     * dialog box response can be mocked so that the user running the tests 
     * doesn't have to watch out and click on some dialog box that comes up. 
     * Only {@link FileChooserWithOverwriteGuard#getConfirmationResponse()} is 
     * overridden.
     */
    private static class MockFileChooser extends FileChooserWithOverwriteGuard {
        
        private int mockResponse = JOptionPane.OK_OPTION;
        
        void setMockResponse(int responseCode) {
            this.mockResponse = responseCode;
        }
        
        @Override
        int getConfirmationResponse() {
            return this.mockResponse;
        }
        
    }
    
}
