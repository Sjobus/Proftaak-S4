/**
 * Created by Sibe on 12-6-2017.
 */


    window.fbAsyncInit = function() {
        FB.init({
            appId            : '293400821069118',
            autoLogAppEvents : true,
            xfbml            : true,
            version          : 'v2.9'
        });
        FB.AppEvents.logPageView();
    };

    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/nl_NL/sdk.js#xfbml=l&version=v2.9&appId=293400821069118";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));


