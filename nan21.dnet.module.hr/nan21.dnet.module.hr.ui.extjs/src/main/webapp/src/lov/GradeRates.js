Ext.ns("net.nan21.dnet.module.hr.grade.lovs");
net.nan21.dnet.module.hr.grade.lovs.GradeRates = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.hr.grade.ds.model.GradeRateLovDs		
				,_dataProviderName_:"GradeRateLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.grade.frame.GradeRate_UI",bundle:"nan21.dnet.module.hr.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.hr.grade.lovs.GradeRates.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.hr.grade.lovs.GradeRates", net.nan21.dnet.module.hr.grade.lovs.GradeRates);
 
