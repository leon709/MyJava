package leon.aj.rmi;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

public class FileServiceImpl extends UnicastRemoteObject implements FileService {
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(FileServiceImpl.class.getName());
	Map<String, OutputStream> osMap = new HashMap<String, OutputStream>();
	
	private String fileContent;
	
    public FileServiceImpl(String uploadContent) throws RemoteException {
        super();
        this.fileContent = uploadContent;
    }

	
	@Override
	public String start(String fileName,String fileType) throws RemoteException {
		String filePath = fileContent+fileName+fileType;
		log.info(filePath);
		File file = new File(filePath);
		try{
			if(!file.exists()){
				file.createNewFile();
			}
			OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
			String uploadId = UUID.randomUUID().toString();
			osMap.put(uploadId, os);
			return uploadId;
		}catch(Exception e){
			e.printStackTrace();
			log.info("initial fail...");
			throw new RemoteException("initial fail",e);
		} 
		
	}

	@Override
	public void upload(String uploadId, byte[] part, int offset, int len)
			throws RemoteException {
		OutputStream os = osMap.get(uploadId);
		if(os == null){
			throw new RemoteException("file not exists." + uploadId);
		}
		try{
			os.write(part, offset, len);
		}catch(Exception e){
			throw new RemoteException("Exception when upload file:"+uploadId,e);
		}
		
	}

	@Override
	public void finish(String uploadId) throws RemoteException {
		try {
			osMap.get(uploadId).close();
		} catch (IOException e) {
			throw new RemoteException("File to finish the upload.", e);
		}
		log.info("File uploaded:"+uploadId);
	}

}
