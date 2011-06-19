Ext.ns('net.nan21.dnet.module.hr.menu');
var BUNDLE_ID = "nan21.dnet.module.hr.ui.extjs";
net.nan21.dnet.module.hr.menu.hr = [
 
	{"id":"sm_hr_base", "text":"Definitions", leaf:false, children:[
 
	{"id":"sm_hr_base_skill", "text":"Competence", leaf:false, children:[
		
		{id:"RatingScale_UI", text:Dnet.translate("ui","RatingScale_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.skill.frame.RatingScale_UI", _bundle_:BUNDLE_ID},		
		{id:"RatingLevel_UI", text:Dnet.translate("ui","RatingLevel_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.skill.frame.RatingLevel_UI", _bundle_:BUNDLE_ID},		
		{id:"SkillType_UI", text:Dnet.translate("ui","SkillType_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.skill.frame.SkillType_UI", _bundle_:BUNDLE_ID},		
		{id:"Skill_UI", text:Dnet.translate("ui","Skill_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.skill.frame.Skill_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_hr_base_grade", "text":"Grades", leaf:false, children:[
		
		{id:"Grade_UI", text:Dnet.translate("ui","Grade_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.grade.frame.Grade_UI", _bundle_:BUNDLE_ID},		
		{id:"GradeRate_UI", text:Dnet.translate("ui","GradeRate_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.grade.frame.GradeRate_UI", _bundle_:BUNDLE_ID},		
		{id:"PayScale_UI", text:Dnet.translate("ui","PayScale_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.grade.frame.PayScale_UI", _bundle_:BUNDLE_ID},		
		{id:"PayScaleRate_UI", text:Dnet.translate("ui","PayScaleRate_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.grade.frame.PayScaleRate_UI", _bundle_:BUNDLE_ID}	]}
	]}
 
   ];  
if (Dnet.navigationTreeMenus.hr == undefined) {
	Dnet.navigationTreeMenus.hr = { name: "mbMenuHR" , title :"HR: Human Resources", children: [] };
}       
    Dnet.navigationTreeMenus.hr.children = Dnet.navigationTreeMenus.hr.children.concat(net.nan21.dnet.module.hr.menu.hr);
