Ext.ns("net.nan21.dnet.module.hr.training.lovs");
net.nan21.dnet.module.hr.training.lovs.CourseTypes = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.hr.training.ds.model.CourseTypeLovDs		
				,_dataProviderName_:"CourseTypeLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.training.frame.CourseType_UI",bundle:"nan21.dnet.module.hr.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.hr.training.lovs.CourseTypes.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.hr.training.lovs.CourseTypes", net.nan21.dnet.module.hr.training.lovs.CourseTypes);
 
