Ext.ns("net.nan21.dnet.module.hr.grade.lovs");
net.nan21.dnet.module.hr.grade.lovs.PayScalePoints = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.hr.grade.ds.model.PayScalePointLovDs		
				,_dataProviderName_:"PayScalePointLovDs"				 
				
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.hr.grade.lovs.PayScalePoints.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.hr.grade.lovs.PayScalePoints", net.nan21.dnet.module.hr.grade.lovs.PayScalePoints);
 
