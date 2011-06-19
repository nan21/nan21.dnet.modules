 
Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceDs", "nan21.dnet.module.ad.ui.extjs/dc/SysDataSource", "nan21.dnet.module.ad.ui.extjs/ds/SysDsFieldDs", "nan21.dnet.module.ad.ui.extjs/dc/SysDsField", "nan21.dnet.module.ad.ui.extjs/ds/SysDsServiceDs", "nan21.dnet.module.ad.ui.extjs/dc/SysDsService", "nan21.dnet.module.ad.ui.extjs/ds/SysDsEventDs", "nan21.dnet.module.ad.ui.extjs/dc/SysDsEvent"]);

Ext.ns("net.nan21.dnet.module.ad.system.frame");
net.nan21.dnet.module.ad.system.frame.SysDataSources_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.system.frame.SysDataSources_UI"
	
	,_defineDcs_: function () {	
		var  m = new net.nan21.dnet.module.ad.system.dc.SysDataSource({multiEdit:false}), fields = new net.nan21.dnet.module.ad.system.dc.SysDsField({multiEdit:false}), services = new net.nan21.dnet.module.ad.system.dc.SysDsService({multiEdit:false}), events = new net.nan21.dnet.module.ad.system.dc.SysDsEvent({multiEdit:false});	 	
		
		this._dcs_.add("m", m);			
		fields.setDcContext(new dnet.base.DcContext({childDc:fields, parentDc:m, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"dataSourceId", parentField:"id"} ]}}));m.addChild(fields);
		this._dcs_.add("fields", fields);			
		services.setDcContext(new dnet.base.DcContext({childDc:services, parentDc:m, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"dataSourceId", parentField:"id"} ]}}));m.addChild(services);
		this._dcs_.add("services", services);			
		events.setDcContext(new dnet.base.DcContext({childDc:events, parentDc:m, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"dataSourceId", parentField:"id"} ]}}));m.addChild(events);
		this._dcs_.add("events", events);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
			this._elems_.add("btnSynchronize", { xtype:"button", name:"btnSynchronize", id:Ext.id(),iconCls:"icon-action-synchronize" 
					,text:"Synchronize", tooltip:"Scan classpath and synchronize catalog with deployed instances."
					,disabled:false
					,handler: function() {
					var s={modal:true, callbacks:{} };					var successFn = function(dc,response,serviceName,specs) {							 
this._getDc_("m").doQuery();			 	

							 
							}; s.callbacks['successFn'] = successFn; s.callbacks['successScope'] = this;
							
							try{ this._getDc_("m").doService("synchronizeCatalog", s); }catch(e){dnet.base.DcExceptions.showMessage(e);}

 
}					 	
 ,scope:this });	
							 	
		this._elems_.add("mFilter", { xtype:"net.nan21.dnet.module.ad.system.dc.SysDataSource$Filter", id:Ext.id(), _controller_:this._dcs_.get("m") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("mList", { xtype:"net.nan21.dnet.module.ad.system.dc.SysDataSource$List", id:Ext.id(), _controller_:this._dcs_.get("m"),buttons:[ this._elems_.get("btnSynchronize") ] ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("listFields", { xtype:"net.nan21.dnet.module.ad.system.dc.SysDsField$CtxList", id:Ext.id(), _controller_:this._dcs_.get("fields"),title:"Fields" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("listServices", { xtype:"net.nan21.dnet.module.ad.system.dc.SysDsService$CtxList", id:Ext.id(), _controller_:this._dcs_.get("services"),title:"Services" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("listEvents", { xtype:"net.nan21.dnet.module.ad.system.dc.SysDsEvent$CtxList", id:Ext.id(), _controller_:this._dcs_.get("events"),title:"Events" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });				
		this._elems_.add("panelDetails", {layout:"fit",frame:"false" ,items:{ layout:"accordion", activeItem:0, id:Ext.id(),width:400,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); } }}  	}  }); 	  	 
		
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") ]; 				 		
 
			this._elems_.get("mFilter")["region"] = "north";			
			this._elems_.get("mList")["region"] = "center";			
			this._elems_.get("panelDetails")["region"] = "east";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("mFilter") , this._elems_.get("mList") , this._elems_.get("panelDetails") ]; 				 		
 
		this._elems_.get("panelDetails")["items"]["items"] = [ this._elems_.get("listFields") , this._elems_.get("listServices") , this._elems_.get("listEvents") ];	
	 	this._linkToolbar_("tlbMList", "canvas1");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbMList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("m").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMList-load"
		this._tlbitms_.add("tlbMList___S00_", "-") ;
		this._tlbitms_.add("tlbMList___S01_", "-") ;
		this._tlbitms_.add("tlbMList___TITLE_",  {xtype:"tbtext", text:"SysDataSource"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbMList__") != -1); } )
		this._tlbs_.add("tlbMList" , t.getRange() );
	


			this._getDc_("m").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbMList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("m").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbMList__load")) this._tlbitms_.get("tlbMList__load").enable();
                 if(this._tlbitms_.get("tlbMList__new_sr"))this._tlbitms_.get("tlbMList__new_sr").enable();
                 if(this._tlbitms_.get("tlbMList__new_mr"))this._tlbitms_.get("tlbMList__new_mr").enable();
			  } , this );
			  
	

				  	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("m").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("fields").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("services").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("events").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.ad.system.frame.SysDataSources_UI", net.nan21.dnet.module.ad.system.frame.SysDataSources_UI);   
