   

Ext.define("net.nan21.dnet.module.ad.report.dc.ReportParamRt", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.report.ds.model.ReportParamRtDs",
	filterModel: "net.nan21.dnet.module.ad.report.ds.model.ReportParamRtDsFilter",
	paramModel: "net.nan21.dnet.module.ad.report.ds.param.ReportParamRtDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.ad.report.dc.ReportParamRt$TestRt", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.report.dc.ReportParamRt$TestRt",
	
	_noPaginator_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"parameterName", dataIndex:"parameterName",width:200 })
		.addTextColumn({ name:"value", dataIndex:"value",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
	  	.addDefaults()
	  ;  		   
	}  
	,_getCustomCellEditor_: function(record,column) {	
		
		var ed = null;
		 
		if ( record.data.noEdit ) {
	    	ed = new  Ext.form.field.Text({ readOnly:true });
	    }
		else if (!Ext.isEmpty(record.data.listOfValues)) {
	    	ed = new dnet.core.lov.LocalCombo({store:record.data.listOfValues.split(",")});
	    }
		else if (record.data.dataType == "integer" || record.data.dataType == "decimal") {
	    	ed = new Ext.form.field.Number({ });
	    }
	    else if (record.data.dataType == "date") {
	    	ed = new Ext.form.field.Date({});
	    }
	    else if (record.data.dataType == "boolean") {
	    	ed = new dnet.core.lov.LocalCombo({store:["true","false"]});
	    }
 
	    if(ed){
		    ed._dcView_ =  this;
	    }

	    return ed;
	    
	}
});
