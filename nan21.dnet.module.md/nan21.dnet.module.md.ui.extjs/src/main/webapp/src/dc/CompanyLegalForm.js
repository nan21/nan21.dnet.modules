   

Ext.define("net.nan21.dnet.module.md.bp.dc.CompanyLegalForm", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.CompanyLegalFormDs",
	filterModel: "net.nan21.dnet.module.md.bp.ds.model.CompanyLegalFormDsFilter",
	paramModel: "net.nan21.dnet.module.md.bp.ds.param.CompanyLegalFormDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.bp.dc.CompanyLegalForm$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.bp.dc.CompanyLegalForm$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"country", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"country",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:170}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","country"])
		.addChildrenTo("col2",["active"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.bp.dc.CompanyLegalForm$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.bp.dc.CompanyLegalForm$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addLov({name:"country", xtype:"gridcolumn", dataIndex:"country",width:100,editor:{xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "countryId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"countryId", dataIndex:"countryId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
