 
   	 
Ext.define("net.nan21.dnet.module.hr.skill.ds.model.RatingLevelLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }, 		
		{name:"ratingScaleId",type:"int", useNull:true }, 		
		{name:"value",type:"int", useNull:true }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.skill.ds.param.RatingLevelLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 