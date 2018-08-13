/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function valid(){
    var cardnum=document.getElementById("num").value;
    var cardname=document.getElementById("holder").value;
    var expdate=document.getElementById("expdate").value;
    var cvv=document.getElementById("cvv").value;
    
    if(cardnum==''){
         document.getElementById("numreq").innerHTML=" *Please enter the cardnumber";
    return false;
        
    }
    if(cardnum.length!=16){
         document.getElementById("numreq").innerHTML=" *Please enter the valid cardnumber";
    return false;
    }
    if(cvv.length!=3){
         document.getElementById("cvvreq").innerHTML=" *Please enter the valid cvv";
    return false;
    }
    if(cvv==''){
         document.getElementById("cvvreq").innerHTML=" *Please enter the cvv";
    return false;
    }
     if(expdate==''){
         document.getElementById("expreq").innerHTML=" *Please enter the expired date";
    return false;
    }
    if(cardname==''){
         document.getElementById("holderreq").innerHTML=" *Please enter the name";
    return false;
    }
}