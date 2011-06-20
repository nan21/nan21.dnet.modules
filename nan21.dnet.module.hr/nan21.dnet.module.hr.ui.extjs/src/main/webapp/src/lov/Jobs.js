Ext.ns("net.nan21.dnet.module.hr.job.lovs");
net.nan21.dnet.module.hr.job.lovs.Jobs = Ext.extend( dnet.base.AbstractCombo, {	
	 initComponent : function(){
		Ext.apply(
		    this, {
                 mode: "remote"
				,displayField:"code"
				,triggerAction :"query"
				,pageSize:30
				,autoSelect:true
				,listWidth:250 
				,tpl: '<tpl for="."><div class="x-combo-list-item"><div style="">{code}</div><div style="padding-left:30px;">{name}</div></div></tpl>'
				,minChars:0	
				,_dataProviderFields_: 	net.nan21.dnet.module.hr.job.ds.model.JobLovDs		
				,_dataProviderName_:"JobLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.job.frame.Job_UI",bundle:"nan21.dnet.module.hr.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.hr.job.lovs.Jobs.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.hr.job.lovs.Jobs", net.nan21.dnet.module.hr.job.lovs.Jobs);
 
