package transformations;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImagePosition {

	private static Imgcodecs imageCodecs;
	private static Mat srcImage, dstImage;
	private static Mat warpMatrix;

	ImagePosition(String imagePath) {

		imageCodecs = new Imgcodecs();

		// load image to memory
		srcImage = imageCodecs.imread(imagePath);

		// create source triangle, which should not move
		Point[] srcTriangle = new Point[3];
		srcTriangle[0] = new Point(0, 0);
		srcTriangle[1] = new Point(srcImage.cols(), 0);
		srcTriangle[2] = new Point(0, srcImage.rows());

		// create destination triangle -> it moves the image down
		Point[] dstTriangle = new Point[3];
		dstTriangle[0] = new Point(0, +250);
		dstTriangle[1] = new Point(srcImage.cols(), + 250);
		dstTriangle[2] = new Point(0, srcImage.rows() + 250);
		
		/* other destination triangle -> it moves the image to the right
		 * Point[] dstTriangle = new Point[3];
		 * dstTriangle[0] = new Point(250, 0);
		 * dstTriangle[1] = new Point(srcImage.cols() + 250, 0);
		 * dstTriangle[2] = new Point(250, srcImage.rows());
		*/

		// create rotation matrix
		warpMatrix = Imgproc.getAffineTransform(new MatOfPoint2f(srcTriangle), new MatOfPoint2f(dstTriangle));

		// fill destination matrix with zeros
		dstImage = Mat.zeros(srcImage.rows(), srcImage.cols(), srcImage.type());
		
		// modify image position
		Imgproc.warpAffine(srcImage, dstImage, warpMatrix, dstImage.size());

		// display modified image
		HighGui.imshow("Portrait of a Young Man", dstImage);
		HighGui.waitKey();

	}

}
