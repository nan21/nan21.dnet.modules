Ext.ns("net.nan21.dnet.module.bp.md.lovs");
net.nan21.dnet.module.bp.md.lovs.BusinessPartners = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerLovDs		
				,_dataProviderName_:"BusinessPartnerLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.md.frame.BPartner_UI",bundle:"nan21.dnet.module.bp.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.bp.md.lovs.BusinessPartners.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.bp.md.lovs.BusinessPartners", net.nan21.dnet.module.bp.md.lovs.BusinessPartners);
 
