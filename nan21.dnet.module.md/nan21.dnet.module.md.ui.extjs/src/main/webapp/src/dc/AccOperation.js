   

Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccOperation", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccOperationDs",
	filterModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccOperationDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.acc.ds.param.AccOperationDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccOperation$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.acc.dc.AccOperation$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"dbAccount", dataIndex:"dbAccount",anchor:"-20",maxLength:255  })
		.addTextField({ name:"crAccount", dataIndex:"crAccount",anchor:"-20",maxLength:255  })
		.addDateField({ name:"eventDate_From", dataIndex:"eventDate_From", emptyText:"From" })
		.addDateField({ name:"eventDate_To", dataIndex:"eventDate_To", emptyText:"To" })
		.addFieldContainer({name: "eventDate", fieldLabel:"Event Date"}) 
		.addChildrenTo("eventDate",["eventDate_From", "eventDate_To"]) 

		.addNumberField({ name:"dbAmount_From", dataIndex:"dbAmount_From", emptyText:"From" })
		.addNumberField({ name:"dbAmount_To", dataIndex:"dbAmount_To", emptyText:"To" })
		.addFieldContainer({name: "dbAmount", fieldLabel:"Db Amount"})  
		.addChildrenTo("dbAmount",["dbAmount_From", "dbAmount_To"]) 

		.addNumberField({ name:"crAmount_From", dataIndex:"crAmount_From", emptyText:"From" })
		.addNumberField({ name:"crAmount_To", dataIndex:"crAmount_To", emptyText:"To" })
		.addFieldContainer({name: "crAmount", fieldLabel:"Cr Amount"})  
		.addChildrenTo("crAmount",["crAmount_From", "crAmount_To"]) 

		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org",anchor:"-20",allowBlank:false,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"accSchema", xtype:"net.nan21.dnet.module.md.acc.lovs.AccSchemas", dataIndex:"accSchema",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]  })
		.addLov({ name:"period", xtype:"net.nan21.dnet.module.md.base.period.lovs.FiscalPeriods", dataIndex:"period",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "periodId"} ]  })
		.addLov({ name:"bpartner", xtype:"net.nan21.dnet.module.md.bp.lovs.BusinessPartnersName", dataIndex:"bpartner",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "bpartnerId"} ]  })
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form", width:290}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["org","accSchema","period","bpartner"])
		.addChildrenTo("col2",["docNo","dbAccount","crAccount"])
		.addChildrenTo("col3",["eventDate","dbAmount","crAmount"])
    		
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccOperation$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.acc.dc.AccOperation$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"org", dataIndex:"org", width:80 })   	
		.addTextColumn({ name:"accSchema", dataIndex:"accSchema", width:80 })   	
		.addTextColumn({ name:"period", dataIndex:"period",width:100 })   	
		.addTextColumn({ name:"bpartner", dataIndex:"bpartner",width:200 })   	
		.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80 })   	
		.addDateColumn({ name:"eventDate", dataIndex:"eventDate", width:80,format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"dbAccount", dataIndex:"dbAccount", width:80 })   	
		.addTextColumn({ name:"crAccount", dataIndex:"crAccount", width:80 })   	
		.addNumberColumn({ name:"dbAmount", dataIndex:"dbAmount",decimals:2, width:80 })  
		.addNumberColumn({ name:"crAmount", dataIndex:"crAmount",decimals:2, width:80 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
