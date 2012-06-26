   

Ext.define("net.nan21.dnet.module.ad.usr.dc.MyUserSettings", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.MyUserSettingsDs",
	filterModel: "net.nan21.dnet.module.ad.usr.ds.model.MyUserSettingsDsFilter",
	paramModel: "net.nan21.dnet.module.ad.usr.ds.param.MyUserSettingsDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.MyUserSettings$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.MyUserSettings$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name" ,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code" ,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextField({ name:"notes", dataIndex:"notes" ,maxLength:4000  })
		.addCombo({ name:"decimalSeparator", xtype:"localcombo", dataIndex:"decimalSeparator" ,store:[ ".", ","]  })
		.addCombo({ name:"thousandSeparator", xtype:"localcombo", dataIndex:"thousandSeparator" ,store:[ ".", ","]  })
		.addLov({ name:"dateFormat", xtype:"net.nan21.dnet.module.ad.system.lovs.SysDateFormats", dataIndex:"dateFormat" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "dateFormatId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" ,title:"Regional settings", width:300,xtype:"fieldset", border:true, collapsible:true})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ])
		.addChildrenTo("col1",["dateFormat","decimalSeparator","thousandSeparator"])
;
	}	
});
 	
