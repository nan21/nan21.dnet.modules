Ext.ns('net.nan21.dnet.module.ux.menu');
var BUNDLE_ID = "nan21.dnet.module.ux.ui.extjs";
net.nan21.dnet.module.ux.menu.ad = [
		
		{id:"LandFormType_UI", text:Dnet.translate("ui","LandFormType_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ux.example.frame.LandFormType_UI", _bundle_:BUNDLE_ID} 
   ];  
if (Dnet.navigationTreeMenus.ad == undefined) {
	Dnet.navigationTreeMenus.ad = { name: "mbMenuAD" , title :"AD: Administration", children: [] };
}       
    Dnet.navigationTreeMenus.ad.children = Dnet.navigationTreeMenus.ad.children.concat(net.nan21.dnet.module.ux.menu.ad);
