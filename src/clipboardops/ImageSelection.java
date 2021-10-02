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
public class ImageSelection implements Transferable {
    
    private final Image heldImage;
    
    private static final DataFlavor SUPPORTED_FLAVOR = DataFlavor.imageFlavor;
    
    /**
     * Tells which "data flavors" this class supports. Specifically, 
     * <code>imageFlavor</code> only.
     * @return An array containing just one element: <code>imageFlavor</code>.
     */
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        DataFlavor[] array = {DataFlavor.imageFlavor};
        return array;
    }

    /**
     * Determines whether a given data "flavor" is supported by this class. Only 
     * <code>imageFlavor</code> is supported.
     * @param flavor The flavor to check for support. For example, 
     * <code>javaFileListFlavor</code>.
     * @return True only if <code>flavor</code> is <code>imageFlavor</code>. 
     * False in any other case, like the example given above.
     */
    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(SUPPORTED_FLAVOR);
    }

    /**
     * Returns the image held by this <code>ImageSelection</code> object.
     * @param flavor The flavor to use. Should always be 
     * <code>imageFlavor</code>.
     * @return The image (it may be necessary to cast it to 
     * <code>java.awt.Image</code>).
     * @throws IOException If some problem other than a wrong flavor occurs.
     * @throws NullPointerException If <code>flavor</code> is null.
     * @throws UnsupportedFlavorException If <code>flavor</code> is not 
     * <code>imageFlavor</code>.
     */
    @Override
    public Object getTransferData(DataFlavor flavor) 
            throws UnsupportedFlavorException, IOException {
        if (!flavor.equals(SUPPORTED_FLAVOR)) {
            throw new UnsupportedFlavorException(flavor);
        }
        return this.heldImage;
    }
    
    /**
     * Sole constructor.
     * @param image The image to be made available to the system clipboard. This 
     * image can't be changed, except by creating a new 
     * <code>ImageSelection</code> object.
     */
    public ImageSelection(Image image) {
        if (image == null) {
            String excMsg = "Image must not be null";
            throw new NullPointerException(excMsg);
        }
        this.heldImage = image;
    }
    
}
