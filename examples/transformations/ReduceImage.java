package transformations;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ReduceImage {

	private static Imgcodecs imageCodecs;
	private static Mat srcImage, resizeMethodx1_2, resizeMethodx1_4, pyrDownMethodx1_2, pyrDownMethodx1_4;
	
	private String source = "C:\image_processing\\source.jpg";
	private String fileResize1_2x = "C:\\image_processing\\resizex1_2.jpg";
	private String fileResize1_4x = "C:\\image_processing\\resizex1_4.jpg";
	private String filePyrDown1_2x = "C:\\image_processing\\pyrDownx1_2.jpg";
	private String filePyrDown1_4x = "C:\\image_processing\\pyrDownx1_4.jpg";

	public ReduceImage(String imagePath) {
		
		imageCodecs = new Imgcodecs();

		// load source image to memory
		srcImage = imageCodecs.imread(imagePath);
		// save source image
		imageCodecs.imwrite(source, srcImage);
		
		/* RESIZE METHOD */
		
		// extend sizes
		Size imageSizex2 = new Size(srcImage.cols()/2, srcImage.rows()/2);
		Size imageSizex4 = new Size(srcImage.cols()/4, srcImage.rows()/4);
		
		// create matrices 
		resizeMethodx1_2 = new Mat();
		resizeMethodx1_4 = new Mat();
				
		// extend images
		Imgproc.resize(srcImage, resizeMethodx1_2, imageSizex2);
		Imgproc.resize(srcImage, resizeMethodx1_4, imageSizex4);
		
		// save extended images
		imageCodecs.imwrite(fileResize1_2x, resizeMethodx1_2);
		imageCodecs.imwrite(fileResize1_4x, resizeMethodx1_4);
		
		
		/* PYRUP METHOD */
		
		// create matrices 
		pyrDownMethodx1_2 = new Mat();
		pyrDownMethodx1_4 = new Mat();
		
		/* pyrUp requirements - 
		 * | dstsize.width*2 - src.cols | <= 2
		 * | dstsize.height*2 -src.rows | <= 2
		 */
		
		// extend images
		Imgproc.pyrDown(srcImage, pyrDownMethodx1_2, 
				new Size((srcImage.cols()+1)/2, (srcImage.rows()+1)/2));
		Imgproc.pyrDown(pyrDownMethodx1_2, pyrDownMethodx1_4, 
				new Size(((pyrDownMethodx1_2.cols()+1)/2), ((pyrDownMethodx1_2.rows()+1)/2)));
		
		// save extended images
		imageCodecs.imwrite(filePyrDown1_2x, pyrDownMethodx1_2);
		imageCodecs.imwrite(filePyrDown1_4x, pyrDownMethodx1_4);
		
	}
	
	
}
