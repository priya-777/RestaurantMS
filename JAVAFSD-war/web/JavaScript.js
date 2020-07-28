/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//today=new Date();
//var dd=today.getDate();
//var mm=today.getMonth()+1;
//var yyyy=today.getFullYear();
////if(dd<10) dd='0'+dd;
////if(mm<10) mm='0'+mm;
////console.log(mm+"/"+dd+"/"+yyyy);
//var day1=(mm)+"/"+dd+"/"+yyyy;
//document.getElementById("curday").innerHTML=day1;
//
//console.log(day1);
//var day2=(mm)+"/"+(dd+1)+"/"+yyyy;
//document.getElementById("second").innerHTML=day2;
//console.log(day2+"sd");
//var day3=(mm)+"/"+(dd+2)+"/"+yyyy;
//console.log(day3);
//document.getElementById("third").innerHTML=day3;

function test(NoOfPersons)
  {
   var ob=new XMLHttpRequest();
   ob.onreadystatechange=function todo()
   {
            if(ob.readyState===4)
                document.getElementById("display").innerHTML =ob.responseText;
   }
   ob.open("GET","AdminSideTableUpdate?msg="+NoOfPersons,true);
   ob.send();
  }
  
  function getEntries()
  {
   var ob=new XMLHttpRequest();
   ob.onreadystatechange=function todo1()
   {
            if(ob.readyState===4)
                document.getElementById("Entries").innerHTML =ob.responseText;
   }
   ob.open("GET","getTables",true);
   ob.send();
  }