package leon.aj.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileService extends Remote {
	public static final String RMI_URL = "rmi://localhost:9001/FileDataService";
	//enum FILE_TYPE{JAR,JAVA};
	public static final String JAR = ".jar";
	
	public String start(String fileName,String fileType) throws RemoteException;

	public void upload(String uploadId, byte[] part, int offset, int len) throws RemoteException;

	public void finish(String uploadId) throws RemoteException;

}
