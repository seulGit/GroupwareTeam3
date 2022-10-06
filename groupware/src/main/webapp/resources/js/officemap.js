// 사이드바 조직도 클릭시 토글
const officeMap = document.querySelector(".office_map_sidenav");
const officeMapClick = document.querySelector("#officeMapClick");

let flag = false;

officeMapClick.addEventListener('click',function(e){
    e.preventDefault();
    if (flag===true){
        officeMap.style.display='none';
        flag = false;

    }else if(flag===false){
        officeMap.style.display='block';
        flag = true;
    }
})

const officeGroup = document.querySelector(".office_map_group");
const officeGroupEmployee = document.querySelector(".office_map_group_employee");
const officePlanning = document.querySelector(".office_map_strategic_planning");
const officePlanningTeam = document.querySelector(".office_map_strategic_planning_team");
const officeSupport = document.querySelector(".office_map_management_support");
const officeSupportTeam = document.querySelector(".office_map_management_support_team");
const officeHr = document.querySelector(".office_map_hr");
const officeHrTeam = document.querySelector(".office_map_hr_team");
const officeSales = document.querySelector(".office_map_sales");
const officeSalesTeam = document.querySelector(".office_map_sales_team");
const officeMarketing = document.querySelector(".office_map_marketing");
const officeMarketingTeam = document.querySelector(".office_map_marketing_team");
const officeIt = document.querySelector(".office_map_it");
const officeItTeam = document.querySelector(".office_map_it_team");

officeGroup.addEventListener('click',function(){
    if (flag===true){
        officeGroupEmployee.style.display='none';
        flag = false;

    }else if(flag===false){
        officeGroupEmployee.style.display='block';
        flag = true;
    }
})

officePlanning.addEventListener('click',function(){
    if (flag===true){
        officePlanningTeam.style.display='none';
        flag = false;

    }else if(flag===false){
        officePlanningTeam.style.display='block';
        flag = true;
    }
})
officeSupport.addEventListener('click',function(){
    if (flag===true){
        officeSupportTeam.style.display='none';
        flag = false;

    }else if(flag===false){
        officeSupportTeam.style.display='block';
        flag = true;
    }
})
officeHr.addEventListener('click',function(){
    if (flag===true){
        officeHrTeam.style.display='none';
        flag = false;

    }else if(flag===false){
        officeHrTeam.style.display='block';
        flag = true;
    }
})
officeSales.addEventListener('click',function(){
    if (flag===true){
        officeSalesTeam.style.display='none';
        flag = false;

    }else if(flag===false){
        officeSalesTeam.style.display='block';
        flag = true;
    }
})
officeMarketing.addEventListener('click',function(){
    if (flag===true){
        officeMarketingTeam.style.display='none';
        flag = false;

    }else if(flag===false){
        officeMarketingTeam.style.display='block';
        flag = true;
    }
})
officeIt.addEventListener('click',function(){
    if (flag===true){
        officeItTeam.style.display='none';
        flag = false;

    }else if(flag===false){
        officeItTeam.style.display='block';
        flag = true;
    }
})