Ext.ns("net.nan21.dnet.module.bp.base.lovs");
net.nan21.dnet.module.bp.base.lovs.DeliveryMethods = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.bp.base.ds.model.DeliveryMethodLovDs		
				,_dataProviderName_:"DeliveryMethodLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI",bundle:"nan21.dnet.module.bp.ui.extjs",tocElement: "canvasDelivMtd"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.bp.base.lovs.DeliveryMethods.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.bp.base.lovs.DeliveryMethods", net.nan21.dnet.module.bp.base.lovs.DeliveryMethods);
 
