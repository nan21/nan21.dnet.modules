 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/JobDs", "nan21.dnet.module.hr.ui.extjs/dc/Job", "nan21.dnet.module.hr.ui.extjs/ds/JobSkillDs", "nan21.dnet.module.hr.ui.extjs/dc/JobSkill", "nan21.dnet.module.hr.ui.extjs/ds/JobRequirementDs", "nan21.dnet.module.hr.ui.extjs/dc/JobRequirement", "nan21.dnet.module.hr.ui.extjs/ds/JobCourseDs", "nan21.dnet.module.hr.ui.extjs/dc/JobCourse","nan21.dnet.module.hr.ui.extjs/ds/JobTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/JobTypes","nan21.dnet.module.hr.ui.extjs/ds/JobTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/JobTypes","nan21.dnet.module.hr.ui.extjs/ds/SkillLovDs","nan21.dnet.module.hr.ui.extjs/lov/Skills","nan21.dnet.module.hr.ui.extjs/ds/RatingLevelLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingLevels","nan21.dnet.module.hr.ui.extjs/ds/WorkRequirementLovDs","nan21.dnet.module.hr.ui.extjs/lov/WorkRequirements","nan21.dnet.module.hr.ui.extjs/ds/CourseLovDs","nan21.dnet.module.hr.ui.extjs/lov/Courses"]);

