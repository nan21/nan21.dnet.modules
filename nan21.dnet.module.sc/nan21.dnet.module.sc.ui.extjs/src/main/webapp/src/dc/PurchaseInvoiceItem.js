   

Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItem", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemDs",
	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemDsFilter",
	paramModel: "net.nan21.dnet.module.sc.invoice.ds.param.PurchaseInvoiceItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 		 
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItem$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItem$CtxList",
	
	_noImport_: true,
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"productCode", dataIndex:"productCode",width:100 })   	
		.addTextColumn({ name:"productName", dataIndex:"productName",width:200 })   	
		.addNumberColumn({ name:"quantity", dataIndex:"quantity",decimals:2 })  
		.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"uomCode", dataIndex:"uomCode",width:100 })   	
		.addNumberColumn({ name:"netUnitPrice", dataIndex:"unitPrice",decimals:2 })  
		.addNumberColumn({ name:"netAmount", dataIndex:"netAmount",decimals:2 })  
		.addTextColumn({ name:"tax", dataIndex:"tax", hidden:true,width:120 })   	
		.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount",decimals:2 })  
		.addNumberColumn({ name:"lineAmount", dataIndex:"lineAmount",decimals:2 })  
		.addNumberColumn({ name:"purchaseInvoiceId", dataIndex:"purchaseInvoiceId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"taxId", dataIndex:"taxId", hidden:true,width:70 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItem$EditForm", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItem$EditForm",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"productCode", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductsWithUom", dataIndex:"productCode" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ,{lovField:"uom", dsField: "uomCode"} ,{lovField:"uomId", dsField: "uomId"} ]  })
		.addDisplayFieldText({ name:"productName", dataIndex:"productName"  })
		.addNumberField({ name:"quantity", dataIndex:"quantity" ,allowBlank:false , style: "text-align:right;" })
		.addLov({ name:"uomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"uomCode" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]  })
		.addCombo({ name:"entryMode", xtype:"localcombo", dataIndex:"entryMode" ,store:[ "price", "amount"],listeners:{change:{scope:this, fn:this._onEntryModeChange_}}  })
		.addNumberField({ name:"unitPrice", dataIndex:"unitPrice" ,listeners:{change:{scope:this, fn:this.calcNetAmount}} , style: "text-align:right;" })
		.addNumberField({ name:"docLineNetAmount", dataIndex:"netAmount"  , style: "text-align:right;" })
		.addNumberField({ name:"docLineTaxAmount", dataIndex:"taxAmount"  , style: "text-align:right;" })
		.addNumberField({ name:"docLineAmount", dataIndex:"lineAmount"  , style: "text-align:right;" })
		.addDisplayFieldNumber({name:"netAmount", dataIndex:"netAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"taxAmount", dataIndex:"taxAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"lineAmount", dataIndex:"lineAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addLov({ name:"tax", xtype:"net.nan21.dnet.module.md.base.tax.lovs.TaxApplicables", dataIndex:"tax" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "taxId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:400})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"col3", layout:"form" ,width:250})     
		.addPanel({ name:"col4", layout:"form" ,width:250})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		.addPanel({ name:"row1",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} }) 
		.addPanel({ name:"row2",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["row1" ,"row2" ])
		.addChildrenTo("row1",["col1" ,"col2" ])
		.addChildrenTo("col1",["productCode","productName","entryMode"])
		.addChildrenTo("col2",["netAmount","taxAmount","lineAmount"])
		.addChildrenTo("row2",["col3" ,"col4" ])
		.addChildrenTo("col3",["quantity","uomCode","tax"])
		.addChildrenTo("col4",["unitPrice","docLineNetAmount","docLineTaxAmount","docLineAmount"])
;
	}	
	,calcNetAmount: function() {	
		
		var r = this._controller_.record, mode=r.data.entryMode;
		
		if (mode == "price") {
			//r.beginEdit();
			r.set("netAmount", r.get("unitPrice")||0 * r.get("quantity")||0);
			r.set("taxAmount", "");
			r.set("lineAmount", "");
			//r.endEdit();
			return;
		}
	}
	,_onNetAmountChange_: function() {	
			
			var r = this._getController_().getRecord();		 	  
			r.set("taxAmount", "");	
			r.set("lineAmount", "");
			r.set("unitPrice", r.get("netAmount")||0 / r.get("quantity")||0);			  
		
	}
	,_onTaxAmountChange_: function() {	
				
			var r = this._getController_().getRecord();		   			
			r.set("lineAmount", "");			  
		
	}
	,_onLineAmountChange_: function() {	
		
			var r = this._getController_().getRecord();		  			
			r.set("netAmount", "");	
			r.set("taxAmount", "");		  
		
	}
	,_onEntryModeChange_: function() {	
		var r = this._getController_().getRecord(), mode=r.data.entryMode;
		this._doEnableEntryFields_(mode);
		r.beginEdit();
		r.set("unitPrice", "");		
		r.set("netAmount", "");
		r.set("taxAmount", "");
		r.set("lineAmount", "");
		r.endEdit();
		
	}
	,_doEnableEntryFields_: function(mode) {	
		
		if (mode == "price") {
			this._getElement_("unitPrice").enable();
			this._getElement_("docLineNetAmount").disable();
			this._getElement_("docLineTaxAmount").disable();
			this._getElement_("docLineAmount").disable();
			return;
		}  
		if (mode == "amount") {
			this._getElement_("unitPrice").disable();
			this._getElement_("docLineNetAmount").enable();
			this._getElement_("docLineTaxAmount").enable();
			this._getElement_("docLineAmount").enable();
			return;
		}
		 
		
	}
	,_afterBind_: function(record) {	
		if (record) {
			this._doEnableEntryFields_(record.data.entryMode);
		}
	}
});
 	
