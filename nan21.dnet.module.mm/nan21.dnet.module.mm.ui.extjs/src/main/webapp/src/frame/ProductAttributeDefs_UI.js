Dnet.import(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeCategoryDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttributeCategory", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeTypeDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttributeType", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttribute", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeGroupDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttributeGroup","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeCategory","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeType","nan21.dnet.module.bd.ui.extjs/ds/UomTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomType","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeCategory","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeType","nan21.dnet.module.bd.ui.extjs/ds/UomTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomType","nan21.dnet.module.mm.ui.extjs/asgn/AttrGroupsOfAttribute","nan21.dnet.module.mm.ui.extjs/asgn/AttributesOfAttrGroup"]);

Ext.ns("net.nan21.dnet.module.mm.md.frame");
net.nan21.dnet.module.mm.md.frame.ProductAttributeDefs_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.mm.md.frame.ProductAttributeDefs_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("categ", new net.nan21.dnet.module.mm.md.dc.ProductAttributeCategory({multiEdit:true}))
		.addDc("type", new net.nan21.dnet.module.mm.md.dc.ProductAttributeType({multiEdit:true}))
		.addDc("attr", new net.nan21.dnet.module.mm.md.dc.ProductAttribute({multiEdit:true}))
		.addDc("group", new net.nan21.dnet.module.mm.md.dc.ProductAttributeGroup({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {					
			
		this._mainViewName_  = "_main_with_toc_";
		this._getBuilder_()
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addPanel({ name:"_toc_",xtype: 'treepanel',collapsible: true, region:"west", title: 'Navigation',width: 250,autoScroll: true,split: true,rootVisible: false,loader: new Ext.tree.TreeLoader()
			,minWidth:150, maxWidth:500
			,root: new Ext.tree.AsyncTreeNode({expanded: true,
            children: [{ text:"Attributes", leaf: true , name:"canvas1"},{ text:"Attribute groups", leaf: true , name:"canvas2"},{ text:"Attribute types", leaf: true , name:"canvas3"},{ text:"Attribute categories", leaf: true , name:"canvas4"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		}); 
		this._getBuilder_()	
		.addButton({name:"btnAsgnGroups",text:"Groups", tooltip:"Add selected attribute to groups",disabled:true
			,handler: this.onBtnAsgnGroups,scope:this,stateManager:{name:"selected_one_clean", dc:"attr" }	})	
							 	
		.addButton({name:"btnAsgnAttrs",text:"Attributes", tooltip:"Add attributes to the selected group",disabled:true
			,handler: this.onBtnAsgnAttrs,scope:this,stateManager:{name:"selected_one_clean", dc:"group" }	})	
							 	
		.addDcFilterFormView("categ",{ name:"categFilter", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeCategory$Filter",height:40})	 
		.addDcView("categ",{ name:"categEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeCategory$EditList", frame:true})	 
		.addDcFilterFormView("type",{ name:"typeFilter", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeType$Filter",height:70})	 
		.addDcView("type",{ name:"typeEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeType$EditList", frame:true})	 
		.addDcFilterFormView("attr",{ name:"attrFilter", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttribute$Filter",height:70})	 
		.addDcView("attr",{ name:"attrEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttribute$EditList", frame:true,buttons:[ this._elems_.get("btnAsgnGroups") ]})	 
		.addDcFilterFormView("group",{ name:"groupFilter", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeGroup$Filter",height:40})	 
		.addDcView("group",{ name:"groupEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeGroup$EditList", frame:true,buttons:[ this._elems_.get("btnAsgnAttrs") ]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Attributes",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Attribute groups",header:false})  	 
		.addPanel({name: "canvas3", layout:"border", defaults:{split:true},title:"Attribute types",header:false})  	 
		.addPanel({name: "canvas4", layout:"border", defaults:{split:true},title:"Attribute categories",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2","canvas3","canvas4"]) 				 		
		.addChildrenTo("canvas1",["attrFilter","attrEditList"] ,["north","center"])	
		.addChildrenTo("canvas2",["groupFilter","groupEditList"] ,["north","center"])	
		.addChildrenTo("canvas3",["typeFilter","typeEditList"] ,["north","center"])	
		.addChildrenTo("canvas4",["categFilter","categEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvas1","tlbAttrEditList")	  	
	 	.addToolbarTo("canvas2","tlbGroupEditList")	  	
	 	.addToolbarTo("canvas3","tlbTypeEditList")	  	
	 	.addToolbarTo("canvas4","tlbCategEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAttrEditList", {dc:"attr"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbGroupEditList", {dc:"group"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbTypeEditList", {dc:"type"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbCategEditList", {dc:"categ"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}


	,onBtnAsgnGroups: function() {
		this.showAsgnWindow(net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Ui ,{dc:"attr",objectIdField:"id"});
	}					 	

	,onBtnAsgnAttrs: function() {
		this.showAsgnWindow(net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Ui ,{dc:"group",objectIdField:"id"});
	}					 	
});
Ext.reg("net.nan21.dnet.module.mm.md.frame.ProductAttributeDefs_UI", net.nan21.dnet.module.mm.md.frame.ProductAttributeDefs_UI);   
