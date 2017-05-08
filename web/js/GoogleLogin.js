/**
 * Created by myron on 07-05-17.
 */
function onSignIn(googleUser)
{
    //var auth2 = gapi.auth2.getAuthInstance();
    // Useful data for your client-side scripts:
    var profile = googleUser.getBasicProfile();
    console.log("ID: " + profile.getId()); // Don't send this directly to your server!
    profile.getId();
    console.log('Full Name: ' + profile.getName());
    console.log('Given Name: ' + profile.getGivenName());
    console.log('Family Name: ' + profile.getFamilyName());
    console.log("Image URL: " + profile.getImageUrl());
    console.log("Email: " + profile.getEmail());

    document.getElementById('prGoogleID').value = profile.getId();
    document.getElementById("googleID").value = profile.getId();
    document.getElementById('loginForm').submit();
} //this should do it