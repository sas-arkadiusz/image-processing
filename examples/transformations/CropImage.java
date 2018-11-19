package transformations;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class CropImage {

	private static Imgcodecs imageCodecs;
	private static Mat srcImage;

	public CropImage(String imagePath) {

		imageCodecs = new Imgcodecs();

		// load image to memory
		srcImage = imageCodecs.imread(imagePath);
		
		/* FIRST METHOD TO CROP RECTANGLE */
				
		// crop image by submat
		Mat croppedImageSubmat = srcImage.submat(new Rect(50, 50, 100, 100));
		
		/* SECOND METHOD TO CROP RECTANGLE */

        // create a rectangle
        Rect rectCrop = new Rect(50, 50, 150, 150);
        
        // crop image
        Mat croppedImageRectangle= new Mat(srcImage, rectCrop);
		
		// display modified image
		HighGui.imshow("Source", srcImage);
		HighGui.imshow("1.Method: ", croppedImageSubmat);
		HighGui.imshow("2.Method: ", croppedImageRectangle);
		HighGui.waitKey();
	
	}
}
