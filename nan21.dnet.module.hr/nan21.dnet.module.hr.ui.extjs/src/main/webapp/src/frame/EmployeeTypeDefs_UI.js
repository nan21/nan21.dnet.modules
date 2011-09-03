Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/EducationTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/EducationType", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeContactRelationshipDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeContactRelationship", "nan21.dnet.module.hr.ui.extjs/ds/LicenseTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/LicenseType"]);

Ext.ns("net.nan21.dnet.module.hr.employee.frame");
net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("educType", new net.nan21.dnet.module.hr.employee.dc.EducationType({multiEdit:true}))
		.addDc("contactRel", new net.nan21.dnet.module.hr.employee.dc.EmployeeContactRelationship({multiEdit:true}))
		.addDc("licType", new net.nan21.dnet.module.hr.employee.dc.LicenseType({multiEdit:true}))		;		
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
            children: [{ text:"Edit list", leaf: true , name:"canvas1"},{ text:"Edit list", leaf: true , name:"canvas2"},{ text:"Edit list", leaf: true , name:"canvas3"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		}); 
		this._getBuilder_()	
		.addDcFilterFormView("educType",{ name:"educTypeFilter", xtype:"net.nan21.dnet.module.hr.employee.dc.EducationType$Filter"})	 
		.addDcView("educType",{ name:"educTypeEditList", xtype:"net.nan21.dnet.module.hr.employee.dc.EducationType$EditList", frame:true})	 
		.addDcFilterFormView("contactRel",{ name:"contactRelFilter", xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeContactRelationship$Filter"})	 
		.addDcView("contactRel",{ name:"contactRelEditList", xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeContactRelationship$EditList", frame:true})	 
		.addDcFilterFormView("licType",{ name:"licTypeFilter", xtype:"net.nan21.dnet.module.hr.employee.dc.LicenseType$Filter"})	 
		.addDcView("licType",{ name:"licTypeEditList", xtype:"net.nan21.dnet.module.hr.employee.dc.LicenseType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Edit list",header:false})  	 
		.addPanel({name: "canvas3", layout:"border", defaults:{split:true},title:"Edit list",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2","canvas3"]) 				 		
		.addChildrenTo("canvas1",["educTypeFilter","educTypeEditList"] ,["north","center"])	
		.addChildrenTo("canvas2",["contactRelFilter","contactRelEditList"] ,["north","center"])	
		.addChildrenTo("canvas3",["licTypeFilter","licTypeEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvas1","educTypeTlb")	  	
	 	.addToolbarTo("canvas2","contactRelTlb")	  	
	 	.addToolbarTo("canvas3","licTypeTlb")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("educTypeTlb", {dc:"educType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("contactRelTlb", {dc:"contactRel"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("licTypeTlb", {dc:"licType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI", net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI);   
