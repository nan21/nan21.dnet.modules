   
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 
net.nan21.dnet.module.bp.md.dc.BusinessPartner = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"BusinessPartner" 		 
			,ds: new net.nan21.dnet.module.bp.md.ds.BusinessPartnerDs()			  
		});
	 	net.nan21.dnet.module.bp.md.dc.BusinessPartner.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc'); 
net.nan21.dnet.module.bp.md.dc.BusinessPartner$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"type", dataIndex:"type",anchor:"-20",maxLength:1  })
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"gender", dataIndex:"gender",anchor:"-20",maxLength:16  })
		.addTextField({ name:"registrationNo", dataIndex:"registrationNo",anchor:"-20",maxLength:32  })
		.addTextField({ name:"taxNo", dataIndex:"taxNo",anchor:"-20",maxLength:32  })
		.addTextField({ name:"name1", dataIndex:"name1",anchor:"-20",maxLength:255  })
		.addTextField({ name:"name2", dataIndex:"name2",anchor:"-20",maxLength:255  })
		.addLov({ name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"countryCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:220,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form", width:220,labelWidth:0 })
		.addPanel({ name:"col3", layout:"form", width:220,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col3","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["countryCode"])
		.addChildrenTo("col3",["registrationNo","taxNo"])
	}
}); 
Ext.reg("net.nan21.dnet.module.bp.md.dc.BusinessPartner$Filter", net.nan21.dnet.module.bp.md.dc.BusinessPartner$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 	 
net.nan21.dnet.module.bp.md.dc.BusinessPartner$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:100 })   	
		.addTextColumn({ name:"countryCode", dataIndex:"countryCode",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"firstName", dataIndex:"firstName", hidden:true,width:200 })   	
		.addTextColumn({ name:"lastName", dataIndex:"lastName", hidden:true,width:200 })   	
		.addTextColumn({ name:"gender", dataIndex:"gender", hidden:true,width:60 })   	
		.addTextColumn({ name:"legalForm", dataIndex:"legalForm", hidden:true,width:100 })   	
		.addTextColumn({ name:"registrationNo", dataIndex:"registrationNo",width:100 })   	
		.addDateColumn({ name:"registrationDate", dataIndex:"registrationDate", hidden:true,format:Ext.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"taxNo", dataIndex:"taxNo",width:100 })   	
		.addTextColumn({ name:"name1", dataIndex:"name1", hidden:true,width:200 })   	
		.addTextColumn({ name:"name2", dataIndex:"name2", hidden:true,width:200 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.bp.md.dc.BusinessPartner$List", net.nan21.dnet.module.bp.md.dc.BusinessPartner$List ); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 
net.nan21.dnet.module.bp.md.dc.BusinessPartner$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32,vtype:"alphanum"  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addLov({ name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"countryCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  })
		.addTextField({ name:"type", dataIndex:"type",anchor:"-20",disabled:true  ,maxLength:1  })
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"gender", dataIndex:"gender",anchor:"-20" ,maxLength:16  })
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"legalForm", dataIndex:"legalForm",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		.addTextField({ name:"registrationNo", dataIndex:"registrationNo",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		.addDateField({ name:"registrationDate", dataIndex:"registrationDate",width:100 })
		.addTextField({ name:"taxNo", dataIndex:"taxNo",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		//containers
		.addPanel({ name:"formLE", layout:"form" ,width:250,labelWidth:0 })     
		.addPanel({ name:"formPI", layout:"form" ,width:250,labelWidth:0 })     
		.addPanel({ name:"col1", layout:"form" , width:250,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		.addPanel({ name:"col0", layout:"card", activeItem:0 , width:300 })     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col0" ,"col1" ])
		.addChildrenTo("col0",["formLE" ,"formPI" ])
		.addChildrenTo("formLE",["name","registrationNo","taxNo"])
		.addChildrenTo("formPI",["firstName","lastName","gender"])
		.addChildrenTo("col1",["countryCode","code","active"])
;
	}	
});
Ext.reg("net.nan21.dnet.module.bp.md.dc.BusinessPartner$Edit", net.nan21.dnet.module.bp.md.dc.BusinessPartner$Edit ); 
