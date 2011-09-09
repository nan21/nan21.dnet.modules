Ext.ns("net.nan21.dnet.module.hr.payroll.lovs");
net.nan21.dnet.module.hr.payroll.lovs.ElementTypes = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.hr.payroll.ds.model.ElementTypeLovDs		
				,_dataProviderName_:"ElementTypeLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.payroll.frame.Element_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasType"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.hr.payroll.lovs.ElementTypes.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.hr.payroll.lovs.ElementTypes", net.nan21.dnet.module.hr.payroll.lovs.ElementTypes);
 
