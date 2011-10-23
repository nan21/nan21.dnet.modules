   

Ext.define("net.nan21.dnet.module.bp.md.dc.BusinessPartner", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerDs",
	paramModel: "net.nan21.dnet.module.bp.md.ds.param.BusinessPartnerDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.bp.md.dc.BusinessPartner$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bp.md.dc.BusinessPartner$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addCombo({ name:"type", xtype:"combo", dataIndex:"type",anchor:"-20",store:[ "person", "company"]  })
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20",maxLength:255  })
		.addCombo({ name:"gender", xtype:"combo", dataIndex:"gender",anchor:"-20",store:[ "male", "female"]  })
		.addTextField({ name:"companyName", dataIndex:"companyName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"registrationNo", dataIndex:"registrationNo",anchor:"-20",maxLength:32  })
		.addTextField({ name:"taxPayerNo", dataIndex:"taxPayerNo",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"countryCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:220,labelWidth:0 })
		.addPanel({ name:"col2", layout:"anchor", width:220,labelWidth:0 })
		.addPanel({ name:"col3", layout:"anchor", width:220,labelWidth:0 })
		.addPanel({ name:"col4", layout:"anchor", width:220,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["name","code","active"])
		.addChildrenTo("col2",["type","countryCode","taxPayerNo"])
		.addChildrenTo("col3",["firstName","lastName","gender"])
		.addChildrenTo("col4",["companyName","registrationNo"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.bp.md.dc.BusinessPartner$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bp.md.dc.BusinessPartner$List",
	
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
		.addTextColumn({ name:"legalForm", dataIndex:"legalForm", hidden:true,width:120 })   	
		.addTextColumn({ name:"registrationNo", dataIndex:"registrationNo",width:100 })   	
		.addDateColumn({ name:"registrationDate", dataIndex:"registrationDate", hidden:true,format:Ext.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"taxPayerNo", dataIndex:"taxPayerNo",width:200 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.bp.md.dc.BusinessPartner$Create", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.bp.md.dc.BusinessPartner$Create",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addCombo({ name:"type", xtype:"localcombo", dataIndex:"type",anchor:"-20" ,store:[ "person", "company"]  })
		//containers
		.addPanel({ name:"main", layout:"anchor" , autoScroll:true, width:250,labelWidth:0 })     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["type"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.bp.md.dc.BusinessPartner$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.bp.md.dc.BusinessPartner$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32,vtype:"alphanum"  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextField({ name:"type", dataIndex:"type",anchor:"-20",noEdit:true  ,maxLength:16  })
		.addLov({ name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"countryCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  })
		.addTextField({ name:"taxPayerNo", dataIndex:"taxPayerNo",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20" ,maxLength:255,listeners:{change:{scope:this, fn:this._updatePersonName_}}  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20" ,maxLength:255,listeners:{change:{scope:this, fn:this._updatePersonName_}}  })
		.addTextField({ name:"middleName", dataIndex:"middleName",anchor:"-20" ,maxLength:255,listeners:{change:{scope:this, fn:this._updatePersonName_}}  })
		.addTextField({ name:"identityCardNo", dataIndex:"identityCardNo",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"passportNo", dataIndex:"passportNo",anchor:"-20" ,maxLength:255  })
		.addDateField({ name:"birthDate", dataIndex:"birthDate",anchor:"-20" })
		.addCombo({ name:"gender", xtype:"localcombo", dataIndex:"gender",anchor:"-20" ,store:[ "male", "female"]  })
		.addTextField({ name:"companyName", dataIndex:"companyName",anchor:"-20" ,maxLength:255,listeners:{change:{scope:this, fn:this._updateCompanyName_}}  })
		.addTextField({ name:"registrationNo", dataIndex:"registrationNo",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		.addDateField({ name:"registrationDate", dataIndex:"registrationDate",anchor:"-20" })
		.addLov({ name:"legalForm", xtype:"net.nan21.dnet.module.bp.base.lovs.CompanyLegalForms", dataIndex:"legalForm",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "legalFormId"} ],filterFieldMapping: [{lovField:"countryId", dsField: "countryId"} ]  })
		//containers
		.addPanel({ name:"formCompanyCol1", layout:"anchor" , width:500, height:40,labelWidth:0 })     
		.addPanel({ name:"formCompanyCol2", layout:"anchor" , width:250,labelWidth:0 })     
		.addPanel({ name:"formPersonCol1", layout:"anchor" , width:300,labelWidth:0 })     
		.addPanel({ name:"formPersonCol2", layout:"anchor" , width:250,labelWidth:0 })     
		.addPanel({ name:"col1", layout:"anchor" , width:250,labelWidth:0 })     
		.addPanel({ name:"formCompany" , width:550 })      	 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		.addPanel({ name:"formPerson", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, width:550 }) 
		.addPanel({ name:"col0", layout:"card", activeItem:0  })     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col0" ])
		.addChildrenTo("col0",["formCompany" ,"formPerson" ])
		.addChildrenTo("formCompany",["formCompanyCol1" ,"formCompanyCol2" ])
		.addChildrenTo("formCompanyCol1",["companyName"])
		.addChildrenTo("formCompanyCol2",["legalForm","registrationNo","registrationDate"])
		.addChildrenTo("formPerson",["formPersonCol1" ,"formPersonCol2" ])
		.addChildrenTo("formPersonCol1",["firstName","middleName","lastName"])
		.addChildrenTo("formPersonCol2",["identityCardNo","passportNo","gender","birthDate"])
		.addChildrenTo("col1",["type","countryCode","taxPayerNo","code","active"])
;
	}	
	,onRecordChange: function() {	
		var rec = this._controller_.getRecord();
		if(rec) {
			if( rec.get("type") == "company") {
				this._showStackedViewElement_("col0", "formCompany");
			} else {
				this._showStackedViewElement_("col0", "formPerson");
			}			
		}
	}
	,_afterRender_: function() {	
		this._controller_.on("recordChange", this.onRecordChange, this);
	}
	,_updatePersonName_: function() {	
		var rec = this._controller_.getRecord();
		if(rec.get("type") == "person")	{
			var n = rec.get("lastName") + " " + rec.get("firstName") + " " + rec.get("middleName");
			if (rec.get("name") != n) {
				rec.set("name", n)
			}
		}
	}
	,_updateCompanyName_: function() {	
		var rec = this._controller_.getRecord();
		if(rec.get("type") == "company")	{
			var n = rec.get("companyName");
			if (rec.get("name") != n) {
				rec.set("name", n)
			}
		}
	}
});
