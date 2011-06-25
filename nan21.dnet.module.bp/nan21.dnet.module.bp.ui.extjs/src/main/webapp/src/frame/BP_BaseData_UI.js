Dnet.import(["", "nan21.dnet.module.bp.ui.extjs/ds/CustomerGroupDs", "nan21.dnet.module.bp.ui.extjs/dc/CustomerGroup", "nan21.dnet.module.bp.ui.extjs/ds/VendorGroupDs", "nan21.dnet.module.bp.ui.extjs/dc/VendorGroup", "nan21.dnet.module.bp.ui.extjs/ds/DeliveryMethodDs", "nan21.dnet.module.bp.ui.extjs/dc/DeliveryMethod", "nan21.dnet.module.bp.ui.extjs/ds/PaymentMethodDs", "nan21.dnet.module.bp.ui.extjs/dc/PaymentMethod", "nan21.dnet.module.bp.ui.extjs/ds/PaymentTermDs", "nan21.dnet.module.bp.ui.extjs/dc/PaymentTerm"]);

Ext.ns("net.nan21.dnet.module.bp.base.frame");
net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("custGroup", new net.nan21.dnet.module.bp.base.dc.CustomerGroup({multiEdit:true}))
		.addDc("vendGroup", new net.nan21.dnet.module.bp.base.dc.VendorGroup({multiEdit:true}))
		.addDc("delivMtd", new net.nan21.dnet.module.bp.base.dc.DeliveryMethod({multiEdit:true}))
		.addDc("payMtd", new net.nan21.dnet.module.bp.base.dc.PaymentMethod({multiEdit:true}))
		.addDc("payTerm", new net.nan21.dnet.module.bp.base.dc.PaymentTerm({multiEdit:true}))		;		
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
            children: [{ text:"Customer groups", leaf: true , name:"canvas1"},{ text:"Vendor groups", leaf: true , name:"canvas2"},{ text:"Delivery methods", leaf: true , name:"canvas3"},{ text:"Payment methods", leaf: true , name:"canvas4"},{ text:"Payment terms", leaf: true , name:"canvas5"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		}); 
		this._getBuilder_()	
		.addDcView("custGroup",{ name:"custGroupFilter", xtype:"net.nan21.dnet.module.bp.base.dc.CustomerGroup$Filter",height:40})	 
		.addDcView("custGroup",{ name:"custGroupEditList", xtype:"net.nan21.dnet.module.bp.base.dc.CustomerGroup$EditList", frame:true})	 
		.addDcView("vendGroup",{ name:"vendGroupFilter", xtype:"net.nan21.dnet.module.bp.base.dc.VendorGroup$Filter",height:40})	 
		.addDcView("vendGroup",{ name:"vendGroupEditList", xtype:"net.nan21.dnet.module.bp.base.dc.VendorGroup$EditList", frame:true})	 
		.addDcView("delivMtd",{ name:"delivMtdFilter", xtype:"net.nan21.dnet.module.bp.base.dc.DeliveryMethod$Filter",height:40})	 
		.addDcView("delivMtd",{ name:"delivMtdEditList", xtype:"net.nan21.dnet.module.bp.base.dc.DeliveryMethod$EditList", frame:true})	 
		.addDcView("payMtd",{ name:"payMtdFilter", xtype:"net.nan21.dnet.module.bp.base.dc.PaymentMethod$Filter",height:40})	 
		.addDcView("payMtd",{ name:"payMtdEditList", xtype:"net.nan21.dnet.module.bp.base.dc.PaymentMethod$EditList", frame:true})	 
		.addDcView("payTerm",{ name:"payTermFilter", xtype:"net.nan21.dnet.module.bp.base.dc.PaymentTerm$Filter",height:40})	 
		.addDcView("payTerm",{ name:"payTermEditList", xtype:"net.nan21.dnet.module.bp.base.dc.PaymentTerm$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Customer groups",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Vendor groups",header:false})  	 
		.addPanel({name: "canvas3", layout:"border", defaults:{split:true},title:"Delivery methods",header:false})  	 
		.addPanel({name: "canvas4", layout:"border", defaults:{split:true},title:"Payment methods",header:false})  	 
		.addPanel({name: "canvas5", layout:"border", defaults:{split:true},title:"Payment terms",header:false})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2","canvas3","canvas4","canvas5"]) 				 		
		.addChildrenTo("canvas1",["custGroupFilter","custGroupEditList"] ,["north","center"])	
		.addChildrenTo("canvas2",["vendGroupFilter","vendGroupEditList"] ,["north","center"])	
		.addChildrenTo("canvas3",["delivMtdFilter","delivMtdEditList"] ,["north","center"])	
		.addChildrenTo("canvas4",["payMtdFilter","payMtdEditList"] ,["north","center"])	
		.addChildrenTo("canvas5",["payTermFilter","payTermEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvas1","tlbcustGroup")	  	
	 	.addToolbarTo("canvas2","tlbvendGroup")	  	
	 	.addToolbarTo("canvas3","tlbdelivMtd")	  	
	 	.addToolbarTo("canvas4","tlbpayMtd")	  	
	 	.addToolbarTo("canvas5","tlbpayTerm")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbcustGroup", {dc:"custGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
		this._getBuilder_()
			.beginToolbar("tlbvendGroup", {dc:"vendGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
		this._getBuilder_()
			.beginToolbar("tlbdelivMtd", {dc:"delivMtd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
		this._getBuilder_()
			.beginToolbar("tlbpayMtd", {dc:"payMtd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
		this._getBuilder_()
			.beginToolbar("tlbpayTerm", {dc:"payTerm"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
	}

});
Ext.reg("net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI", net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI);   
