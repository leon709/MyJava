package leon.aj.io;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFileFilter implements FileFilter {

	
	@Override
	public boolean accept(File f) {
		boolean accept = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date currDate = new Date();
		String dateStr = sdf.format(currDate);
		Date mdfDate = new Date(f.lastModified());
		
		if(dateStr.equals(sdf.format(mdfDate)) && f.isFile())
			accept = true;
		
		return accept;
	}

}
