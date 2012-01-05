   

Ext.define("net.nan21.dnet.module.bp.calendar.dc.CalendarEventPriority", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventPriorityDs",
	filterModel: "net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventPriorityDsFilter",
	paramModel: "net.nan21.dnet.module.bp.calendar.ds.param.CalendarEventPriorityDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.bp.calendar.dc.CalendarEventPriority$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bp.calendar.dc.CalendarEventPriority$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addCombo({ name:"eventType", xtype:"combo", dataIndex:"eventType",anchor:"-20",store:[ "call", "meeting", "task"]  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["name","eventType","active"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.bp.calendar.dc.CalendarEventPriority$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bp.calendar.dc.CalendarEventPriority$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addComboColumn({ name:"eventType", dataIndex:"eventType", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv' ,store:[ "call", "meeting", "task"] , triggerAction:'all', forceSelection:true }})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
