/**
 * Created by myron on 07-05-17.
 */
function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then
    (
        function () {
            console.log('User signed out.');
        }
    );
    document.location.replace("index.jsp");
}
function onLoad() {
    gapi.load('auth2', function() {
        gapi.auth2.init();
    });
}