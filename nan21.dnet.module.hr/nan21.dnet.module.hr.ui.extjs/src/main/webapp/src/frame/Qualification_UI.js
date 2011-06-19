 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/QualificationDs", "nan21.dnet.module.hr.ui.extjs/dc/Qualification", "nan21.dnet.module.hr.ui.extjs/ds/QualificationSkillDs", "nan21.dnet.module.hr.ui.extjs/dc/QualificationSkill","nan21.dnet.module.hr.ui.extjs/ds/SkillLovDs","nan21.dnet.module.hr.ui.extjs/lov/Skills","nan21.dnet.module.hr.ui.extjs/ds/RatingLevelLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingLevels"]);

Ext.ns("net.nan21.dnet.module.hr.skill.frame");
net.nan21.dnet.module.hr.skill.frame.Qualification_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.skill.frame.Qualification_UI"
	
	,_defineDcs_: function () {	
		var  qualif = new net.nan21.dnet.module.hr.skill.dc.Qualification({multiEdit:true}), skill = new net.nan21.dnet.module.hr.skill.dc.QualificationSkill({multiEdit:true});	 	
		
		this._dcs_.add("qualif", qualif);			
		skill.setDcContext(new dnet.base.DcContext({childDc:skill, parentDc:qualif, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"qualificationId", parentField:"id"} ]}}));qualif.addChild(skill);
		this._dcs_.add("skill", skill);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("qualifFilter", { xtype:"net.nan21.dnet.module.hr.skill.dc.Qualification$Filter", id:Ext.id(), _controller_:this._dcs_.get("qualif") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("qualifEditList", { xtype:"net.nan21.dnet.module.hr.skill.dc.Qualification$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("qualif") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("skillCtxEditList", { xtype:"net.nan21.dnet.module.hr.skill.dc.QualificationSkill$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("skill"),title:"Required competence" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });				
		this._elems_.add("panelRequirements", {layout:"fit",frame:"false" ,items:{ layout:"accordion", activeItem:0, id:Ext.id(),width:500,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); } }}  	}  }); 	  	 
		
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Edit list",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") ]; 				 		
 
			this._elems_.get("qualifFilter")["region"] = "north";			
			this._elems_.get("qualifEditList")["region"] = "center";			
			this._elems_.get("panelRequirements")["region"] = "east";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("qualifFilter") , this._elems_.get("qualifEditList") , this._elems_.get("panelRequirements") ]; 				 		
 
		this._elems_.get("panelRequirements")["items"]["items"] = [ this._elems_.get("skillCtxEditList") ];	
	 	this._linkToolbar_("tlbQualifEditList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbSkillCtxEditList", "skillCtxEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbQualifEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("qualif").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbQualifEditList-load"
		this._tlbitms_.add("tlbQualifEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("qualif").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbQualifEditList-save_mr"
		this._tlbitms_.add("tlbQualifEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("qualif").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbQualifEditList-new_mr"
		this._tlbitms_.add("tlbQualifEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("qualif").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbQualifEditList-copy_mr"
		this._tlbitms_.add("tlbQualifEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("qualif").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbQualifEditList-delete_mr"
		this._tlbitms_.add("tlbQualifEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("qualif").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbQualifEditList-rollback_mr"
		this._tlbitms_.add("tlbQualifEditList___S00_", "-") ;
		this._tlbitms_.add("tlbQualifEditList___S01_", "-") ;
		this._tlbitms_.add("tlbQualifEditList___TITLE_",  {xtype:"tbtext", text:"Qualification"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbQualifEditList__") != -1); } )
		this._tlbs_.add("tlbQualifEditList" , t.getRange() );
	


			this._getDc_("qualif").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbQualifEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("qualif").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbQualifEditList__load")) this._tlbitms_.get("tlbQualifEditList__load").enable();
                 if(this._tlbitms_.get("tlbQualifEditList__new_sr"))this._tlbitms_.get("tlbQualifEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbQualifEditList__new_mr"))this._tlbitms_.get("tlbQualifEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("qualif").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbQualifEditList__copy_mr")) this._tlbitms_.get("tlbQualifEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbQualifEditList__delete_mr")) this._tlbitms_.get("tlbQualifEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbQualifEditList__copy_mr")) this._tlbitms_.get("tlbQualifEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbQualifEditList__delete_mr")) this._tlbitms_.get("tlbQualifEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("qualif").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbQualifEditList__load")) this._tlbitms_.get("tlbQualifEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbQualifEditList__save_mr")) this._tlbitms_.get("tlbQualifEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbQualifEditList__rollback_record_mr"))this._tlbitms_.get("tlbQualifEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbQualifEditList__rollback_mr"))this._tlbitms_.get("tlbQualifEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("qualif").on("cleanRecord" , function() {
		  		  if (this._getDc_("qualif").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbQualifEditList__load")) this._tlbitms_.get("tlbQualifEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbQualifEditList__save_mr"))this._tlbitms_.get("tlbQualifEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbQualifEditList__rollback_record_mr"))this._tlbitms_.get("tlbQualifEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbQualifEditList__rollback_mr"))this._tlbitms_.get("tlbQualifEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbQualifEditList__load")) this._tlbitms_.get("tlbQualifEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbQualifEditList__back_mr"))this._tlbitms_.get("tlbQualifEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbQualifEditList__save_mr"))this._tlbitms_.get("tlbQualifEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbQualifEditList__rollback_record_mr"))this._tlbitms_.get("tlbQualifEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbQualifEditList__rollback_mr"))this._tlbitms_.get("tlbQualifEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbSkillCtxEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("skill").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSkillCtxEditList-load"
		this._tlbitms_.add("tlbSkillCtxEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("skill").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbSkillCtxEditList-save_mr"
		this._tlbitms_.add("tlbSkillCtxEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("skill").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSkillCtxEditList-new_mr"
		this._tlbitms_.add("tlbSkillCtxEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("skill").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSkillCtxEditList-copy_mr"
		this._tlbitms_.add("tlbSkillCtxEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("skill").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSkillCtxEditList-delete_mr"
		this._tlbitms_.add("tlbSkillCtxEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("skill").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSkillCtxEditList-rollback_mr"
		this._tlbitms_.add("tlbSkillCtxEditList___S00_", "-") ;
		this._tlbitms_.add("tlbSkillCtxEditList___S01_", "-") ;
		this._tlbitms_.add("tlbSkillCtxEditList___TITLE_",  {xtype:"tbtext", text:"QualificationSkill"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbSkillCtxEditList__") != -1); } )
		this._tlbs_.add("tlbSkillCtxEditList" , t.getRange() );
	


			this._getDc_("skill").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbSkillCtxEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("skill").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbSkillCtxEditList__load")) this._tlbitms_.get("tlbSkillCtxEditList__load").enable();
                 if(this._tlbitms_.get("tlbSkillCtxEditList__new_sr"))this._tlbitms_.get("tlbSkillCtxEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbSkillCtxEditList__new_mr"))this._tlbitms_.get("tlbSkillCtxEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("skill").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbSkillCtxEditList__copy_mr")) this._tlbitms_.get("tlbSkillCtxEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbSkillCtxEditList__delete_mr")) this._tlbitms_.get("tlbSkillCtxEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbSkillCtxEditList__copy_mr")) this._tlbitms_.get("tlbSkillCtxEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbSkillCtxEditList__delete_mr")) this._tlbitms_.get("tlbSkillCtxEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("skill").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbSkillCtxEditList__load")) this._tlbitms_.get("tlbSkillCtxEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbSkillCtxEditList__save_mr")) this._tlbitms_.get("tlbSkillCtxEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbSkillCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbSkillCtxEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbSkillCtxEditList__rollback_mr"))this._tlbitms_.get("tlbSkillCtxEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("skill").on("cleanRecord" , function() {
		  		  if (this._getDc_("skill").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbSkillCtxEditList__load")) this._tlbitms_.get("tlbSkillCtxEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbSkillCtxEditList__save_mr"))this._tlbitms_.get("tlbSkillCtxEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbSkillCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbSkillCtxEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbSkillCtxEditList__rollback_mr"))this._tlbitms_.get("tlbSkillCtxEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbSkillCtxEditList__load")) this._tlbitms_.get("tlbSkillCtxEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbSkillCtxEditList__back_mr"))this._tlbitms_.get("tlbSkillCtxEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbSkillCtxEditList__save_mr"))this._tlbitms_.get("tlbSkillCtxEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbSkillCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbSkillCtxEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbSkillCtxEditList__rollback_mr"))this._tlbitms_.get("tlbSkillCtxEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("qualif").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
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
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.hr.skill.frame.Qualification_UI", net.nan21.dnet.module.hr.skill.frame.Qualification_UI);   
