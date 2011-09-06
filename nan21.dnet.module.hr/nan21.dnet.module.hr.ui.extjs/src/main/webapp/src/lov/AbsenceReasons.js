Ext.ns("net.nan21.dnet.module.hr.time.lovs");
net.nan21.dnet.module.hr.time.lovs.AbsenceReasons = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.hr.time.ds.model.AbsenceReasonLovDs		
				,_dataProviderName_:"AbsenceReasonLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasReason"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.hr.time.lovs.AbsenceReasons.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.hr.time.lovs.AbsenceReasons", net.nan21.dnet.module.hr.time.lovs.AbsenceReasons);
 
