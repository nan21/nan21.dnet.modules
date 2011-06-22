   
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.WfProcess = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"WfProcess" 		 
			,ds: new net.nan21.dnet.module.ad.workflow.ds.WfProcessDs()			  
		});
	 	net.nan21.dnet.module.ad.workflow.dc.WfProcess.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc'); 
net.nan21.dnet.module.ad.workflow.dc.WfProcess$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("id", { name:"id", xtype:"textfield", _rbkey_:"id", dataIndex:"id", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("code", { name:"code", xtype:"textfield", _rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("name", { name:"name", xtype:"textfield", _rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("category", { name:"category", xtype:"textfield", dataIndex:"category", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("resourceName", { name:"resourceName", xtype:"textfield", dataIndex:"resourceName", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("deployment", { name:"deployment", xtype:"net.nan21.dnet.module.ad.workflow.lovs.WfDeployments", dataIndex:"deployment", id:Ext.id(),anchor:"-20",retFieldMapping: [{lovField:"id", dsField: "deploymentId"} ,{lovField:"fullName", dsParam: "deployment"} ],listeners: {change: {scope:this, fn:function(f,nv,ov) {this._controller_.setParamValue("deployment", nv);} }}  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id(), width:280,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col3") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("code") ,this._elems_.get("name") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("category") ,this._elems_.get("resourceName") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("deployment") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfProcess$Filter", net.nan21.dnet.module.ad.workflow.dc.WfProcess$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 	 
net.nan21.dnet.module.ad.workflow.dc.WfProcess$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("id", { xtype:"gridcolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("version", { xtype:"numbercolumn",_rbkey_:"version", dataIndex:"version", sortable:true, hidden:false, align:"right",format:"0",width:70 });  
		this._columns_.add("code", { xtype:"gridcolumn",_rbkey_:"code", dataIndex:"code", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("category", { xtype:"gridcolumn", dataIndex:"category", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("resourceName", { xtype:"gridcolumn", dataIndex:"resourceName", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("diagramResourceName", { xtype:"gridcolumn", dataIndex:"diagramResourceName", sortable:true, hidden:true,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfProcess$List", net.nan21.dnet.module.ad.workflow.dc.WfProcess$List ); 
