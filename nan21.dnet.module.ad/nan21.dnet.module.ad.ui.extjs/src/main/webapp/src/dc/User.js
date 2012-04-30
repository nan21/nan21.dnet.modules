   

Ext.define("net.nan21.dnet.module.ad.usr.dc.User", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.UserDs",
	filterModel: "net.nan21.dnet.module.ad.usr.ds.model.UserDsFilter",
	paramModel: "net.nan21.dnet.module.ad.usr.ds.param.UserDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.User$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.usr.dc.User$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addLov({ name:"accountType", xtype:"net.nan21.dnet.module.ad.usr.lovs.UserTypes", dataIndex:"accountType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accountTypeId"} ]  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addBooleanField({ name:"locked", dataIndex:"locked",anchor:"-20"  })
		.addLov({ name:"withRole", xtype:"net.nan21.dnet.module.ad.usr.lovs.Roles", paramIndex:"withRole",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "withRoleId"} ]  })
		.addLov({ name:"inGroup", xtype:"net.nan21.dnet.module.ad.usr.lovs.UserGroups", paramIndex:"inGroup",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "inGroupId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code","active","locked"])
		.addChildrenTo("col2",["accountType","withRole","inGroup"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.ad.usr.dc.User$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.usr.dc.User$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addBooleanColumn({ name:"locked", dataIndex:"locked"})   	     
		.addTextColumn({ name:"accountType", dataIndex:"accountType",width:120 })   	
		.addTextColumn({ name:"decimalSeparator", dataIndex:"decimalSeparator", hidden:true,width:50 })   	
		.addTextColumn({ name:"thousandSeparator", dataIndex:"thousandSeparator", hidden:true,width:50 })   	
		.addTextColumn({ name:"dateFormat", dataIndex:"dateFormat", hidden:true,width:120 })   	
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.User$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.User$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,noUpdate:true ,allowBlank:false,maxLength:32  })
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addLov({ name:"accountType", xtype:"net.nan21.dnet.module.ad.usr.lovs.UserTypes", dataIndex:"accountType",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accountTypeId"} ]  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addCheckbox({ name:"locked", dataIndex:"locked"  })
		.addCombo({ name:"decimalSeparator", xtype:"localcombo", dataIndex:"decimalSeparator",anchor:"-20" ,store:[ ".", ","]  })
		.addCombo({ name:"thousandSeparator", xtype:"localcombo", dataIndex:"thousandSeparator",anchor:"-20" ,store:[ ".", ","]  })
		.addLov({ name:"dateFormat", xtype:"net.nan21.dnet.module.ad.system.lovs.SysDateFormats", dataIndex:"dateFormat",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "dateFormatId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:350})     
		.addPanel({ name:"col2", layout:"form" ,title:"Regional settings", width:280,xtype:"fieldset", border:true, collapsible:true})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","code","accountType","notes","active","locked"])
		.addChildrenTo("col2",["dateFormat","decimalSeparator","thousandSeparator"])
;
	}	
});
 	
 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.User$ChangePasswordForm", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.User$ChangePasswordForm",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"newPassword", paramIndex:"newPassword",anchor:"-20" ,allowBlank:false  })
		.addTextField({ name:"confirmPassword", paramIndex:"confirmPassword",anchor:"-20" ,allowBlank:false  })
		//containers
		.addPanel({ name:"main", layout:"form" , autoScroll:true, width:350})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["newPassword","confirmPassword"])
;
	}	
});
 	
