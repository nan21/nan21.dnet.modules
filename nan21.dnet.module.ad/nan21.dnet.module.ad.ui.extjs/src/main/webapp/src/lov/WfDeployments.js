Ext.ns("net.nan21.dnet.module.ad.workflow.lovs");
net.nan21.dnet.module.ad.workflow.lovs.WfDeployments = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.ad.workflow.ds.model.WfDeploymentDs		
				,_dataProviderName_:"WfDeploymentDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.workflow.frame.Workflow_UI",bundle:"nan21.dnet.module.ad.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.ad.workflow.lovs.WfDeployments.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.lovs.WfDeployments", net.nan21.dnet.module.ad.workflow.lovs.WfDeployments);
 
