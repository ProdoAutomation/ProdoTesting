package dataProviders;

public class FileReaderManager {
	
	private FileReaderManager() {
		
	}

	public static FileReaderManager getInstance() {
		FileReaderManager File = new FileReaderManager();
		return File;
	}
	
	public ConfigFileManager getCRInstance() throws Exception {
		ConfigFileManager config = new ConfigFileManager();
		return config;
	}
}
