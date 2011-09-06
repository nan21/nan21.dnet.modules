Ext.ns("net.nan21.dnet.module.ad.workflow.lovs");
net.nan21.dnet.module.ad.workflow.lovs.ActDeployments = Ext.extend( dnet.base.AbstractCombo, {	
	 initComponent : function(){
		Ext.apply(
		    this, {
                 mode: "remote"
				,displayField:"fullName"
				,triggerAction :"query"
				,pageSize:30
				,autoSelect:true
				,listWidth:250 
				,tpl: '<tpl for="."><div class="x-combo-list-item"><div style="">{fullName}</div></div></tpl>'
				,minChars:0	
				,_dataProviderFields_: 	net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentLovDs		
				,_dataProviderName_:"ActDeploymentLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.workflow.frame.WorkflowAdmin_UI",bundle:"nan21.dnet.module.ad.ui.extjs",tocElement: "canvasDeployment"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.ad.workflow.lovs.ActDeployments.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.lovs.ActDeployments", net.nan21.dnet.module.ad.workflow.lovs.ActDeployments);
 
