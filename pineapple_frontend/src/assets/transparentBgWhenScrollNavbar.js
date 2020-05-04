jQuery(function() {
    var header = jQuery(".x-navbar");
    jQuery(window).scroll(function() {    
        var scroll = jQuery(window).scrollTop();
    
        if (scroll >= 500) {
             header.removeClass('clearnavbar').addClass("darknavbar");
        } else {
             header.removeClass("darknavbar").addClass('clearnavbar');
        }
    });
});