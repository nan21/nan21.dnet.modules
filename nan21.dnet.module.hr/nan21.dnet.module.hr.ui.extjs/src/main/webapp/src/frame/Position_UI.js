 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/PositionDs", "nan21.dnet.module.hr.ui.extjs/dc/Position", "nan21.dnet.module.hr.ui.extjs/ds/PositionSkillDs", "nan21.dnet.module.hr.ui.extjs/dc/PositionSkill", "nan21.dnet.module.hr.ui.extjs/ds/PositionRequirementDs", "nan21.dnet.module.hr.ui.extjs/dc/PositionRequirement", "nan21.dnet.module.hr.ui.extjs/ds/PositionCourseDs", "nan21.dnet.module.hr.ui.extjs/dc/PositionCourse","nan21.dnet.module.ad.ui.extjs/ds/OrganizationLovDs","nan21.dnet.module.ad.ui.extjs/lov/Organizations","nan21.dnet.module.hr.ui.extjs/ds/JobLovDs","nan21.dnet.module.hr.ui.extjs/lov/Jobs","nan21.dnet.module.ad.ui.extjs/ds/OrganizationLovDs","nan21.dnet.module.ad.ui.extjs/lov/Organizations","nan21.dnet.module.hr.ui.extjs/ds/JobLovDs","nan21.dnet.module.hr.ui.extjs/lov/Jobs","nan21.dnet.module.hr.ui.extjs/ds/SkillLovDs","nan21.dnet.module.hr.ui.extjs/lov/Skills","nan21.dnet.module.hr.ui.extjs/ds/RatingLevelLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingLevels","nan21.dnet.module.hr.ui.extjs/ds/WorkRequirementLovDs","nan21.dnet.module.hr.ui.extjs/lov/WorkRequirements","nan21.dnet.module.hr.ui.extjs/ds/CourseLovDs","nan21.dnet.module.hr.ui.extjs/lov/Courses"]);

