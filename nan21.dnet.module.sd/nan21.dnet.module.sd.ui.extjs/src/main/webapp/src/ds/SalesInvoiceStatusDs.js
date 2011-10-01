 
   	 
Ext.define("net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceStatusDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sequenceNo",type:"int", useNull:true }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "sequenceNo", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceStatusDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 