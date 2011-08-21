package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

import org.springframework.web.multipart.MultipartFile;

import net.nan21.dnet.core.api.action.IFileUploadResult;
import net.nan21.dnet.core.api.service.IFileUploadService;
import net.nan21.dnet.core.presenter.service.AbstractFileUploadService;

public class DeployUploadedWorkflow extends AbstractFileUploadService 
	implements IFileUploadService{

	@Override
	public IFileUploadResult execute(String name, MultipartFile file,
			String p1, String p2) throws Exception {
		if (file.isEmpty()) {
			throw new Exception("Upload was not succesful. Try again please.");
		}
		String deploymentName = (name!=null && !name.equals(""))?name:file.getOriginalFilename();		 
		InputStream stream = null;
		
		try {
			stream = file.getInputStream();
			ZipInputStream inputStream = new ZipInputStream(stream);
			    
			getWorkflowEngine().getRepositoryService().createDeployment()
			    .name(deploymentName)
			    .addZipInputStream(inputStream)
			    .deploy();
		} finally {
			stream.close();
		}
 
		return null;
	}

}
