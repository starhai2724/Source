$.xhrPool = [];
$.xhrPool.abortAll = function () {
    $(this).each(function (idx, jqXHR) {
        jqXHR.abort();
    });
};

$.ajaxSetup({
    beforeSend: function (jqXHR) {
        $.xhrPool.push(jqXHR);
        $("#loading-mask").show();
    }
});
$(document).ajaxStop(function () {
    $.xhrPool.pop();
    $("#loading-mask").hide();
});

$(document).ajaxError(function () {
    $.xhrPool.abortAll();
});
//window.fbAsyncInit = function () {
//    FB.init({
//        appId: '317495925099540', // Set YOUR APP ID
//        status: true, // check login status
//        cookie: true, // enable cookies to allow the server to access the session
//        xfbml: true,  // parse XFBML
//        oauth: true // Enable oauth authentication
//    });
//};

//(function (d, s, id) {
//    var js, fjs = d.getElementsByTagName(s)[0];
//    if (d.getElementById(id)) return;
//    js = d.createElement(s); js.id = id;
//    js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=317495925099540";
//    fjs.parentNode.insertBefore(js, fjs);
//} (document, 'script', 'facebook-jssdk'));
