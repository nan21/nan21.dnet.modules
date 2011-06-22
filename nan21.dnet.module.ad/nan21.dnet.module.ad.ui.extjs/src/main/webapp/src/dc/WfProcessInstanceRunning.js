   
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"WfProcessInstanceRunning" 		 
			,ds: new net.nan21.dnet.module.ad.workflow.ds.WfProcessInstanceRunningDs()			  
		});
	 	net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc'); 
net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("id", { name:"id", xtype:"textfield", _rbkey_:"id", dataIndex:"id", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("processFullName", { name:"processFullName", xtype:"net.nan21.dnet.module.ad.workflow.lovs.WfProcesses", dataIndex:"processFullName", id:Ext.id(),anchor:"-20",retFieldMapping: [{lovField:"id", dsField: "processId"} ],listeners: {change: {scope:this, fn:function(f,nv,ov) {this._controller_.setParamValue("processFullName", nv);} }}  });
		this._elems_.add("startedBy", { name:"startedBy", xtype:"textfield", dataIndex:"startedBy", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("startTime", { name:"startTime", xtype:"datefield", dataIndex:"startTime", id:Ext.id(),width:100 ,format:Ext.DATE_FORMAT });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(), width:300,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col3") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("processFullName") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("startTime") ,this._elems_.get("startedBy") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("id") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning$Filter", net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 	 
net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("id", { xtype:"gridcolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("process", { xtype:"gridcolumn", dataIndex:"process", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("processVersion", { xtype:"numbercolumn", dataIndex:"processVersion", sortable:true, hidden:false, align:"right",format:"0",width:70 });  
		this._columns_.add("processInstanceId", { xtype:"gridcolumn", dataIndex:"processInstanceId", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("startTime", { xtype:"datecolumn", dataIndex:"startTime", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("startedBy", { xtype:"gridcolumn", dataIndex:"startedBy", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("startAction", { xtype:"gridcolumn", dataIndex:"startAction", sortable:true, hidden:false, width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning$List", net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning$List ); 