Ext.ns("net.nan21.dnet.module.hr.job.frame");
net.nan21.dnet.module.hr.job.frame.Position_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.job.frame.Position_UI"
	
	,_defineDcs_: function () {	
		var  pos = new net.nan21.dnet.module.hr.job.dc.Position({multiEdit:false}), skill = new net.nan21.dnet.module.hr.skill.dc.PositionSkill({multiEdit:true}), req = new net.nan21.dnet.module.hr.job.dc.PositionRequirement({multiEdit:true}), course = new net.nan21.dnet.module.hr.training.dc.PositionCourse({multiEdit:true});	 	
		
		this._dcs_.add("pos", pos);			
		skill.setDcContext(new dnet.base.DcContext({childDc:skill, parentDc:pos, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"positionId", parentField:"id"} ]}}));pos.addChild(skill);
		this._dcs_.add("skill", skill);			
		req.setDcContext(new dnet.base.DcContext({childDc:req, parentDc:pos, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"positionId", parentField:"id"} ]}}));pos.addChild(req);
		this._dcs_.add("req", req);			
		course.setDcContext(new dnet.base.DcContext({childDc:course, parentDc:pos, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"positionId", parentField:"id"} ]}}));pos.addChild(course);
		this._dcs_.add("course", course);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("posFilter", { xtype:"net.nan21.dnet.module.hr.job.dc.Position$Filter", id:Ext.id(), _controller_:this._dcs_.get("pos") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("posList", { xtype:"net.nan21.dnet.module.hr.job.dc.Position$List", id:Ext.id(), _controller_:this._dcs_.get("pos") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("posEdit", { xtype:"net.nan21.dnet.module.hr.job.dc.Position$Edit", id:Ext.id(), _controller_:this._dcs_.get("pos"),height:150 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("pos").isRecordValid = this._dcs_.get("pos").isRecordValid.createInterceptor(function() { return this._getElement_("posEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("skillCtxEditList", { xtype:"net.nan21.dnet.module.hr.skill.dc.PositionSkill$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("skill"),title:"Competences" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("reqCtxEditList", { xtype:"net.nan21.dnet.module.hr.job.dc.PositionRequirement$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("req"),title:"Requirements" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("courseCtxEditList", { xtype:"net.nan21.dnet.module.hr.training.dc.PositionCourse$PositionCtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("course"),title:"Courses" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });		
		this._elems_.add("detailsTab", {layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()	}  }); 	 
		
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("posFilter")["region"] = "north";			
			this._elems_.get("posList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("posFilter") , this._elems_.get("posList") ]; 				 		
 
			this._elems_.get("posEdit")["region"] = "north";			
			this._elems_.get("detailsTab")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("posEdit") , this._elems_.get("detailsTab") ]; 				 		
 
		this._elems_.get("detailsTab")["items"]["items"] = [ this._elems_.get("reqCtxEditList") , this._elems_.get("skillCtxEditList") , this._elems_.get("courseCtxEditList") ];	
	 	this._linkToolbar_("tlbPosList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbPosEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbSkillCtxEditList", "skillCtxEditList");	 	  	
	 	this._linkToolbar_("tlbReqCtxEditList", "reqCtxEditList");	 	  	
	 	this._linkToolbar_("tlbCourseCtxEditList", "courseCtxEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbPosList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("pos").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPosList-load"
		this._tlbitms_.add("tlbPosList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("pos")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbPosList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPosList-edit_sr"
		this._tlbitms_.add("tlbPosList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("pos").doNew(); this._invokeTlbItem_("tlbPosList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPosList-new_sr"
		this._tlbitms_.add("tlbPosList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("pos").doCopy(); this._invokeTlbItem_("tlbPosList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPosList-copy_sr"
		this._tlbitms_.add("tlbPosList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("pos").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPosList-delete_selected_sr"
		this._tlbitms_.add("tlbPosList___S00_", "-") ;
		this._tlbitms_.add("tlbPosList___S01_", "-") ;
		this._tlbitms_.add("tlbPosList___TITLE_",  {xtype:"tbtext", text:"Position"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbPosList__") != -1); } )
		this._tlbs_.add("tlbPosList" , t.getRange() );

		this._getDc_("pos").on("onEdit", function() {this._invokeTlbItem_("tlbPosList__edit_sr");} , this);

	


			this._getDc_("pos").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbPosList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("pos").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbPosList__load")) this._tlbitms_.get("tlbPosList__load").enable();
                 if(this._tlbitms_.get("tlbPosList__new_sr"))this._tlbitms_.get("tlbPosList__new_sr").enable();
                 if(this._tlbitms_.get("tlbPosList__new_mr"))this._tlbitms_.get("tlbPosList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("pos").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbPosList__edit_sr")) this._tlbitms_.get("tlbPosList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbPosList__copy_sr")) this._tlbitms_.get("tlbPosList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbPosList__delete_selected_sr")) this._tlbitms_.get("tlbPosList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbPosList__edit_sr")) this._tlbitms_.get("tlbPosList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbPosList__copy_sr")) this._tlbitms_.get("tlbPosList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbPosList__delete_selected_sr")) this._tlbitms_.get("tlbPosList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbPosEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("pos")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbPosEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPosEdit-back_sr"
		this._tlbitms_.add("tlbPosEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("pos").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPosEdit-save"
		this._tlbitms_.add("tlbPosEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("pos").doNew(); this._invokeTlbItem_("tlbPosEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPosEdit-new_sr"
		this._tlbitms_.add("tlbPosEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("pos").doCopy(); this._invokeTlbItem_("tlbPosEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPosEdit-copy_sr"
		this._tlbitms_.add("tlbPosEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("pos").getCurrentRecord().phantom) {this._getDc_("pos").discardChanges();this._invokeTlbItem_("tlbPosEdit__back_sr");} else  {this._getDc_("pos").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPosEdit-rollback_sr"
		this._tlbitms_.add("tlbPosEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("pos").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPosEdit-prev_rec_sr"
		this._tlbitms_.add("tlbPosEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("pos").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPosEdit-next_rec_sr"
		this._tlbitms_.add("tlbPosEdit___S00_", "-") ;
		this._tlbitms_.add("tlbPosEdit___S01_", "-") ;
		this._tlbitms_.add("tlbPosEdit___TITLE_",  {xtype:"tbtext", text:"Position"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbPosEdit__") != -1); } )
		this._tlbs_.add("tlbPosEdit" , t.getRange() );
	


			this._getDc_("pos").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbPosEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("pos").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbPosEdit__load")) this._tlbitms_.get("tlbPosEdit__load").enable();
                 if(this._tlbitms_.get("tlbPosEdit__new_sr"))this._tlbitms_.get("tlbPosEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbPosEdit__new_mr"))this._tlbitms_.get("tlbPosEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("pos").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbPosEdit__back_sr")) this._tlbitms_.get("tlbPosEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbPosEdit__save")) this._tlbitms_.get("tlbPosEdit__save").enable();
                    if(this._tlbitms_.get("tlbPosEdit__new_sr")) this._tlbitms_.get("tlbPosEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbPosEdit__copy_sr")) this._tlbitms_.get("tlbPosEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbPosEdit__rollback_record_sr")) this._tlbitms_.get("tlbPosEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbPosEdit__rollback_sr")) this._tlbitms_.get("tlbPosEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbPosEdit__prev_rec_sr")) this._tlbitms_.get("tlbPosEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbPosEdit__next_rec_sr")) this._tlbitms_.get("tlbPosEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("pos").on("cleanRecord" , function() {
		  		  if (this._getDc_("pos").isDirty() ) {
                    if(this._tlbitms_.get("tlbPosEdit__back_sr")) this._tlbitms_.get("tlbPosEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbPosEdit__save")) this._tlbitms_.get("tlbPosEdit__save").enable();
                    if(this._tlbitms_.get("tlbPosEdit__new_sr")) this._tlbitms_.get("tlbPosEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbPosEdit__copy_sr")) this._tlbitms_.get("tlbPosEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbPosEdit__rollback_record_sr")) this._tlbitms_.get("tlbPosEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbPosEdit__rollback_sr")) this._tlbitms_.get("tlbPosEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbPosEdit__prev_rec_sr")) this._tlbitms_.get("tlbPosEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbPosEdit__next_rec_sr")) this._tlbitms_.get("tlbPosEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbPosEdit__back_sr")) this._tlbitms_.get("tlbPosEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbPosEdit__save")) this._tlbitms_.get("tlbPosEdit__save").disable();
                  	if(this._tlbitms_.get("tlbPosEdit__new_sr")) this._tlbitms_.get("tlbPosEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbPosEdit__copy_sr")) this._tlbitms_.get("tlbPosEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbPosEdit__rollback_record_sr")) this._tlbitms_.get("tlbPosEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbPosEdit__rollback_sr")) this._tlbitms_.get("tlbPosEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbPosEdit__prev_rec_sr")) this._tlbitms_.get("tlbPosEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbPosEdit__next_rec_sr")) this._tlbitms_.get("tlbPosEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("pos").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbPosEdit__copy_sr")) this._tlbitms_.get("tlbPosEdit__copy_sr").enable();
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
		this._tlbitms_.add("tlbSkillCtxEditList___TITLE_",  {xtype:"tbtext", text:"PositionSkill"} );
        
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
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbReqCtxEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("req").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbReqCtxEditList-load"
		this._tlbitms_.add("tlbReqCtxEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("req").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbReqCtxEditList-save_mr"
		this._tlbitms_.add("tlbReqCtxEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("req").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbReqCtxEditList-new_mr"
		this._tlbitms_.add("tlbReqCtxEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("req").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbReqCtxEditList-copy_mr"
		this._tlbitms_.add("tlbReqCtxEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("req").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbReqCtxEditList-delete_mr"
		this._tlbitms_.add("tlbReqCtxEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("req").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbReqCtxEditList-rollback_mr"
		this._tlbitms_.add("tlbReqCtxEditList___S00_", "-") ;
		this._tlbitms_.add("tlbReqCtxEditList___S01_", "-") ;
		this._tlbitms_.add("tlbReqCtxEditList___TITLE_",  {xtype:"tbtext", text:"PositionRequirement"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbReqCtxEditList__") != -1); } )
		this._tlbs_.add("tlbReqCtxEditList" , t.getRange() );
	


			this._getDc_("req").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbReqCtxEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("req").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbReqCtxEditList__load")) this._tlbitms_.get("tlbReqCtxEditList__load").enable();
                 if(this._tlbitms_.get("tlbReqCtxEditList__new_sr"))this._tlbitms_.get("tlbReqCtxEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbReqCtxEditList__new_mr"))this._tlbitms_.get("tlbReqCtxEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("req").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbReqCtxEditList__copy_mr")) this._tlbitms_.get("tlbReqCtxEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbReqCtxEditList__delete_mr")) this._tlbitms_.get("tlbReqCtxEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbReqCtxEditList__copy_mr")) this._tlbitms_.get("tlbReqCtxEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbReqCtxEditList__delete_mr")) this._tlbitms_.get("tlbReqCtxEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("req").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbReqCtxEditList__load")) this._tlbitms_.get("tlbReqCtxEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbReqCtxEditList__save_mr")) this._tlbitms_.get("tlbReqCtxEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbReqCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbReqCtxEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbReqCtxEditList__rollback_mr"))this._tlbitms_.get("tlbReqCtxEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("req").on("cleanRecord" , function() {
		  		  if (this._getDc_("req").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbReqCtxEditList__load")) this._tlbitms_.get("tlbReqCtxEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbReqCtxEditList__save_mr"))this._tlbitms_.get("tlbReqCtxEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbReqCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbReqCtxEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbReqCtxEditList__rollback_mr"))this._tlbitms_.get("tlbReqCtxEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbReqCtxEditList__load")) this._tlbitms_.get("tlbReqCtxEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbReqCtxEditList__back_mr"))this._tlbitms_.get("tlbReqCtxEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbReqCtxEditList__save_mr"))this._tlbitms_.get("tlbReqCtxEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbReqCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbReqCtxEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbReqCtxEditList__rollback_mr"))this._tlbitms_.get("tlbReqCtxEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbCourseCtxEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("course").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCourseCtxEditList-load"
		this._tlbitms_.add("tlbCourseCtxEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("course").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCourseCtxEditList-save_mr"
		this._tlbitms_.add("tlbCourseCtxEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("course").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCourseCtxEditList-new_mr"
		this._tlbitms_.add("tlbCourseCtxEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("course").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCourseCtxEditList-copy_mr"
		this._tlbitms_.add("tlbCourseCtxEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("course").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCourseCtxEditList-delete_mr"
		this._tlbitms_.add("tlbCourseCtxEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("course").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCourseCtxEditList-rollback_mr"
		this._tlbitms_.add("tlbCourseCtxEditList___S00_", "-") ;
		this._tlbitms_.add("tlbCourseCtxEditList___S01_", "-") ;
		this._tlbitms_.add("tlbCourseCtxEditList___TITLE_",  {xtype:"tbtext", text:"PositionCourse"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbCourseCtxEditList__") != -1); } )
		this._tlbs_.add("tlbCourseCtxEditList" , t.getRange() );
	


			this._getDc_("course").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbCourseCtxEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("course").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbCourseCtxEditList__load")) this._tlbitms_.get("tlbCourseCtxEditList__load").enable();
                 if(this._tlbitms_.get("tlbCourseCtxEditList__new_sr"))this._tlbitms_.get("tlbCourseCtxEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbCourseCtxEditList__new_mr"))this._tlbitms_.get("tlbCourseCtxEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("course").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbCourseCtxEditList__copy_mr")) this._tlbitms_.get("tlbCourseCtxEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbCourseCtxEditList__delete_mr")) this._tlbitms_.get("tlbCourseCtxEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbCourseCtxEditList__copy_mr")) this._tlbitms_.get("tlbCourseCtxEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbCourseCtxEditList__delete_mr")) this._tlbitms_.get("tlbCourseCtxEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("course").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbCourseCtxEditList__load")) this._tlbitms_.get("tlbCourseCtxEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbCourseCtxEditList__save_mr")) this._tlbitms_.get("tlbCourseCtxEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCourseCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbCourseCtxEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCourseCtxEditList__rollback_mr"))this._tlbitms_.get("tlbCourseCtxEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("course").on("cleanRecord" , function() {
		  		  if (this._getDc_("course").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbCourseCtxEditList__load")) this._tlbitms_.get("tlbCourseCtxEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbCourseCtxEditList__save_mr"))this._tlbitms_.get("tlbCourseCtxEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCourseCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbCourseCtxEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCourseCtxEditList__rollback_mr"))this._tlbitms_.get("tlbCourseCtxEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbCourseCtxEditList__load")) this._tlbitms_.get("tlbCourseCtxEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbCourseCtxEditList__back_mr"))this._tlbitms_.get("tlbCourseCtxEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbCourseCtxEditList__save_mr"))this._tlbitms_.get("tlbCourseCtxEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbCourseCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbCourseCtxEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbCourseCtxEditList__rollback_mr"))this._tlbitms_.get("tlbCourseCtxEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("pos").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("posEdit").id ]);								 
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
		this._dcs_.get("req").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("course").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.hr.job.frame.Position_UI", net.nan21.dnet.module.hr.job.frame.Position_UI);   
