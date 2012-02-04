   

Ext.define("net.nan21.dnet.module.bp.md.dc.BusinessPartner", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerDs",
	filterModel: "net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerDsFilter",
	paramModel: "net.nan21.dnet.module.bp.md.ds.param.BusinessPartnerDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bp.md.dc.BusinessPartner$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
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
		.addLov({ name:"legalForm", xtype:"net.nan21.dnet.module.bp.base.lovs.CompanyLegalForms", dataIndex:"legalForm",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "legalFormId"} ]  })
		.addTextField({ name:"companyName", dataIndex:"companyName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"registrationNo", dataIndex:"registrationNo",anchor:"-20",maxLength:32  })
		.addTextField({ name:"taxPayerNo", dataIndex:"taxPayerNo",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"countryCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:220}) 
		.addPanel({ name:"col2", layout:"anchor",title:"Person", width:240,xtype:"fieldset", border:true, collapsible:true}) 
		.addPanel({ name:"col3", layout:"anchor",title:"Company", width:240,xtype:"fieldset", border:true, collapsible:true}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name","code","active","type","countryCode","taxPayerNo"])
		.addChildrenTo("col2",["firstName","lastName","gender"])
		.addChildrenTo("col3",["companyName","registrationNo","legalForm"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.bp.md.dc.BusinessPartner$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bp.md.dc.BusinessPartner$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:100 })   	
		.addTextColumn({ name:"countryCode", dataIndex:"countryCode",width:100 })   	
		.addTextColumn({ name:"taxPayerNo", dataIndex:"taxPayerNo", width:80 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active", width:60})   	     
		.addTextColumn({ name:"firstName", dataIndex:"firstName", hidden:true,width:200 })   	
		.addTextColumn({ name:"lastName", dataIndex:"lastName", hidden:true,width:200 })   	
		.addTextColumn({ name:"identityCardNo", dataIndex:"identityCardNo", width:80 })   	
		.addTextColumn({ name:"gender", dataIndex:"gender", hidden:true,width:60 })   	
		.addTextColumn({ name:"legalForm", dataIndex:"legalForm", width:80 })   	
		.addTextColumn({ name:"registrationNo", dataIndex:"registrationNo", width:80 })   	
		.addDateColumn({ name:"registrationDate", dataIndex:"registrationDate", width:80,format:Dnet.DATE_FORMAT})   	      	     
	  	.addDefaults()
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.bp.md.dc.BusinessPartner$Create", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.bp.md.dc.BusinessPartner$Create",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addCombo({ name:"type", xtype:"localcombo", dataIndex:"type",anchor:"-20" ,store:[ "person", "company"]  })
		//containers
		.addPanel({ name:"main", layout:"anchor" , autoScroll:true, width:250})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["type"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.bp.md.dc.BusinessPartner$Edit", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.bp.md.dc.BusinessPartner$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addDisplayFieldText({ name:"type", dataIndex:"type"  })
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
		.addTextField({ name:"registrationNo", dataIndex:"registrationNo",anchor:"-20" ,maxLength:32  })
		.addDateField({ name:"registrationDate", dataIndex:"registrationDate",anchor:"-20" })
		.addLov({ name:"legalForm", xtype:"net.nan21.dnet.module.bp.base.lovs.CompanyLegalForms", dataIndex:"legalForm",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "legalFormId"} ],filterFieldMapping: [{lovField:"countryId", dsField: "countryId"} ]  })
		//containers
		.addPanel({ name:"formCompanyCol1", layout:"anchor" , width:500, height:40})     
		.addPanel({ name:"formCompanyCol2", layout:"anchor" , width:250})     
		.addPanel({ name:"formPersonCol1", layout:"anchor" , width:300})     
		.addPanel({ name:"formPersonCol2", layout:"anchor" , width:250})     
		.addPanel({ name:"col1", layout:"anchor" , width:250})     
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
		.addChildrenTo("formPersonCol1",["lastName","firstName","middleName"])
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
