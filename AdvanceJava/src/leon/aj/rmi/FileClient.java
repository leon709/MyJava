package leon.aj.rmi;

import java.io.File;
import java.io.FileInputStream;
import java.rmi.Naming;
import java.util.logging.Logger;

public class FileClient {

	static Logger log = Logger.getLogger(FileClient.class.getName());
	
    public static void main(String[] args) {
        try {
        	File file = new File("D:\\tools\\Library\\struts2-spring-plugin-2.2.3.jar");
        	FileInputStream fis = new FileInputStream(file);
            FileService fileService = (FileService) Naming.lookup(FileService.RMI_URL);
            String uploadId = fileService.start("struts2-spring-plugin-2.2.3",FileService.JAR);
            
            log.info(uploadId);
            
            byte[] buffer = new byte[1024];
            int len = fis.read(buffer);
            while(len> -1){
            	fileService.upload(uploadId, buffer, 0, len);
            	log.info("read part");
            	len = fis.read(buffer);
            }
            fileService.finish(uploadId);
            log.info("file upload finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
