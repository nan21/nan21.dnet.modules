package net.nan21.dnet.module.ad._presenterdelegates.data;
 
import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.nan21.dnet.core.api.action.IFileUploadResult;
import net.nan21.dnet.core.api.service.IEntityServiceFactory;
import net.nan21.dnet.core.api.service.IFileUploadService;
import net.nan21.dnet.core.presenter.service.AbstractFileUploadService;
import net.nan21.dnet.core.presenter.service.ServiceLocator;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentService;
import net.nan21.dnet.module.ad.data.domain.entity.Attachment;

public class AttachmentUploadDelegate extends AbstractFileUploadService 
implements IFileUploadService {

	/**
	 * Save an uploaded file as attachment. 
	 * The p1 parameter is expected to send the ID of the Attachment record to which this upload belongs.
	 */
	@Override
	public IFileUploadResult execute(String name, MultipartFile file,
			String p1, String p2) throws Exception {
		if (file.isEmpty()) {
			throw new Exception("Upload was not succesful. Try again please.");
		}
		ServiceLocator sl =  this.getServiceLocator();
		  
		IAttachmentService s = (IAttachmentService)sl.findEntityService(Attachment.class, (List<IEntityServiceFactory>) sl.getAppContext().getBean("osgiEntityServiceFactories"));
		Long id = Long.decode(p1);
		//Attachment a = s.findById(id);
		//Attachment a = (Attachment)s.getEntityManager().createNamedQuery(Attachment.NQ_FIND_BY_ID).setParameter("pId", id).getSingleResult();
		Attachment a = (Attachment)s.getEntityManager().createQuery("SELECT e FROM Attachment e WHERE e.id = :pId").setParameter("pId", id).getSingleResult();
		
		
		String path = a.getType().getUploadPath();
		String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.')+1);
		String newFileName = id + "." + extension;
		file.transferTo(new File( path+"/"+newFileName) );
		a.setLocation(newFileName);
		s.update(a);
		return null;
	}
	
}
