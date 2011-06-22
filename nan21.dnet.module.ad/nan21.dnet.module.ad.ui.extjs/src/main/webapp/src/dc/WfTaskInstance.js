   
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"WfTaskInstance" 		 
			,ds: new net.nan21.dnet.module.ad.workflow.ds.WfTaskInstanceDs()			  
		});
	 	net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc'); 
net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("id", { name:"id", xtype:"textfield", _rbkey_:"id", dataIndex:"id", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("processId", { name:"processId", xtype:"textfield", dataIndex:"processId", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("taskKey", { name:"taskKey", xtype:"textfield", dataIndex:"taskKey", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("processInstanceId", { name:"processInstanceId", xtype:"textfield", dataIndex:"processInstanceId", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("executionId", { name:"executionId", xtype:"textfield", dataIndex:"executionId", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("name", { name:"name", xtype:"textfield", _rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("description", { name:"description", xtype:"textfield", _rbkey_:"description", dataIndex:"description", id:Ext.id(),anchor:"-20",maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}  });
		this._elems_.add("assignee", { name:"assignee", xtype:"textfield", dataIndex:"assignee", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("deleteReason", { name:"deleteReason", xtype:"textfield", dataIndex:"deleteReason", id:Ext.id(), width:100,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		//containers
		this._elems_.add("main", { name:"main", layout:"form", id:Ext.id(), autoScroll:true,width:210,labelWidth:0 });
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("id") ,this._elems_.get("processId") ,this._elems_.get("taskKey") ,this._elems_.get("processInstanceId") ,this._elems_.get("executionId") ,this._elems_.get("name") ,this._elems_.get("description") ,this._elems_.get("assignee") ,this._elems_.get("deleteReason") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$Filter", net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 	 
net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("id", { xtype:"gridcolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("processId", { xtype:"gridcolumn", dataIndex:"processId", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("taskKey", { xtype:"gridcolumn", dataIndex:"taskKey", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("processInstanceId", { xtype:"gridcolumn", dataIndex:"processInstanceId", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("executionId", { xtype:"gridcolumn", dataIndex:"executionId", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("description", { xtype:"gridcolumn",_rbkey_:"description", dataIndex:"description", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("assignee", { xtype:"gridcolumn", dataIndex:"assignee", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("startTime", { xtype:"datecolumn", dataIndex:"startTime", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("endTime", { xtype:"datecolumn", dataIndex:"endTime", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("duration", { xtype:"numbercolumn", dataIndex:"duration", sortable:true, hidden:false, align:"right",format:"0",width:70 });  
		this._columns_.add("deleteReason", { xtype:"gridcolumn", dataIndex:"deleteReason", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("priority", { xtype:"numbercolumn", dataIndex:"priority", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("dueDate", { xtype:"datecolumn", dataIndex:"dueDate", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$List", net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$List ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$AssignForm = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("assignee", { name:"assignee", xtype:"textfield", dataIndex:"assignee", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		//containers
		this._elems_.add("main", { name:"main", layout:"form", id:Ext.id() , autoScroll:true,width:250,labelWidth:0 });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("assignee") ];
	}	
});
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$AssignForm", net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$AssignForm ); 
