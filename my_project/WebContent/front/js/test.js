$(function(){
    alert("啊哈哈");
    $.ajax({
        url:path+"/zkc/selectTest.action",
        type:"post",
        dataType:"json",
        success:function (data) {
            alert(123);
        }
    });
});