package leon.aj.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Logger;

public class FileServer {
	Logger log = Logger.getLogger(FileServer.class.getName());
	FileService fileService;

	public FileServer(){
		try {
			String uploadContent = "D:/shares/";
			fileService = new FileServiceImpl(uploadContent);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void start(){
		try {
			LocateRegistry.createRegistry(9001);
			Naming.rebind(FileService.RMI_URL, fileService);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		log.info("Server started.");
	}
	
	public static void main(String[] str){
		new FileServer().start();
	}
}
