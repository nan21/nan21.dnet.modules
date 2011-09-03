Ext.ns("net.nan21.dnet.module.bd.uom.lovs");
net.nan21.dnet.module.bd.uom.lovs.UomType = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.bd.uom.ds.model.UomTypeLovDs		
				,_dataProviderName_:"UomTypeLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.uom.frame.UomType_UI",bundle:"nan21.dnet.module.bd.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.bd.uom.lovs.UomType.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.bd.uom.lovs.UomType", net.nan21.dnet.module.bd.uom.lovs.UomType);
 
