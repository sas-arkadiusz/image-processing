package transformations;

public class Main {

	private static String imagePath;
	
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	
	public static void main(String[] args) {
		
		// set path to the image
		imagePath = "F:\\courses\\image processing\\resources\\images\\main-image.jpg";
		
		//new ImagePosition(imagePath); 
		
		//new MirrorImage(imagePath);
		
		//new ImageRotation(imagePath);

	}

}