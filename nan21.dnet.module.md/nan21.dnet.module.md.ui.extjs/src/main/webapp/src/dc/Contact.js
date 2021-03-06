   

Ext.define("net.nan21.dnet.module.md.bp.dc.Contact", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.ContactDs",
	filterModel: "net.nan21.dnet.module.md.bp.ds.model.ContactDsFilter",
	paramModel: "net.nan21.dnet.module.md.bp.ds.param.ContactDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.bp.dc.Contact$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.bp.dc.Contact$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20",maxLength:255  })
		.addLov({ name:"bpartnerCode", xtype:"net.nan21.dnet.module.md.bp.lovs.BusinessPartnersCode", dataIndex:"bpartnerCode",anchor:"-20",maxLength:32,retFieldMapping: []  })
		.addCombo({ name:"gender", xtype:"combo", dataIndex:"gender",anchor:"-20",store:[ "male", "female"]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:220}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["firstName","lastName"])
		.addChildrenTo("col2",["bpartnerCode","gender"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.bp.dc.Contact$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.bp.dc.Contact$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"firstName", dataIndex:"firstName", width:120 })   	
		.addTextColumn({ name:"lastName", dataIndex:"lastName", width:120 })   	
		.addNumberColumn({ name:"bpartnerId", dataIndex:"bpartnerId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"bpartnerCode", dataIndex:"bpartnerCode",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"gender", dataIndex:"gender",width:60 })   	
		.addTextColumn({ name:"position", dataIndex:"position",width:200 })   	
		.addDateColumn({ name:"birthdate", dataIndex:"birthdate",format:Dnet.DATE_FORMAT})   	      	     
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.bp.dc.Contact$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.bp.dc.Contact$CtxEditList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"firstName", dataIndex:"firstName", width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"lastName", dataIndex:"lastName", width:120,editor:{xtype:"textfield", selectOnFocus:true,allowBlank:false } })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addComboColumn({ name:"gender", dataIndex:"gender", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true 	, valueField: 'bv', displayField: 'tv' ,store:[ "male", "female"] , triggerAction:'all', forceSelection:true }})
		.addTextColumn({ name:"position", dataIndex:"position",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addDateColumn({ name:"birthdate", dataIndex:"birthdate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.md.bp.dc.Contact$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.bp.dc.Contact$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"firstName", dataIndex:"firstName" ,maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName" ,allowBlank:false,maxLength:255  })
		.addCombo({ name:"gender", xtype:"localcombo", dataIndex:"gender" ,store:[ "male", "female"]  })
		.addTextField({ name:"position", dataIndex:"position" ,maxLength:255  })
		.addDateField({ name:"birthdate", dataIndex:"birthdate" })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addLov({ name:"bpartnerCode", xtype:"net.nan21.dnet.module.md.bp.lovs.BusinessPartnersCode", dataIndex:"bpartnerCode" ,maxLength:32,retFieldMapping: []  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:250})     
		.addPanel({ name:"col3", layout:"form" , width:300})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["firstName","lastName","active"])
		.addChildrenTo("col2",["gender","birthdate"])
		.addChildrenTo("col3",["bpartnerCode","position"])
;
	}	
});
 	
