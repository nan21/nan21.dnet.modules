 
   	 
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.ElementDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"name",type:"string" }, 		
		{name:"code",type:"string" }, 		
		{name:"active",type:"boolean" }, 		
		{name:"notes",type:"string" }, 		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"createdBy",type:"string" }, 		
		{name:"modifiedBy",type:"string" }, 		
		{name:"version",type:"int", useNull:true }, 		
		{name:"typeId",type:"int", useNull:true }, 		
		{name:"type",type:"string" }, 		
		{name:"dataType",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.ElementDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 