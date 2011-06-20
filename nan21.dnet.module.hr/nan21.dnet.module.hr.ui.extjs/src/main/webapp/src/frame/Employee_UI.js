 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeDs", "nan21.dnet.module.hr.ui.extjs/dc/Employee", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeSkillDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeSkill", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeContactDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeContact", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelDs", "nan21.dnet.module.bd.ui.extjs/dc/CommunicationChannel", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeEducationDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeEducation", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeWorkExperienceDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeWorkExperience", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeLicenseDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeLicense", "nan21.dnet.module.bd.ui.extjs/ds/LocationDs", "nan21.dnet.module.bd.ui.extjs/dc/Location","nan21.dnet.module.ad.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.ad.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/RegionLovDs","nan21.dnet.module.bd.ui.extjs/lov/Regions","nan21.dnet.module.ad.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.ad.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.hr.ui.extjs/ds/EmployeeContactRelationshipLovDs","nan21.dnet.module.hr.ui.extjs/lov/EmployeeContactRelationships","nan21.dnet.module.hr.ui.extjs/ds/SkillLovDs","nan21.dnet.module.hr.ui.extjs/lov/Skills","nan21.dnet.module.hr.ui.extjs/ds/RatingLevelLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingLevels","nan21.dnet.module.hr.ui.extjs/ds/EducationTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/EducationTypes","nan21.dnet.module.hr.ui.extjs/ds/LicenseTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/LicenseTypes","nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/CommunicationChannelTypes"]);

