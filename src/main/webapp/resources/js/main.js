$(function(){

    $('a.voity').click( function(event){
        event.preventDefault();
        $('#myOverlay').fadeIn(297, function(){
            $('#myModal')
                .css('display', 'block')
                .animate({opacity: 1}, 198);
        });
    });


    $('#myModal__close, #myOverlay').click( function(){
        $('#myModal').animate({opacity: 0}, 198, function(){
            $(this).css('display', 'none');
            $('#myOverlay').fadeOut(297);
        });
    });

    $("a.btn-main").on("click", function(e){
        e.preventDefault();
        let anchor = $(this).attr('href');
        $('html, body').stop().animate({
            scrollTop: $(anchor).offset().top - 60
        }, 1700);
    });

    $("a.btn-about-project").on("click", function(e){
        e.preventDefault();
        let anchor = $(this).attr('href');
        $('html, body').stop().animate({
            scrollTop: $(anchor).offset().top - 60
        }, 1700);
    });

    $("a.btn-timetable").on("click", function(e){
        e.preventDefault();
        let anchor = $(this).attr('href');
        $('html, body').stop().animate({
            scrollTop: $(anchor).offset().top - 60
        }, 1700);
    });

    $("a.btn-request").on("click", function(e){
        e.preventDefault();
        let anchor = $(this).attr('href');
        $('html, body').stop().animate({
            scrollTop: $(anchor).offset().top - 60
        }, 1700);
    });

    $("a.arrow").on("click", function(e){
        e.preventDefault();
        let anchor = $(this).attr('href');
        $('html, body').stop().animate({
            scrollTop: $(anchor).offset().top - 60
        }, 1700);
    });

    $('.btn-send').click(function(e) {
        e.preventDefault();
        $('.popup-bg').fadeIn(800);
        $('html').addClass('no-scroll');
    });

    $('#myModal___close').click(function() {
        $('.popup-bg').fadeOut(800);
        $('html').removeClass('no-scroll');
    });




});



