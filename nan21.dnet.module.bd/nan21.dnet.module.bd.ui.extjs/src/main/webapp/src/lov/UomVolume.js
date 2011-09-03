Ext.ns("net.nan21.dnet.module.bd.uom.lovs");
net.nan21.dnet.module.bd.uom.lovs.UomVolume = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.bd.uom.ds.model.UomVolumeLovDs		
				,_dataProviderName_:"UomVolumeLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.uom.frame.UomMD_UI",bundle:"nan21.dnet.module.bd.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.bd.uom.lovs.UomVolume.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.bd.uom.lovs.UomVolume", net.nan21.dnet.module.bd.uom.lovs.UomVolume);
 
