   

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
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org",anchor:"-20",allowBlank:false,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"accSchema", xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas", dataIndex:"accSchema",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]  })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.bd.tx.lovs.TxDocTypes", dataIndex:"docType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		.addLov({ name:"period", xtype:"net.nan21.dnet.module.bd.tx.lovs.FiscalPeriods", dataIndex:"period",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "periodId"} ]  })
		.addLov({ name:"journal", xtype:"net.nan21.dnet.module.bd.acc.lovs.AccJournals", dataIndex:"journal",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "journalId"} ]  })
		.addLov({ name:"bpartner", xtype:"net.nan21.dnet.module.md.bp.lovs.BusinessPartnersName", dataIndex:"bpartner",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "bpartnerId"} ]  })
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"posted", dataIndex:"posted",anchor:"-20"  })
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

		.addNumberField({ name:"docAmount_From", dataIndex:"docAmount_From", emptyText:"From" })
		.addNumberField({ name:"docAmount_To", dataIndex:"docAmount_To", emptyText:"To" })
		.addFieldContainer({name: "docAmount", fieldLabel:"Doc Amount"})  
		.addChildrenTo("docAmount",["docAmount_From", "docAmount_To"]) 

		.addNumberField({ name:"difference_From", dataIndex:"difference_From", emptyText:"From" })
		.addNumberField({ name:"difference_To", dataIndex:"difference_To", emptyText:"To" })
		.addFieldContainer({name: "difference", fieldLabel:"Difference"})  
		.addChildrenTo("difference",["difference_From", "difference_To"]) 

		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form", width:290}) 
		.addPanel({ name:"col4", layout:"form", width:290}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["org","accSchema","docNo","posted"])
		.addChildrenTo("col2",["period","journal","bpartner","docType"])
		.addChildrenTo("col3",["docDate","docAmount"])
		.addChildrenTo("col4",["dbAmount","crAmount","difference"])
    		
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccDoc$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.dc.AccDoc$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"org", dataIndex:"org", hidden:true,width:100 })   	
		.addTextColumn({ name:"accSchema", dataIndex:"accSchema", hidden:true,width:100 })   	
		.addTextColumn({ name:"period", dataIndex:"period", hidden:true,width:100 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate", width:80,format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80 })   	
		.addNumberColumn({ name:"docAmount", dataIndex:"docAmount",decimals:2, width:80 })  
		.addTextColumn({ name:"docCurrency", dataIndex:"docCurrency", width:80 })   	
		.addTextColumn({ name:"bpartner", dataIndex:"bpartner",width:200 })   	
		.addTextColumn({ name:"journal", dataIndex:"journal",width:120 })   	
		.addTextColumn({ name:"docType", dataIndex:"docType",width:120 })   	
		.addBooleanColumn({ name:"posted", dataIndex:"posted", width:60})   	     
		.addNumberColumn({ name:"dbAmount", dataIndex:"dbAmount", hidden:true,decimals:2, width:80 })  
		.addNumberColumn({ name:"crAmount", dataIndex:"crAmount", hidden:true,decimals:2, width:80 })  
		.addNumberColumn({ name:"difference", dataIndex:"difference", hidden:true,decimals:2, width:80 })  
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"bpartnerId", dataIndex:"bpartnerId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"periodId", dataIndex:"periodId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
