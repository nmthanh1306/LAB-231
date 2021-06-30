/*
 * 
 * @param {type} imageID
 * @returns {undefined}
 * (1)get id (id set by image path) of each image 
 * and send this path to show image with bigger image(css) 
 * (2)show and hide the block of bigger image by property display
 **/

function show(imageID) {
    document.getElementById('showImage').src = imageID; //(1)
    var isShow = document.getElementById('fancybox'); //(2)
    if (isShow.style.display === "block") {
        isShow.style.display = "none";
    } else {
        isShow.style.display = "block";
    }
}


//Image transfer function
function imageOnClick(image) {
    document.getElementById("feature-image").src = image;
}
