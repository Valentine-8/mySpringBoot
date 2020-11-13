$(function () {
    $('.imgcode').click(function () {
        var url = ctx+"captcha/captchaImage?s ="+Math.random();
        $(".imgcode").attr("src", url);
    })
})

$(function() {
    $("#btnSubmit").click(function(){

        var btn = $("#btnSubmit");
        btn.button('loading');
        alert($("input[name='username']").val());
        setTimeout(function () { btn.button('reset'); },1000);
        alert($("input[name='password']").val());
    });
});