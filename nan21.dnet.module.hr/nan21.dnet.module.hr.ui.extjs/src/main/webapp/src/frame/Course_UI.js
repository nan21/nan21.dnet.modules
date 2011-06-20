 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/CourseDs", "nan21.dnet.module.hr.ui.extjs/dc/Course", "nan21.dnet.module.hr.ui.extjs/ds/JobCourseDs", "nan21.dnet.module.hr.ui.extjs/dc/JobCourse", "nan21.dnet.module.hr.ui.extjs/ds/PositionCourseDs", "nan21.dnet.module.hr.ui.extjs/dc/PositionCourse","nan21.dnet.module.hr.ui.extjs/ds/CourseTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/CourseTypes","nan21.dnet.module.hr.ui.extjs/ds/CourseTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/CourseTypes","nan21.dnet.module.hr.ui.extjs/ds/JobLovDs","nan21.dnet.module.hr.ui.extjs/lov/Jobs","nan21.dnet.module.hr.ui.extjs/ds/PositionLovDs","nan21.dnet.module.hr.ui.extjs/lov/Positions"]);

Ext.ns("net.nan21.dnet.module.hr.training.frame");
net.nan21.dnet.module.hr.training.frame.Course_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.training.frame.Course_UI"
	
	,_defineDcs_: function () {	
		var  course = new net.nan21.dnet.module.hr.training.dc.Course({multiEdit:false}), job = new net.nan21.dnet.module.hr.training.dc.JobCourse({multiEdit:true}), position = new net.nan21.dnet.module.hr.training.dc.PositionCourse({multiEdit:true});	 	
		
		this._dcs_.add("course", course);			
		job.setDcContext(new dnet.base.DcContext({childDc:job, parentDc:course, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"courseId", parentField:"id"} ]}}));course.addChild(job);
		this._dcs_.add("job", job);			
		position.setDcContext(new dnet.base.DcContext({childDc:position, parentDc:course, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"courseId", parentField:"id"} ]}}));course.addChild(position);
		this._dcs_.add("position", position);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("courseFilter", { xtype:"net.nan21.dnet.module.hr.training.dc.Course$Filter", id:Ext.id(), _controller_:this._dcs_.get("course") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("courseList", { xtype:"net.nan21.dnet.module.hr.training.dc.Course$List", id:Ext.id(), _controller_:this._dcs_.get("course") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("courseEdit", { xtype:"net.nan21.dnet.module.hr.training.dc.Course$Edit", id:Ext.id(), _controller_:this._dcs_.get("course") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("course").isRecordValid = this._dcs_.get("course").isRecordValid.createInterceptor(function() { return this._getElement_("courseEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("jobList", { xtype:"net.nan21.dnet.module.hr.training.dc.JobCourse$CourseCtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("job"),title:"Jobs" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("positionList", { xtype:"net.nan21.dnet.module.hr.training.dc.PositionCourse$CourseCtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("position"),title:"Positions" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });				
		this._elems_.add("details", {layout:"fit",frame:"false" ,items:{ layout:"accordion", activeItem:0, id:Ext.id(),width:450,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); } }}  	}  }); 	  	 
		
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("courseFilter")["region"] = "north";			
			this._elems_.get("courseList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("courseFilter") , this._elems_.get("courseList") ]; 				 		
 
			this._elems_.get("courseEdit")["region"] = "center";			
			this._elems_.get("details")["region"] = "east";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("courseEdit") , this._elems_.get("details") ]; 				 		
 
		this._elems_.get("details")["items"]["items"] = [ this._elems_.get("jobList") , this._elems_.get("positionList") ];	
	 	this._linkToolbar_("tlbCourseList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbCourseEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbJobList", "jobList");	 	  	
	 	this._linkToolbar_("tlbPositionList", "positionList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbCourseList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("course").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCourseList-load"
		this._tlbitms_.add("tlbCourseList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("course")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbCourseList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCourseList-edit_sr"
		this._tlbitms_.add("tlbCourseList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("course").doNew(); this._invokeTlbItem_("tlbCourseList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCourseList-new_sr"
		this._tlbitms_.add("tlbCourseList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("course").doCopy(); this._invokeTlbItem_("tlbCourseList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCourseList-copy_sr"
		this._tlbitms_.add("tlbCourseList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("course").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCourseList-delete_selected_sr"
		this._tlbitms_.add("tlbCourseList___S00_", "-") ;
		this._tlbitms_.add("tlbCourseList___S01_", "-") ;
		this._tlbitms_.add("tlbCourseList___TITLE_",  {xtype:"tbtext", text:"Course"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbCourseList__") != -1); } )
		this._tlbs_.add("tlbCourseList" , t.getRange() );

		this._getDc_("course").on("onEdit", function() {this._invokeTlbItem_("tlbCourseList__edit_sr");} , this);

	


			this._getDc_("course").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbCourseList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("course").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbCourseList__load")) this._tlbitms_.get("tlbCourseList__load").enable();
                 if(this._tlbitms_.get("tlbCourseList__new_sr"))this._tlbitms_.get("tlbCourseList__new_sr").enable();
                 if(this._tlbitms_.get("tlbCourseList__new_mr"))this._tlbitms_.get("tlbCourseList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("course").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbCourseList__edit_sr")) this._tlbitms_.get("tlbCourseList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbCourseList__copy_sr")) this._tlbitms_.get("tlbCourseList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbCourseList__delete_selected_sr")) this._tlbitms_.get("tlbCourseList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbCourseList__edit_sr")) this._tlbitms_.get("tlbCourseList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbCourseList__copy_sr")) this._tlbitms_.get("tlbCourseList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbCourseList__delete_selected_sr")) this._tlbitms_.get("tlbCourseList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbCourseEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("course")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbCourseEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCourseEdit-back_sr"
		this._tlbitms_.add("tlbCourseEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("course").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCourseEdit-save"
		this._tlbitms_.add("tlbCourseEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("course").doNew(); this._invokeTlbItem_("tlbCourseEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCourseEdit-new_sr"
		this._tlbitms_.add("tlbCourseEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("course").doCopy(); this._invokeTlbItem_("tlbCourseEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCourseEdit-copy_sr"
		this._tlbitms_.add("tlbCourseEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("course").getCurrentRecord().phantom) {this._getDc_("course").discardChanges();this._invokeTlbItem_("tlbCourseEdit__back_sr");} else  {this._getDc_("course").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCourseEdit-rollback_sr"
		this._tlbitms_.add("tlbCourseEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("course").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCourseEdit-prev_rec_sr"
		this._tlbitms_.add("tlbCourseEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("course").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCourseEdit-next_rec_sr"
		this._tlbitms_.add("tlbCourseEdit___S00_", "-") ;
		this._tlbitms_.add("tlbCourseEdit___S01_", "-") ;
		this._tlbitms_.add("tlbCourseEdit___TITLE_",  {xtype:"tbtext", text:"Course"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbCourseEdit__") != -1); } )
		this._tlbs_.add("tlbCourseEdit" , t.getRange() );
	


			this._getDc_("course").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbCourseEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("course").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbCourseEdit__load")) this._tlbitms_.get("tlbCourseEdit__load").enable();
                 if(this._tlbitms_.get("tlbCourseEdit__new_sr"))this._tlbitms_.get("tlbCourseEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbCourseEdit__new_mr"))this._tlbitms_.get("tlbCourseEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("course").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbCourseEdit__back_sr")) this._tlbitms_.get("tlbCourseEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbCourseEdit__save")) this._tlbitms_.get("tlbCourseEdit__save").enable();
                    if(this._tlbitms_.get("tlbCourseEdit__new_sr")) this._tlbitms_.get("tlbCourseEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbCourseEdit__copy_sr")) this._tlbitms_.get("tlbCourseEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbCourseEdit__rollback_record_sr")) this._tlbitms_.get("tlbCourseEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbCourseEdit__rollback_sr")) this._tlbitms_.get("tlbCourseEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbCourseEdit__prev_rec_sr")) this._tlbitms_.get("tlbCourseEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbCourseEdit__next_rec_sr")) this._tlbitms_.get("tlbCourseEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("course").on("cleanRecord" , function() {
		  		  if (this._getDc_("course").isDirty() ) {
                    if(this._tlbitms_.get("tlbCourseEdit__back_sr")) this._tlbitms_.get("tlbCourseEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbCourseEdit__save")) this._tlbitms_.get("tlbCourseEdit__save").enable();
                    if(this._tlbitms_.get("tlbCourseEdit__new_sr")) this._tlbitms_.get("tlbCourseEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbCourseEdit__copy_sr")) this._tlbitms_.get("tlbCourseEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbCourseEdit__rollback_record_sr")) this._tlbitms_.get("tlbCourseEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbCourseEdit__rollback_sr")) this._tlbitms_.get("tlbCourseEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbCourseEdit__prev_rec_sr")) this._tlbitms_.get("tlbCourseEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbCourseEdit__next_rec_sr")) this._tlbitms_.get("tlbCourseEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbCourseEdit__back_sr")) this._tlbitms_.get("tlbCourseEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbCourseEdit__save")) this._tlbitms_.get("tlbCourseEdit__save").disable();
                  	if(this._tlbitms_.get("tlbCourseEdit__new_sr")) this._tlbitms_.get("tlbCourseEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbCourseEdit__copy_sr")) this._tlbitms_.get("tlbCourseEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbCourseEdit__rollback_record_sr")) this._tlbitms_.get("tlbCourseEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbCourseEdit__rollback_sr")) this._tlbitms_.get("tlbCourseEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbCourseEdit__prev_rec_sr")) this._tlbitms_.get("tlbCourseEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbCourseEdit__next_rec_sr")) this._tlbitms_.get("tlbCourseEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("course").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbCourseEdit__copy_sr")) this._tlbitms_.get("tlbCourseEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbJobList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("job").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobList-load"
		this._tlbitms_.add("tlbJobList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("job").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobList-save_mr"
		this._tlbitms_.add("tlbJobList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("job").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobList-new_mr"
		this._tlbitms_.add("tlbJobList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("job").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobList-copy_mr"
		this._tlbitms_.add("tlbJobList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("job").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobList-delete_mr"
		this._tlbitms_.add("tlbJobList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("job").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobList-rollback_mr"
		this._tlbitms_.add("tlbJobList___S00_", "-") ;
		this._tlbitms_.add("tlbJobList___S01_", "-") ;
		this._tlbitms_.add("tlbJobList___TITLE_",  {xtype:"tbtext", text:"JobCourse"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbJobList__") != -1); } )
		this._tlbs_.add("tlbJobList" , t.getRange() );
	


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
                        if(this._tlbitms_.get("tlbJobList__copy_mr")) this._tlbitms_.get("tlbJobList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbJobList__delete_mr")) this._tlbitms_.get("tlbJobList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbJobList__copy_mr")) this._tlbitms_.get("tlbJobList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbJobList__delete_mr")) this._tlbitms_.get("tlbJobList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("job").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbJobList__load")) this._tlbitms_.get("tlbJobList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbJobList__save_mr")) this._tlbitms_.get("tlbJobList__save_mr").enable();
                    if(this._tlbitms_.get("tlbJobList__rollback_record_mr"))this._tlbitms_.get("tlbJobList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbJobList__rollback_mr"))this._tlbitms_.get("tlbJobList__rollback_mr").enable();
			  } , this );

			this._getDc_("job").on("cleanRecord" , function() {
		  		  if (this._getDc_("job").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbJobList__load")) this._tlbitms_.get("tlbJobList__load").disable();	                
                    if(this._tlbitms_.get("tlbJobList__save_mr"))this._tlbitms_.get("tlbJobList__save_mr").enable();
                    if(this._tlbitms_.get("tlbJobList__rollback_record_mr"))this._tlbitms_.get("tlbJobList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbJobList__rollback_mr"))this._tlbitms_.get("tlbJobList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbJobList__load")) this._tlbitms_.get("tlbJobList__load").enable();	
                  	if(this._tlbitms_.get("tlbJobList__back_mr"))this._tlbitms_.get("tlbJobList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbJobList__save_mr"))this._tlbitms_.get("tlbJobList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbJobList__rollback_record_mr"))this._tlbitms_.get("tlbJobList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbJobList__rollback_mr"))this._tlbitms_.get("tlbJobList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbPositionList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("position").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPositionList-load"
		this._tlbitms_.add("tlbPositionList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("position").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPositionList-save_mr"
		this._tlbitms_.add("tlbPositionList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("position").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPositionList-new_mr"
		this._tlbitms_.add("tlbPositionList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("position").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPositionList-copy_mr"
		this._tlbitms_.add("tlbPositionList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("position").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPositionList-delete_mr"
		this._tlbitms_.add("tlbPositionList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("position").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPositionList-rollback_mr"
		this._tlbitms_.add("tlbPositionList___S00_", "-") ;
		this._tlbitms_.add("tlbPositionList___S01_", "-") ;
		this._tlbitms_.add("tlbPositionList___TITLE_",  {xtype:"tbtext", text:"PositionCourse"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbPositionList__") != -1); } )
		this._tlbs_.add("tlbPositionList" , t.getRange() );
	


			this._getDc_("position").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbPositionList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("position").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbPositionList__load")) this._tlbitms_.get("tlbPositionList__load").enable();
                 if(this._tlbitms_.get("tlbPositionList__new_sr"))this._tlbitms_.get("tlbPositionList__new_sr").enable();
                 if(this._tlbitms_.get("tlbPositionList__new_mr"))this._tlbitms_.get("tlbPositionList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("position").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbPositionList__copy_mr")) this._tlbitms_.get("tlbPositionList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbPositionList__delete_mr")) this._tlbitms_.get("tlbPositionList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbPositionList__copy_mr")) this._tlbitms_.get("tlbPositionList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbPositionList__delete_mr")) this._tlbitms_.get("tlbPositionList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("position").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbPositionList__load")) this._tlbitms_.get("tlbPositionList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbPositionList__save_mr")) this._tlbitms_.get("tlbPositionList__save_mr").enable();
                    if(this._tlbitms_.get("tlbPositionList__rollback_record_mr"))this._tlbitms_.get("tlbPositionList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbPositionList__rollback_mr"))this._tlbitms_.get("tlbPositionList__rollback_mr").enable();
			  } , this );

			this._getDc_("position").on("cleanRecord" , function() {
		  		  if (this._getDc_("position").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbPositionList__load")) this._tlbitms_.get("tlbPositionList__load").disable();	                
                    if(this._tlbitms_.get("tlbPositionList__save_mr"))this._tlbitms_.get("tlbPositionList__save_mr").enable();
                    if(this._tlbitms_.get("tlbPositionList__rollback_record_mr"))this._tlbitms_.get("tlbPositionList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbPositionList__rollback_mr"))this._tlbitms_.get("tlbPositionList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbPositionList__load")) this._tlbitms_.get("tlbPositionList__load").enable();	
                  	if(this._tlbitms_.get("tlbPositionList__back_mr"))this._tlbitms_.get("tlbPositionList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbPositionList__save_mr"))this._tlbitms_.get("tlbPositionList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbPositionList__rollback_record_mr"))this._tlbitms_.get("tlbPositionList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbPositionList__rollback_mr"))this._tlbitms_.get("tlbPositionList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("course").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("courseEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("job").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("position").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.hr.training.frame.Course_UI", net.nan21.dnet.module.hr.training.frame.Course_UI);   
