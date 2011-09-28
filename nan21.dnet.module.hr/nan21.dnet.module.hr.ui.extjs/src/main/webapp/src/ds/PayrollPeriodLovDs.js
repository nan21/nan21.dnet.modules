 
   	 
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"startDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"endDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"active",type:"boolean" }, 		
		{name:"payrollId",type:"int", useNull:true }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.PayrollPeriodLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 