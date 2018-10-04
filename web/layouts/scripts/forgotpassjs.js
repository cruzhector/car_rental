/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function check(){
    
    var em=document.getElementById("username").value;
    var pass=document.getElementById("pass").value;
    var cnpass=document.getElementById("cnpass").value;
    
    if(em==''){
        document.getElementById("username").innerHTML='username cannot be empty';
        return false;
    }
    if(pass==''){
        document.getElementById("lpassreq").innerHTML='password cannot be empty';
        return false;
    }
    
     if(cnpass==''){
        document.getElementById("cnpassreq").innerHTML='confirm password cannot be empty';
        return false;
    }
}
