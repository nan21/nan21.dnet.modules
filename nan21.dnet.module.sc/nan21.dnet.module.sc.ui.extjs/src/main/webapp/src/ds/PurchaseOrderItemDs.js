/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderItemDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"purchaseOrderId", type:"int", useNull:true},
		{name:"productId", type:"int", useNull:true},
		{name:"productCode", type:"string"},
		{name:"productName", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uomCode", type:"string"},
		{name:"quantity", type:"float", useNull:true},
		{name:"unitPrice", type:"float", useNull:true},
		{name:"netAmount", type:"float", useNull:true},
		{name:"taxAmount", type:"float", useNull:true},
		{name:"lineAmount", type:"float", useNull:true},
		{name:"taxId", type:"int", useNull:true},
		{name:"tax", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderItemDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
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
		{name:"purchaseOrderId", type:"int", useNull:true},
		{name:"purchaseOrderId_From",type:"int", useNull:true},
		{name:"purchaseOrderId_To",type:"int", useNull:true},
		{name:"productId", type:"int", useNull:true},
		{name:"productId_From",type:"int", useNull:true},
		{name:"productId_To",type:"int", useNull:true},
		{name:"productCode", type:"string"},
		{name:"productName", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uomId_From",type:"int", useNull:true},
		{name:"uomId_To",type:"int", useNull:true},
		{name:"uomCode", type:"string"},
		{name:"quantity", type:"float", useNull:true},
		{name:"quantity_From",type:"float", useNull:true},
		{name:"quantity_To",type:"float", useNull:true},
		{name:"unitPrice", type:"float", useNull:true},
		{name:"unitPrice_From",type:"float", useNull:true},
		{name:"unitPrice_To",type:"float", useNull:true},
		{name:"netAmount", type:"float", useNull:true},
		{name:"netAmount_From",type:"float", useNull:true},
		{name:"netAmount_To",type:"float", useNull:true},
		{name:"taxAmount", type:"float", useNull:true},
		{name:"taxAmount_From",type:"float", useNull:true},
		{name:"taxAmount_To",type:"float", useNull:true},
		{name:"lineAmount", type:"float", useNull:true},
		{name:"lineAmount_From",type:"float", useNull:true},
		{name:"lineAmount_To",type:"float", useNull:true},
		{name:"taxId", type:"int", useNull:true},
		{name:"taxId_From",type:"int", useNull:true},
		{name:"taxId_To",type:"int", useNull:true},
		{name:"tax", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.sc.order.ds.param.PurchaseOrderItemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 