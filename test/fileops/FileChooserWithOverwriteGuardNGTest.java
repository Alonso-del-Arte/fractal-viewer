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

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFileChooser;
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
    
    private static final Random RANDOM = new Random();
    
    private static final String TEMP_DIR_PATH 
            = System.getProperty("java.io.tmpdir");
    
    private File TEST_NEW_FILE;
    
    private File TEST_EXISTING_FILE;
    
    @BeforeSuite
    public void setUpClass() {
        // TODO: Create example existing file
    }
    
    @Test
    public void testApproveSelection() {
        System.out.println("approveSelection");
        String filename = TEMP_DIR_PATH + File.separatorChar + "NewFile" 
                + RANDOM.nextInt() + ".txt";
        TEST_NEW_FILE = new File(filename);
        String preMsg = TEST_NEW_FILE.getName() + " should not already exist";
        assert !TEST_NEW_FILE.exists() : preMsg;
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @AfterSuite
    public void tearDownClass() {
        // TODO: Delete example existing file
    }
    
    /**
     * Extends {@link FileChooserWithOverwriteGuard} so that the confirmation 
     * dialog box response can be mocked. Then the user running the tests 
     * doesn't have to watch out and click on some dialog box that comes up. 
     * Only {@link FileChooserWithOverwriteGuard#getConfirmationResponse()}, 
     * <code>JFileChooser.cancelSelection()</code> and 
     * <code>JFileChooser.showSaveDialog()</code> are overridden.
     */
    private static class MockFileChooser extends FileChooserWithOverwriteGuard {
        
        private final int mockResponse;
        
        private boolean mockResponseGiven = false;
        
        /**
         * The return value. This does not hide <code>JFileChooser</code>'s 
         * <code>returnValue</code> field because that one's private, and thus 
         * inaccessible to this class. If that was protected instead, this field 
         * would be unnecessary.
         */
        private int returnValue;
        
        /**
         * Overrides the superclass so that a Yes, No or Cancel response is 
         * given without a <code>JOptionPane</code> coming up. This way we don't 
         * have to worry about how to click on that through the test program.
         * @return Whatever response code was assigned through the constructor.
         */
        @Override
        int getConfirmationResponse() {
            switch (this.mockResponse) {
                case JOptionPane.YES_OPTION:
                    this.returnValue = JFileChooser.APPROVE_OPTION;
                case JOptionPane.NO_OPTION:
                case JOptionPane.CANCEL_OPTION:
                    this.returnValue = JFileChooser.CANCEL_OPTION;
                default:
                    this.returnValue = JFileChooser.ERROR_OPTION;
            }
            this.mockResponseGiven = true;
            return this.mockResponse;
        }
        
        /**
         * Indicates whether or not the mock response has been given.
         * @return False if {@link #getConfirmationResponse()} has never been 
         * called on this instance, true if it has been called even just once.
         */
        boolean mockResponseHasBeenGiven() {
            return this.mockResponseGiven;
        }
        
        @Override
        public void cancelSelection() {
            super.cancelSelection();
            this.returnValue = JFileChooser.CANCEL_OPTION;
        }
        
        /**
         * Does not actually show a save dialog. But it does call 
         * <code>approveSelection()</code> and hopefully that does check whether 
         * the file exists already or not.
         * @param parent Should normally be an actual parent component, but for 
         * testing purposes should perhaps preferably be null.
         * @return A <code>JFileChooser</code> option constant according to the 
         * chosen <code>JOptionPane</code> response code.
         */
        @Override
        public int showSaveDialog(Component parent) {
            this.approveSelection();
            return this.returnValue;
        }

        /**
         * Sole constructor. The superclass constructor is called implicitly. 
         * This constructor has nothing to add other than setting the response 
         * code. Even though one mock file chooser can be used for multiple 
         * files, it is perhaps best to construct a new mock file chooser for 
         * each test.
         * @param code The response code this mock file chooser's {@link
         * #getConfirmationResponse()} will always return.
         */
        public MockFileChooser(int code) {
            this.mockResponse = code;
        }
        
    }
    
}
