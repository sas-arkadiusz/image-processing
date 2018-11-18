package transformations;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ExtendImage {

	private static Imgcodecs imageCodecs;
	private static Mat srcImage, resizeMethodx2, resizeMethodx4, pyrUpMethodx2, pyrUpMethodx4;
	
	private String source = "C:\\image-processing\\lab03\\source.jpg";
	private String fileResize2x = "C:\\image-processing\\lab03\\resizex2.jpg";
	private String fileResize4x = "C:\\image-processing\\lab03\\resizex4.jpg";
	private String filePyrUp2x = "C:\\image-processing\\lab03\\pyrUpx2.jpg";
	private String filePyrUp4x = "C:\\image-processing\\lab03\\pyrUpx4.jpg";
	
	public ExtendImage(String imagePath) {
		
		imageCodecs = new Imgcodecs();

		// load source image to memory
		srcImage = imageCodecs.imread(imagePath);
		// save source image
		imageCodecs.imwrite(source, srcImage);
		
		/* RESIZE METHOD */
		
		// extend sizes
		Size imageSizex2 = new Size(2*srcImage.cols(), 2*srcImage.rows());
		Size imageSizex4 = new Size(4*srcImage.cols(), 4*srcImage.rows());
		
		// create matrices 
		resizeMethodx2 = new Mat();
		resizeMethodx4 = new Mat();
		
		// extend images
		Imgproc.resize(srcImage, resizeMethodx2, imageSizex2);
		Imgproc.resize(srcImage, resizeMethodx4, imageSizex4);
		
		// save extended images
		imageCodecs.imwrite(fileResize2x, resizeMethodx2);
		imageCodecs.imwrite(fileResize4x, resizeMethodx4);
		
		
		/* PYRUP METHOD */
		
		// create matrices 
		pyrUpMethodx2 = new Mat();
		pyrUpMethodx4 = new Mat();
		
		/* pyrUp requirements - 
		 * | dstsize.width -src.cols*2 | <= (dstsize.width mod 2) 
		 * | dstsize.height -src.rows*2 | <= (dstsize.height mod 2)
		 */
		
		// extend images
		Imgproc.pyrUp(srcImage, pyrUpMethodx2, new Size(2*pyrUpMethodx2.cols(), 2*pyrUpMethodx2.rows()));
		Imgproc.pyrUp(pyrUpMethodx2, pyrUpMethodx4, new Size((pyrUpMethodx2.cols()*2), (pyrUpMethodx2.rows()*2)));
		
		// save extended images
		imageCodecs.imwrite(filePyrUp2x, pyrUpMethodx2);
		imageCodecs.imwrite(filePyrUp4x, pyrUpMethodx4);
		
		
	}
	
}
