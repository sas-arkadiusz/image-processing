package transformations;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class MirrorImage {

	private static Imgcodecs imageCodecs;
	private static Mat srcImage, dstImageHorizontally, dstImageVertically ;
	private static Mat warpMatrix;

	MirrorImage(String imagePath) {

		imageCodecs = new Imgcodecs();

		// load image to memory
		srcImage = imageCodecs.imread(imagePath);
		
		// fill destination matrices with zeros
		dstImageHorizontally = Mat.zeros(srcImage.rows(), srcImage.cols(), srcImage.type());
		dstImageVertically = Mat.zeros(srcImage.rows(), srcImage.cols(), srcImage.type());
		
		// flip horizontal
		Core.flip(srcImage, dstImageHorizontally, 1);
		
		// flip vertical
		Core.flip(srcImage, dstImageVertically, 0);
		
		// display modified image
		HighGui.imshow("Source Image", srcImage);
		HighGui.imshow("Flip Horizontal", dstImageHorizontally);
		HighGui.imshow("Flip Vertical", dstImageVertically);
		HighGui.waitKey();
	
	}
}
