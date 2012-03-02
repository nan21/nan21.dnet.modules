   

Ext.define("net.nan21.dnet.module.ad.usr.dc.MenuItem", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.MenuItemDs",
	filterModel: "net.nan21.dnet.module.ad.usr.ds.model.MenuItemDsFilter",
	paramModel: "net.nan21.dnet.module.ad.usr.ds.param.MenuItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.MenuItem$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.usr.dc.MenuItem$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"title", dataIndex:"title",anchor:"-20",maxLength:255  })
		.addTextField({ name:"frame", dataIndex:"frame",anchor:"-20",maxLength:255  })
		.addTextField({ name:"bundle", dataIndex:"bundle",anchor:"-20",maxLength:255  })
		.addTextField({ name:"iconUrl", dataIndex:"iconUrl",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addBooleanField({ name:"separatorBefore", dataIndex:"separatorBefore",anchor:"-20"  })
		.addBooleanField({ name:"separatorAfter", dataIndex:"separatorAfter",anchor:"-20"  })
		.addLov({ name:"menuItem", xtype:"net.nan21.dnet.module.ad.usr.lovs.MenuItems", dataIndex:"menuItem",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "menuItemId"} ]  })
		.addLov({ name:"menu", xtype:"net.nan21.dnet.module.ad.usr.lovs.Menus", dataIndex:"menu",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "menuId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:180}) 
		.addPanel({ name:"col3", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name","title","frame","bundle"])
		.addChildrenTo("col2",["active","separatorBefore","separatorAfter"])
		.addChildrenTo("col3",["menu","menuItem","iconUrl"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.usr.dc.MenuItem$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.usr.dc.MenuItem$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:120 })   	
		.addTextColumn({ name:"title", dataIndex:"title",width:200 })   	
		.addTextColumn({ name:"menuItem", dataIndex:"menuItem",width:120 })   	
		.addTextColumn({ name:"menu", dataIndex:"menu",width:120 })   	
		.addTextColumn({ name:"frame", dataIndex:"frame",width:200 })   	
		.addTextColumn({ name:"bundle", dataIndex:"bundle",width:200 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	 
Ext.define("net.nan21.dnet.module.ad.usr.dc.MenuItem$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.MenuItem$EditList",
	
	_bulkEditFields_ : ["menu","menuItem","active","bundle","frame","sequenceNo"],
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255} })
		.addTextColumn({ name:"title", dataIndex:"title",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255} })
		.addLov({name:"menu", xtype:"gridcolumn", dataIndex:"menu",width:120,editor:{xtype:"net.nan21.dnet.module.ad.usr.lovs.Menus" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "menuId"} ]} })
		.addLov({name:"menuItem", xtype:"gridcolumn", dataIndex:"menuItem",width:120,editor:{xtype:"net.nan21.dnet.module.ad.usr.lovs.MenuItems" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "menuItemId"} ]} })
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addTextColumn({ name:"frame", dataIndex:"frame",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255} })
		.addTextColumn({ name:"bundle", dataIndex:"bundle",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:400} })
		.addBooleanColumn({ name:"separatorBefore", dataIndex:"separatorBefore"})
		.addBooleanColumn({ name:"separatorAfter", dataIndex:"separatorAfter"})
		.addTextColumn({ name:"iconUrl", dataIndex:"iconUrl",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255} })
	  	.addDefaults()
	  ;  		   
	}  
});
 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.MenuItem$Edit", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.MenuItem$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"title", dataIndex:"title",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"frame", dataIndex:"frame",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"bundle", dataIndex:"bundle",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"iconUrl", dataIndex:"iconUrl",anchor:"-20" ,maxLength:255  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addCheckbox({ name:"separatorBefore", dataIndex:"separatorBefore"  })
		.addCheckbox({ name:"separatorAfter", dataIndex:"separatorAfter"  })
		.addLov({ name:"menuItem", xtype:"net.nan21.dnet.module.ad.usr.lovs.MenuItems", dataIndex:"menuItem",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "menuItemId"} ]  })
		.addLov({ name:"menu", xtype:"net.nan21.dnet.module.ad.usr.lovs.Menus", dataIndex:"menu",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "menuId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" ,width:250})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","title","separatorBefore","separatorAfter","iconUrl","active"])
		.addChildrenTo("col2",["menu","menuItem","frame","bundle"])
;
	}	
});
