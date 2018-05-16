$(function () {
    $.ajax({
        type: "Post",
        url: "/bonguser/getBongDevice",
        dataType: "json",//表示后台返回的数据是json对象
        success: function (result) {
            $(".bongDevice").find("option").text("====请选择====");
            for(var i = 0; i < result.length; i++){
                var $bongmac = result[i];
                $(".bongDevice").find("option").text($bongmac);
            }

        },
    });
});