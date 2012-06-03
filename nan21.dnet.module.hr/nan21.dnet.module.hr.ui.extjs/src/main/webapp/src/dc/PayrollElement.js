   

Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElement", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementDs",
	filterModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementDsFilter",
	paramModel: "net.nan21.dnet.module.hr.payroll.ds.param.PayrollElementDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElement$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.PayrollElement$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addCombo({ name:"dataType", xtype:"combo", dataIndex:"dataType",anchor:"-20",store:[ "string", "number", "boolean", "date"]  })
		.addCombo({ name:"calculation", xtype:"combo", dataIndex:"calculation",anchor:"-20",store:[ "manual", "formula"]  })
		.addCombo({ name:"balanceFunction", xtype:"combo", dataIndex:"balanceFunction",anchor:"-20",store:[ "sum", "count", "avg"]  })
		.addLov({ name:"engine", xtype:"net.nan21.dnet.module.bd.elem.lovs.Engines", dataIndex:"engine",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "engineId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ],filterFieldMapping: [{lovField:"engineId", dsField: "engineId"} ]  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addBooleanField({ name:"balance", dataIndex:"balance",anchor:"-20"  })
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
		.addChildrenTo("col2",["engine","type","dataType"])
		.addChildrenTo("col3",["balance","active"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElement$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.payroll.dc.PayrollElement$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"engine", dataIndex:"engine",width:120 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addBooleanColumn({ name:"balance", dataIndex:"balance", width:70})   	     
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", width:70 })  
		.addTextColumn({ name:"dataType", dataIndex:"dataType", width:80 })   	
		.addTextColumn({ name:"calculation", dataIndex:"calculation", width:80 })   	
		.addTextColumn({ name:"balanceFunction", dataIndex:"balanceFunction",width:100 })   	
		.addTextColumn({ name:"sourceElement", dataIndex:"sourceElement",width:100 })   	
		.addTextColumn({ name:"accItem", dataIndex:"accItem",width:120 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active", width:70})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElement$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.PayrollElement$EditList",
	
	_bulkEditFields_ : ["calculation","engine","type","dataType","active"],
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"engine", xtype:"gridcolumn", dataIndex:"engine",width:120,editor:{xtype:"net.nan21.dnet.module.bd.elem.lovs.Engines" , selectOnFocus:true,allowBlank:false ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "engineId"} ]} })
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true,allowBlank:false ,maxLength:32} })
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true,allowBlank:false } })
		.addLov({name:"type", xtype:"gridcolumn", dataIndex:"type",width:120,editor:{xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementTypes" , selectOnFocus:true,allowBlank:false ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ],filterFieldMapping: [{lovField:"engineId", dsField: "engineId"} ]} })
		.addBooleanColumn({ name:"balance", dataIndex:"balance", width:70})
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addComboColumn({ name:"dataType", dataIndex:"dataType", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true 	, valueField: 'bv', displayField: 'tv' ,store:[ "string", "number", "boolean", "date"] , triggerAction:'all', forceSelection:true }})
		.addComboColumn({ name:"calculation", dataIndex:"calculation", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true 	, valueField: 'bv', displayField: 'tv' ,store:[ "manual", "formula"] , triggerAction:'all', forceSelection:true }})
		.addComboColumn({ name:"balanceFunction", dataIndex:"balanceFunction", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true 	, valueField: 'bv', displayField: 'tv' ,store:[ "sum", "count", "avg"] , triggerAction:'all', forceSelection:true }})
		.addLov({name:"sourceElement", xtype:"gridcolumn", dataIndex:"sourceElement",width:100,editor:{xtype:"net.nan21.dnet.module.hr.payroll.lovs.PayrollElementsSource" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "sourceElementId"} ],filterFieldMapping: [{lovField:"engineId", dsField: "engineId"} ]} })
		.addLov({name:"accItem", xtype:"gridcolumn", dataIndex:"accItem",width:120,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.AccItems" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accItemId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active", width:70})
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200,editor:{xtype:"textfield", selectOnFocus:true } })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElement$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.PayrollElement$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32  })
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addNumberField({ name:"sequenceNo", dataIndex:"sequenceNo",anchor:"-20"  , style: "text-align:right;" })
		.addCombo({ name:"calculation", xtype:"localcombo", dataIndex:"calculation",anchor:"-20" ,store:[ "manual", "formula"]  })
		.addCombo({ name:"balanceFunction", xtype:"localcombo", dataIndex:"balanceFunction",anchor:"-20" ,store:[ "sum", "count", "avg"]  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addCheckbox({ name:"balance", dataIndex:"balance",listeners:{change:{scope:this, fn:this.onBalanceChange}}  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:80,anchor:"-20"   })
		.addCombo({ name:"dataType", xtype:"localcombo", dataIndex:"dataType",anchor:"-20" ,allowBlank:false,store:[ "string", "number", "boolean", "date"]  })
		.addLov({ name:"engine", xtype:"net.nan21.dnet.module.bd.elem.lovs.Engines", dataIndex:"engine",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "engineId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementTypes", dataIndex:"type",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ],filterFieldMapping: [{lovField:"engineId", dsField: "engineId"} ]  })
		.addLov({ name:"accItem", xtype:"net.nan21.dnet.module.md.acc.lovs.AccItems", dataIndex:"accItem",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accItemId"} ]  })
		.addLov({ name:"sourceElement", xtype:"net.nan21.dnet.module.hr.payroll.lovs.PayrollElementsSource", dataIndex:"sourceElement",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "sourceElementId"} ],filterFieldMapping: [{lovField:"engineId", dsField: "engineId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:350})     
		.addPanel({ name:"colStack_1", layout:"form" ,width:250})     
		.addPanel({ name:"colStack_2", layout:"form" ,width:250})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		.addPanel({ name:"colStack", layout:"card", activeItem:0  })     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"colStack" ])
		.addChildrenTo("col1",["name","code","engine","type","dataType"])
		.addChildrenTo("col2",["notes","active","balance"])
		.addChildrenTo("colStack",["colStack_1" ,"colStack_2" ])
		.addChildrenTo("colStack_1",["sequenceNo","calculation"])
		.addChildrenTo("colStack_2",["balanceFunction","sourceElement","accItem"])
;
	}	
	,onBalanceChange: function() {	
		var r = this._getController_().getRecord();
		if (r.get("balance")) {
			r.set("calculation", "");            
		} else {
            r.set("balanceFunction", "");             
		}
		this._doSwitchViews_(r.data.balance);
	}
	,_doSwitchViews_: function(balance) {	
		if (balance) {
			this._showStackedViewElement_("colStack",1);			 
		} else {
			this._showStackedViewElement_("colStack",0);	 
		}
	}
	,_afterBind_: function(record) {	
		if (record) {
			this._doSwitchViews_(record.data.balance);
		}
	}
});
 	
