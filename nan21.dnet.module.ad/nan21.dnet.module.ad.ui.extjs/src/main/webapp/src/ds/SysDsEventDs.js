 
   	 
Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDsEventDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"createdBy",type:"string" }, 		
		{name:"modifiedBy",type:"string" }, 		
		{name:"version",type:"int", useNull:true }, 		
		{name:"dataSourceId",type:"int", useNull:true }, 		
		{name:"dataSource",type:"string" }, 		
		{name:"name",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.system.ds.param.SysDsEventDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 