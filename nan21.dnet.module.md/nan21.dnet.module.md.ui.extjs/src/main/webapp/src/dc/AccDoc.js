   

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccDoc", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.fin.ds.model.AccDocDs",
	filterModel: "net.nan21.dnet.module.md.tx.fin.ds.model.AccDocDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.fin.ds.param.AccDocDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccDoc$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.fin.dc.AccDoc$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"accSchema", xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas", dataIndex:"accSchema",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]  })
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20",maxLength:255  })
		.addDateField({ name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
		.addDateField({ name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
		.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"}) 
		.addChildrenTo("docDate",["docDate_From", "docDate_To"]) 

		.addNumberField({ name:"dbAmount_From", dataIndex:"dbAmount_From", emptyText:"From" })
		.addNumberField({ name:"dbAmount_To", dataIndex:"dbAmount_To", emptyText:"To" })
		.addFieldContainer({name: "dbAmount", fieldLabel:"Db Amount"})  
		.addChildrenTo("dbAmount",["dbAmount_From", "dbAmount_To"]) 

		.addNumberField({ name:"crAmount_From", dataIndex:"crAmount_From", emptyText:"From" })
		.addNumberField({ name:"crAmount_To", dataIndex:"crAmount_To", emptyText:"To" })
		.addFieldContainer({name: "crAmount", fieldLabel:"Cr Amount"})  
		.addChildrenTo("crAmount",["crAmount_From", "crAmount_To"]) 

		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:290}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["org","accSchema","docNo"])
		.addChildrenTo("col2",["docDate","dbAmount","crAmount"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccDoc$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.dc.AccDoc$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"org", dataIndex:"org",width:100 })   	
		.addTextColumn({ name:"accSchema", dataIndex:"accSchema",width:100 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"docNo", dataIndex:"docNo",width:200 })   	
		.addTextColumn({ name:"docType", dataIndex:"docType",width:120 })   	
		.addNumberColumn({ name:"dbAmount", dataIndex:"dbAmount",decimals:2 })  
		.addNumberColumn({ name:"crAmount", dataIndex:"crAmount",decimals:2 })  
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccDoc$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.tx.fin.dc.AccDoc$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"accSchema", xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas", dataIndex:"accSchema",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]  })
		.addDateField({ name:"docDate", dataIndex:"docDate",anchor:"-20" })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:300})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["org"])
		.addChildrenTo("col2",["accSchema","docDate"])
;
	}	
});
 	
