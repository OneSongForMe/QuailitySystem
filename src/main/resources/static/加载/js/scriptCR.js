// user
var user_Boolean = false;
var password_Boolean = false;
var varconfirm_Boolean = false;
var emaile_Boolean = false;
var Mobile_Boolean = false;
var address=false;
$('.reg_user').blur(function(){
  var res=null;
  var name=$(".reg_user").val();
  $.ajax({
    type: "get",// get或者post
    url: "findbyname?name="+name,// 请求的url地址
    dataType: "text",//json写了jq会帮我们转换成数组或者对象 他已经用JSON.parse弄好了
    success: function (data) { // 成功拿到结果放到这个函数 data就是拿到的结果
      res=data;
    }
  });

  if ((/^[a-z0-9_-]{4,8}$/).test($(".reg_user").val())&&res!=null&&res!=="is not isExist"){
    $('.user_hint').html("✔").css("color","green");
    user_Boolean = true;
  }else {
    $('.user_hint').html("×").css("color","red");
    user_Boolean = false;
  }
});
// password
$('.reg_password').blur(function(){
  if ((/^[a-z0-9_-]{6,16}$/).test($(".reg_password").val())){
    $('.password_hint').html("✔").css("color","green");
    password_Boolean = true;
  }else {
    $('.password_hint').html("×").css("color","red");
    password_Boolean = false;
  }
});


// password_confirm
$('.reg_confirm').blur(function(){
  if (($(".reg_password").val())==($(".reg_confirm").val())){
    $('.confirm_hint').html("✔").css("color","green");
    varconfirm_Boolean = true;
  }else {
    $('.confirm_hint').html("×").css("color","red");
    varconfirm_Boolean = false;
  }
});


// Email
$('.reg_email').blur(function(){
  if ((/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/).test($(".reg_email").val())){
    $('.email_hint').html("✔").css("color","green");
    emaile_Boolean = true;
  }else {
    $('.email_hint').html("×").css("color","red");
    emaile_Boolean = false;
  }
});


// Mobile
$('.reg_mobile').blur(function(){
  if ((/^1[34578]\d{9}$/).test($(".reg_mobile").val())){
    $('.mobile_hint').html("✔").css("color","green");
    Mobile_Boolean = true;
  }else {
    $('.mobile_hint').html("×").css("color","red");
    Mobile_Boolean = false;
  }
});

$('.reg_address').blur(function(){
  if ($(".reg_address").val()!=""){
    $('.address_hint').html("✔").css("color","green");
    address= true;
  }else {
    $('.address_hint').html("×").css("color","red");
    address = false;
  }
});

// // click
// $('.red_button').click(function(){
//   if(user_Boolean && password_Boolea && varconfirm_Boolean && emaile_Boolean && Mobile_Boolean == true){
//     alert("注册成功");
//     return true;
//   }else {
//     alert("请完善信息");
//     return false;
//
//   }
// });
function check(){
  if(user_Boolean && password_Boolea && varconfirm_Boolean && emaile_Boolean && Mobile_Boolean &&address== true){
    return true;
  }else {
    alert("请完善信息");
    return false;

  }
}
