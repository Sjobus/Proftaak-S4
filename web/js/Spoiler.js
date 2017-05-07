/**
 * Created by myron on 07-05-17.
 */
$(document).ready(function(){
    $(".spoiler-trigger").click(function() {
        $(this).parent().next().collapse('toggle');
    });
});