Ext.ns("net.nan21.dnet.module.hr.ui");
net.nan21.dnet.module.hr.ui.Employee_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.ui.Employee_UI"
	
	,_defineDcs_: function () {	
		var  emp = new net.nan21.dnet.module.hr.employee.dc.Employee({multiEdit:false}), skill = new net.nan21.dnet.module.hr.skill.dc.EmployeeSkill({multiEdit:true}), cont = new net.nan21.dnet.module.hr.employee.dc.EmployeeContact({multiEdit:true}), communic = new net.nan21.dnet.module.bd.contact.dc.CommunicationChannel({multiEdit:true}), educ = new net.nan21.dnet.module.hr.employee.dc.EmployeeEducation({multiEdit:true}), work = new net.nan21.dnet.module.hr.employee.dc.EmployeeWorkExperience({multiEdit:true}), lic = new net.nan21.dnet.module.hr.employee.dc.EmployeeLicense({multiEdit:true}), address = new net.nan21.dnet.module.bd.geo.dc.Location({multiEdit:false});	 	
		
		this._dcs_.add("emp", emp);			
		skill.setDcContext(new dnet.base.DcContext({childDc:skill, parentDc:emp, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"employeeId", parentField:"id"} ]}}));emp.addChild(skill);
		this._dcs_.add("skill", skill);			
		cont.setDcContext(new dnet.base.DcContext({childDc:cont, parentDc:emp, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"employeeId", parentField:"id"} ]}}));emp.addChild(cont);
		this._dcs_.add("cont", cont);			
		communic.setDcContext(new dnet.base.DcContext({childDc:communic, parentDc:emp, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]}}));emp.addChild(communic);
		this._dcs_.add("communic", communic);			
		educ.setDcContext(new dnet.base.DcContext({childDc:educ, parentDc:emp, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"employeeId", parentField:"id"} ]}}));emp.addChild(educ);
		this._dcs_.add("educ", educ);			
		work.setDcContext(new dnet.base.DcContext({childDc:work, parentDc:emp, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"employeeId", parentField:"id"} ]}}));emp.addChild(work);
		this._dcs_.add("work", work);			
		lic.setDcContext(new dnet.base.DcContext({childDc:lic, parentDc:emp, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"employeeId", parentField:"id"} ]}}));emp.addChild(lic);
		this._dcs_.add("lic", lic);			
		address.setDcContext(new dnet.base.DcContext({childDc:address, parentDc:emp, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]}}));emp.addChild(address);
		this._dcs_.add("address", address);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("empFilter", { xtype:"net.nan21.dnet.module.hr.employee.dc.Employee$Filter", id:Ext.id(), _controller_:this._dcs_.get("emp") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("empList", { xtype:"net.nan21.dnet.module.hr.employee.dc.Employee$List", id:Ext.id(), _controller_:this._dcs_.get("emp") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("empEditMain", { xtype:"net.nan21.dnet.module.hr.employee.dc.Employee$EditMain", id:Ext.id(), _controller_:this._dcs_.get("emp"),height:100 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("emp").isRecordValid = this._dcs_.get("emp").isRecordValid.createInterceptor(function() { return this._getElement_("empEditMain")._isValid_(); }, this);		 
		  
		this._elems_.add("empEditOther", { xtype:"net.nan21.dnet.module.hr.employee.dc.Employee$EditOther", id:Ext.id(), _controller_:this._dcs_.get("emp"),title:"Details" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("emp").isRecordValid = this._dcs_.get("emp").isRecordValid.createInterceptor(function() { return this._getElement_("empEditOther")._isValid_(); }, this);		 
		  
		this._elems_.add("contEditList", { xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeContact$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("cont"),title:"Contacts" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("skillEditList", { xtype:"net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("skill"),title:"Competences" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("educEditList", { xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeEducation$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("educ"),title:"Education" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("workEditList", { xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeWorkExperience$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("work"),title:"Work experience" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("licEditList", { xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeLicense$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("lic"),title:"Licenses" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("communicEditList", { xtype:"net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("communic"),title:"Communication" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("addressList", { xtype:"net.nan21.dnet.module.bd.geo.dc.Location$ListCtx", id:Ext.id(), _controller_:this._dcs_.get("address") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("addressEdit", { xtype:"net.nan21.dnet.module.bd.geo.dc.Location$EditCtx", id:Ext.id(), _controller_:this._dcs_.get("address") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("address").isRecordValid = this._dcs_.get("address").isRecordValid.createInterceptor(function() { return this._getElement_("addressEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });		this._elems_.add("addressPanel", { layout:"card", activeItem:0, id:Ext.id(),title:"Address",listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });		
		this._elems_.add("empDetailsTab", {layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()	}  }); 	 
		
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
		
		this._elems_.add("addressEditWrapper", { layout:"fit", id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);} }} }); 
	
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("empFilter")["region"] = "north";			
			this._elems_.get("empList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("empFilter") , this._elems_.get("empList") ]; 				 		
 
			this._elems_.get("empEditMain")["region"] = "north";			
			this._elems_.get("empDetailsTab")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("empEditMain") , this._elems_.get("empDetailsTab") ]; 				 		
 
		this._elems_.get("empDetailsTab")["items"]["items"] = [ this._elems_.get("empEditOther") , this._elems_.get("communicEditList") , this._elems_.get("addressPanel") , this._elems_.get("contEditList") , this._elems_.get("skillEditList") , this._elems_.get("licEditList") , this._elems_.get("educEditList") , this._elems_.get("workEditList") ];	
 
	
	 	this._elems_.get("addressPanel")["items"] = [ this._elems_.get("addressList") , this._elems_.get("addressEditWrapper") ]; 				 		
 
	
	 	this._elems_.get("addressEditWrapper")["items"] = [ this._elems_.get("addressEdit") ]; 				 		
	 	this._linkToolbar_("tlbEmpList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbEmpEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbSkillList", "skillEditList");	 	  	
	 	this._linkToolbar_("tlbContList", "contEditList");	 	  	
	 	this._linkToolbar_("tlbEducList", "educEditList");	 	  	
	 	this._linkToolbar_("tlbWorkList", "workEditList");	 	  	
	 	this._linkToolbar_("tlbLicList", "licEditList");	 	  	
	 	this._linkToolbar_("tlbCommunicEditList", "communicEditList");	 	  	
	 	this._linkToolbar_("tlbAddressList", "addressList");	 	  	
	 	this._linkToolbar_("tlbAddressEdit", "addressEditWrapper");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbEmpList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("emp").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEmpList-load"
		this._tlbitms_.add("tlbEmpList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("emp")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbEmpList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEmpList-edit_sr"
		this._tlbitms_.add("tlbEmpList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("emp").doNew(); this._invokeTlbItem_("tlbEmpList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbEmpList-new_sr"
		this._tlbitms_.add("tlbEmpList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("emp").doCopy(); this._invokeTlbItem_("tlbEmpList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbEmpList-copy_sr"
		this._tlbitms_.add("tlbEmpList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("emp").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbEmpList-delete_selected_sr"
		this._tlbitms_.add("tlbEmpList___S00_", "-") ;
		this._tlbitms_.add("tlbEmpList___S01_", "-") ;
		this._tlbitms_.add("tlbEmpList___TITLE_",  {xtype:"tbtext", text:"Employee"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbEmpList__") != -1); } )
		this._tlbs_.add("tlbEmpList" , t.getRange() );

		this._getDc_("emp").on("onEdit", function() {this._invokeTlbItem_("tlbEmpList__edit_sr");} , this);

	


			this._getDc_("emp").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbEmpList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("emp").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbEmpList__load")) this._tlbitms_.get("tlbEmpList__load").enable();
                 if(this._tlbitms_.get("tlbEmpList__new_sr"))this._tlbitms_.get("tlbEmpList__new_sr").enable();
                 if(this._tlbitms_.get("tlbEmpList__new_mr"))this._tlbitms_.get("tlbEmpList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("emp").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbEmpList__edit_sr")) this._tlbitms_.get("tlbEmpList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbEmpList__copy_sr")) this._tlbitms_.get("tlbEmpList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbEmpList__delete_selected_sr")) this._tlbitms_.get("tlbEmpList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbEmpList__edit_sr")) this._tlbitms_.get("tlbEmpList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbEmpList__copy_sr")) this._tlbitms_.get("tlbEmpList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbEmpList__delete_selected_sr")) this._tlbitms_.get("tlbEmpList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbEmpEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("emp")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbEmpEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEmpEdit-back_sr"
		this._tlbitms_.add("tlbEmpEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("emp").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbEmpEdit-save"
		this._tlbitms_.add("tlbEmpEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("emp").doNew(); this._invokeTlbItem_("tlbEmpEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbEmpEdit-new_sr"
		this._tlbitms_.add("tlbEmpEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("emp").doCopy(); this._invokeTlbItem_("tlbEmpEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbEmpEdit-copy_sr"
		this._tlbitms_.add("tlbEmpEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("emp").getCurrentRecord().phantom) {this._getDc_("emp").discardChanges();this._invokeTlbItem_("tlbEmpEdit__back_sr");} else  {this._getDc_("emp").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEmpEdit-rollback_sr"
		this._tlbitms_.add("tlbEmpEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("emp").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEmpEdit-prev_rec_sr"
		this._tlbitms_.add("tlbEmpEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("emp").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbEmpEdit-next_rec_sr"
		this._tlbitms_.add("tlbEmpEdit___S00_", "-") ;
		this._tlbitms_.add("tlbEmpEdit___S01_", "-") ;
		this._tlbitms_.add("tlbEmpEdit___TITLE_",  {xtype:"tbtext", text:"Employee"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbEmpEdit__") != -1); } )
		this._tlbs_.add("tlbEmpEdit" , t.getRange() );
	


			this._getDc_("emp").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbEmpEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("emp").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbEmpEdit__load")) this._tlbitms_.get("tlbEmpEdit__load").enable();
                 if(this._tlbitms_.get("tlbEmpEdit__new_sr"))this._tlbitms_.get("tlbEmpEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbEmpEdit__new_mr"))this._tlbitms_.get("tlbEmpEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("emp").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbEmpEdit__back_sr")) this._tlbitms_.get("tlbEmpEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbEmpEdit__save")) this._tlbitms_.get("tlbEmpEdit__save").enable();
                    if(this._tlbitms_.get("tlbEmpEdit__new_sr")) this._tlbitms_.get("tlbEmpEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbEmpEdit__copy_sr")) this._tlbitms_.get("tlbEmpEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbEmpEdit__rollback_record_sr")) this._tlbitms_.get("tlbEmpEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbEmpEdit__rollback_sr")) this._tlbitms_.get("tlbEmpEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbEmpEdit__prev_rec_sr")) this._tlbitms_.get("tlbEmpEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbEmpEdit__next_rec_sr")) this._tlbitms_.get("tlbEmpEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("emp").on("cleanRecord" , function() {
		  		  if (this._getDc_("emp").isDirty() ) {
                    if(this._tlbitms_.get("tlbEmpEdit__back_sr")) this._tlbitms_.get("tlbEmpEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbEmpEdit__save")) this._tlbitms_.get("tlbEmpEdit__save").enable();
                    if(this._tlbitms_.get("tlbEmpEdit__new_sr")) this._tlbitms_.get("tlbEmpEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbEmpEdit__copy_sr")) this._tlbitms_.get("tlbEmpEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbEmpEdit__rollback_record_sr")) this._tlbitms_.get("tlbEmpEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbEmpEdit__rollback_sr")) this._tlbitms_.get("tlbEmpEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbEmpEdit__prev_rec_sr")) this._tlbitms_.get("tlbEmpEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbEmpEdit__next_rec_sr")) this._tlbitms_.get("tlbEmpEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbEmpEdit__back_sr")) this._tlbitms_.get("tlbEmpEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbEmpEdit__save")) this._tlbitms_.get("tlbEmpEdit__save").disable();
                  	if(this._tlbitms_.get("tlbEmpEdit__new_sr")) this._tlbitms_.get("tlbEmpEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbEmpEdit__copy_sr")) this._tlbitms_.get("tlbEmpEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbEmpEdit__rollback_record_sr")) this._tlbitms_.get("tlbEmpEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbEmpEdit__rollback_sr")) this._tlbitms_.get("tlbEmpEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbEmpEdit__prev_rec_sr")) this._tlbitms_.get("tlbEmpEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbEmpEdit__next_rec_sr")) this._tlbitms_.get("tlbEmpEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("emp").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbEmpEdit__copy_sr")) this._tlbitms_.get("tlbEmpEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbSkillList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("skill").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSkillList-load"
		this._tlbitms_.add("tlbSkillList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("skill").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbSkillList-save_mr"
		this._tlbitms_.add("tlbSkillList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("skill").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSkillList-new_mr"
		this._tlbitms_.add("tlbSkillList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("skill").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSkillList-copy_mr"
		this._tlbitms_.add("tlbSkillList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("skill").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSkillList-delete_mr"
		this._tlbitms_.add("tlbSkillList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("skill").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSkillList-rollback_mr"
		this._tlbitms_.add("tlbSkillList___S00_", "-") ;
		this._tlbitms_.add("tlbSkillList___S01_", "-") ;
		this._tlbitms_.add("tlbSkillList___TITLE_",  {xtype:"tbtext", text:"EmployeeSkill"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbSkillList__") != -1); } )
		this._tlbs_.add("tlbSkillList" , t.getRange() );
	


			this._getDc_("skill").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbSkillList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("skill").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbSkillList__load")) this._tlbitms_.get("tlbSkillList__load").enable();
                 if(this._tlbitms_.get("tlbSkillList__new_sr"))this._tlbitms_.get("tlbSkillList__new_sr").enable();
                 if(this._tlbitms_.get("tlbSkillList__new_mr"))this._tlbitms_.get("tlbSkillList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("skill").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbSkillList__copy_mr")) this._tlbitms_.get("tlbSkillList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbSkillList__delete_mr")) this._tlbitms_.get("tlbSkillList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbSkillList__copy_mr")) this._tlbitms_.get("tlbSkillList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbSkillList__delete_mr")) this._tlbitms_.get("tlbSkillList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("skill").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbSkillList__load")) this._tlbitms_.get("tlbSkillList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbSkillList__save_mr")) this._tlbitms_.get("tlbSkillList__save_mr").enable();
                    if(this._tlbitms_.get("tlbSkillList__rollback_record_mr"))this._tlbitms_.get("tlbSkillList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbSkillList__rollback_mr"))this._tlbitms_.get("tlbSkillList__rollback_mr").enable();
			  } , this );

			this._getDc_("skill").on("cleanRecord" , function() {
		  		  if (this._getDc_("skill").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbSkillList__load")) this._tlbitms_.get("tlbSkillList__load").disable();	                
                    if(this._tlbitms_.get("tlbSkillList__save_mr"))this._tlbitms_.get("tlbSkillList__save_mr").enable();
                    if(this._tlbitms_.get("tlbSkillList__rollback_record_mr"))this._tlbitms_.get("tlbSkillList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbSkillList__rollback_mr"))this._tlbitms_.get("tlbSkillList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbSkillList__load")) this._tlbitms_.get("tlbSkillList__load").enable();	
                  	if(this._tlbitms_.get("tlbSkillList__back_mr"))this._tlbitms_.get("tlbSkillList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbSkillList__save_mr"))this._tlbitms_.get("tlbSkillList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbSkillList__rollback_record_mr"))this._tlbitms_.get("tlbSkillList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbSkillList__rollback_mr"))this._tlbitms_.get("tlbSkillList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbContList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("cont").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbContList-load"
		this._tlbitms_.add("tlbContList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("cont").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbContList-save_mr"
		this._tlbitms_.add("tlbContList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("cont").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbContList-new_mr"
		this._tlbitms_.add("tlbContList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("cont").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbContList-copy_mr"
		this._tlbitms_.add("tlbContList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("cont").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbContList-delete_mr"
		this._tlbitms_.add("tlbContList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("cont").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbContList-rollback_mr"
		this._tlbitms_.add("tlbContList___S00_", "-") ;
		this._tlbitms_.add("tlbContList___S01_", "-") ;
		this._tlbitms_.add("tlbContList___TITLE_",  {xtype:"tbtext", text:"EmployeeContact"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbContList__") != -1); } )
		this._tlbs_.add("tlbContList" , t.getRange() );
	


			this._getDc_("cont").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbContList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("cont").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbContList__load")) this._tlbitms_.get("tlbContList__load").enable();
                 if(this._tlbitms_.get("tlbContList__new_sr"))this._tlbitms_.get("tlbContList__new_sr").enable();
                 if(this._tlbitms_.get("tlbContList__new_mr"))this._tlbitms_.get("tlbContList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("cont").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbContList__copy_mr")) this._tlbitms_.get("tlbContList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbContList__delete_mr")) this._tlbitms_.get("tlbContList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbContList__copy_mr")) this._tlbitms_.get("tlbContList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbContList__delete_mr")) this._tlbitms_.get("tlbContList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("cont").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbContList__load")) this._tlbitms_.get("tlbContList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbContList__save_mr")) this._tlbitms_.get("tlbContList__save_mr").enable();
                    if(this._tlbitms_.get("tlbContList__rollback_record_mr"))this._tlbitms_.get("tlbContList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbContList__rollback_mr"))this._tlbitms_.get("tlbContList__rollback_mr").enable();
			  } , this );

			this._getDc_("cont").on("cleanRecord" , function() {
		  		  if (this._getDc_("cont").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbContList__load")) this._tlbitms_.get("tlbContList__load").disable();	                
                    if(this._tlbitms_.get("tlbContList__save_mr"))this._tlbitms_.get("tlbContList__save_mr").enable();
                    if(this._tlbitms_.get("tlbContList__rollback_record_mr"))this._tlbitms_.get("tlbContList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbContList__rollback_mr"))this._tlbitms_.get("tlbContList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbContList__load")) this._tlbitms_.get("tlbContList__load").enable();	
                  	if(this._tlbitms_.get("tlbContList__back_mr"))this._tlbitms_.get("tlbContList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbContList__save_mr"))this._tlbitms_.get("tlbContList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbContList__rollback_record_mr"))this._tlbitms_.get("tlbContList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbContList__rollback_mr"))this._tlbitms_.get("tlbContList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbEducList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("educ").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEducList-load"
		this._tlbitms_.add("tlbEducList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("educ").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbEducList-save_mr"
		this._tlbitms_.add("tlbEducList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("educ").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEducList-new_mr"
		this._tlbitms_.add("tlbEducList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("educ").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEducList-copy_mr"
		this._tlbitms_.add("tlbEducList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("educ").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEducList-delete_mr"
		this._tlbitms_.add("tlbEducList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("educ").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEducList-rollback_mr"
		this._tlbitms_.add("tlbEducList___S00_", "-") ;
		this._tlbitms_.add("tlbEducList___S01_", "-") ;
		this._tlbitms_.add("tlbEducList___TITLE_",  {xtype:"tbtext", text:"EmployeeEducation"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbEducList__") != -1); } )
		this._tlbs_.add("tlbEducList" , t.getRange() );
	


			this._getDc_("educ").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbEducList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("educ").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbEducList__load")) this._tlbitms_.get("tlbEducList__load").enable();
                 if(this._tlbitms_.get("tlbEducList__new_sr"))this._tlbitms_.get("tlbEducList__new_sr").enable();
                 if(this._tlbitms_.get("tlbEducList__new_mr"))this._tlbitms_.get("tlbEducList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("educ").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbEducList__copy_mr")) this._tlbitms_.get("tlbEducList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbEducList__delete_mr")) this._tlbitms_.get("tlbEducList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbEducList__copy_mr")) this._tlbitms_.get("tlbEducList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbEducList__delete_mr")) this._tlbitms_.get("tlbEducList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("educ").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbEducList__load")) this._tlbitms_.get("tlbEducList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbEducList__save_mr")) this._tlbitms_.get("tlbEducList__save_mr").enable();
                    if(this._tlbitms_.get("tlbEducList__rollback_record_mr"))this._tlbitms_.get("tlbEducList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbEducList__rollback_mr"))this._tlbitms_.get("tlbEducList__rollback_mr").enable();
			  } , this );

			this._getDc_("educ").on("cleanRecord" , function() {
		  		  if (this._getDc_("educ").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbEducList__load")) this._tlbitms_.get("tlbEducList__load").disable();	                
                    if(this._tlbitms_.get("tlbEducList__save_mr"))this._tlbitms_.get("tlbEducList__save_mr").enable();
                    if(this._tlbitms_.get("tlbEducList__rollback_record_mr"))this._tlbitms_.get("tlbEducList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbEducList__rollback_mr"))this._tlbitms_.get("tlbEducList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbEducList__load")) this._tlbitms_.get("tlbEducList__load").enable();	
                  	if(this._tlbitms_.get("tlbEducList__back_mr"))this._tlbitms_.get("tlbEducList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbEducList__save_mr"))this._tlbitms_.get("tlbEducList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbEducList__rollback_record_mr"))this._tlbitms_.get("tlbEducList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbEducList__rollback_mr"))this._tlbitms_.get("tlbEducList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbWorkList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("work").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbWorkList-load"
		this._tlbitms_.add("tlbWorkList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("work").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbWorkList-save_mr"
		this._tlbitms_.add("tlbWorkList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("work").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbWorkList-new_mr"
		this._tlbitms_.add("tlbWorkList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("work").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbWorkList-copy_mr"
		this._tlbitms_.add("tlbWorkList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("work").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbWorkList-delete_mr"
		this._tlbitms_.add("tlbWorkList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("work").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbWorkList-rollback_mr"
		this._tlbitms_.add("tlbWorkList___S00_", "-") ;
		this._tlbitms_.add("tlbWorkList___S01_", "-") ;
		this._tlbitms_.add("tlbWorkList___TITLE_",  {xtype:"tbtext", text:"EmployeeWorkExperience"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbWorkList__") != -1); } )
		this._tlbs_.add("tlbWorkList" , t.getRange() );
	


			this._getDc_("work").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbWorkList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("work").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbWorkList__load")) this._tlbitms_.get("tlbWorkList__load").enable();
                 if(this._tlbitms_.get("tlbWorkList__new_sr"))this._tlbitms_.get("tlbWorkList__new_sr").enable();
                 if(this._tlbitms_.get("tlbWorkList__new_mr"))this._tlbitms_.get("tlbWorkList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("work").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbWorkList__copy_mr")) this._tlbitms_.get("tlbWorkList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbWorkList__delete_mr")) this._tlbitms_.get("tlbWorkList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbWorkList__copy_mr")) this._tlbitms_.get("tlbWorkList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbWorkList__delete_mr")) this._tlbitms_.get("tlbWorkList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("work").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbWorkList__load")) this._tlbitms_.get("tlbWorkList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbWorkList__save_mr")) this._tlbitms_.get("tlbWorkList__save_mr").enable();
                    if(this._tlbitms_.get("tlbWorkList__rollback_record_mr"))this._tlbitms_.get("tlbWorkList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbWorkList__rollback_mr"))this._tlbitms_.get("tlbWorkList__rollback_mr").enable();
			  } , this );

			this._getDc_("work").on("cleanRecord" , function() {
		  		  if (this._getDc_("work").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbWorkList__load")) this._tlbitms_.get("tlbWorkList__load").disable();	                
                    if(this._tlbitms_.get("tlbWorkList__save_mr"))this._tlbitms_.get("tlbWorkList__save_mr").enable();
                    if(this._tlbitms_.get("tlbWorkList__rollback_record_mr"))this._tlbitms_.get("tlbWorkList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbWorkList__rollback_mr"))this._tlbitms_.get("tlbWorkList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbWorkList__load")) this._tlbitms_.get("tlbWorkList__load").enable();	
                  	if(this._tlbitms_.get("tlbWorkList__back_mr"))this._tlbitms_.get("tlbWorkList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbWorkList__save_mr"))this._tlbitms_.get("tlbWorkList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbWorkList__rollback_record_mr"))this._tlbitms_.get("tlbWorkList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbWorkList__rollback_mr"))this._tlbitms_.get("tlbWorkList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbLicList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("lic").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbLicList-load"
		this._tlbitms_.add("tlbLicList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("lic").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbLicList-save_mr"
		this._tlbitms_.add("tlbLicList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("lic").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbLicList-new_mr"
		this._tlbitms_.add("tlbLicList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("lic").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbLicList-copy_mr"
		this._tlbitms_.add("tlbLicList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("lic").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbLicList-delete_mr"
		this._tlbitms_.add("tlbLicList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("lic").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbLicList-rollback_mr"
		this._tlbitms_.add("tlbLicList___S00_", "-") ;
		this._tlbitms_.add("tlbLicList___S01_", "-") ;
		this._tlbitms_.add("tlbLicList___TITLE_",  {xtype:"tbtext", text:"EmployeeLicense"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbLicList__") != -1); } )
		this._tlbs_.add("tlbLicList" , t.getRange() );
	


			this._getDc_("lic").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbLicList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("lic").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbLicList__load")) this._tlbitms_.get("tlbLicList__load").enable();
                 if(this._tlbitms_.get("tlbLicList__new_sr"))this._tlbitms_.get("tlbLicList__new_sr").enable();
                 if(this._tlbitms_.get("tlbLicList__new_mr"))this._tlbitms_.get("tlbLicList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("lic").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbLicList__copy_mr")) this._tlbitms_.get("tlbLicList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbLicList__delete_mr")) this._tlbitms_.get("tlbLicList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbLicList__copy_mr")) this._tlbitms_.get("tlbLicList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbLicList__delete_mr")) this._tlbitms_.get("tlbLicList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("lic").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbLicList__load")) this._tlbitms_.get("tlbLicList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbLicList__save_mr")) this._tlbitms_.get("tlbLicList__save_mr").enable();
                    if(this._tlbitms_.get("tlbLicList__rollback_record_mr"))this._tlbitms_.get("tlbLicList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbLicList__rollback_mr"))this._tlbitms_.get("tlbLicList__rollback_mr").enable();
			  } , this );

			this._getDc_("lic").on("cleanRecord" , function() {
		  		  if (this._getDc_("lic").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbLicList__load")) this._tlbitms_.get("tlbLicList__load").disable();	                
                    if(this._tlbitms_.get("tlbLicList__save_mr"))this._tlbitms_.get("tlbLicList__save_mr").enable();
                    if(this._tlbitms_.get("tlbLicList__rollback_record_mr"))this._tlbitms_.get("tlbLicList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbLicList__rollback_mr"))this._tlbitms_.get("tlbLicList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbLicList__load")) this._tlbitms_.get("tlbLicList__load").enable();	
                  	if(this._tlbitms_.get("tlbLicList__back_mr"))this._tlbitms_.get("tlbLicList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbLicList__save_mr"))this._tlbitms_.get("tlbLicList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbLicList__rollback_record_mr"))this._tlbitms_.get("tlbLicList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbLicList__rollback_mr"))this._tlbitms_.get("tlbLicList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbCommunicEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("communic").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCommunicEditList-load"
		this._tlbitms_.add("tlbCommunicEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("communic").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCommunicEditList-save_mr"
		this._tlbitms_.add("tlbCommunicEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("communic").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCommunicEditList-new_mr"
		this._tlbitms_.add("tlbCommunicEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("communic").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCommunicEditList-copy_mr"
		this._tlbitms_.add("tlbCommunicEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("communic").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCommunicEditList-delete_mr"
		this._tlbitms_.add("tlbCommunicEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("communic").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCommunicEditList-rollback_mr"
		this._tlbitms_.add("tlbCommunicEditList___S00_", "-") ;
		this._tlbitms_.add("tlbCommunicEditList___S01_", "-") ;
		this._tlbitms_.add("tlbCommunicEditList___TITLE_",  {xtype:"tbtext", text:"CommunicationChannel"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbCommunicEditList__") != -1); } )
		this._tlbs_.add("tlbCommunicEditList" , t.getRange() );
	


			this._getDc_("communic").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbCommunicEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("communic").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbCommunicEditList__load")) this._tlbitms_.get("tlbCommunicEditList__load").enable();
                 if(this._tlbitms_.get("tlbCommunicEditList__new_sr"))this._tlbitms_.get("tlbCommunicEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbCommunicEditList__new_mr"))this._tlbitms_.get("tlbCommunicEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("communic").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbCommunicEditList__copy_mr")) this._tlbitms_.get("tlbCommunicEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbCommunicEditList__delete_mr")) this._tlbitms_.get("tlbCommunicEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbCommunicEditList__copy_mr")) this._tlbitms_.get("tlbCommunicEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbCommunicEditList__delete_mr")) this._tlbitms_.get("tlbCommunicEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("communic").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbCommunicEditList__load")) this._tlbitms_.get("tlbCommunicEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbCommunicEditList__save_mr")) this._tlbitms_.get("tlbCommunicEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCommunicEditList__rollback_record_mr"))this._tlbitms_.get("tlbCommunicEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCommunicEditList__rollback_mr"))this._tlbitms_.get("tlbCommunicEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("communic").on("cleanRecord" , function() {
		  		  if (this._getDc_("communic").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbCommunicEditList__load")) this._tlbitms_.get("tlbCommunicEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbCommunicEditList__save_mr"))this._tlbitms_.get("tlbCommunicEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCommunicEditList__rollback_record_mr"))this._tlbitms_.get("tlbCommunicEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCommunicEditList__rollback_mr"))this._tlbitms_.get("tlbCommunicEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbCommunicEditList__load")) this._tlbitms_.get("tlbCommunicEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbCommunicEditList__back_mr"))this._tlbitms_.get("tlbCommunicEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbCommunicEditList__save_mr"))this._tlbitms_.get("tlbCommunicEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbCommunicEditList__rollback_record_mr"))this._tlbitms_.get("tlbCommunicEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbCommunicEditList__rollback_mr"))this._tlbitms_.get("tlbCommunicEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbAddressList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("address").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAddressList-load"
		this._tlbitms_.add("tlbAddressList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("address")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbAddressList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAddressList-edit_sr"
		this._tlbitms_.add("tlbAddressList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("address").doNew(); this._invokeTlbItem_("tlbAddressList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressList-new_sr"
		this._tlbitms_.add("tlbAddressList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("address").doCopy(); this._invokeTlbItem_("tlbAddressList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressList-copy_sr"
		this._tlbitms_.add("tlbAddressList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("address").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressList-delete_selected_sr"
		this._tlbitms_.add("tlbAddressList___S00_", "-") ;
		this._tlbitms_.add("tlbAddressList___S01_", "-") ;
		this._tlbitms_.add("tlbAddressList___TITLE_",  {xtype:"tbtext", text:"Location"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbAddressList__") != -1); } )
		this._tlbs_.add("tlbAddressList" , t.getRange() );

		this._getDc_("address").on("onEdit", function() {this._invokeTlbItem_("tlbAddressList__edit_sr");} , this);

	


			this._getDc_("address").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbAddressList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("address").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbAddressList__load")) this._tlbitms_.get("tlbAddressList__load").enable();
                 if(this._tlbitms_.get("tlbAddressList__new_sr"))this._tlbitms_.get("tlbAddressList__new_sr").enable();
                 if(this._tlbitms_.get("tlbAddressList__new_mr"))this._tlbitms_.get("tlbAddressList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("address").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbAddressList__edit_sr")) this._tlbitms_.get("tlbAddressList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbAddressList__copy_sr")) this._tlbitms_.get("tlbAddressList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbAddressList__delete_selected_sr")) this._tlbitms_.get("tlbAddressList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbAddressList__edit_sr")) this._tlbitms_.get("tlbAddressList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbAddressList__copy_sr")) this._tlbitms_.get("tlbAddressList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbAddressList__delete_selected_sr")) this._tlbitms_.get("tlbAddressList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbAddressEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("address")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbAddressEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAddressEdit-back_sr"
		this._tlbitms_.add("tlbAddressEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("address").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressEdit-save"
		this._tlbitms_.add("tlbAddressEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("address").doNew(); this._invokeTlbItem_("tlbAddressEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressEdit-new_sr"
		this._tlbitms_.add("tlbAddressEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("address").doCopy(); this._invokeTlbItem_("tlbAddressEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressEdit-copy_sr"
		this._tlbitms_.add("tlbAddressEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("address").getCurrentRecord().phantom) {this._getDc_("address").discardChanges();this._invokeTlbItem_("tlbAddressEdit__back_sr");} else  {this._getDc_("address").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAddressEdit-rollback_sr"
		this._tlbitms_.add("tlbAddressEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("address").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAddressEdit-prev_rec_sr"
		this._tlbitms_.add("tlbAddressEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("address").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressEdit-next_rec_sr"
		this._tlbitms_.add("tlbAddressEdit___S00_", "-") ;
		this._tlbitms_.add("tlbAddressEdit___S01_", "-") ;
		this._tlbitms_.add("tlbAddressEdit___TITLE_",  {xtype:"tbtext", text:"Location"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbAddressEdit__") != -1); } )
		this._tlbs_.add("tlbAddressEdit" , t.getRange() );
	


			this._getDc_("address").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbAddressEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("address").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbAddressEdit__load")) this._tlbitms_.get("tlbAddressEdit__load").enable();
                 if(this._tlbitms_.get("tlbAddressEdit__new_sr"))this._tlbitms_.get("tlbAddressEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbAddressEdit__new_mr"))this._tlbitms_.get("tlbAddressEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("address").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbAddressEdit__back_sr")) this._tlbitms_.get("tlbAddressEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__save")) this._tlbitms_.get("tlbAddressEdit__save").enable();
                    if(this._tlbitms_.get("tlbAddressEdit__new_sr")) this._tlbitms_.get("tlbAddressEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__copy_sr")) this._tlbitms_.get("tlbAddressEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__rollback_record_sr")) this._tlbitms_.get("tlbAddressEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbAddressEdit__rollback_sr")) this._tlbitms_.get("tlbAddressEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbAddressEdit__prev_rec_sr")) this._tlbitms_.get("tlbAddressEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__next_rec_sr")) this._tlbitms_.get("tlbAddressEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("address").on("cleanRecord" , function() {
		  		  if (this._getDc_("address").isDirty() ) {
                    if(this._tlbitms_.get("tlbAddressEdit__back_sr")) this._tlbitms_.get("tlbAddressEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__save")) this._tlbitms_.get("tlbAddressEdit__save").enable();
                    if(this._tlbitms_.get("tlbAddressEdit__new_sr")) this._tlbitms_.get("tlbAddressEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__copy_sr")) this._tlbitms_.get("tlbAddressEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__rollback_record_sr")) this._tlbitms_.get("tlbAddressEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbAddressEdit__rollback_sr")) this._tlbitms_.get("tlbAddressEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbAddressEdit__prev_rec_sr")) this._tlbitms_.get("tlbAddressEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__next_rec_sr")) this._tlbitms_.get("tlbAddressEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbAddressEdit__back_sr")) this._tlbitms_.get("tlbAddressEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbAddressEdit__save")) this._tlbitms_.get("tlbAddressEdit__save").disable();
                  	if(this._tlbitms_.get("tlbAddressEdit__new_sr")) this._tlbitms_.get("tlbAddressEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbAddressEdit__copy_sr")) this._tlbitms_.get("tlbAddressEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbAddressEdit__rollback_record_sr")) this._tlbitms_.get("tlbAddressEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbAddressEdit__rollback_sr")) this._tlbitms_.get("tlbAddressEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbAddressEdit__prev_rec_sr")) this._tlbitms_.get("tlbAddressEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbAddressEdit__next_rec_sr")) this._tlbitms_.get("tlbAddressEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("address").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbAddressEdit__copy_sr")) this._tlbitms_.get("tlbAddressEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("emp").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("empEditMain").id,this._elems_.get("empEditOther").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("skill").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("cont").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("communic").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("educ").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("work").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("lic").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("address").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("addressEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.hr.ui.Employee_UI", net.nan21.dnet.module.hr.ui.Employee_UI);   
