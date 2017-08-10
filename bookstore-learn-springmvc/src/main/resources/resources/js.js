/**
 * Created by a58 on 16/10/26.
 */
$(function () {
    $(".login").click(function () {
        $(".inputCheckBox1").toggleClass('inputCheckBox2')
    })

    $("#58dun").click(function () {
        $("body").append('<div class="mask"></div>');
        $("body").append('<div class="pop"></div>');
        $(".pop").css({
            'width': '800px',
            'height': '400px'
        });
        $(".pop").load('staticResource/downLoad.html');
    })

    $(".putBox input[type=text],.putBox input[type=password]").focus(function () {
        $(this).parent().addClass("active");
    })
    $(".putBox input[type=text],.putBox input[type=password]").blur(function () {
        $(this).parent().removeClass("active");
    })

    var w = window.screen.width;
    // var body = document.getElementById("body");
    // body.style.backgroundSize = w + 'px';
    $(".body").css('background-size', w);
    $(".body").css('-ms-background-size', w);
    $("#password").change(function () {
        var password = $(this).val();
        var reg = /^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;
        if (!reg.test(password)) {
            $(".passWord p").show();
        }
        else {
            $(".passWord p").hide();
        }
    })
    // var w1 = $(window).width();
    // var w2 = $(".main").width();
    // $(".main").css('left',(w1 - w2)/2);
})