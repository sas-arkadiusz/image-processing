package transformations;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageRotation {
	
	private static Imgcodecs imageCodecs;
	private static Mat srcImage, dstImage;
	private static Mat rotationMatrix;

	ImageRotation(String imagePath) {

		imageCodecs = new Imgcodecs();

		// load image to memory
		srcImage = imageCodecs.imread(imagePath);
		
		// rotation properties
		Point center = new Point(srcImage.cols() / 2, srcImage.rows() / 2);
		double angle = 315.0;
		double scale = 1.0;
		
		// get rotation matrix
		rotationMatrix = Imgproc.getRotationMatrix2D(center, angle, scale);
		
		// modify image rotation
		Mat warpRotateDst = new Mat();
		Imgproc.warpAffine(srcImage, warpRotateDst, rotationMatrix, srcImage.size());
		
		// display modified image
		HighGui.imshow("Source", srcImage);
		HighGui.imshow("Modified Image", warpRotateDst);
		HighGui.waitKey();
		
	}

}
