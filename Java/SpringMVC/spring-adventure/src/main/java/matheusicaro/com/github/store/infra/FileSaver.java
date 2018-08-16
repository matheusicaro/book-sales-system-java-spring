package matheusicaro.com.github.store.infra;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	@Autowired
	private HttpServletRequest request;
	
	public String write(String baseFolder, MultipartFile file, String title, boolean uploadOfFileCancelled) {
		
		try {
			String linkSaveFile = "";
			if(!uploadOfFileCancelled && !file.isEmpty()) {
				System.out.println();
				String realPath = request.getServletContext().getRealPath("/" + baseFolder);
				
				int pointOfFileExtension = file.getOriginalFilename().indexOf(".");
				String extensionOfFile = file.getOriginalFilename().substring(pointOfFileExtension, file.getOriginalFilename().length());
				String path = realPath + "\\" + title + extensionOfFile;
				file.transferTo(new File(path));
				linkSaveFile =  baseFolder + "\\" + file.getOriginalFilename();
			}
			return linkSaveFile;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
		
	}
		
}
