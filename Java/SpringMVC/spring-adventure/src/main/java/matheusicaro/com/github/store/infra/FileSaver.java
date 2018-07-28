package matheusicaro.com.github.store.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	@Autowired
	private HttpServletRequest request;
	
	public String write(String baseFolder, MultipartFile file, String title) {
		
		try {

			String realPath = request.getServletContext().getRealPath("/" + baseFolder);
			
			int pointOfFileExtension = file.getOriginalFilename().indexOf(".");
			String extension = file.getOriginalFilename().substring(pointOfFileExtension, file.getOriginalFilename().length());
			String path = realPath + "\\" + title + extension;
			file.transferTo(new File(path));
			
			return  baseFolder + "\\" + file.getOriginalFilename();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
		
	}
		
}
