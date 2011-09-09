Ext.ns("net.nan21.dnet.module.hr.job.lovs");
net.nan21.dnet.module.hr.job.lovs.WorkRequirementTypes = Ext.extend( dnet.base.AbstractCombo, {	
	 initComponent : function(){
		Ext.apply(
		    this, {
                 mode: "remote"
				,displayField:"name"
				,triggerAction :"query"
				,pageSize:30
				,autoSelect:true
				,listWidth:250 
				,tpl: '<tpl for="."><div class="x-combo-list-item"><div style="">{name}</div></div></tpl>'
				,minChars:0	
				,_dataProviderFields_: 	net.nan21.dnet.module.hr.job.ds.model.WorkRequirementTypeLovDs		
				,_dataProviderName_:"WorkRequirementTypeLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.job.frame.JobBaseDataDef_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasWrType"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.hr.job.lovs.WorkRequirementTypes.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.hr.job.lovs.WorkRequirementTypes", net.nan21.dnet.module.hr.job.lovs.WorkRequirementTypes);
 
