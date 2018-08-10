/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

            
function val(){
var name=document.getElementById("name").value;
var email=document.getElementById("email").value;
var phnnum=document.getElementById("phnnum").value;
var dob=document.getElementById("dob").value;
var li=document.getElementById("license").value;
var aadhar=document.getElementById("aadhar").value;
var pass=document.getElementById("password").value;
var cpass=document.getElementById("confrmpass").value;
//var aadh_reg=RegExp("^\d{4}\s\d{4}\s\d{4}$");
var gmail_re=RegExp("^[a-z0-9](\.?[a-z0-9]){5,}@g(oogle)?mail\.com$");
if(name== ''){
  document.getElementById("namereq").innerHTML=" *Please enter the Fullname";
  return false;
}
if(email==''){
  document.getElementById("emailreq").innerHTML=" *Please enter the Gmailid";
  return false;
}
if(phnnum==''){
  document.getElementById("phnreq").innerHTML=" *Please enter the Phonenumber";
  return false;
}
if(isNaN(phnnum)){
  document.getElementById("phnreq").innerHTML=" *Please enter the valid Phonenumber";
  return false;
}
if(dob == ''){
  document.getElementById("dobreq").innerHTML=" *Please enter the Date of Birth";
  return false;
}
if(li == ''){
  document.getElementById("lisreq").innerHTML=" *Please enter the License Number";
  return false;
}
if(li.length!=13){
  document.getElementById("lisreq").innerHTML=" *Please enter the 13digit License Number";
  return false;
}
if(aadhar == ''){
  document.getElementById("aadarreq").innerHTML=" *Please enter the aadhar number";
  return false;
}
if(aadhar.length!=12){
  document.getElementById("aadarreq").innerHTML=" *Please enter the 12 digit aadhar number";
  return false;
}
if(pass == ''){
  document.getElementById("passreq").innerHTML=" *Please enter the Password";
  return false;
}
if(cpass == ''){
  document.getElementById("cpassreq").innerHTML=" *Please enter the conform Password";
  return false;
}
if(pass!==cpass){
        alert("passwords not match");
        return false;
}
if(!(gmail_re.test(email))){
     document.getElementById("emailreq").innerHTML=" *Please enter the Gmailid";
     return false;
}
//if(!(aadh_reg.test(aadhar))){
//  document.getElementById("aadarreq").innerHTML=" *Please enter the valid aadhar number";
//  return false;
//}
}
 