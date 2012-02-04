   

Ext.define("net.nan21.dnet.module.ad.workflow.dc.WfDefNodeField", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeFieldDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeFieldDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.WfDefNodeFieldDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.ad.workflow.dc.WfDefNodeField$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.WfDefNodeField$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addComboColumn({ name:"type", dataIndex:"type", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv' ,store:[ "text", "number", "date"] , triggerAction:'all', forceSelection:true }})
		.addBooleanColumn({ name:"required", dataIndex:"required"})
		.addNumberColumn({ name:"nodeId", dataIndex:"nodeId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
