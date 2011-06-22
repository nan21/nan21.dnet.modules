   
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.WfMyTaskHistory = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"WfMyTaskHistory" 		 
			,ds: new net.nan21.dnet.module.ad.workflow.ds.WfMyTaskHistoryDs()			  
		});
	 	net.nan21.dnet.module.ad.workflow.dc.WfMyTaskHistory.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc'); 
net.nan21.dnet.module.ad.workflow.dc.WfMyTaskHistory$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield", _rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("deleteReason", { name:"deleteReason", xtype:"textfield", dataIndex:"deleteReason", id:Ext.id(), width:100,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfMyTaskHistory$Filter", net.nan21.dnet.module.ad.workflow.dc.WfMyTaskHistory$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 	 
net.nan21.dnet.module.ad.workflow.dc.WfMyTaskHistory$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("id", { xtype:"gridcolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("description", { xtype:"gridcolumn",_rbkey_:"description", dataIndex:"description", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("startTime", { xtype:"datecolumn", dataIndex:"startTime", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("endTime", { xtype:"datecolumn", dataIndex:"endTime", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("priority", { xtype:"numbercolumn", dataIndex:"priority", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("dueDate", { xtype:"datecolumn", dataIndex:"dueDate", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfMyTaskHistory$List", net.nan21.dnet.module.ad.workflow.dc.WfMyTaskHistory$List ); 