Ext.ns("net.nan21.dnet.module.hr.job.frame");
net.nan21.dnet.module.hr.job.frame.Job_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.job.frame.Job_UI"
	
	,_defineDcs_: function () {	
		var  job = new net.nan21.dnet.module.hr.job.dc.Job({multiEdit:false}), skill = new net.nan21.dnet.module.hr.skill.dc.JobSkill({multiEdit:true}), req = new net.nan21.dnet.module.hr.job.dc.JobRequirement({multiEdit:true}), course = new net.nan21.dnet.module.hr.training.dc.JobCourse({multiEdit:true});	 	
		
		this._dcs_.add("job", job);			
		skill.setDcContext(new dnet.base.DcContext({childDc:skill, parentDc:job, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"jobId", parentField:"id"} ]}}));job.addChild(skill);
		this._dcs_.add("skill", skill);			
		req.setDcContext(new dnet.base.DcContext({childDc:req, parentDc:job, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"jobId", parentField:"id"} ]}}));job.addChild(req);
		this._dcs_.add("req", req);			
		course.setDcContext(new dnet.base.DcContext({childDc:course, parentDc:job, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"jobId", parentField:"id"} ]}}));job.addChild(course);
		this._dcs_.add("course", course);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("jobFilter", { xtype:"net.nan21.dnet.module.hr.job.dc.Job$Filter", id:Ext.id(), _controller_:this._dcs_.get("job") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("jobList", { xtype:"net.nan21.dnet.module.hr.job.dc.Job$List", id:Ext.id(), _controller_:this._dcs_.get("job") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("jobEditList", { xtype:"net.nan21.dnet.module.hr.job.dc.Job$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("job") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("jobEdit", { xtype:"net.nan21.dnet.module.hr.job.dc.Job$Edit", id:Ext.id(), _controller_:this._dcs_.get("job"),height:120 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("job").isRecordValid = this._dcs_.get("job").isRecordValid.createInterceptor(function() { return this._getElement_("jobEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("skillCtxEditList", { xtype:"net.nan21.dnet.module.hr.skill.dc.JobSkill$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("skill"),title:"Competences" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("reqCtxEditList", { xtype:"net.nan21.dnet.module.hr.job.dc.JobRequirement$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("req"),title:"Requirements" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("courseCtxEditList", { xtype:"net.nan21.dnet.module.hr.training.dc.JobCourse$JobCtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("course"),title:"Courses" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });		
		this._elems_.add("detailsTab", {layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()	}  }); 	 
		
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("jobFilter")["region"] = "north";			
			this._elems_.get("jobList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("jobFilter") , this._elems_.get("jobList") ]; 				 		
 
			this._elems_.get("jobEdit")["region"] = "north";			
			this._elems_.get("detailsTab")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("jobEdit") , this._elems_.get("detailsTab") ]; 				 		
 
		this._elems_.get("detailsTab")["items"]["items"] = [ this._elems_.get("reqCtxEditList") , this._elems_.get("skillCtxEditList") , this._elems_.get("courseCtxEditList") ];	
	 	this._linkToolbar_("tlbJobList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbJobEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbSkillCtxEditList", "skillCtxEditList");	 	  	
	 	this._linkToolbar_("tlbReqCtxEditList", "reqCtxEditList");	 	  	
	 	this._linkToolbar_("tlbCourseCtxEditList", "courseCtxEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbJobList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("job").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobList-load"
		this._tlbitms_.add("tlbJobList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("job")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbJobList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobList-edit_sr"
		this._tlbitms_.add("tlbJobList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("job").doNew(); this._invokeTlbItem_("tlbJobList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobList-new_sr"
		this._tlbitms_.add("tlbJobList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("job").doCopy(); this._invokeTlbItem_("tlbJobList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobList-copy_sr"
		this._tlbitms_.add("tlbJobList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("job").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobList-delete_selected_sr"
		this._tlbitms_.add("tlbJobList___S00_", "-") ;
		this._tlbitms_.add("tlbJobList___S01_", "-") ;
		this._tlbitms_.add("tlbJobList___TITLE_",  {xtype:"tbtext", text:"Job"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbJobList__") != -1); } )
		this._tlbs_.add("tlbJobList" , t.getRange() );

		this._getDc_("job").on("onEdit", function() {this._invokeTlbItem_("tlbJobList__edit_sr");} , this);

	


			this._getDc_("job").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbJobList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("job").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbJobList__load")) this._tlbitms_.get("tlbJobList__load").enable();
                 if(this._tlbitms_.get("tlbJobList__new_sr"))this._tlbitms_.get("tlbJobList__new_sr").enable();
                 if(this._tlbitms_.get("tlbJobList__new_mr"))this._tlbitms_.get("tlbJobList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("job").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbJobList__edit_sr")) this._tlbitms_.get("tlbJobList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbJobList__copy_sr")) this._tlbitms_.get("tlbJobList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbJobList__delete_selected_sr")) this._tlbitms_.get("tlbJobList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbJobList__edit_sr")) this._tlbitms_.get("tlbJobList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbJobList__copy_sr")) this._tlbitms_.get("tlbJobList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbJobList__delete_selected_sr")) this._tlbitms_.get("tlbJobList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbJobEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("job")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbJobEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobEdit-back_sr"
		this._tlbitms_.add("tlbJobEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("job").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobEdit-save"
		this._tlbitms_.add("tlbJobEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("job").doNew(); this._invokeTlbItem_("tlbJobEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobEdit-new_sr"
		this._tlbitms_.add("tlbJobEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("job").doCopy(); this._invokeTlbItem_("tlbJobEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobEdit-copy_sr"
		this._tlbitms_.add("tlbJobEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("job").getCurrentRecord().phantom) {this._getDc_("job").discardChanges();this._invokeTlbItem_("tlbJobEdit__back_sr");} else  {this._getDc_("job").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobEdit-rollback_sr"
		this._tlbitms_.add("tlbJobEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("job").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobEdit-prev_rec_sr"
		this._tlbitms_.add("tlbJobEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("job").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobEdit-next_rec_sr"
		this._tlbitms_.add("tlbJobEdit___S00_", "-") ;
		this._tlbitms_.add("tlbJobEdit___S01_", "-") ;
		this._tlbitms_.add("tlbJobEdit___TITLE_",  {xtype:"tbtext", text:"Job"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbJobEdit__") != -1); } )
		this._tlbs_.add("tlbJobEdit" , t.getRange() );
	


			this._getDc_("job").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbJobEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("job").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbJobEdit__load")) this._tlbitms_.get("tlbJobEdit__load").enable();
                 if(this._tlbitms_.get("tlbJobEdit__new_sr"))this._tlbitms_.get("tlbJobEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbJobEdit__new_mr"))this._tlbitms_.get("tlbJobEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("job").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbJobEdit__back_sr")) this._tlbitms_.get("tlbJobEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__save")) this._tlbitms_.get("tlbJobEdit__save").enable();
                    if(this._tlbitms_.get("tlbJobEdit__new_sr")) this._tlbitms_.get("tlbJobEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__copy_sr")) this._tlbitms_.get("tlbJobEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__rollback_record_sr")) this._tlbitms_.get("tlbJobEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbJobEdit__rollback_sr")) this._tlbitms_.get("tlbJobEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbJobEdit__prev_rec_sr")) this._tlbitms_.get("tlbJobEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__next_rec_sr")) this._tlbitms_.get("tlbJobEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("job").on("cleanRecord" , function() {
		  		  if (this._getDc_("job").isDirty() ) {
                    if(this._tlbitms_.get("tlbJobEdit__back_sr")) this._tlbitms_.get("tlbJobEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__save")) this._tlbitms_.get("tlbJobEdit__save").enable();
                    if(this._tlbitms_.get("tlbJobEdit__new_sr")) this._tlbitms_.get("tlbJobEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__copy_sr")) this._tlbitms_.get("tlbJobEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__rollback_record_sr")) this._tlbitms_.get("tlbJobEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbJobEdit__rollback_sr")) this._tlbitms_.get("tlbJobEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbJobEdit__prev_rec_sr")) this._tlbitms_.get("tlbJobEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__next_rec_sr")) this._tlbitms_.get("tlbJobEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbJobEdit__back_sr")) this._tlbitms_.get("tlbJobEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbJobEdit__save")) this._tlbitms_.get("tlbJobEdit__save").disable();
                  	if(this._tlbitms_.get("tlbJobEdit__new_sr")) this._tlbitms_.get("tlbJobEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbJobEdit__copy_sr")) this._tlbitms_.get("tlbJobEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbJobEdit__rollback_record_sr")) this._tlbitms_.get("tlbJobEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbJobEdit__rollback_sr")) this._tlbitms_.get("tlbJobEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbJobEdit__prev_rec_sr")) this._tlbitms_.get("tlbJobEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbJobEdit__next_rec_sr")) this._tlbitms_.get("tlbJobEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("job").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbJobEdit__copy_sr")) this._tlbitms_.get("tlbJobEdit__copy_sr").enable();
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
		this._tlbitms_.add("tlbSkillCtxEditList___TITLE_",  {xtype:"tbtext", text:"JobSkill"} );
        
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
		this._tlbitms_.add("tlbReqCtxEditList___TITLE_",  {xtype:"tbtext", text:"JobRequirement"} );
        
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
		this._tlbitms_.add("tlbCourseCtxEditList___TITLE_",  {xtype:"tbtext", text:"JobCourse"} );
        
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
		this._dcs_.get("job").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("jobEdit").id ]);								 
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
Ext.reg("net.nan21.dnet.module.hr.job.frame.Job_UI", net.nan21.dnet.module.hr.job.frame.Job_UI);   
