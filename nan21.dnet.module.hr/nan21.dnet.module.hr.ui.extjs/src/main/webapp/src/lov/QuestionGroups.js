Ext.ns("net.nan21.dnet.module.hr.grade.lovs");
net.nan21.dnet.module.hr.grade.lovs.QuestionGroups = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.null.model.nullDs		
				,_dataProviderName_:"nullDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.null.null",bundle:"nan21.dnet.module.null.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.hr.grade.lovs.QuestionGroups.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.hr.grade.lovs.QuestionGroups", net.nan21.dnet.module.hr.grade.lovs.QuestionGroups);
 
