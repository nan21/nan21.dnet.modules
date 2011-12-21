   

Ext.define("net.nan21.dnet.module.ad.usr.dc.MyUserSettings", {
	extend: "dnet.base.AbstractDc",
 
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
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.MyUserSettings$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextField({ name:"notes", dataIndex:"notes",anchor:"-20" ,maxLength:4000  })
		.addCombo({ name:"decimalSeparator", xtype:"localcombo", dataIndex:"decimalSeparator",anchor:"-20" ,store:[ ".", ","]  })
		.addCombo({ name:"thousandSeparator", xtype:"localcombo", dataIndex:"thousandSeparator",anchor:"-20" ,store:[ ".", ","]  })
		.addLov({ name:"dateFormat", xtype:"net.nan21.dnet.module.ad.system.lovs.SysDateFormats", dataIndex:"dateFormat",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "dateFormatId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" ,title:"Regional settings", width:300,xtype:"fieldset", border:false, collapsible:true})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ])
		.addChildrenTo("col1",["dateFormat","decimalSeparator","thousandSeparator"])
;
	}	
});
