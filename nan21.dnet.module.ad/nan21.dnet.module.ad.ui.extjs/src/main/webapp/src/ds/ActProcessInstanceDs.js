 
   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"string" }, 		
		{name:"processInstanceId",type:"string" }, 		
		{name:"processId",type:"string" }, 		
		{name:"process",type:"string" }, 		
		{name:"processVersion",type:"int", useNull:true }, 		
		{name:"startTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"startedBy",type:"string" }, 		
		{name:"startAction",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.ActProcessInstanceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 	
		{name:"processFullName",type:"string"},	
		{name:"reasonToKill",type:"string"},	
		{name:"from",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT},	
		{name:"to",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	]
}); 
 