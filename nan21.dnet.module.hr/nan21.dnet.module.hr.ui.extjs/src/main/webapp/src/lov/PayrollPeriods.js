Ext.ns("net.nan21.dnet.module.hr.payroll.lovs");
net.nan21.dnet.module.hr.payroll.lovs.PayrollPeriods = Ext.extend( dnet.base.AbstractCombo, {	
	 initComponent : function(){
		Ext.apply(
		    this, {
                 mode: "remote"
				,displayField:"name"
				,triggerAction :"query"
				,pageSize:30
				,autoSelect:true
				,listWidth:250 
				,tpl: '<tpl for="."><div class="x-combo-list-item"><div style="">{name}</div><div style="padding-left:30px;">{startDate}</div><div style="padding-left:30px;">{endDate}</div></div></tpl>'
				,minChars:0	
				,_dataProviderFields_: 	net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodLovDs		
				,_dataProviderName_:"PayrollPeriodLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.payroll.frame.Payroll_UI",bundle:"nan21.dnet.module.hr.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.hr.payroll.lovs.PayrollPeriods.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.hr.payroll.lovs.PayrollPeriods", net.nan21.dnet.module.hr.payroll.lovs.PayrollPeriods);
 
