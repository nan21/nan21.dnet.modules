package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.web.multipart.MultipartFile;

import net.nan21.dnet.core.api.action.IFileUploadResult;
import net.nan21.dnet.core.api.service.IFileUploadService;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.service.AbstractFileUploadService;
import net.nan21.dnet.module.ad.workflow.business.service.IActDeploymentService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

public class DeployUploadedWorkflow extends AbstractFileUploadService implements
		IFileUploadService {

	@Override
	public IFileUploadResult execute(String name, MultipartFile file,
			String p1, String p2) throws Exception {
		if (file.isEmpty()) {
			throw new Exception("Upload was not succesful. Try again please.");
		}
		String deploymentName = (name != null && !name.equals("")) ? name
				: file.getOriginalFilename();
		// deploymentName = Session.user.get().getClientId() + ":"
		// + deploymentName;
		InputStream stream = null;

		try {
			stream = file.getInputStream();
			ZipInputStream inputStream = new ZipInputStream(stream);

			RepositoryService rs = getWorkflowEngine().getRepositoryService();
			Deployment d = rs.createDeployment().name(deploymentName)
					.addZipInputStream(inputStream).deploy();

			// update clientId

			IActDeploymentService srv = (IActDeploymentService) this
					.getServiceLocator().findEntityService(ActDeployment.class);

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("clientId", Session.user.get().getClientId());
			params.put("id", d.getId());

			// TODO: move these along with the deployment into a tranzactional
			// business method
			srv.update(" update " + ActDeployment.class.getSimpleName()
					+ " set clientId = :clientId where id = :id ", params);

			srv.update(" update " + ActProcessDefinition.class.getSimpleName()
					+ " set clientId = :clientId where deployment.id = :id ",
					params);

		} finally {
			stream.close();
		}

		return null;
	}

}
