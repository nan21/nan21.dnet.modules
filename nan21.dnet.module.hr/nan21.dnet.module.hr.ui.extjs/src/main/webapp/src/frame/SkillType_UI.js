Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/SkillCategoryDs", "nan21.dnet.module.hr.ui.extjs/dc/SkillCategory", "nan21.dnet.module.hr.ui.extjs/ds/SkillTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/SkillType","nan21.dnet.module.hr.ui.extjs/ds/SkillCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/SkillCategories","nan21.dnet.module.hr.ui.extjs/ds/SkillCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/SkillCategories"]);

Ext.ns("net.nan21.dnet.module.hr.skill.frame");
net.nan21.dnet.module.hr.skill.frame.SkillType_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.skill.frame.SkillType_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("scateg", new net.nan21.dnet.module.hr.skill.dc.SkillCategory({multiEdit:true}))
		.addDc("stype", new net.nan21.dnet.module.hr.skill.dc.SkillType({multiEdit:true}))		;		
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
            children: [{ text:"Categories", leaf: true , name:"canvasCateg"},{ text:"Types", leaf: true , name:"canvasType"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		}); 
		this._getBuilder_()	
		.addDcView("scateg",{ name:"scategFilter", xtype:"net.nan21.dnet.module.hr.skill.dc.SkillCategory$Filter",height:35})	 
		.addDcView("scateg",{ name:"scategEditList", xtype:"net.nan21.dnet.module.hr.skill.dc.SkillCategory$EditList", frame:true})	 
		.addDcView("stype",{ name:"stypeFilter", xtype:"net.nan21.dnet.module.hr.skill.dc.SkillType$Filter",height:60})	 
		.addDcView("stype",{ name:"stypeEditList", xtype:"net.nan21.dnet.module.hr.skill.dc.SkillType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCateg", layout:"border", defaults:{split:true},title:"Categories",header:false})  	 
		.addPanel({name: "canvasType", layout:"border", defaults:{split:true},title:"Types",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasCateg","canvasType"]) 				 		
		.addChildrenTo("canvasCateg",["scategFilter","scategEditList"] ,["north","center"])	
		.addChildrenTo("canvasType",["stypeFilter","stypeEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasCateg","tlbscateg")	  	
	 	.addToolbarTo("canvasType","tlbstype")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbscateg", {dc:"scateg"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbstype", {dc:"stype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.hr.skill.frame.SkillType_UI", net.nan21.dnet.module.hr.skill.frame.SkillType_UI);   
