   

Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.fi.asset.ds.model.AssetDs",
	filterModel: "net.nan21.dnet.module.fi.asset.ds.model.AssetDsFilter",
	paramModel: "net.nan21.dnet.module.fi.asset.ds.param.AssetDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.fi.asset.dc.Asset$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"category", xtype:"net.nan21.dnet.module.fi.asset.lovs.AssetCategories", dataIndex:"category",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]  })
		.addLov({ name:"productCode", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.Products", dataIndex:"productCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"col3", layout:"form", width:170}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["org","category","productCode"])
		.addChildrenTo("col3",["active"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.fi.asset.dc.Asset$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"org", dataIndex:"org",width:100 })   	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"category", dataIndex:"category",width:100 })   	
		.addTextColumn({ name:"productCode", dataIndex:"productCode",width:100 })   	
		.addTextColumn({ name:"productName", dataIndex:"productName", hidden:true,width:200 })   	
		.addTextColumn({ name:"method", dataIndex:"method", hidden:true,width:60 })   	
		.addTextColumn({ name:"calculation", dataIndex:"calculation", hidden:true,width:60 })   	
		.addTextColumn({ name:"periodType", dataIndex:"periodType",width:60 })   	
		.addNumberColumn({ name:"periodValue", dataIndex:"periodValue" })  
		.addNumberColumn({ name:"periodPercenatge", dataIndex:"periodPercenatge" })  
		.addNumberColumn({ name:"initialValue", dataIndex:"initialValue",decimals:2 })  
		.addNumberColumn({ name:"residualValue", dataIndex:"residualValue",decimals:2 })  
		.addNumberColumn({ name:"depreciationAmount", dataIndex:"depreciationAmount",decimals:2 })  
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200 })   	
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"categoryId", dataIndex:"categoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.fi.asset.dc.Asset$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name" ,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code" ,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:80   })
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"category", xtype:"net.nan21.dnet.module.fi.asset.lovs.AssetCategories", dataIndex:"category" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]  })
		.addLov({ name:"productCode", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.Products", dataIndex:"productCode" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ]  })
		.addDisplayFieldText({ name:"productName", dataIndex:"productName"  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:300})     
		.addPanel({ name:"col3", layout:"form" , width:300, defaults:{
labelAlign:"top",labelWidth:70}})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["name","code","org"])
		.addChildrenTo("col2",["category","productCode","productName"])
		.addChildrenTo("col3",["notes"])
;
	}	
});
 	
 	

Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset$EditDeprec", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.fi.asset.dc.Asset$EditDeprec",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addCheckbox({ name:"withDepreciation", dataIndex:"withDepreciation",listeners:{change:{scope:this, fn:this.onWithDepreciationChange}}  })
		.addCombo({ name:"method", xtype:"localcombo", dataIndex:"method" ,store:[ "linear"]  })
		.addCombo({ name:"calculation", xtype:"localcombo", dataIndex:"calculation" ,store:[ "percentage", "time"],listeners:{change:{scope:this, fn:this.onCalculationChange}}  })
		.addCombo({ name:"periodType", xtype:"localcombo", dataIndex:"periodType" ,store:[ "month", "year"]  })
		.addNumberField({ name:"periodValue", dataIndex:"periodValue" ,_enableFn_: function(dc,r) {return (r.data.calculation == 'time');} , style: "text-align:right;" })
		.addNumberField({ name:"periodPercenatge", dataIndex:"periodPercenatge" ,_enableFn_: function(dc,r) {return (r.data.calculation == 'percentage');} , style: "text-align:right;" })
		.addDateField({ name:"purchaseDate", dataIndex:"purchaseDate" })
		.addDateField({ name:"deprecStartDate", dataIndex:"deprecStartDate" })
		.addDisplayFieldDate({name:"deprecEndDate", dataIndex:"deprecEndDate"  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addNumberField({ name:"initialValue", dataIndex:"initialValue"  , style: "text-align:right;" })
		.addNumberField({ name:"residualValue", dataIndex:"residualValue"  , style: "text-align:right;" })
		.addDisplayFieldNumber({name:"depreciationAmount", dataIndex:"depreciationAmount",decimals:2  })
		.addNumberField({ name:"initialDeprecAmount", dataIndex:"initialDeprecAmount"  , style: "text-align:right;" })
		//containers
		.addPanel({ name:"col1", layout:"form" ,width:250})     
		.addPanel({ name:"col2", layout:"form" , width:250})     
		.addPanel({ name:"col3", layout:"form" , width:250})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["withDepreciation","purchaseDate","deprecStartDate","deprecEndDate"])
		.addChildrenTo("col2",["method","calculation","periodType","periodValue","periodPercenatge"])
		.addChildrenTo("col3",["currency","initialValue","residualValue","initialDeprecAmount","depreciationAmount"])
;
	}	
	,onWithDepreciationChange: function() {	
		var r = this._getController_().getRecord();		 
			if ( ! r.get("withDepreciation") ) {
				this._disableAllFields_();
				this._getElement_("withDepreciation").enable();				 
			} else {
				this._enableAllFields_();
				this._setFieldsEnabledState_(["periodPercenatge","periodValue" ], r);
			}
		
	}
	,_beforeApplyStates_: function(r) {	
		
			if ( ! r.get("withDepreciation") ) {
				this._disableAllFields_();
				this._getElement_("withDepreciation").enable();
				return false;
			}
	}
	,onCalculationChange: function() {	
		var r = this._getController_().getRecord();		 
		this._setFieldsEnabledState_(["periodPercenatge","periodValue" ], r);
	}
});
 	
