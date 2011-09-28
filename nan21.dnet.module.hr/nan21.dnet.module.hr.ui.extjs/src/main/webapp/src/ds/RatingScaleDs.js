 
   	 
Ext.define("net.nan21.dnet.module.hr.skill.ds.model.RatingScaleDs" , {
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
	
Ext.define("net.nan21.dnet.module.hr.skill.ds.param.RatingScaleDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 