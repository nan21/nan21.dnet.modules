Ext.ns("net.nan21.dnet.module.bp.md.lovs");
net.nan21.dnet.module.bp.md.lovs.BpContacts = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.bp.md.ds.model.BpContactLovDs		
				,_dataProviderName_:"BpContactLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.md.frame.Contact_UI",bundle:"nan21.dnet.module.bp.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.bp.md.lovs.BpContacts.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.bp.md.lovs.BpContacts", net.nan21.dnet.module.bp.md.lovs.BpContacts);
 
