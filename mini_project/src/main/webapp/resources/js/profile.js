/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$( document ).ready(function() {
    console.log( "ready!" );
});

$(function() {
  $( "#checkin" ).datepicker({minDate : 0, dateFormat: 'dd-mm-yy'});
  $("#checkout").attr("disabled", "disabled");
  $( "#checkout" ).datepicker({minDate:0, dateFormat: 'dd-mm-yy'});

$( "#checkin" ).on("change",function(){
onCheckin();

});
  
});

function onCheckin(){
if($("#checkin").val() !== ""){
$("#checkout").removeAttr("disabled");
var dateMin = $('#checkin').datepicker("getDate");
var rMin = new Date(dateMin.getFullYear(), dateMin.getMonth(), dateMin.getDate() + 1);
$("#checkout").datepicker('option', 'minDate', new Date(rMin));
}else{
$("#checkout").val("");
$("#checkout").attr("disabled", "disabled");
}
}