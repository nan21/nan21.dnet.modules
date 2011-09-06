Ext.ns("net.nan21.dnet.module.hr.training.lovs");
net.nan21.dnet.module.hr.training.lovs.CourseCategories = Ext.extend( dnet.base.AbstractCombo, {	
	 initComponent : function(){
		Ext.apply(
		    this, {
                 mode: "remote"
				,displayField:"name"
				,triggerAction :"query"
				,pageSize:30
				,autoSelect:true
				,listWidth:250 
				,tpl: '<tpl for="."><div class="x-combo-list-item"><div style="">{name}</div></div></tpl>'
				,minChars:0	
				,_dataProviderFields_: 	net.nan21.dnet.module.hr.training.ds.model.CourseCategoryLovDs		
				,_dataProviderName_:"CourseCategoryLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.training.frame.CourseType_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasCategory"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.hr.training.lovs.CourseCategories.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.hr.training.lovs.CourseCategories", net.nan21.dnet.module.hr.training.lovs.CourseCategories);
 
