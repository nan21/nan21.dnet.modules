 
   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.WfDefProcessDs" , {
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
		{name:"version",type:"int", useNull:true }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.WfDefProcessDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 