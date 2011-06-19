Ext.ns("net.nan21.dnet.module.hr.skill.lovs");
net.nan21.dnet.module.hr.skill.lovs.SkillTypes = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.hr.skill.ds.model.SkillTypeLovDs		
				,_dataProviderName_:"SkillTypeLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.skill.frame.SkillType_UI",bundle:"nan21.dnet.module.hr.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.hr.skill.lovs.SkillTypes.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.hr.skill.lovs.SkillTypes", net.nan21.dnet.module.hr.skill.lovs.SkillTypes);
 