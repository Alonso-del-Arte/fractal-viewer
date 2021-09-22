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
package clipboardops;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.Image;
import java.io.IOException;

/**
 * This is like <code>StringSelection</code>, but for images drawn using AWT and 
 * Swing. This class is immutable except for clipboard ownership status.
 * @author Alonso del Arte
 */
public class ImageSelection implements Transferable, ClipboardOwner {
    
    private final Image heldImage;
    
    private static final DataFlavor SUPPORTED_FLAVOR = DataFlavor.imageFlavor;
    
    private static final DataFlavor[] FLAVOR_ARRAY = {SUPPORTED_FLAVOR};
    
    private boolean clipboardOwnershipFlag = true;

    public DataFlavor[] getTransferDataFlavors() {
        DataFlavor[] array = {};
        return array;
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return false;
    }

    public Object getTransferData(DataFlavor flavor) 
            throws UnsupportedFlavorException, IOException {
        return "Sorry, not implemented yet";
    }
    
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        // TODO: Write tests for this
    }
    
    /**
     * Tells whether an instance of this class has ownership of the clipboard.
     * @return True if the instance does have ownership of the clipboard, false 
     * otherwise.
     */
    public boolean hasOwnership() {
        return this.clipboardOwnershipFlag;
    }

    /**
     * Sole constructor.
     * @param image The image to be made available to the system clipboard. This 
     * image can't be changed, except by creating a new 
     * <code>ImageSelection</code> object.
     */
    public ImageSelection(Image image) {
        this.heldImage = image;
    }
    
}
