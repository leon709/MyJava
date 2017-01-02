package leon.aj.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

public class CheckModify {
	public static final String BASE_DATA_FILE = "base.properties";
	public static final String FILE_LIST = "filelist.txt";
	public static final String DATE_FORMAT = "yyyyMMdd";
	public static final String FILE_ZIP = ".zip";
	public static final String DATE_TAG = ">>DATE:";
	
	private static Properties props = null;
	private static List<String> fileList = null;
	public static final List<String> newFileList = new ArrayList<String>();
	
	static {
		try {
			props = loadBaseData(BASE_DATA_FILE);
			fileList = loadFileList(FILE_LIST);
		} catch (IOException e) {
			System.out.println("Exception when load the base data.");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		String workSpaceDir = props.getProperty("workspace.dir");
		String projectName = props.getProperty("projectName");
		File f = new File(workSpaceDir+projectName);
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Date currDate = new Date();
		
		// D:/temp/
		String zipFileDir = props.getProperty("zipFile.dir");
		// CAS_AIFRealease_13_02_
		String zipFileSuffix = props.getProperty("zipFile.suffix");
		// D:/temp/CAS_AIFRealease_13_02_yyyyMMdd
		String zipFileContent = zipFileDir + zipFileSuffix+sdf.format(currDate);
		
		//copy exist files
		for(String s: fileList){
			copyFile(new File(workSpaceDir+s),new File(zipFileContent+File.separator+s));
		}
		
		parse(f,currDate,sdf,zipFileContent);
		
		// do zip
		System.out.println(Utils.compress(zipFileContent, zipFileContent+FILE_ZIP));
		
		//check new file
		newFileList.removeAll(fileList);
		if(newFileList.size() > 0)
			writeNewFile(newFileList);
	}

	private static List<String> loadFileList(String path) {
		List<String> dataList = new ArrayList<String>();
		String s = null;
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			while((s=br.readLine())!=null){
				if(!s.startsWith(DATE_TAG) && !isEmpty(s))
					dataList.add(s);
			}
			if(fr != null)
				fr.close();
			if(br != null)
				br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;
	}
	
	public static void writeNewFile(List<String> fileList){
		FileWriter fw = null;
		BufferedWriter bw = null;
		try{
			Date currDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
			fw = new FileWriter(FILE_LIST,true);
			bw = new BufferedWriter(fw);
			bw.write(DATE_TAG+sdf.format(currDate)+"\n");
			for(String s: fileList){
				bw.write(s+"\n");
				System.out.println(s);
			}
			bw.write("\n");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(bw != null)
					bw.close();
				if(fw != null)
					fw.close();
				
			}catch(Exception e){
				System.out.println("Exception when close the Writer stream.");
				e.printStackTrace();
			}
		}
	}

	private static Properties loadBaseData(String baseDataFile) throws IOException {
		Properties props = new Properties();
		InputStream inputStream = new FileInputStream(baseDataFile);
		props.load(inputStream);
		
		if(inputStream != null)
			inputStream.close();
		
		return props;
	}

	public static void parse(File f,Date d, SimpleDateFormat sdf,String zipFileContent) throws IOException{
		String projectName = props.getProperty("projectName");
		
		File[] childs= f.listFiles();
		for(int i=0;i<childs.length;i++){
			
			if(isNeed(childs[i],d,sdf)){
				String filePath = childs[i].getAbsolutePath();
				int iRoot = filePath.indexOf(projectName);
				copyFile(childs[i], new File(zipFileContent+File.separator+filePath.substring(iRoot)));
				newFileList.add(filePath.substring(iRoot));
			}
			
			if(childs[i].isDirectory()){
				parse(childs[i],d,sdf,zipFileContent);
			}
		}
	}
	
	public static boolean isNeed(File f,Date d, SimpleDateFormat sdf) throws IOException{
		boolean isNeed = false;
		String dateStr = sdf.format(d);
		Date mdfDate = new Date(f.lastModified());
		if(f.isFile()){
			if(dateStr.equals(sdf.format(mdfDate)) && checkName(f))
				isNeed = true;
		}
		return isNeed;
	}
	public static boolean checkName(File f) throws IOException{
		boolean r = false;
		List<String> fileTypeList = new ArrayList<String>();
		String[] fileType = props.getProperty("fileType").split(",");
		for(String s : fileType){
			fileTypeList.add(s);
		}
		//fileTypeList.add("java");
		//fileTypeList.add("jsp");
		//fileTypeList.add("jspf");
		//fileTypeList.add("xml");
		//fileTypeList.add("properties");
		//fileTypeList.add("jar");
		//fileTypeList.add("txt");
		
		if(fileTypeList.contains(getFileType(f)))
			r = true;
		return r;
	}
	public static String getFileType(File f){
		String fileName = f.getName();
		int i = fileName.lastIndexOf('.');
		return fileName.substring(i+1);
	} 
	
	public static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        if(!targetFile.exists()){
        	targetFile.getParentFile().mkdirs();
        	targetFile.createNewFile();
        }
        try {
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // buffer byte array
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            outBuff.flush();
        } catch(Exception e){
        	System.out.println("Exception when copy file:"+sourceFile);
        	e.printStackTrace();
        } finally {
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }
	
	/**
     * compress to zip file
     * 
     * @param srcPathName
     * @param zipFilePath
     * @return zip success ? true : false
     */
    public static boolean compress(String srcPathName, String zipFilePath) {
        if (isEmpty(srcPathName) || isEmpty(zipFilePath))
            return false;

        File zipFile = new File(zipFilePath);
        File srcdir = new File(srcPathName);
        if (!srcdir.exists())
            return false;
        Project prj = new Project();
        Zip zip = new Zip();
        zip.setProject(prj);
        zip.setDestFile(zipFile);
        FileSet fileSet = new FileSet();
        fileSet.setProject(prj);
        fileSet.setDir(srcdir);
        zip.addFileset(fileSet);
        zip.execute();
        return zipFile.exists();
    }
    
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
