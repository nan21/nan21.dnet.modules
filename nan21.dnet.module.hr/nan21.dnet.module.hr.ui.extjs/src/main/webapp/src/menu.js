
Ext.ns('net.nan21.dnet.module.hr.menu');
var BUNDLE_ID = "nan21.dnet.module.hr.ui.extjs";

net.nan21.dnet.module.hr.menu.hr = [
 
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
 ,		 
	{"id":"sm_hr_base_job", "text":"Jobs", leaf:false, children:[
		
		{id:"JobBaseDataDef_UI", text:Dnet.translate("ui","JobBaseDataDef_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.job.frame.JobBaseDataDef_UI", _bundle_:BUNDLE_ID},		
		{id:"Job_UI", text:Dnet.translate("ui","Job_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.job.frame.Job_UI", _bundle_:BUNDLE_ID},		
		{id:"Position_UI", text:Dnet.translate("ui","Position_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.job.frame.Position_UI", _bundle_:BUNDLE_ID}	]}
 ,		 
	{"id":"sm_hr_base_employee", "text":"Employees", leaf:false, children:[
		
		{id:"EmployeeTypeDefs_UI", text:Dnet.translate("ui","EmployeeTypeDefs_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI", _bundle_:BUNDLE_ID},		
		{id:"Employee_UI", text:Dnet.translate("ui","Employee_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.employee.frame.Employee_UI", _bundle_:BUNDLE_ID}	]}
 ,		 
	{"id":"sm_hr_base_payroll", "text":"Payroll", leaf:false, children:[
		
		{id:"Element_UI", text:Dnet.translate("ui","Element_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.payroll.frame.Element_UI", _bundle_:BUNDLE_ID},		
		{id:"Payroll_UI", text:Dnet.translate("ui","Payroll_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.payroll.frame.Payroll_UI", _bundle_:BUNDLE_ID},		
		{id:"ElementValue_UI", text:Dnet.translate("ui","ElementValue_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.payroll.frame.ElementValue_UI", _bundle_:BUNDLE_ID}	]}
 ,		 
	{"id":"sm_hr_base_training", "text":"Training", leaf:false, children:[
		
		{id:"CourseType_UI", text:Dnet.translate("ui","CourseType_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.training.frame.CourseType_UI", _bundle_:BUNDLE_ID},		
		{id:"Course_UI", text:Dnet.translate("ui","Course_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.training.frame.Course_UI", _bundle_:BUNDLE_ID}	]}
 ,		 
	{"id":"sm_hr_base_time", "text":"Time management", leaf:false, children:[
		
		{id:"Absence_UI", text:Dnet.translate("ui","Absence_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.time.frame.Absence_UI", _bundle_:BUNDLE_ID},		
		{id:"AbsenceBaseData_UI", text:Dnet.translate("ui","AbsenceBaseData_UI"), leaf:true, _frame_:"net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI", _bundle_:BUNDLE_ID}	]}
 
   ];  
if (Dnet.navigationTreeMenus.hr == undefined) {
	Dnet.navigationTreeMenus.hr = { name: "mbMenuHR" , title :"HR: Human Resources", children: [] };
}       
    Dnet.navigationTreeMenus.hr.children = Dnet.navigationTreeMenus.hr.children.concat(net.nan21.dnet.module.hr.menu.hr);
    
