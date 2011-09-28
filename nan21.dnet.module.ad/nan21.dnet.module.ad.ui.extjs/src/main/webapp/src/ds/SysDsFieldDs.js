 
   	 
Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDsFieldDs" , {
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
		{name:"dataSourceId",type:"int", useNull:true }, 		
		{name:"dataSource",type:"string" }, 		
		{name:"dataType",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.system.ds.param.SysDsFieldDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 