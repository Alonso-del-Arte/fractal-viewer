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

import static org.testng.Assert.*;

import org.testng.annotations.Test;

/**
 * Tests of the PNGFileFilter class.
 * @author Alonso del Arte
 */
public class PNGFileFilterNGTest {
    
    /**
     * Test of the accept function, of the PNGFileFilter class.
     */
    @Test
    public void testAccept() {
        System.out.println("accept");
        File file = null;
        PNGFileFilter instance = new PNGFileFilter();
        boolean expResult = false;
        boolean result = instance.accept(file);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of the getDescription function, of the PNGFileFilter class.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        PNGFileFilter instance = new PNGFileFilter();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
