Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/CourseCategoryDs", "nan21.dnet.module.hr.ui.extjs/dc/CourseCategory", "nan21.dnet.module.hr.ui.extjs/ds/CourseTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/CourseType","nan21.dnet.module.hr.ui.extjs/ds/CourseTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/CourseTypes","nan21.dnet.module.hr.ui.extjs/ds/CourseTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/CourseTypes"]);

Ext.ns("net.nan21.dnet.module.hr.training.frame");
net.nan21.dnet.module.hr.training.frame.CourseType_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.training.frame.CourseType_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("ccateg", new net.nan21.dnet.module.hr.training.dc.CourseCategory({multiEdit:true}))
		.addDc("ctype", new net.nan21.dnet.module.hr.training.dc.CourseType({multiEdit:true}))		;		
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
            children: [{ text:"Course Categories", leaf: true , name:"canvasCategory"},{ text:"Course Types", leaf: true , name:"canvasType"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		}); 
		this._getBuilder_()	
		.addDcView("ccateg",{ name:"ccategFilter", xtype:"net.nan21.dnet.module.hr.training.dc.CourseCategory$Filter",height:35})	 
		.addDcView("ccateg",{ name:"ccategEditList", xtype:"net.nan21.dnet.module.hr.training.dc.CourseCategory$EditList", frame:true})	 
		.addDcView("ctype",{ name:"ctypeFilter", xtype:"net.nan21.dnet.module.hr.training.dc.CourseType$Filter",height:60})	 
		.addDcView("ctype",{ name:"ctypeEditList", xtype:"net.nan21.dnet.module.hr.training.dc.CourseType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCategory", layout:"border", defaults:{split:true},title:"Course Categories",header:false})  	 
		.addPanel({name: "canvasType", layout:"border", defaults:{split:true},title:"Course Types",header:false})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasCategory","canvasType"]) 				 		
		.addChildrenTo("canvasCategory",["ccategFilter","ccategEditList"] ,["north","center"])	
		.addChildrenTo("canvasType",["ctypeFilter","ctypeEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasCategory","tlbCcategEditList")	  	
	 	.addToolbarTo("canvasType","tlbCtypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCcategEditList", {dc:"ccateg"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
		this._getBuilder_()
			.beginToolbar("tlbCtypeEditList", {dc:"ctype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
	}

});
Ext.reg("net.nan21.dnet.module.hr.training.frame.CourseType_UI", net.nan21.dnet.module.hr.training.frame.CourseType_UI);   
