var toggle = false;
$( document ).ready(function() {
    console.log( "ready!" );

    // $(".popover").click(function(){
    //     //$(this).next().hide();
    //     //$(this).next().show();
    //     if(!$(this).next().find("active"))
    //     {
    //         console.log("test");
    //         $(this).next().removeClass("active");
    //     }
    //     $(this).next().addClass("active");
    // });
    // $(".popover").click(function(){
    //     if (toggle = true){
    //         $("active").hide();
    //         $("popper-content").removeClass("active");
    //         toggle = false;
    //     }
    // })

    $('.popover').hunterPopup({
        content: $('.popper-content'),
        title: 'Ticket Verkauf',
        placement: 'left',
        width: 'auto',
        height: '180px'  
    });
});

