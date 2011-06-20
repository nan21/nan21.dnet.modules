Ext.ns("net.nan21.dnet.module.hr.payroll.lovs");
net.nan21.dnet.module.hr.payroll.lovs.Elements = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.hr.payroll.ds.model.ElementLovDs		
				,_dataProviderName_:"ElementLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.payroll.frame.Element_UI",bundle:"nan21.dnet.module.hr.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.hr.payroll.lovs.Elements.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.hr.payroll.lovs.Elements", net.nan21.dnet.module.hr.payroll.lovs.Elements);
 
