Ext.ns("net.nan21.dnet.module.mm.md.lovs");
net.nan21.dnet.module.mm.md.lovs.ProductAttributeCategory = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.mm.md.ds.model.ProductAttributeCategoryLovDs		
				,_dataProviderName_:"ProductAttributeCategoryLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.md.frame.ProductAttributeDefs_UI",bundle:"nan21.dnet.module.mm.ui.extjs",tocElement: "canvasCateg"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.mm.md.lovs.ProductAttributeCategory.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.mm.md.lovs.ProductAttributeCategory", net.nan21.dnet.module.mm.md.lovs.ProductAttributeCategory);
 
