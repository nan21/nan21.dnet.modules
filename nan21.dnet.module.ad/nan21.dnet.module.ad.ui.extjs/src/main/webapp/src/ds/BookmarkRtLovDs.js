/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.BookmarkRtLovDs" ,{
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
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"parentId", type:"int", useNull:true},
		{name:"parent", type:"string"},
		{name:"text", type:"string"},
		{name:"frame", type:"string"},
		{name:"bundle", type:"string"},
		{name:"separatorBefore", type:"boolean"},
		{name:"separatorAfter", type:"boolean"},
		{name:"leaf", type:"boolean"}
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.BookmarkRtLovDsFilter" ,{
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
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"parentId", type:"int", useNull:true},
		{name:"parentId_From",type:"int", useNull:true},
		{name:"parentId_To",type:"int", useNull:true},
		{name:"parent", type:"string"},
		{name:"text", type:"string"},
		{name:"frame", type:"string"},
		{name:"bundle", type:"string"},
		{name:"separatorBefore", type:"boolean", useNull:true},
		{name:"separatorAfter", type:"boolean", useNull:true},
		{name:"leaf", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.usr.ds.param.BookmarkRtLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 