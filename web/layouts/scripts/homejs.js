/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function val(){
    var pdate=document.getElementById("pdate").value;
    var ddate=document.getElementById("ddate").value;
    var present=new Date();
    var d1=new Date(pdate);
    var d2=new Date(ddate);
    if(d1<present){
        
        document.getElementById("preq").innerHTML=" *check the date";
        return false;
    }
    if(d1>=d2){
        document.getElementById("preq").innerHTML=" *check the dates";
        return false;
    }
    if(pdate=''){
     document.getElementById("preq").innerHTML=" Required Pickup Date";
        return false;   
    }
     if(pdate=''){
     document.getElementById("dreq").innerHTML=" Required drop Date";
        return false;   
    }
    
       
    
}