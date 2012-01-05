   

Ext.define("net.nan21.dnet.module.ad.usr.dc.User", {
	extend: "dnet.base.AbstractDc",
 
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
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.usr.dc.User$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addLov({ name:"accountType", xtype:"net.nan21.dnet.module.ad.usr.lovs.UserTypes", dataIndex:"accountType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accountTypeId"} ]  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addBooleanField({ name:"locked", dataIndex:"locked",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"col2", layout:"anchor", width:200, defaults:{
labelAlign:"right",labelWidth:70}}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code","accountType"])
		.addChildrenTo("col2",["active","locked"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.usr.dc.User$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.usr.dc.User$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
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
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.User$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.User$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32  })
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addLov({ name:"accountType", xtype:"net.nan21.dnet.module.ad.usr.lovs.UserTypes", dataIndex:"accountType",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accountTypeId"} ]  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addCheckbox({ name:"locked", dataIndex:"locked"  })
		.addCombo({ name:"decimalSeparator", xtype:"localcombo", dataIndex:"decimalSeparator",anchor:"-20" ,store:[ ".", ","]  })
		.addCombo({ name:"thousandSeparator", xtype:"localcombo", dataIndex:"thousandSeparator",anchor:"-20" ,store:[ ".", ","]  })
		.addLov({ name:"dateFormat", xtype:"net.nan21.dnet.module.ad.system.lovs.SysDateFormats", dataIndex:"dateFormat",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "dateFormatId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:350})     
		.addPanel({ name:"col2", layout:"anchor" ,title:"Regional settings", width:280,xtype:"fieldset", border:false, collapsible:true})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
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
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.User$ChangePasswordForm",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"newPassword", paramIndex:"newPassword",anchor:"-20" ,allowBlank:false  })
		.addTextField({ name:"confirmPassword", paramIndex:"confirmPassword",anchor:"-20" ,allowBlank:false  })
		//containers
		.addPanel({ name:"main", layout:"anchor" , autoScroll:true, width:350})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["newPassword","confirmPassword"])
;
	}	
});
