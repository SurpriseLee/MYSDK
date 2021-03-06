package pers.lxs.file;

import java.io.File;

public class FileNameConverter {
	
	private String srcFilePath;
	
	private String srcFileSuffix;
	private String dstFileSuffix;
	
	public FileNameConverter(String srcFilePath, String srcFileSuffix, String dstFileSuffix) {
		this.srcFilePath = srcFilePath;

		this.srcFileSuffix = srcFileSuffix;
		this.dstFileSuffix = dstFileSuffix;
	}
		
	public void process() {
		
		File srcFile = new File(srcFilePath);	
		
		if(srcFile.isFile()) {
			renameFileName(srcFile);
		} else if(srcFile.isDirectory()) {
			process(srcFile);
		}
	}
	
	public void process(File file) {
		
		File[] files = file.listFiles();
		
		for(File f : files) {
			if(f.isFile()) {
				renameFileName(f);
			} else if(f.isDirectory()) {
				process(f);
			}
		}
	}
	
	private void renameFileName(File file) {
		
		if(file.getName().matches(".*" + srcFileSuffix + "$")) {
			String fileNewNamePath = file.getParent() + File.separator + file.getName().replace(srcFileSuffix, dstFileSuffix);
			file.renameTo(new File(fileNewNamePath));
		} 	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length != 3) {
			System.out.println("There are three parameters are needed! Please check your parameters correctly!");
			return;
		}
		
		String srcFilePath = args[0];
		String srcFileSuffix = args[1];
		String dstFileSuffix = args[2];
		
		FileNameConverter fileNameConverter = new FileNameConverter(srcFilePath, srcFileSuffix, dstFileSuffix);
		fileNameConverter.process();
	}

}
