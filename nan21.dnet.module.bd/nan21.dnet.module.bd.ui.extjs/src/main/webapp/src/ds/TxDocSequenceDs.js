 
   	 
Ext.define("net.nan21.dnet.module.bd.tx.ds.model.TxDocSequenceDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"firstNo", type:"int", useNull:true},
		{name:"lastNo", type:"int", useNull:true},
		{name:"nextNo", type:"int", useNull:true},
		{name:"incrementBy", type:"int", useNull:true},
		{name:"prefix", type:"string"},
		{name:"suffix", type:"string"}
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.bd.tx.ds.model.TxDocSequenceDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"firstNo", type:"int", useNull:true},
		{name:"firstNo_From",type:"int", useNull:true},
		{name:"firstNo_To",type:"int", useNull:true},
		{name:"lastNo", type:"int", useNull:true},
		{name:"lastNo_From",type:"int", useNull:true},
		{name:"lastNo_To",type:"int", useNull:true},
		{name:"nextNo", type:"int", useNull:true},
		{name:"nextNo_From",type:"int", useNull:true},
		{name:"nextNo_To",type:"int", useNull:true},
		{name:"incrementBy", type:"int", useNull:true},
		{name:"incrementBy_From",type:"int", useNull:true},
		{name:"incrementBy_To",type:"int", useNull:true},
		{name:"prefix", type:"string"},
		{name:"suffix", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.tx.ds.param.TxDocSequenceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 