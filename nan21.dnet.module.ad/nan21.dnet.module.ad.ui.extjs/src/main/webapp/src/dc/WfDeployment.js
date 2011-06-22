   
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.WfDeployment = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"WfDeployment" 		 
			,ds: new net.nan21.dnet.module.ad.workflow.ds.WfDeploymentDs()			  
		});
	 	net.nan21.dnet.module.ad.workflow.dc.WfDeployment.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc'); 
net.nan21.dnet.module.ad.workflow.dc.WfDeployment$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield", _rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("from", { name:"from", xtype:"datefield", dataIndex:"from", id:Ext.id(),width:100,listeners: {change: {scope:this, fn:function(f,nv,ov) {this._controller_.setParamValue("from", nv);} }} ,format:Ext.DATE_FORMAT });
		this._elems_.add("to", { name:"to", xtype:"datefield", dataIndex:"to", id:Ext.id(),width:100,listeners: {change: {scope:this, fn:function(f,nv,ov) {this._controller_.setParamValue("to", nv);} }} ,format:Ext.DATE_FORMAT });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("from") ,this._elems_.get("to") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfDeployment$Filter", net.nan21.dnet.module.ad.workflow.dc.WfDeployment$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 	 
net.nan21.dnet.module.ad.workflow.dc.WfDeployment$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("id", { xtype:"gridcolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false, width:300 });   	
		this._columns_.add("deployTime", { xtype:"datecolumn", dataIndex:"deployTime", sortable:true, hidden:false, width:150,format:Ext.DATETIME_FORMAT});   	      	     
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfDeployment$List", net.nan21.dnet.module.ad.workflow.dc.WfDeployment$List ); 
