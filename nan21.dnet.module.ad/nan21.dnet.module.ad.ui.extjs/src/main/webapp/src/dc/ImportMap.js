   
Ext.ns('net.nan21.dnet.module.ad.impex.dc');	 
net.nan21.dnet.module.ad.impex.dc.ImportMap = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"ImportMap" 		 
			,ds: new net.nan21.dnet.module.ad.impex.ds.ImportMapDs()			  
		});
	 	net.nan21.dnet.module.ad.impex.dc.ImportMap.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.impex.dc'); 
net.nan21.dnet.module.ad.impex.dc.ImportMap$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active"  })
		//containers
		.addPanel({ name:"main", layout:"hbox", autoScroll:true, defaults:{labelAlign:"right",labelWidth:80,width:210 }})
	}
	,_linkElements_: function () {
		this._getBuilder_()
		this._elems_.get("main")["items"] = [
	    {layout:"form", border:false 
	      ,items:[ this._elems_.get("name")] }
	  ,	    {layout:"form", border:false 
	      ,items:[ this._elems_.get("active")] }
];
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.impex.dc.ImportMap$Filter", net.nan21.dnet.module.ad.impex.dc.ImportMap$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.impex.dc');	 	 
net.nan21.dnet.module.ad.impex.dc.ImportMap$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:120 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.impex.dc.ImportMap$List", net.nan21.dnet.module.ad.impex.dc.ImportMap$List ); 
 	
Ext.ns('net.nan21.dnet.module.ad.impex.dc');	 
net.nan21.dnet.module.ad.impex.dc.ImportMap$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"description", dataIndex:"description",height:40,anchor:"-20"   })
		.addDateField({ name:"modifiedAt", dataIndex:"modifiedAt",width:100,disabled:true  ,allowBlank:false})
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy",anchor:"-20",disabled:true  ,allowBlank:false,maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:400,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" ,width:250,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","description"])
		.addChildrenTo("col2",["active"])
;
	}	
});
Ext.reg("net.nan21.dnet.module.ad.impex.dc.ImportMap$Edit", net.nan21.dnet.module.ad.impex.dc.ImportMap$Edit ); 
