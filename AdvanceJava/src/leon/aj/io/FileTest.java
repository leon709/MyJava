package leon.aj.io;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File f = new File("D:\\temp\\AdvanceJava\\src");
		
		File ff = new File("D:\\temp\\pc.png");
		
		System.out.println(ff.getPath());
		System.out.println(ff.getParent());
		System.out.println(f.getPath());
		System.out.println(f.mkdir());
		System.out.println(f.mkdirs());
		
		File f3 = new File("D:\\SpaceEclipse\\JavaSE\\AdvanceJava\\src\\leon\\aj\\io\\CheckModify.java");
		
		System.out.println(f3.getAbsolutePath().indexOf("AdvanceJava"));
	}

}
