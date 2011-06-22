Ext.ns("net.nan21.dnet.module.ad.workflow.lovs");
net.nan21.dnet.module.ad.workflow.lovs.WfDefNodeTypes = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeTypeLovDs		
				,_dataProviderName_:"WfDefNodeTypeLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.workflow.frame.WfDefNodeType_UI",bundle:"nan21.dnet.module.ad.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.ad.workflow.lovs.WfDefNodeTypes.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.lovs.WfDefNodeTypes", net.nan21.dnet.module.ad.workflow.lovs.WfDefNodeTypes);
 
