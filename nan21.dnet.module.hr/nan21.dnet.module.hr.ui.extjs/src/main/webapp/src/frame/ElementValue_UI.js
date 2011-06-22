 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/ElementValueDs", "nan21.dnet.module.hr.ui.extjs/dc/ElementValue","nan21.dnet.module.hr.ui.extjs/ds/ElementLovDs","nan21.dnet.module.hr.ui.extjs/lov/Elements","nan21.dnet.module.hr.ui.extjs/ds/EmployeeLovDs","nan21.dnet.module.hr.ui.extjs/lov/Employees","nan21.dnet.module.hr.ui.extjs/ds/PayrollPeriodLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayrollPeriods"]);

Ext.ns("net.nan21.dnet.module.hr.payroll.frame");
net.nan21.dnet.module.hr.payroll.frame.ElementValue_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.payroll.frame.ElementValue_UI"
	
	,_defineDcs_: function () {	
		var  expval = new net.nan21.dnet.module.hr.payroll.dc.ElementValue({multiEdit:false});	 	
		
		this._dcs_.add("expval", expval);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("expvalFilter", { xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementValue$Filter", id:Ext.id(), _controller_:this._dcs_.get("expval") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("expvalList", { xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementValue$List", id:Ext.id(), _controller_:this._dcs_.get("expval") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Edit list",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") ]; 				 		
 
			this._elems_.get("expvalFilter")["region"] = "north";			
			this._elems_.get("expvalList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("expvalFilter") , this._elems_.get("expvalList") ]; 				 		
	 	this._linkToolbar_("tlbExpvalList", "canvas1");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
		this._tlbitms_.add("tlbExpvalList__load", new Ext.Action({
			id:Ext.id(), text: "Load", tooltip: '/** Load records from database according to specified filter. */', iconCls: "icon-action-load", scope:this
			, handler:function() {try {this._getDc_("expval").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbExpvalList-load"
		this._tlbitms_.add("tlbExpvalList___S00_", "-") ;
		this._tlbitms_.add("tlbExpvalList___S01_", "-") ;
		this._tlbitms_.add("tlbExpvalList___TITLE_",  {xtype:"tbtext", text:"ElementValue"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbExpvalList__") != -1); } )
		this._tlbs_.add("tlbExpvalList" , t.getRange() );
	


			this._getDc_("expval").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbExpvalList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("expval").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbExpvalList__load")) this._tlbitms_.get("tlbExpvalList__load").enable();
                 if(this._tlbitms_.get("tlbExpvalList__new_sr"))this._tlbitms_.get("tlbExpvalList__new_sr").enable();
                 if(this._tlbitms_.get("tlbExpvalList__new_mr"))this._tlbitms_.get("tlbExpvalList__new_mr").enable();
			  } , this );
			  
	

				  	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("expval").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.hr.payroll.frame.ElementValue_UI", net.nan21.dnet.module.hr.payroll.frame.ElementValue_UI);   
